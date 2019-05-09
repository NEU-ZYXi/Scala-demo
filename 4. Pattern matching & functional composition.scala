
// Function Composition
def f(s: String) = "f(" + s + ")"
def g(s: String) = "g(" + s + ")"

// compose, makes a new function that compose other functions f(g(x))
val fComposeG = f _ compose g _
fComposeG: (String) => String = <function>
fComposeG("wow")
res0: String = f(g(wow))


// andThen, like compose but calls the first function and then the second, g(f(x))
val fAndThenG = f _ andThen g _
fAndThenG: (String) => String = <function>
fAndThenG("wow")
res0: String = g(f(wow))


// Currying vs Partial Application
// ParitalFunction is only defined for certain values of the defined type, use isDefinedAt to determine if the PartialFunction will accept a given argument
val one: ParitialFunction[Int, String] = { case 1 => "one" }
one.isDefinedAt(1)
res0: Boolean = true
one.isDefinedAt(2)
res1: Boolean = false
one(1)
res2: String = one

// PartialFunction can be composed with orElse that reflects whether the PartialFunction is defined over the supplied argument
val two: PartialFunction[Int, String] = { case 2 => "two" }
val three: PartialFunction[Int, String] = { case 3 => "three" }
val wildcard: PartialFunction[Int, String] = { case _ => "something else" }
val partial = one orElse two orElse three orElse wildcard
partial(5)
res0: String = something else
partial(3)
res1: String = three




