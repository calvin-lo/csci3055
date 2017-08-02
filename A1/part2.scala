/*
	Added "="" after def
*/
import scala.language.implicitConversions
implicit def IntToBool(i:Int) = if ( i < 0) true else false

def quicksort[K](comparator: (K, K) => Int)(input: List[K]): List[K] = {
  if (input.isEmpty) {
    input
  } else {
  	val pivot = input.head
  	val left = input.filter(comparator(_,pivot))
  	val right = input.filter(comparator(pivot,_))
  	quicksort(comparator)(left) ::: pivot :: quicksort(comparator)(right)

  }
}


val input = List(5, 6, 3, 2, 4);
val comparator = (x:Int, y:Int) =>(x - y)
val sorted = quicksort(comparator)(input)
println (sorted)
