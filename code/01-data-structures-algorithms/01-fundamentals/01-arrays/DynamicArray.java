
// ============================================================================
// STATIC AND DYNAMIC ARRAYS
// ============================================================================
//
// Core Concept:
// A Static Array is a fixed-length, contiguous block of memory containing n
// elements, indexable from 0 to n-1.
// A Dynamic Array is a resizable array built conceptually on top of a static
// array, which can grow and shrink as needed.
//
// Key Mechanics:
// - Static Constraints: Once a static array is initialized with a specific
//   size, its length cannot be changed. If it fills up, no more elements
//   can be added.
// - Dynamic Growth: Relies on an underlying static array. When adding an
//   element to a full array, a new static array (typically double the size)
//   is created, all existing elements are copied over, and the new element
//   is appended.
// - Shifting: Deleting an element from the middle requires all subsequent
//   elements to the right to be shifted left by one index to prevent empty gaps.
//
// Time & Space Complexity:
// - Access/Update: O(1) for both types.
// - Search: O(n) (requires scanning the array).
// - Insertion (Append): O(1) for static (if space allows). For dynamic arrays,
//   it is amortized O(1), but periodically spikes to O(n) when a resize
//   operation is triggered.
// - Deletion: O(n) because of the need to shift elements to fill the gap.
//   (Removing from the very end is O(1)).
// - Space Complexity: O(n) for both.
//
// Pros & Cons / Use Cases:
// - Static Arrays: Ideal when you know the exact maximum number of items
//   ahead of time, as they avoid the overhead memory costs of resizing.
// - Dynamic Arrays: Best used when the number of elements is unknown or
//   unpredictable. However, they carry the trade-off of occasional expensive
//   O(n) operations when growing the array and require shifting when removing
//   items from the middle.
// ============================================================================
//
// Implementation Notes:
// - 3 class-level fields: array (the backing store), size (number of elements
//   visible to the caller), length (actual capacity of the backing array).
//   size <= length always. Callers only ever see/interact with size.
// - 2 constructors: no-arg defaults to capacity 8; parameterized accepts an
//   initial capacity (throws if negative).
// - Index safety: get/set/removeAt must validate against size (not length).
//   Slots in range [size, length) are uninitialized garbage — never expose them.
//   add triggers a resize (double capacity) when size == length before inserting.
//   removeAt shrinks capacity by half when size drops to or below length/4.

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable<T> {

    private T[] array;
    private int size;
    private int length;

    public DynamicArray() {
        this(8);
    }

    public DynamicArray(int length) {
        if (length < 0) throw new IllegalArgumentException("Length should be bigger than 0");
        this.length = length;
        array = (T[]) new Object[length];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return this.array[index];
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        this.array[index] = element;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            this.array[i] = null;
        }
        size = 0;
    }

    public void add(T element) {
        if (size == length) {
            length = length == 0 ? 1 : length * 2;
            T[] newArray = (T[]) new Object[length];
            for (int i = 0; i < size; i++) newArray[i] = array[i];
            array = newArray;
        }
        array[size++] = element;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        size--;
        if (size <= length / 4 && length / 2 > 0) length /= 2;
        T[] newArray = (T[]) new Object[length];

        for (int i = 0, j = 0; i < size + 1; i++) {
            if (i == index) continue;
            newArray[j++] = array[i];
        }
        array = newArray;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element == null ? array[i] == null : array[i].equals(element))
                return i;
        }
        return -1;
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) string.append(",");
            string.append(array[i]);
        }
        string.append("]");
        return string.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return array[index++];
            }
        };
    }
}