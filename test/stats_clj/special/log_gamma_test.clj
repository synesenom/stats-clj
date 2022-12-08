(ns stats-clj.special.log-gamma-test
  (:require [clojure.test :refer :all]
            [stats-clj.utils :refer [almost-equal?]]
            [stats-clj.special :refer [log-gamma]]))

(deftest log-gamma-test
  (testing "zero"
    (is (= ##Inf (log-gamma 0))))
  (testing "nonzero argument"
    ;; Values are compared against scipy's implementation.
    (is (every? true? (map almost-equal?
                           [1.047397916201484, 0.356027311027709,
                            0.036003461153392, -0.099755152445816, -0.115903800845502,
                            -0.044264738533964, 0.096465914021257, 0.294059767421599]
                           (map log-gamma [0.314159265358979, 0.628318530717959,
                                           0.942477796076938, 1.256637061435917, 1.570796326794897,
                                           1.884955592153876, 2.199114857512855, 2.513274122871834])
                           )))))
