(ns stats-clj.special
  (:require [stats-clj.special.log-gamma :as log-gamma]
            [stats-clj.special.gamma :as gamma]))

(def log-gamma log-gamma/log-gamma)
(def gamma gamma/gamma)
