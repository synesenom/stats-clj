(ns stats-clj.special.log-beta-test
  (:require [clojure.test :refer :all]
            [stats-clj.utils :refer [almost-equal?]]
            [stats-clj.special :refer [log-beta]]))

(deftest log-beta-test
  (testing "zero"
    (is (= ##Inf (log-beta 0 3)))
    (is (= ##Inf (log-beta 3 0
                           ))))
  (testing "real arguments"
    (is (every? true? (map almost-equal?
                           [2.8116268027196867
                            1.228069170741136
                            0.36450139475135473
                            -0.34609646319277865
                            -0.9914043284048736]
                           (map #(apply log-beta %) [[0.09 0.17]
                                                     [0.3755993321445267 0.6187989505128276]
                                                     [0.6611986642890534 1.067597901025655]
                                                     [0.9467979964335801 1.5163968515384827]
                                                     [1.232397328578107 1.9651958020513103]])
                           )))))
