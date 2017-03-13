(ns trash-talker.util)


(defn help-request []
  {:title "Help"
   :output (str "The sports analyst knows everything. Just say, alexa, ask "
                "sports analyst what is his opinion of Muhammad Ali?")
   :reprompt-text (str "The sports analyst knows everything. Just say, alexa, ask "
                       "sports analyst what is his opinion of Muhammad Ali?"
                       "Do you want to try?")
   :should-end-session false})


(defn launch-request []
  {:title "Welcome"
   :output (str "Please allow me to introduce you to the sports analyst. "
                "The sports analyst knows everything. Just say, alexa, ask "
                "sports analyst what is his opinion of Muhammad Ali?")
   :reprompt-text (str "The sports analyst knows everything. Just say, alexa, ask "
                       "sports analyst what is his opinion of Muhammad Ali?"
                       "Do you want to try?")
   :should-end-session false})
