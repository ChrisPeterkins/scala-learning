package oop

/**
 * ObjectOrientedBasics.scala - Introduction to OOP in Scala
 * 
 * This example demonstrates:
 * - Classes and objects
 * - Constructor parameters
 * - Methods and fields
 * - Traits (interfaces with implementation)
 * - Case classes
 * - Companion objects
 * - Inheritance
 */
object ObjectOrientedBasics {
  
  def main(args: Array[String]): Unit = {
    println("=== Object-Oriented Programming in Scala ===\n")
    
    demonstrateClasses()
    demonstrateTraits()
    demonstrateCaseClasses()
    demonstrateCompanionObjects()
    demonstrateInheritance()
  }
  
  // 1. Basic classes
  def demonstrateClasses(): Unit = {
    println("1. Classes:")
    
    // Create instances
    val person1 = new Person("Alice", 30)
    val person2 = new Person("Bob", 25)
    
    println(person1.greet())
    println(person2.greet())
    println(s"${person1.name} is ${person1.age} years old")
    
    // Create a new person with different age
    val person3 = new Person(person1.name, 31)
    println(s"${person3.name} is now ${person3.age} years old")
    
    println()
  }
  
  // 2. Traits - similar to interfaces but with implementation
  def demonstrateTraits(): Unit = {
    println("2. Traits:")
    
    val dog = new Dog("Buddy", "Golden Retriever")
    val cat = new Cat("Whiskers", "Persian")
    
    println(dog.makeSound())
    println(cat.makeSound())
    println(dog.getInfo())
    println(cat.getInfo())
    
    // Using trait methods
    println(s"${dog.name} is a ${dog.breed}")
    println(s"${cat.name} is a ${cat.breed}")
    
    println()
  }
  
  // 3. Case classes - immutable data classes with built-in features
  def demonstrateCaseClasses(): Unit = {
    println("3. Case Classes:")
    
    val point1 = Point(10, 20)
    val point2 = Point(10, 20)
    val point3 = Point(15, 25)
    
    // Automatic toString
    println(s"Point: $point1")
    
    // Automatic equality
    println(s"point1 == point2: ${point1 == point2}")
    println(s"point1 == point3: ${point1 == point3}")
    
    // Pattern matching
    point1 match {
      case Point(x, y) => println(s"Point at ($x, $y)")
    }
    
    // Copy with modifications
    val point4 = point1.copy(x = 15)
    println(s"Modified point: $point4")
    
    // Automatic companion object with apply method
    val point5 = Point.apply(5, 10)
    println(s"Created with apply: $point5")
    
    println()
  }
  
  // 4. Companion objects - static members and factory methods
  def demonstrateCompanionObjects(): Unit = {
    println("4. Companion Objects:")
    
    // Using factory methods
    val email1 = Email.create("user@example.com")
    val email2 = Email.create("invalid-email")
    
    println(s"Email 1: $email1")
    println(s"Email 2: $email2")
    
    // Using apply method
    val email3 = Email("admin@company.com")
    println(s"Email 3: $email3")
    
    // Using static field
    println(s"Default domain: ${Email.defaultDomain}")
    
    println()
  }
  
  // 5. Inheritance
  def demonstrateInheritance(): Unit = {
    println("5. Inheritance:")
    
    val shapes = List(
      new Circle(5.0),
      new Rectangle(4.0, 6.0),
      new Square(3.0)
    )
    
    shapes.foreach { shape =>
      println(s"${shape.getClass.getSimpleName}: area = ${shape.area}, perimeter = ${shape.perimeter}")
    }
    
    println()
  }
}

// Basic class with constructor parameters
class Person(val name: String, val age: Int) {
  def greet(): String = s"Hello, my name is $name and I'm $age years old."
}

// Trait - like an interface but can have implementation
trait Animal {
  def name: String
  def breed: String
  def makeSound(): String
  
  // Default implementation
  def getInfo(): String = s"$name is a $breed"
}

// Classes implementing traits
class Dog(val name: String, val breed: String) extends Animal {
  def makeSound(): String = "Woof!"
}

class Cat(val name: String, val breed: String) extends Animal {
  def makeSound(): String = "Meow!"
}

// Case class - immutable data class with automatic features
case class Point(x: Int, y: Int)

// Case class with companion object
case class Email(address: String) {
  def isValid: Boolean = address.contains("@")
}

// Companion object for Email
object Email {
  val defaultDomain = "example.com"
  
  // Factory method
  def create(address: String): Option[Email] = {
    if (address.contains("@")) Some(Email(address))
    else None
  }
}

// Abstract class for shapes
abstract class Shape {
  def area: Double
  def perimeter: Double
}

// Concrete implementations
class Circle(radius: Double) extends Shape {
  def area: Double = math.Pi * radius * radius
  def perimeter: Double = 2 * math.Pi * radius
}

class Rectangle(width: Double, height: Double) extends Shape {
  def area: Double = width * height
  def perimeter: Double = 2 * (width + height)
}

class Square(side: Double) extends Shape {
  def area: Double = side * side
  def perimeter: Double = 4 * side
} 