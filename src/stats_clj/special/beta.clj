(ns stats-clj.special.beta
  (:require [stats-clj.special.log-gamma :refer [log-gamma]]))

(defn beta [x, y]
  ;; Returns the value of the beta function.
  ;; See https://en.wikipedia.org/wiki/Beta_function.
  (Math/exp (+ (log-gamma x) (log-gamma y) (- (log-gamma (+ x y))))))
