(ns csci3055.a2.quicksort)

;; can take a sequence as argument
(defn quicksort2 [[comparator & coll]]
    (when comparator
        (concat 
            (quicksort2 (filter #(< % comparator) coll))
            (list comparator)
            (quicksort2 (filter #(>= % comparator) coll))
        )
    )
)

;; cannot take a sequence as argument
(defn quicksort [comparator & coll]
    (when comparator
        (concat 
            ;; filter return a lazy sequence, therefore, need to use quicksort2 to do the sorting
            (quicksort2 (filter #(< % comparator) coll))
            (list comparator)
            (quicksort2 (filter #(>= % comparator) coll))
        )
    )
)