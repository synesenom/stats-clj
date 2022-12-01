(ns stats-clj.utils-test
  (:require [clojure.test :refer :all]
            [stats-clj.utils :as utils]))

(deftest almost-equal-test
  (testing "It should return false."
    (is (true? (utils/almost-equal? 0 0))))
  (testing "It should return false."
    (is (false? (utils/almost-equal? 1 2))))
  (testing "TODO Rename this test."
    (is (true? (utils/almost-equal? 1 1))))
  (testing "TODO Rename this test."
    (is (false? (utils/almost-equal? 1.791759469228055 1.7917594692280547 1e-16))))
  (testing "TODO Rename this test."
    (is (true? (utils/almost-equal? 1.791759469228055 1.7917594692280547 1e-10))))
  )
