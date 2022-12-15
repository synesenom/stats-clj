(ns stats-clj.core.tests-test
  (:require [clojure.test :refer :all]
            [stats-clj.core.tests :as tests]))

(deftest chi-2-test
  (testing "foo"
    (is (= 3 (tests/chi-2 3))))
  )