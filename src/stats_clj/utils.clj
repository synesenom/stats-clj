(ns stats-clj.utils)

(defn almost-equal?
  "This is a function (like everything in clojure)."
  ([x y precision]
   (if (zero? x)
     (zero? y)
     (< (abs (/ (- x y) x)) precision)
     ))
  ([x y] (almost-equal? x y 1e-10))
  )
