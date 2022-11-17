(ns stats-clj.special.gamma-test
  (:require [clojure.test :refer :all]
            [stats-clj.special :refer [gamma]]))

(deftest gamma-test
  (testing "gamma(0) = inf"
    (is (= ##Inf (gamma 0))))
  (testing "gamma(n) = (n - 1)!"
    (is (= [1 1 2 6 24 120]
           (map (fn [z] (Math/round ^float (gamma z))) [1 2 3 4 5 6]) ))))
