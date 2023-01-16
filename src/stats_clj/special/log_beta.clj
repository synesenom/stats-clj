(ns stats-clj.special.log-beta
  (:require [stats-clj.special.log-gamma :refer [log-gamma]]))

(defn log-beta [x, y]
  ;; Returns the logarithm of the beta function.
  (+ (log-gamma x) (log-gamma y) (- (log-gamma (+ x y)))))
