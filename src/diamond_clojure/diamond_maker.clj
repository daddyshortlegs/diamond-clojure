(ns diamond-clojure.diamond_maker
  (:gen-class))

(use '[clojure.string :only [index-of]])



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
  (apply str (gen-leading-spaces char index) (get-char-for-index index) (gen-middle-spaces (get-char-for-index index)) (get-char-for-index index) "\n"))

(defn generate-tip [char]
  (str (gen-leading-spaces char 0) "A\n"))

(defn draw-top [char]
  (apply str (for [x (range 1 (+ 1 (get-index-for-char char)))]
    (draw-line char x))))

(defn draw-body [char]
  (apply str
         (generate-tip char)
         (draw-top char)
         (draw-line char 1)
         (generate-tip char)
         ))

(defn diamond-maker [char]
  (if (= char "A")
    (str "A")
    (draw-body char)

    )
  )