
// apply methods, syntactic sugar for when a class or object has one main use
class Foo {
  def apply() = 0 
}
val foo = new Foo
foo()
res0: Int = 0


// Objects, used to hold single instances of a class, often used for factories
object Timer {
  var count = 0
  def currentCount(): Long = {
    count += 1
    count
  }
}
Timer.currentCount()
res0: Long = 1


// Functions are Objects, also object-functional programming
// Function is a set of traits, traits define the apply() 
object addOne extends Function1[Int, Int] {
  def apply(m: Int): Int = m + 1 
}
addOne(1)
res0: Int = 2

class AddOne extends (Int => Int) {
  def apply(m: Int): Int = m + 1 
}
var addOne = new AddOne
addOne(1)
res1: Int = 2


// Pattern Matching
// Matching on values
val times = 1
times match {
  case 1 => "one"
  case 2 => "two"
  case _ => "some other number"
}

// Matching with guards
times match {
  case i if i == 1 => "one"
  case i if i == 2 => "two"
  case _ => "some other number"
}

// Matching on type
def bigger(o: Any): Any = {
  o match {
    case i: Int if i < 0 => i - 1
    case i: Int => i + 1
    case d: Double if d < 0.0 => d - 0.1
    case d: Double => d + 0.1
    case text: String => text + "s"
  }
}

// Matching on class members
def calcType(calc: Calculator) = calc match {
  case _ if calc.brand == "HP" && calc.model == "20B" => "financial"
  case _ if calc.brand == "HP" && calc.model == "30B" => "business"
}


// Exceptions, use try-catch-finally syntax that uses pattern matching
try {
  calculator.add(1, 2) 
} catch {
  case e: ServerNotFoundException => log.error(e, "server is not found") 
} finally {
  calculator.close() 
}




