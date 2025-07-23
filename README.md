# Scala Learning Journey 🚀

Welcome to your Scala learning adventure! This repository contains examples, exercises, and projects to help you master Scala programming.

## What is Scala?

Scala (Scalable Language) is a modern programming language that combines:
- **Object-oriented programming** (like Java)
- **Functional programming** (like Haskell)
- **Static typing** with powerful type inference
- **JVM compatibility** (runs on the Java Virtual Machine)

## Key Features

- **Concise syntax** - Less boilerplate than Java
- **Type inference** - Compiler figures out types automatically
- **Immutability** - Encourages functional programming patterns
- **Pattern matching** - Powerful control structures
- **Higher-order functions** - Functions that take/return other functions
- **Case classes** - Immutable data structures with built-in equality
- **Traits** - Similar to interfaces but with implementation

## What You Can Build

- Web applications (Play, Akka HTTP)
- Data processing (Apache Spark)
- Microservices (Lagom)
- Backend APIs (Akka, http4s)
- Desktop applications
- Android apps
- Big data applications
- Financial applications

## Project Structure

```
scala-learning/
├── src/
│   ├── main/
│   │   └── scala/
│   │       ├── basics/           # Basic Scala concepts
│   │       ├── functional/       # Functional programming
│   │       ├── oop/             # Object-oriented programming
│   │       ├── collections/      # Collections and data structures
│   │       └── projects/         # Mini projects
│   └── test/
│       └── scala/               # Unit tests
├── build.sbt                    # Build configuration
└── README.md                    # This file
```

## Getting Started

1. **Prerequisites**: Java 11+ and Scala 3.x
2. **Build Tool**: sbt (Scala Build Tool)
3. **IDE**: IntelliJ IDEA with Scala plugin (recommended)

## Learning Path

### 1. Basics
- Variables and types
- Functions
- Control structures
- Pattern matching

### 2. Functional Programming
- Immutability
- Higher-order functions
- Option/Some/None
- Either/Left/Right
- For comprehensions

### 3. Object-Oriented Programming
- Classes and objects
- Traits
- Case classes
- Companion objects

### 4. Collections
- Lists, Sets, Maps
- Immutable vs mutable
- Common operations
- Streams and lazy evaluation

### 5. Advanced Topics
- Type classes
- Implicits
- Macros
- Concurrency with Akka

## Running Examples

```bash
# Start sbt console
sbt

# Run a specific example
sbt "runMain basics.HelloWorld"

# Run tests
sbt test

# Compile
sbt compile
```

## Resources

- [Official Scala Documentation](https://docs.scala-lang.org/)
- [Scala School by Twitter](https://twitter.github.io/scala_school/)
- [Functional Programming in Scala](https://www.manning.com/books/functional-programming-in-scala)
- [Programming in Scala](https://www.artima.com/shop/programming_in_scala_3ed)

## Contributing

This is a personal learning repository. Feel free to:
- Add your own examples
- Improve existing code
- Add exercises and solutions
- Document your learning journey

Happy coding! 🎉 