# 📚 Fundamental Definitions

> Core Concepts for Understanding Data Structures and Algorithms

<br>

---

<br>

## 📖 Table of Contents

| Definition | Link |
|:---|:---|
| Abstract Data Type (ADT) | [View](#-abstract-data-type-adt) |
| Data Structure (DS) | [View](#-data-structure-ds) |
| Big-O Notation | [View](#-big-o-notation) |
| Time Complexity | [View](#-time-complexity) |
| Space Complexity | [View](#-space-complexity) |
| Complexity Classes | [View](#-complexity-classes) |
| Big-O Simplification Rules | [View](#-big-o-simplification-rules) |

<br>

---

<br>

## 🔹 Abstract Data Type (ADT)

> **"An abstraction of a data structure which provides only the interface to which a data structure must adhere."**

<br>

### Key Takeaways

✅ Theoretical specification defining operations and behavior

✅ Language-agnostic blueprint

✅ Defines the contract that any implementation must follow

<br>

---

<br>

## 🔹 Data Structure (DS)

> **"A way of organizing data so that it can be used effectively."**

<br>

### Key Takeaways

✅ Concrete implementation of an ADT in a specific programming language

✅ Involves writing actual code, managing memory, and implementing logic

✅ One ADT can have multiple DS implementations

<br>

---

<br>

## 🔹 Big-O Notation

> **"A mathematical framework used to describe the upper bound or worst-case scenario of an algorithm's performance as the size of the input (n) approaches infinity."**

<br>

### Key Takeaways

✅ Describes how runtime or memory requirements scale with input size

✅ Represents worst-case scenario performance

✅ Allows comparison of algorithms independent of hardware or constants

<br>

---

<br>

## 🔹 Time Complexity

> **"A measure of the amount of time an algorithm takes to run, expressed as a function of the input size."**

<br>

### Key Takeaways

✅ Quantifies algorithmic efficiency in terms of execution time

✅ Often expressed using Big-O notation (e.g., `O(n)`, `O(log n)`, `O(n²)`)

✅ Critical for selecting appropriate algorithms for performance-sensitive applications

<br>

---

<br>

## 🔹 Space Complexity

> **"A measure of the amount of working memory (RAM) an algorithm requires to execute, expressed as a function of the input size."**

<br>

### Key Takeaways

✅ Quantifies algorithmic efficiency in terms of memory usage

✅ Often expressed using Big-O notation (e.g., `O(1)`, `O(n)`, `O(n²)`)

✅ Important trade-off consideration when comparing algorithms with similar time complexity

<br>

---

<br>

## 🔹 Complexity Classes

> **"The categorization of algorithms based on their growth rate, ranked from most to least efficient."**

<br>

### Key Takeaways

✅ `O(1)` — Constant Time: Algorithm execution time/space independent of input size

✅ `O(log n)` — Logarithmic Time: Execution time grows logarithmically; typically divides search space in half

✅ `O(n)` — Linear Time: Execution time grows directly proportional to input size

✅ `O(n log n)` — Linearithmic Time: Combination of linear and logarithmic operations; common in efficient sorting

✅ `O(n²)` — Quadratic Time: Execution time proportional to the square of input size

✅ `O(n³)` — Cubic Time: Execution time proportional to the cube of input size

✅ `O(2ⁿ)` — Exponential Time: Execution time doubles with each additional input element

✅ `O(n!)` — Factorial Time: Execution time grows by factorial of input size; least efficient class

<br>

---

<br>

## 🔹 Big-O Simplification Rules

> **"Rules for simplifying Big-O expressions to identify dominant growth terms."**

<br>

### Key Takeaways

✅ **Dropping Constants** — Big-O only cares about growth rate relative to n; constant multipliers are ignored. Example: `O(c·f(n))` becomes `O(f(n))`

✅ **Dropping Non-Dominant Terms** — When adding complexities (sequential operations), only the highest growth rate term is kept. Example: `O(f(n) + g(n))` becomes `O(max(f(n), g(n)))`

✅ **Multiplication Rule** — When operations are nested, complexities multiply together. Example: `O(f(n)·g(n))`

<br>

---
