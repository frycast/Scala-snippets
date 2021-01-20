/*
Following these tutorials:
* https://www.tutorialspoint.com/scala/
* https://docs.scala-lang.org/tour/basics.html
* https://docs.scala-lang.org/overviews/scala-book/prelude-taste-of-scala.html

*/

// %% Creating / declaring a package
// The package declaration is first non-comment line in source code, e.g.,
// package com.liftcode.stuff

// %% Importing a package
// You can import more than one class or object from a single package
import scala.collection.mutable.HashMap
import scala.collection.immutable.{TreeMap, TreeSet} // more than one

// %% Operator identifiers
// An operator identifier consists of one or more operator characters, e.g.,
// + ++ ::: <?> :>

// %% Mixed identifiers
// consists of an alphanumeric identifier, which is followed by an underscore and an operator identifier
// unary_+,  myvar_=

// %% Literal identifiers
// is an arbitrary string enclosed in back ticks (` . . . `), e.g.,
// `x` `<clinit>` `yield`

object Main { 
    // %% The unit return type signifies nothing useful to return (similar to void in Java)
    def main(args: Array[String]): Unit = {
        println("Some text")

        // %% Name the results of an expression with val
        val x = 1 + 1
        println(x) // 2
        // x = 3 // This does not compile - cannot re-assign values
        
        // %% Variables are values that can be re-assigned
        var z = 1 + 1
        z = 3

        // %% Explicitly state the type of a value or variable
        val y1: Int = 1 + 1
        var y2: Int = 1 + 1
        
        // %% Blocks
        println({
            val x = 1 + 1
            x + 1
        }) // 3

        // %% Anonymous function
        println( (x: Int) => x + 1 )

        // %% Named functions
        val addOne = (x: Int) => x + 1
        addOne(1)

        // %% Function with multiple parameters
        val add = (x: Int, y: Int) => x + y
        println(add(1, 2)) // 3

        // %% Function with no parameters
        val getTheAnswer = () => 42
        println(getTheAnswer()) // 42

        // %% Methods are different to functions
        // they have a name, parameter list, return type and body
        def add2(x: Int, y: Int): Int = x + y

        // %% A method can take multiple parameter lists
        def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
        println(addThenMultiply(1, 2)(3)) // 9

        // %% A method may take no parameter lists at all
        def name: String = System.getProperty("user.name")
        println("Hello, " + name + "!")

        // %% A multi-line method
        def getSquareString(input: Double): String = {
            val square = input * input
            square.toString
        }
        println(getSquareString(2.5)) // 6.25

        // %% A class is defined using its constructor parameters
        class Greeter(prefix: String, suffix: String) {
            def greet(name: String): Unit =
            println(prefix + name + suffix)
        }
        val greeter = new Greeter("Hello, ", "!")
        greeter.greet("Scala developer") // Hello, Scala developer!

        // %% Case class
        // By default, instances of case classes are immutable, 
        // and they are compared by value (unlike classes, whose instances are compared by reference).
        // This makes them additionally useful for pattern matching.
        case class Point(x: Int, y: Int)
        // Can be instantiated without the new keyword
        val point = new Point(1, 2)
        val anotherPoint = Point(1, 2)
        val yetAnotherPoint = Point(2, 2)
        // Are compared by value
        if (point == anotherPoint) {
            println(point.toString + " and " + anotherPoint.toString + " are the same.")
        } else {
            println(point.toString + " and " + anotherPoint.toString + " are different.")
        } // Point(1,2) and Point(1,2) are the same.

        // %% Objects are single instances of their own definitions
        object IdFactory {
            private var counter = 0
            def create(): Int = {
                counter += 1
                counter
            }
        }
        val newId: Int = IdFactory.create()
        println(newId) // 1
        val newerId: Int = IdFactory.create()
        println(newerId) // 2

        // %% Traits are abstract data types containing certain fields and methods.
        // In Scala inheritance, a class can only extend one other class, but it can extend multiple traits.
        trait Greeter2 {
            def greet(name: String): Unit
        }
        trait Greeter3 {
            def greet(name: String): Unit =
            println("Hello, " + name + "!")
        }
        class DefaultGreeter extends Greeter3
        class CustomizableGreeter(prefix: String, postfix: String) extends Greeter3 {
            override def greet(name: String): Unit = {
                println(prefix + name + postfix)
            }
        }
        val greeter = new DefaultGreeter()
        greeter.greet("Scala developer") // Hello, Scala developer!
        val customGreeter = new CustomizableGreeter("How are you, ", "?")
        customGreeter.greet("Scala developer") // How are you, Scala developer?




    }
}