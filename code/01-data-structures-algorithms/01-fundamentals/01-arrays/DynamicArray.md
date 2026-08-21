# 📚 Static and Dynamic Arrays

> Core Concepts, Complexity Analysis, and Implementation Notes

<br>

---

<br>

## 📖 Table of Contents

| Section | Link |
|:---|:---|
| Core Concept | [View](#-core-concept) |
| Key Mechanics | [View](#-key-mechanics) |
| Time & Space Complexity | [View](#-time--space-complexity) |
| Pros & Cons / Use Cases | [View](#-pros--cons--use-cases) |
| Implementation Notes | [View](#-implementation-notes) |

<br>

---

<br>

## 🔹 Core Concept

> **"A Static Array is a fixed-length, contiguous block of memory containing n elements, indexable from 0 to n-1."**

> **"A Dynamic Array is a resizable array built on top of a static array, which can grow and shrink as needed."**

<br>

### Key Takeaways

✅ Static arrays have a fixed size set at initialization — cannot grow or shrink

<br>

✅ Dynamic arrays wrap a static array internally and resize automatically

<br>

✅ Both store elements in contiguous memory, enabling `O(1)` index-based access

<br>

---

<br>

## 🔹 Key Mechanics

> **"How static constraints, dynamic growth, and element shifting work under the hood."**

<br>

### Key Takeaways

✅ **Static Constraints** — Once initialized with a specific size, the length cannot be changed. If it fills up, no more elements can be added

<br>

✅ **Dynamic Growth** — When adding to a full array, a new array (double the size) is created, all elements are copied over, and the new element is appended

<br>

✅ **Shifting** — Deleting from the middle requires all elements to the right to shift left by one index to prevent gaps

<br>

---

<br>

## 🔹 Time & Space Complexity

> **"Performance characteristics for common operations on static and dynamic arrays."**

<br>

### Key Takeaways

✅ **Access / Update** — `O(1)` for both types

<br>

✅ **Search** — `O(n)` — requires scanning the array

<br>

✅ **Insertion (Append)** — `O(1)` for static (if space allows); amortized `O(1)` for dynamic, spikes to `O(n)` on resize

<br>

✅ **Deletion** — `O(n)` due to element shifting; removing from the very end is `O(1)`

<br>

✅ **Space Complexity** — `O(n)` for both

<br>

---

<br>

## 🔹 Pros & Cons / Use Cases

> **"When to reach for a static array versus a dynamic array."**

<br>

### Key Takeaways

✅ **Static Arrays** — Ideal when the exact maximum number of elements is known ahead of time; avoids resizing overhead

<br>

✅ **Dynamic Arrays** — Best when the number of elements is unknown or unpredictable; trade-off of occasional `O(n)` resize and `O(n)` mid-array removal

<br>

---

<br>

## 🔹 Implementation Notes

> **"Key decisions to keep in mind when implementing a generic DynamicArray."**

<br>

### Key Takeaways

✅ **3 class-level fields** — `array` (backing store), `size` (elements visible to caller), `length` (actual capacity). `size <= length` always

<br>

✅ **2 constructors** — no-arg defaults to capacity `8`; parameterized accepts initial capacity (throws `IllegalArgumentException` if negative)

<br>

✅ **Index safety** — `get`, `set`, and `removeAt` must validate against `size` (not `length`). Slots in `[size, length)` are uninitialized — never expose them

<br>

✅ **Resize up** — `add` doubles capacity when `size == length` before inserting

<br>

✅ **Resize down** — `removeAt` halves capacity when `size <= length / 4`, preventing wasted memory without thrashing

<br>

---