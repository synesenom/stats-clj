(ns stats-clj.special.log-gamma)

(defn res [x]
  (- (* (+ x 0.5) (Math/log (+ x 5.5))) (+ x 5.5)))

(defn log-gamma-core [coeffs z]
  (+ (res z) (Math/log (*
                         (/ 2.5066282746310005 z)
                         (reduce
                           (fn [sum i] (+ sum (/ (nth coeffs i) (+ i (+ 1 z)))))
                           1.000000000190015 [0 1 2 3 4 5])))))

(defn log-gamma [z]
  (max 0 (log-gamma-core [76.18009172947146
                          -86.50532032941677
                          24.01409824083091
                          -1.231739572450155
                          0.1208650973866179e-2
                          -0.5395239384953e-5] z)))
