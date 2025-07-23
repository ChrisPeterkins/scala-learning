package functional

/**
 * FunctionalBasics.scala - Introduction to Functional Programming in Scala
 * 
 * This example demonstrates:
 * - Immutability
 * - Higher-order functions
 * - Anonymous functions (lambdas)
 * - Function composition
 * - Option type
 * - Pattern matching
 */
object FunctionalBasics {
  
  def main(args: Array[String]): Unit = {
    println("=== Functional Programming in Scala ===\n")
    
    demonstrateImmutability()
    demonstrateHigherOrderFunctions()
    demonstrateOptions()
    demonstratePatternMatching()
    demonstrateFunctionComposition()
  }
  
  // 1. Immutability - prefer val over var
  def demonstrateImmutability(): Unit = {
    println("1. Immutability:")
    
    // Immutable list - cannot be modified after creation
    val numbers = List(1, 2, 3, 4, 5)
    println(s"Original list: $numbers")
    
    // Create new list with additional element
    val newNumbers = numbers :+ 6
    println(s"New list: $newNumbers")
    println(s"Original list unchanged: $numbers")
    
    // This would cause a compilation error:
    // numbers(0) = 10  // Error: value update is not a member of List[Int]
    
    println()
  }
  
  // 2. Higher-order functions - functions that take/return other functions
  def demonstrateHigherOrderFunctions(): Unit = {
    println("2. Higher-Order Functions:")
    
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    // map - transform each element
    val doubled = numbers.map(x => x * 2)
    println(s"Doubled: $doubled")
    
    // filter - keep elements that satisfy a condition
    val evens = numbers.filter(x => x % 2 == 0)
    println(s"Even numbers: $evens")
    
    // reduce - combine all elements into a single value
    val sum = numbers.reduce((a, b) => a + b)
    println(s"Sum: $sum")
    
    // More concise syntax with underscore
    val product = numbers.reduce(_ * _)
    println(s"Product: $product")
    
    // Chaining operations
    val result = numbers
      .filter(_ % 2 == 0)  // Keep even numbers
      .map(_ * 2)          // Double them
      .reduce(_ + _)       // Sum them
    println(s"Sum of doubled evens: $result")
    
    println()
  }
  
  // 3. Option type - safe handling of nullable values
  def demonstrateOptions(): Unit = {
    println("3. Option Type:")
    
    // Safe division that returns Option[Double]
    def safeDivide(a: Double, b: Double): Option[Double] = {
      if (b != 0) Some(a / b) else None
    }
    
    val result1 = safeDivide(10, 2)
    val result2 = safeDivide(10, 0)
    
    // Pattern matching with Option
    result1 match {
      case Some(value) => println(s"10 / 2 = $value")
      case None => println("Division by zero!")
    }
    
    result2 match {
      case Some(value) => println(s"Result: $value")
      case None => println("Division by zero!")
    }
    
    // Using Option methods
    val defaultValue = result2.getOrElse(0.0)
    println(s"Default value for division by zero: $defaultValue")
    
    // map on Option
    val doubled = result1.map(_ * 2)
    println(s"Doubled result: $doubled")
    
    println()
  }
  
  // 4. Pattern matching - powerful control structure
  def demonstratePatternMatching(): Unit = {
    println("4. Pattern Matching:")
    
    def describe(x: Any): String = x match {
      case 0 => "zero"
      case 1 => "one"
      case n: Int if n > 0 => s"positive number: $n"
      case n: Int if n < 0 => s"negative number: $n"
      case s: String => s"string: '$s'"
      case list: List[_] => s"list with ${list.length} elements"
      case _ => "something else"
    }
    
    println(describe(0))
    println(describe(42))
    println(describe(-5))
    println(describe("hello"))
    println(describe(List(1, 2, 3)))
    println(describe(3.14))
    
    println()
  }
  
  // 5. Function composition
  def demonstrateFunctionComposition(): Unit = {
    println("5. Function Composition:")
    
    // Define some simple functions
    val addOne = (x: Int) => x + 1
    val multiplyByTwo = (x: Int) => x * 2
    val square = (x: Int) => x * x
    
    // Compose functions using andThen
    val addOneThenMultiply = addOne.andThen(multiplyByTwo)
    val addOneThenSquare = addOne.andThen(square)
    
    println(s"addOneThenMultiply(5) = ${addOneThenMultiply(5)}")
    println(s"addOneThenSquare(5) = ${addOneThenSquare(5)}")
    
    // Compose multiple functions
    val complexFunction = addOne.andThen(multiplyByTwo).andThen(square)
    println(s"complexFunction(3) = ${complexFunction(3)}")
    
    // Using compose (reverse order)
    val reverseCompose = square.compose(multiplyByTwo).compose(addOne)
    println(s"reverseCompose(3) = ${reverseCompose(3)}")
    
    println()
  }
} 