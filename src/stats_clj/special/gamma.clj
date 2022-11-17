(ns stats-clj.special.gamma)

(def COEFFICIENTS [676.5203681218851,
                   -1259.1392167224028,
                   771.32342877765313,
                   -176.61502916214059,
                   12.507343278686905,
                   -0.13857109526572012,
                   9.9843695780195716e-6,
                   1.5056327351493116e-7])

(defn gamma [z]
  ;; Returns the value of the gamma function using the Lanczos approximation.
  ;; See https://en.wikipedia.org/wiki/Lanczos_approximation.
  (if (< z 0.5)
    (/ Math/PI (* (gamma (- 1 z)) (Math/sin (* Math/PI z))))
    (*
      (reduce (fn [sum i] (+ sum (/ (nth COEFFICIENTS i) (+ z i))))
              0.99999999999980993 [0 1 2 3 4 5 6 7])
      (Math/sqrt (* 2 Math/PI))
      (Math/exp (- 0 (+ z 6.5)))
      (Math/pow (+ z 6.5) (+ z -0.5))
      )))
