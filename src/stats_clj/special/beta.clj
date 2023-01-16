(ns stats-clj.special.beta
  (:require [stats-clj.special.log-beta :refer [log-beta]]))

(defn beta [x, y]
  ;; Returns the value of the beta function.
  ;; See https://en.wikipedia.org/wiki/Beta_function.
  (Math/exp (log-beta x y)))
