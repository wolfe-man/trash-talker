(ns trash-talker.intent
  (:require [trash-talker.util :refer [help-request]]))


(defn talk-trash [subject]
  (println subject)
  (let [rand (rand-int 12)]
    (case rand
      0 (str "As Bryce Harper would say, I’m not answering that. "
             "That’s a clown question, bro.")

      1 (str subject " couldn't beat the school of the blind.")

      2 (str "Aside from " subject " being ugly. " subject " is pretty good.")

      3 (str "As Muhammad Ali would say, " subject " is going to get "
             "beat so bad they will need a shoehorn to put their hat on.")

      4 (str "As Muhammad Ali would say, If " subject " ever dreams of "
             "winning, " subject " better wake up and apologize.")

      5 (str "As Muhammad Ali would say, " subject " is so mean, "
             subject " makes medicine sick.")

      6 (str "As Muhammad Ali would say, " subject " has two chances. "
             "Slim, and none. And Slim just left town.")

      7 (str "As Floyd Mayweather would say, Once " subject " gets stomped. "
             subject " is going to be forced to make a sushi roll and cook "
             "some rice.")

      8 (str "As David Haye would say, " subject " makes the Elephant Man "
             "look like Pamela Anderson.")

      9 (str "As Donald Trump would say, " subject " is low energy and has "
              "zero class.")

      10 (str "As Mike Ditka would say, What’s the difference "
              "between a 3-week-old puppy and a " subject "? "
              "In six weeks, the puppy stops whining.")

      11 (str "As Dwayne The Rock Johnson would say, " subject
              " looks like a big monkey came down here, took a crap, "
              "and out came " subject "!"))))


(defn intent-request [{:keys [intent]}]
  (println intent)
  (let [subject (get-in intent [:slots :mySubject :value])
        trash-talk (talk-trash subject)]
    {:title "Trash Talk"
     :output trash-talk
     :reprompt-text ""
     :should-end-session true}))
