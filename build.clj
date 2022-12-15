(ns build
  (:refer-clojure :exclude [test])
  (:require [clojure.tools.build.api :as b] ; for b/git-count-revs
            [org.corfield.build :as bb]))

(def lib 'io.github.synesenom/stats-clj)
(def version "0.1.0-SNAPSHOT")
#_ ; alternatively, use MAJOR.MINOR.COMMITS:
(def version (format "1.0.%s" (b/git-count-revs nil)))

(defn test "Run the tests, in a separate process." [opts]
  (bb/run-tests opts))

(defn with-opts [opts]
  (merge {:lib lib :version version} opts))

(defn jar "Only builds JAR, doesn't run tests." [opts]
  (-> (with-opts opts)
      bb/clean
      bb/jar))

(defn ci "Run the CI pipeline of tests (and build the JAR)." [opts]
  (-> (with-opts opts)
      (bb/run-tests)
      (bb/clean)
      (bb/jar)))

(defn install "Install the JAR locally." [opts]
  (bb/install (with-opts opts)))

(defn deploy "Deploy the JAR to Clojars." [opts]
  (bb/deploy (with-opts opts)))


;; you can even run (and debug!) your build tasks from the repl/ns itself
;; - watch the REPL buffer for an output
(comment
  (test {})

  ;; for install, you first need to make the jar
  (jar {})
  (install {})
  )
