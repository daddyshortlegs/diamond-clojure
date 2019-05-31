(ns diamond-clojure.diamond_maker
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn diamond-maker [char]
  (if (= char "A")
    (str "A")
    (str " A\nB B\n A\n"))
  )