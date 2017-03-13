(ns trash-talker.core
  (:gen-class
   :implements [com.amazonaws.services.lambda.runtime.RequestStreamHandler])
  (:require [clojure.java.io :as io]
            [clojure.data.json :as json]
            [trash-talker.intent :refer [intent-request]]
            [trash-talker.util :refer [help-request
                                       launch-request]]))


(defn build-speechlet [{:keys [title output reprompt-text
                               should-end-session]}]
  {"version" "1.0"
   "sessionAttributes" {}
   "response" {"outputSpeech" {"type" "PlainText"
                               "text" output}
               "card" {"type" "Simple"
                       "title" title
                       "content" output}
               "reprompt" {"outputSpeech" {"type" "PlainText"
                                           "text" reprompt-text}}
               "shouldEndSession" should-end-session}})


(defn -handleRequest
  [this input output context]
  (with-open [w (io/writer output)]
    (let [req (json/read (io/reader input) :key-fn keyword)
          event-object (:request req)
          file-type (:type event-object)
          resp
          (cond
            (= "LaunchRequest" file-type)
            (launch-request)

            (and (= "IntentRequest" file-type)
                 (= "AMAZON.HelpIntent" (get-in event-object [:intent :name])))
            (help-request)

            (= "IntentRequest" file-type)
            (intent-request event-object))]
      (-> resp
          build-speechlet
          (json/write w)))
    (.flush w)))
