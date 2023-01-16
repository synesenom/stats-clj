(ns stats-clj.special.beta-test
  (:require [clojure.test :refer :all]
            [stats-clj.utils :refer [almost-equal?]]
            [stats-clj.special :refer [beta]]))

(deftest beta-test
  (testing "zero"
    (is (= ##Inf (beta 0 3)))
    (is (= ##Inf (beta 3 0))))
  (testing "real arguments"
    (is (every? true? (map almost-equal?
                           [21.692410102533042
                            3.6998579981175097
                            1.5285990737881217
                            0.7456468415602905
                            0.38967490871473065]
                           (map #(apply beta %) [[0.07 0.13]
                                                 [0.35559933214452666 0.5787989505128276]
                                                 [0.6411986642890533 1.027597901025655]
                                                 [0.92679799643358 1.4763968515384827]
                                                 [1.2123973285781067 1.9251958020513102]])
                           )))))
