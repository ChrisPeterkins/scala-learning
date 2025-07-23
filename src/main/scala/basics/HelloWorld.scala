package basics

/**
 * HelloWorld.scala - Your first Scala program!
 * 
 * This example demonstrates:
 * - Basic Scala syntax
 * - Object declaration (singleton)
 * - Main method
 * - String interpolation
 * - Basic variable declarations
 */
object HelloWorld {
  
  // Main method - entry point of the program
  def main(args: Array[String]): Unit = {
    println("Hello, Scala World! 🚀")
    
    // Basic variable declarations
    val name = "Scala Learner"  // val = immutable (like final in Java)
    var age = 25               // var = mutable (avoid when possible)
    
    // String interpolation with s"..." (similar to f-strings in Python)
    println(s"Welcome, $name! You are $age years old.")
    
    // Type annotations (optional due to type inference)
    val greeting: String = "Hello from Scala!"
    val number: Int = 42
    
    println(greeting)
    println(s"The answer is: $number")
    
    // Basic function call
    val result = addNumbers(10, 20)
    println(s"10 + 20 = $result")
    
    // Demonstrate some basic operations
    demonstrateBasics()
  }
  
  // Function definition
  def addNumbers(a: Int, b: Int): Int = {
    a + b  // Last expression is the return value
  }
  
  // Function with type inference (return type can be omitted)
  def multiplyNumbers(a: Int, b: Int) = a * b
  
  // Unit return type (equivalent to void in Java)
  def demonstrateBasics(): Unit = {
    println("\n=== Basic Scala Features ===")
    
    // 1. Type inference
    val list = List(1, 2, 3, 4, 5)  // Type is inferred as List[Int]
    val map = Map("a" -> 1, "b" -> 2)  // Type is inferred as Map[String, Int]
    
    println(s"List: $list")
    println(s"Map: $map")
    
    // 2. String interpolation
    val x = 10
    val y = 20
    println(s"$x + $y = ${x + y}")
    
    // 3. Raw strings (no interpolation)
    val rawString = raw"This is a raw string with \n newline character"
    println(rawString)
    
    // 4. Multi-line strings
    val multiLine = """
      |This is a
      |multi-line
      |string
      |""".stripMargin
    println(multiLine)
  }
} 