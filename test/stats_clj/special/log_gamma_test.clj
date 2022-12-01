(ns stats-clj.special.log-gamma-test
  (:require [clojure.test :refer :all]
            [stats-clj.utils :refer [almost-equal?]]
            [stats-clj.special :refer [log-gamma]]))

(deftest log-gamma-test
  (testing "log-gamma(0) = inf"
    (is (= ##Inf (log-gamma 0))))
  (testing "log-gamma(n) = log[(n - 1)!]"
    (is (every? true? (map almost-equal?
                           [0.0 -4.440892098500626E-16 0.6931471805599441 1.791759469228055 3.1780538303479453]
                           (map log-gamma [1 2 3 4 5])
                           (repeat 1e-10))))))
