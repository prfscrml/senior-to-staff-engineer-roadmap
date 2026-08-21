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