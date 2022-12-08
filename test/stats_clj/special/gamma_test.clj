(ns stats-clj.special.gamma-test
  (:require [clojure.test :refer :all]
            [stats-clj.utils :refer [almost-equal?]]
            [clojure.math :as math]
            [stats-clj.special :refer [gamma]]))

(deftest gamma-test
  (testing "zero"
    (is (= ##Inf (gamma 0))))
  (testing "integer argument"
    (is (= [1 1 2 6 24 120]
           (map (fn [x] (math/round (gamma x))) [1 2 3 4 5 6]))))
  (testing "irrational argument"
    ;; Values are compared against scipy's implementation.
    (is (every? true? (map almost-equal?
                           [9.513507698668732, 2.140682974809618, 1.255370383856041,
                            0.977199278852609, 0.890498935327492, 0.903429438130048,
                            0.993732399615867, 1.166092652648105, 1.444007869691018]
                           (map gamma [0.1, 0.414159265358979, 0.728318530717959,
                                       1.042477796076938, 1.356637061435917, 1.670796326794897,
                                       1.984955592153876, 2.299114857512855, 2.613274122871835])
                           )))))
