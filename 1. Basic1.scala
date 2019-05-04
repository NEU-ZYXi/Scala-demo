
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

// underscore as an unnamed magical wildcard
def add(m: Int, n: Int): Int = m + n
val add2 = add(2, _: Int)
add2(3)
res0: Int = 5

// curried functions
def multiply(m: Int)(n: Int): Int = m * n
multiply(2)(3)
res0: Int = 6

val timesTwo = multiply(2) _
timesTwo: (Int) => Int = <funciton1>
timesTwo(3)
res1: Int = 6

// variable length arguments
def capitalizeAll(args: String*) = {
  args.map {
    arg => arg.capitalize 
  }
}

// Classes
class Calculator {
  val brand: String = "a"
  def add(m: Int, n: Int): Int = m + n
}

val calc = new Calculator
calc.add(1, 2)
res0: Int = 3
calc.brand
res1: String = "a"

// constructor
calss Calculator(brand: String) {
  val color: String = if (brand == "a") {
    "black"
  } else {
    "white"
  }
}

val calc = new Calculator("a")

// Inheritance
extends

// abstract classes
abstract class Shape {
  def getArea(): Int 
}

class Circle(r: Int) extends Shape {
  def getArea(): Int = {r * r * 3} 
}

// traits are collections of fields and behaviors that can extend or mixin to classes, one class can extend several traits using 'with'
trait Car {
  val brand: String 
}

trait Shiny {
  val factor: Int
}

class BMW extends Car {
  val brand = "BMW" 
}

class BMW extends Car with Shiny {
  val brand = "BMW"
  val factor = 10
}

