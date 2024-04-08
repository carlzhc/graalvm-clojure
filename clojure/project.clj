(defproject graalvm-clojure "0.1.0-SNAPSHOT"

  :dependencies []

  :main simple.main

  :profiles {:uberjar {:aot :all}
             :clojure-1.11.1 {:dependencies [[org.clojure/clojure "1.11.1"]]
                              :uberjar-name "simple-clojure-1.11.1-uberjar.jar"}}
  )
