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

(def total (ref 0))

(defn counting [coll]
    (dosync
        (let [result (count_char coll)]
            (alter total + result))
    )
)


(defn future-count [Kthreads]
    (def l1 (random-list 1000000))
    (def K (int (Math/ceil (/ (count l1) Kthreads))))
    (def l2 (partition K K nil l1))
    (loop [n 0]
        (when (< n (count l2))
            (let [t (future (counting (nth l2 n)))]
                (deref t)
            )
            (recur (inc n))
        )
    )
)

(loop [n 1]
    (when (<= n 15)
        (time (future-count n))
        (recur (inc n))
    )
)


;;(time (count_char (random-list 1000000)))
