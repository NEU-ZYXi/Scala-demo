
// Arrays, preserve order, can contain duplicates, mutable
val numbers = Array(1, 2, 3, 4, 5)
numbers(3) = 10


// Lists, preserve order, can contain duplicates, immutable
val numbers = List(1, 2, 3, 4, 5)


// Sets, do not preserve order, have no duplicates
val numbers = Set(1, 2, 2, 3, 3, 4, 5)
numbers: scala.collection.immutable.Set[Int] = Set(1, 4, 5, 2, 3)


// Tuple, a tuple groups together simple logical collection of items without using a class
val hostPort = ("localhost", 80)
// tuple ahs no named accessors, use postion to access which is 1-based index
hostPort._1
res0: String = localhost
hostPort._2
res1: Int = 80


// Maps, hold basic datatypes, can contain Maps or functions as values
Map(1 -> 2)
Map("foo" -> "bar")
Map(1 -> Map("foo" -> "bar"))


// Option, a container that may or may not hold something
trait Option[T] {
  def isDefined: Boolean
  def get: T
  def getOrElse(t: T): T
}
// Map.get uses Option for its return type
val numbers = Map("one" -> 1, "two" -> 2)
numbers.get("two")
res0: Option[Int] = Some(2)
numbers.get("three")
res1: Option[Int] = None


// Functional Combinators
// map, evaluates a function over each element in the list, return a list with the same number of elements
val numbers = List(1, 2, 3, 4, 5)
numbers.map((i: Int) => i * 2)
res0: List[Int] = List(2, 4, 6, 8, 10)

def timesTwo(i: Int): Int = i * 2
numbers.map(timesTwo)
res1: List[Int] = List(2, 4, 6, 8, 10)


// foreach, like map but returns nothing
numbers.foreach((i: Int) => i * 2)


// filter, removes any elements where the filter function evaluates to false
numbers.filter((i: Int) => i % 2 == 0)
res0: List[Int] = List(2, 4)

def isEven(i: Int): Boolean = i % 2 == 0
numbers.filter(isEven)
res1: List[Int] = List(2, 4)


// zip, aggregates the contents of two lists into a single list of pairs
List(1, 2, 3).zip(List("a", "b", "c"))
res0: List[(Int, String)] = List((1,a), (2,b), (3,c))


// partition, splits a list based on where it falls with respect to a predicate function
numbers.partition(_ % 2 == 0)
res0: (List[Int], List[Int]) = (List(2, 4),List(1, 3, 5))


// find, returns the first elememnt of a collection that matches a predicate function
numbers.find((i: Int) => i > 3)
res0: Option[Int] = Some(4)


// drop, drop the first i element
numbers.drop(3)
res0: List[Int] = List(4, 5)
// dropWhile, removes the first element that match a predicate function
numbers.dropWhile(_ % 2 != 0)
res1: List[Int] = List(2, 3, 4, 5)


// foldLeft
numbers.foldLeft(0)((m: Int, n: Int) => m + n)
res0: Int = 55
// 0 is the starting value, m is accumulator, n is the element in the list
// foldRight, same as foldLeft but it runs in the opposite direction
val 

// flatten, collapses one level of nested structure
List(List(1, 2), List(3, 4)).flatten
res0: List[Int] = List(1, 2, 3, 4)


// flatMap, takes a function that works on the nested lists and then concatenates the results back together
val nestedNumbers = List(List(1, 2), List(3, 4))
nestedNumbers.flatMap(x => x.map(_ * 2))
res0: List[Int] = List(2, 4, 6, 8)
// it's a short-hand for mappint and flattening 
nestedNumbers.map((x: List[Int]) => x.map(_ * 2)).flatten








