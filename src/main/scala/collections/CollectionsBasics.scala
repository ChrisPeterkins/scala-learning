package collections

/**
 * CollectionsBasics.scala - Introduction to Scala Collections
 * 
 * This example demonstrates:
 * - Lists, Sets, Maps
 * - Immutable vs mutable collections
 * - Common operations (map, filter, reduce, etc.)
 * - For comprehensions
 * - Streams and lazy evaluation
 */
object CollectionsBasics {
  
  def main(args: Array[String]): Unit = {
    println("=== Scala Collections ===\n")
    
    demonstrateLists()
    demonstrateSets()
    demonstrateMaps()
    demonstrateForComprehensions()
    demonstrateStreams()
    demonstrateCommonOperations()
  }
  
  // 1. Lists - ordered, indexed sequences
  def demonstrateLists(): Unit = {
    println("1. Lists:")
    
    // Creating lists
    val numbers = List(1, 2, 3, 4, 5)
    val fruits = "apple" :: "banana" :: "orange" :: Nil  // Nil is empty list
    val mixed = List(1, "hello", 3.14, true)
    
    println(s"Numbers: $numbers")
    println(s"Fruits: $fruits")
    println(s"Mixed: $mixed")
    
    // List operations
    println(s"First element: ${numbers.head}")
    println(s"All but first: ${numbers.tail}")
    println(s"Is empty: ${numbers.isEmpty}")
    println(s"Length: ${numbers.length}")
    
    // Adding elements (creates new list)
    val moreNumbers = 0 :: numbers
    val evenMore = numbers :+ 6
    println(s"Added to front: $moreNumbers")
    println(s"Added to end: $evenMore")
    
    // Concatenating lists
    val combined = numbers ++ List(6, 7, 8)
    println(s"Combined: $combined")
    
    println()
  }
  
  // 2. Sets - unordered collections of unique elements
  def demonstrateSets(): Unit = {
    println("2. Sets:")
    
    // Creating sets
    val numbers = Set(1, 2, 3, 4, 5)
    val duplicates = Set(1, 2, 2, 3, 3, 3)  // Duplicates are removed
    val empty = Set.empty[Int]
    
    println(s"Numbers: $numbers")
    println(s"With duplicates: $duplicates")
    println(s"Empty set: $empty")
    
    // Set operations
    val set1 = Set(1, 2, 3, 4)
    val set2 = Set(3, 4, 5, 6)
    
    println(s"Union: ${set1 union set2}")
    println(s"Intersection: ${set1 intersect set2}")
    println(s"Difference: ${set1 diff set2}")
    
    // Adding/removing elements
    val newSet = set1 + 5
    val removedSet = set1 - 2
    println(s"Added 5: $newSet")
    println(s"Removed 2: $removedSet")
    
    println()
  }
  
  // 3. Maps - key-value pairs
  def demonstrateMaps(): Unit = {
    println("3. Maps:")
    
    // Creating maps
    val scores = Map("Alice" -> 95, "Bob" -> 87, "Charlie" -> 92)
    val emptyMap = Map.empty[String, Int]
    
    println(s"Scores: $scores")
    println(s"Empty map: $emptyMap")
    
    // Accessing values
    println(s"Alice's score: ${scores("Alice")}")
    println(s"Bob's score: ${scores.get("Bob")}")
    println(s"David's score: ${scores.get("David")}")
    
    // Safe access with default
    println(s"David's score (default 0): ${scores.getOrElse("David", 0)}")
    
    // Adding/updating entries
    val newScores = scores + ("David" -> 88)
    val updatedScores = scores + ("Alice" -> 98)  // Updates existing key
    println(s"Added David: $newScores")
    println(s"Updated Alice: $updatedScores")
    
    // Removing entries
    val withoutBob = scores - "Bob"
    println(s"Without Bob: $withoutBob")
    
    // Iterating over maps
    scores.foreach { case (name, score) =>
      println(s"$name scored $score")
    }
    
    println()
  }
  
  // 4. For comprehensions - powerful way to work with collections
  def demonstrateForComprehensions(): Unit = {
    println("4. For Comprehensions:")
    
    val numbers = List(1, 2, 3, 4, 5)
    val fruits = List("apple", "banana", "orange")
    
    // Basic for comprehension
    val doubled = for (n <- numbers) yield n * 2
    println(s"Doubled: $doubled")
    
    // With filter (guard)
    val evens = for (n <- numbers if n % 2 == 0) yield n
    println(s"Evens: $evens")
    
    // Multiple generators
    val combinations = for {
      n <- numbers
      fruit <- fruits
    } yield s"$n $fruit"
    println(s"Combinations: $combinations")
    
    // With multiple conditions
    val filtered = for {
      n <- numbers if n > 2
      fruit <- fruits if fruit.length > 5
    } yield s"$n $fruit"
    println(s"Filtered combinations: $filtered")
    
    // For comprehension with yield returns a collection
    // Without yield, it's just a loop
    for (n <- numbers) {
      println(s"Processing: $n")
    }
    
    println()
  }
  
  // 5. LazyList - lazy evaluated sequences (replaces Stream)
  def demonstrateStreams(): Unit = {
    println("5. LazyList (Lazy Evaluation):")
    
    // Infinite lazy list of natural numbers
    def naturalNumbers: LazyList[Int] = {
      def loop(n: Int): LazyList[Int] = n #:: loop(n + 1)
      loop(1)
    }
    
    // Take first 10 numbers
    val firstTen = naturalNumbers.take(10)
    println(s"First 10 natural numbers: ${firstTen.toList}")
    
    // Fibonacci lazy list
    def fibonacci: LazyList[Int] = {
      def loop(a: Int, b: Int): LazyList[Int] = a #:: loop(b, a + b)
      loop(0, 1)
    }
    
    val fibFirstTen = fibonacci.take(10)
    println(s"First 10 Fibonacci numbers: ${fibFirstTen.toList}")
    
    // LazyList operations are lazy
    val bigLazyList = naturalNumbers.map(_ * 2).filter(_ > 10)
    val firstFew = bigLazyList.take(5)
    println(s"First 5 even numbers > 10: ${firstFew.toList}")
    
    println()
  }
  
  // 6. Common collection operations
  def demonstrateCommonOperations(): Unit = {
    println("6. Common Operations:")
    
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    
    // Transformations
    val doubled = numbers.map(_ * 2)
    val strings = numbers.map(_.toString)
    println(s"Doubled: $doubled")
    println(s"Strings: $strings")
    
    // Filtering
    val evens = numbers.filter(_ % 2 == 0)
    val odds = numbers.filterNot(_ % 2 == 0)
    println(s"Evens: $evens")
    println(s"Odds: $odds")
    
    // Folding/Reducing
    val sum = numbers.reduce(_ + _)
    val product = numbers.reduce(_ * _)
    val max = numbers.reduce((a, b) => if (a > b) a else b)
    println(s"Sum: $sum")
    println(s"Product: $product")
    println(s"Max: $max")
    
    // Grouping
    val grouped = numbers.groupBy(_ % 2 == 0)
    println(s"Grouped by even/odd: $grouped")
    
    // Sorting
    val sorted = numbers.sorted
    val reverseSorted = numbers.sorted.reverse
    println(s"Sorted: $sorted")
    println(s"Reverse sorted: $reverseSorted")
    
    // Finding
    val firstEven = numbers.find(_ % 2 == 0)
    val allEven = numbers.forall(_ % 2 == 0)
    val anyEven = numbers.exists(_ % 2 == 0)
    println(s"First even: $firstEven")
    println(s"All even: $allEven")
    println(s"Any even: $anyEven")
    
    // Chaining operations
    val result = numbers
      .filter(_ % 2 == 0)      // Keep even numbers
      .map(_ * 2)              // Double them
      .filter(_ > 10)          // Keep numbers > 10
      .reduce(_ + _)           // Sum them
    println(s"Complex operation result: $result")
    
    println()
  }
} 