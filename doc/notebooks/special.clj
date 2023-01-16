;; # The `special` namespace
;; This namespace implements various special functions used across `stats-clj`.

^{::clerk/toc :collapsed}
^{::clerk/visibility {:code :hide :result :hide}}
(require '[stats-clj.special :as special])

;; ## special/beta [x y]
;; The [beta function](https://en.wikipedia.org/wiki/Beta_function):
^{::clerk/visibility {:code :hide}}
(clerk/tex "\\Beta(x, y) = \\frac{\\Gamma(x) \\Gamma(y}{\\Gamma(x + y)}")

^{::clerk/visibility {:code :hide}}
(clerk/vl
  {:data     {:values (map (fn [x] {:x x :y 3 :z (special/beta x 3)}) (range 0.1 6 0.1))}
   :width    600
   :height   300
   :autosize {:type "fit"}
   :mark     {:type "line"}
   :encoding {:x {:field :x
                  :type  :quantitative}
              :y {:field :z
                  :title "y"
                  :type  :quantitative
                  :scale {:type "log"}}}})
;; TODO Add more curves.

^{::clerk/visibility {:code :hide :result :hide}}
(defn plot [func & {:keys [logy] :or {logy false}}]
  (clerk/vl
    {:data     {:values (map (fn [x] {:x x :y (func x)}) (range 0.1 6 0.1))}
     :width    600
     :height   300
     :autosize {:type "fit"}
     :mark     {:type "line"}
     :encoding {:x {:field :x
                    :type  :quantitative}
                :y {:field :y
                    :type  :quantitative
                    :scale (if logy {:type "log"} {})}}
     })
  )

;; ## special/gamma [x]
;; The [gamma function](https://en.wikipedia.org//wiki/Gamma_function):
^{::clerk/visibility {:code :hide}}
(clerk/tex "\\Gamma(x) = \\int_0^\\infty t^{x - 1} e^{-t} dt.")

^{::clerk/visibility {:code :hide}}
(plot special/gamma :logy true)

;; ## special/log-gamma [x]
;; The [natural logarithm](https://mathworld.wolfram.com/LogGammaFunction.html) of the gamma function.
^{::clerk/visibility {:code :hide}}
(plot special/log-gamma)

