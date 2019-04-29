
// start the Scala interpreter
sbt console

// Expressions
1 + 1
res0: Int = 2

// Values, cannot change the binding to a val
val two = 1 + 1
two: Int = 2

// Variables, can change the binding
var name = "a"
name = "b"

// Functions
def addOne(m: Int): Int = m + 1
val three = addOne(2)
three: Int = 3

def four() = 2 + 2  // without arguments
four()
res0: Int = 4

// Anonymous Functions
(x: Int) => x + 1
res0: (Int) => Int = <function1>
res0(1)
res1: Int = 2

val addOne = (x: Int) => x + 1  // save anonymous functions to vals
addOne(1)
res0: Int = 2

def timesTwo(i: Int): Int = {  // use {} for multiple lines functions
  println("hello world")
  i * 2
}
