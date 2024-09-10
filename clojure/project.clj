(defproject graalvm-clojure "0.1.0-SNAPSHOT"

  :dependencies [[org.clojure/clojure "1.12.0"]]

  :main simple.main

  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}
             :clojure-1.12.0 {:dependencies [[org.clojure/clojure "1.12.0"]]
                              :uberjar-name "simple-clojure-1.12.0-uberjar.jar"}}
  :plugins [[lein-ancient "1.0.0-RC4-SNAPSHOT"]
            [lein-environ "1.2.0"]
            [io.taylorwood/lein-native-image "0.3.1"]]

  :native-image {
                 ;; :name ; override the default format "%name-%version"
                 ;; :graal-bin "/path/to/graalvm/" ; path to GraalVM home, optional
                 :opts [
                        "-H:+UnlockExperimentalVMOptions"
                        "-H:+ReportExceptionStackTraces"
                        "-H:-CheckToolchain"
                        "--no-fallback"
                        "--native-image-info"
                        "--install-exit-handlers"
                        "--initialize-at-build-time"
                        "--report-unsupported-elements-at-runtime"
                        "-march=x86-64" ; use `-march=list' to show all possible value
                        ]})
