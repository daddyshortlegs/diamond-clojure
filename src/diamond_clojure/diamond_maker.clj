(ns diamond-clojure.diamond_maker
  (:gen-class))

(use '[clojure.string :only [index-of]])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn diamond-maker [char]
  (if (= char "A")
    (str "A")
    (str " A\nB B\n A\n"))
  )

(defn get-index-for-char [char]
  (index-of "ABCDEFGHIJKLMNOPQRSTUVWXYZ" char)
  )

(defn gen-leading-spaces [char index]
  (def num-spaces (- (get-index-for-char char) index))
  (apply str (take num-spaces (repeat " ")))
  )
