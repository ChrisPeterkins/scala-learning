package projects

/**
 * Calculator.scala - A simple functional calculator
 * 
 * This project demonstrates:
 * - Case classes for data modeling
 * - Pattern matching for control flow
 * - Functional programming principles
 * - Error handling with Either
 * - Algebraic data types
 */
object Calculator {
  
  def main(args: Array[String]): Unit = {
    println("=== Functional Calculator ===\n")
    
    // Test basic operations
    testBasicOperations()
    
    // Test complex expressions
    testComplexExpressions()
    
    // Test error handling
    testErrorHandling()
    
    // Interactive calculator
    runInteractiveCalculator()
  }
  
  // Algebraic data type for expressions
  sealed trait Expression
  
  case class Number(value: Double) extends Expression
  case class Add(left: Expression, right: Expression) extends Expression
  case class Subtract(left: Expression, right: Expression) extends Expression
  case class Multiply(left: Expression, right: Expression) extends Expression
  case class Divide(left: Expression, right: Expression) extends Expression
  
  // Error handling with Either
  type CalculationResult = Either[String, Double]
  
  // Evaluator function
  def evaluate(expr: Expression): CalculationResult = expr match {
    case Number(value) => Right(value)
    
    case Add(left, right) =>
      for {
        l <- evaluate(left)
        r <- evaluate(right)
      } yield l + r
    
    case Subtract(left, right) =>
      for {
        l <- evaluate(left)
        r <- evaluate(right)
      } yield l - r
    
    case Multiply(left, right) =>
      for {
        l <- evaluate(left)
        r <- evaluate(right)
      } yield l * r
    
    case Divide(left, right) =>
      for {
        l <- evaluate(left)
        r <- evaluate(right)
        result <- if (r != 0) Right(l / r) else Left("Division by zero")
      } yield result
  }
  
  // Pretty printer for expressions
  def prettyPrint(expr: Expression): String = expr match {
    case Number(value) => value.toString
    case Add(left, right) => s"(${prettyPrint(left)} + ${prettyPrint(right)})"
    case Subtract(left, right) => s"(${prettyPrint(left)} - ${prettyPrint(right)})"
    case Multiply(left, right) => s"(${prettyPrint(left)} * ${prettyPrint(right)})"
    case Divide(left, right) => s"(${prettyPrint(left)} / ${prettyPrint(right)})"
  }
  
  // Test basic operations
  def testBasicOperations(): Unit = {
    println("Testing Basic Operations:")
    
    val expressions = List(
      ("Simple addition", Add(Number(5), Number(3))),
      ("Simple subtraction", Subtract(Number(10), Number(4))),
      ("Simple multiplication", Multiply(Number(6), Number(7))),
      ("Simple division", Divide(Number(15), Number(3)))
    )
    
    expressions.foreach { case (description, expr) =>
      val result = evaluate(expr)
      result match {
        case Right(value) => println(s"$description: ${prettyPrint(expr)} = $value")
        case Left(error) => println(s"$description: Error - $error")
      }
    }
    println()
  }
  
  // Test complex expressions
  def testComplexExpressions(): Unit = {
    println("Testing Complex Expressions:")
    
    // (5 + 3) * (10 - 2)
    val complex1 = Multiply(
      Add(Number(5), Number(3)),
      Subtract(Number(10), Number(2))
    )
    
    // (20 / 4) + (6 * 2)
    val complex2 = Add(
      Divide(Number(20), Number(4)),
      Multiply(Number(6), Number(2))
    )
    
    val complexExpressions = List(
      ("Complex 1", complex1),
      ("Complex 2", complex2)
    )
    
    complexExpressions.foreach { case (description, expr) =>
      val result = evaluate(expr)
      result match {
        case Right(value) => println(s"$description: ${prettyPrint(expr)} = $value")
        case Left(error) => println(s"$description: Error - $error")
      }
    }
    println()
  }
  
  // Test error handling
  def testErrorHandling(): Unit = {
    println("Testing Error Handling:")
    
    val errorExpressions = List(
      ("Division by zero", Divide(Number(10), Number(0))),
      ("Nested division by zero", Divide(Number(20), Divide(Number(5), Number(0))))
    )
    
    errorExpressions.foreach { case (description, expr) =>
      val result = evaluate(expr)
      result match {
        case Right(value) => println(s"$description: ${prettyPrint(expr)} = $value")
        case Left(error) => println(s"$description: ${prettyPrint(expr)} -> Error: $error")
      }
    }
    println()
  }
  
  // Interactive calculator
  def runInteractiveCalculator(): Unit = {
    println("Interactive Calculator (type 'quit' to exit):")
    println("Available operations: +, -, *, /")
    println("Example: 5 + 3 * 2")
    
    import scala.io.StdIn
    
    def parseExpression(input: String): Option[Expression] = {
      val tokens = input.trim.split("\\s+").toList
      parseTokens(tokens)
    }
    
    def parseTokens(tokens: List[String]): Option[Expression] = tokens match {
      case Nil => None
      case single :: Nil => single.toDoubleOption.map(Number.apply)
      case left :: op :: right :: Nil =>
        for {
          l <- left.toDoubleOption.map(Number.apply)
          r <- right.toDoubleOption.map(Number.apply)
          expr <- op match {
            case "+" => Some(Add(l, r))
            case "-" => Some(Subtract(l, r))
            case "*" => Some(Multiply(l, r))
            case "/" => Some(Divide(l, r))
            case _ => None
          }
        } yield expr
      case _ => None
    }
    
    def loop(): Unit = {
      print("> ")
      val input = StdIn.readLine()
      
      if (input.toLowerCase == "quit") {
        println("Goodbye!")
        return
      }
      
      parseExpression(input) match {
        case Some(expr) =>
          evaluate(expr) match {
            case Right(result) => println(s"Result: $result")
            case Left(error) => println(s"Error: $error")
          }
        case None => println("Invalid expression. Use format: number operator number")
      }
      
      loop()
    }
    
    // Uncomment the line below to enable interactive mode
    // loop()
    println("Interactive mode disabled in this demo. Uncomment loop() call to enable.")
  }
}

// Extension method for String to safely convert to Double
extension (s: String) {
  def toDoubleOption: Option[Double] = {
    try Some(s.toDouble)
    catch case _: NumberFormatException => None
  }
} 