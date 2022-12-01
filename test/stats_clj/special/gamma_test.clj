(ns stats-clj.special.gamma-test
  (:require [clojure.test :refer :all]
            [clojure.math :as math]
            [stats-clj.special :refer [gamma]]))

(deftest gamma-test
  ;; TODO Tests for z < 0.5 values.
  (testing "gamma(0) = inf"
    (is (= ##Inf (gamma 0))))
  (testing "gamma(n) = (n - 1)!"
    (is (= [1 1 2 6 24 120]
           (map (fn [z] (math/round (gamma z))) [1 2 3 4 5 6]) ))))
