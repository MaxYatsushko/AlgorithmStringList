package org.example;

import java.util.*;

public class StringListImpl implements StringList {


    private String[] stringList;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;
    //private static final String[] EMPTY_ELEMENTDATA = {};
    private static final String[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public StringListImpl() {
        this.stringList = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public String[] getStringList() {
        return stringList;
    }

    @Override
    public String add(String item) {
        add(item, stringList, size);

        return item;
    }

    private void add(String str, String[] stringList, int size) {
        if (size == stringList.length)
            stringList = grow();
        stringList[size] = str;
        this.size = size + 1;
    }

    private String[] grow(int minCapacity) {
        return stringList = Arrays.copyOf(stringList,
                newCapacity(minCapacity));
    }

    private String[] grow() {
        return grow(size + 1);
    }

    private int newCapacity(int minCapacity) {
        int oldCapacity = stringList.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (stringList == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }


    @Override
    public String add(int index, String item) {
        rangeCheckForAdd(index);
        final int size;
        String[] stringTemp;
        if ((size = this.size) == (stringTemp = this.stringList).length)
            stringTemp = grow();
        System.arraycopy(stringTemp, index,
                stringTemp, index + 1,
                size - index);
        stringTemp[index] = item;
        this.size = size + 1;

        return item;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public String set(int index, String item) {
        Objects.checkIndex(index, size);
        //String oldValue = stringList[index];
        stringList[index] = item;

        return item;
    }

    @Override
    public String remove(String item) {
        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(String item) {
        return indexOfRange(item, 0, size);
    }

    int indexOfRange(String item, int start, int end) {
        if (item == null) {
            for (int i = start; i < end; i++) {
                if (stringList[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (item.equals(stringList[i])) {
                    return i;
                }
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(String item) {
        return lastIndexOfRange(item, 0, size);
    }

    int lastIndexOfRange(String item, int start, int end) {
        if (item == null) {
            for (int i = end - 1; i >= start; i--) {
                if (stringList[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = end - 1; i >= start; i--) {
                if (item.equals(stringList[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        Objects.checkIndex(index, size);

        return stringList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int to = size, i = size = 0; i < to; i++)
            stringList[i] = null;
    }
    @Override
    public String[] toArray() {
        return Arrays.copyOf(stringList, size);
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "stringList=" + Arrays.toString(stringList) +
                ", size=" + size +
                '}';
    }
}
