package ss10_array_list_link_list.bai_tap.array_list;

import java.util.Arrays;

public class ArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        elements = new Object[capacity];
    }

    private void ensureCapa() {
        if (size > elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    public void add(Object x) {
        size += 1;
        ensureCapa();
        elements[size-1] = x;
    }

    public boolean add(Object x, int index) {
        if (index >= 0 && index <= size) {
            size += 1;
            ensureCapa();
            for (int i = size - 2; i >= index; i--) {
                elements[i + 1] = elements[i];
            }
            elements[index] = x;
            return true;
        }
        return false;
    }

    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
            size -= 1;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public ArrayList<E> clone() {
        ArrayList<E> xx = new ArrayList<>(elements.length);
        for (Object x : elements) {
            xx.add(x);
        }
        return xx;
    }

    public boolean contains(Object e) {
        for (Object x : elements) {
            if (e.equals(x)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object x) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(Object x) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(x)) {
                return true;
            }
        }return false;
    }


    public Object get(int index) {
        if (index >= 0 && index < size) {
            return (Object) elements[index];
        }
        return null;
    }

    public void clear() {
        elements = (Object[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public Object[] getElements() {
        return this.elements;
    }

}
