(ns diamond-clojure.diamond_maker
  (:gen-class))

(use '[clojure.string :only [index-of]])

(def alphabet "ABCDEFGHIJKLMNOPQRSTUVWXYZ")

(defn get-index-for-char [char] (index-of alphabet char))

(defn char-for-index [index] (str (.charAt alphabet index)))

(defn calc-leading-spaces [char index] (- (get-index-for-char char) index))

(defn gen-spaces [num] (apply str (take num (repeat " "))))

(defn gen-leading-spaces [char index] (gen-spaces (calc-leading-spaces char index)))

(defn calc-middle-spaces [char] (+ 1 (* 2 (- (get-index-for-char char) 1))))

(defn gen-middle-spaces [char] (gen-spaces (calc-middle-spaces char )))

(defn draw-line [char index]
  (let [current-char (char-for-index index)]
    (apply str (gen-leading-spaces char index) current-char (gen-middle-spaces current-char) current-char "\n")))

(defn generate-tip [char] (str (gen-leading-spaces char 0) "A\n"))

(defn draw [char r] (apply str (for [x r] (draw-line char x))))

(defn draw-middle [char]
  (draw char (concat (range 1 (get-index-for-char char)) (range (get-index-for-char char) 0 -1))))

(defn draw-body [char] (apply str (generate-tip char) (draw-middle char) (generate-tip char)))

(defn diamond-maker [char]
  (if (= char "A")
    (str "A")
    (draw-body char))
  )