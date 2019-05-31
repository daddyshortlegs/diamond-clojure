(ns diamond-clojure.diamond_maker
  (:gen-class))

(use '[clojure.string :only [index-of]])

(defn diamond-maker [char]
  (if (= char "A")
    (str "A")
    (str " A\nB B\n A\n"))
  )

(defn get-index-for-char [char]
  (index-of "ABCDEFGHIJKLMNOPQRSTUVWXYZ" char)
  )

(defn get-char-for-index [index]
  (str (.charAt "ABCDEFGHIJKLMNOPQRSTUVWXYZ" index)))

(defn calc-leading-spaces [char index]
  (- (get-index-for-char char) index))

(defn gen-spaces [num]
  (apply str (take num (repeat " "))))

(defn gen-leading-spaces [char index]
  (gen-spaces (calc-leading-spaces char index))
  )

(defn calc-middle-spaces [char]
  (+ 1 (* 2 (- (get-index-for-char char) 1))))

(defn gen-middle-spaces [char]
  (gen-spaces (calc-middle-spaces char )))

(defn draw-line [char index]
  (str (gen-leading-spaces char index) char (gen-middle-spaces char) char "\n"))