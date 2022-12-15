(ns stats-clj.special-test
  (:require [clojure.test :refer :all]
            [stats-clj.utils :refer [almost-equal?]]
            [clojure.math :as math]
            [stats-clj.special :as special]))

(deftest gamma-test
  (testing "zero"
    (is (= ##Inf (special/gamma 0))))
  (testing "integer argument"
    (is (= [1 1 2 6 24 120]
           (map (fn [x] (math/round (special/gamma x))) [1 2 3 4 5 6]))))
  (testing "irrational argument"
    ;; Values are compared against scipy's implementation.
    (is (every? true? (map almost-equal?
                           [9.513507698668732, 2.140682974809618, 1.255370383856041,
                            0.977199278852609, 0.890498935327492, 0.903429438130048,
                            0.993732399615867, 1.166092652648105, 1.444007869691018]
                           (map special/gamma [0.1, 0.414159265358979, 0.728318530717959,
                                               1.042477796076938, 1.356637061435917, 1.670796326794897,
                                               1.984955592153876, 2.299114857512855, 2.613274122871835])
                           )))))

(deftest log-gamma-test
  (testing "zero"
    (is (= ##Inf (special/log-gamma 0))))
  (testing "nonzero argument"
    ;; Values are compared against scipy's implementation.
    (is (every? true? (map almost-equal?
                           [1.047397916201484, 0.356027311027709,
                            0.036003461153392, -0.099755152445816, -0.115903800845502,
                            -0.044264738533964, 0.096465914021257, 0.294059767421599]
                           (map special/log-gamma [0.314159265358979, 0.628318530717959,
                                                   0.942477796076938, 1.256637061435917, 1.570796326794897,
                                                   1.884955592153876, 2.199114857512855, 2.513274122871834])
                           )))))
