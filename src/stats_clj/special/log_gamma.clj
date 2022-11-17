(ns stats-clj.special.log-gamma)

(def COEFFICIENTS [76.18009172947146
                   -86.50532032941677
                   24.01409824083091
                   -1.231739572450155
                   0.1208650973866179e-2
                   -0.5395239384953e-5])

(defn log-gamma [z]
  ;; Runs the modified Lanczos algorithm for log-gamma.
  (+ (- (* (+ z 0.5) (Math/log (+ z 5.5))) (+ z 5.5))
     (Math/log (*
                 (/ 2.5066282746310005 z)
                 (reduce
                   (fn [sum i] (+ sum (/ (nth COEFFICIENTS i) (+ i (+ 1 z)))))
                   1.000000000190015 [0 1 2 3 4 5])))))
