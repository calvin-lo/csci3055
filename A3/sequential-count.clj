
(def random (java.util.Random.))

(def mychars 
   (map char (concat (range 48 58) (range 66 91) (range 97 123))))

(defn random-char [] 
  (nth mychars (.nextInt random (count mychars))))

(defn random-string []
  (apply str (take 10 (repeatedly random-char))))

(defn random-list[size] 
    (take size (repeatedly #(random-string))))

(defn count_char [coll] 
    (reduce 
        (fn [n c] 
            (inc n)
        ) 0  (distinct (apply concat coll))
    )
)

(defn sequential-count []
    (loop [N 10]
        (when (<= N 100)
            (print "N " N ": ")
            (time (count_char (random-list N)))
            (recur (+ N 5))
        )
    )
)

(sequential-count)