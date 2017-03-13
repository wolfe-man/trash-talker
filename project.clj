(defproject trash-talker "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[amazonica "0.3.80"
                  :exclusions [com.amazonaws/aws-java-sdk
                               com.amazonaws/amazon-kinesis-client]]
                 [com.amazonaws/aws-lambda-java-core "1.1.0"]
                 [com.amazonaws/aws-java-sdk-core "1.11.75"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]]
  :plugins [[lein-ancient "0.6.10"]
            [lein-bikeshed "0.4.1"]
            [lein-kibit "0.1.3"]]
  :profiles {:uberjar {:aot :all}})
