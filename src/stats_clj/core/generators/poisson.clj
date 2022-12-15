(ns stats-clj.core.generators.poisson)

(defn- poisson-knuth [lambda]
  (loop [k 1 p 1]
    (if (> p (Math/exp (- lambda)))
      (recur (inc k) (* p (rand)))
      (- k 1))))

(defn poisson [lambda]
  ;; TODO Unit test with Chi2.
  ;; When lambda is small (< 30), we run Knuth's algorithm.
  (poisson-knuth lambda)
  )

(poisson 1)
