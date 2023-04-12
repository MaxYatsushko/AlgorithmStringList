package org.example;

import org.example.exceptions.StringListNotFoundException;
import org.example.exceptions.StringListNullPointerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringListImplTest {


    private StringListImpl stringList;
    @BeforeEach
    void initEmployees(){
        stringList = new StringListImpl();
    }
    @Test
    public void getStringList_success() {
        //входные данные
        stringList = new StringListImpl(2);

        //ожидаемый результат
        String[] strings = new String[2];

        //начало теста
        String[] actualStrings = stringList.getStringList();
        assertArrayEquals(strings, actualStrings);
    }

    @Test
    public void addIndex_success() {
        //входные данные
        int size = 2;
        String[] strings = new String[size + 1];
        stringList = new StringListImpl(size);

        //ожидаемый результат
        String expectedString = "test string";
        strings[0] = expectedString;

        //начало теста
        String actualString = stringList.add(0, expectedString);
        String[] actualStrings = stringList.getStringList();

        assertEquals(expectedString, actualString);
        assertEquals(strings[0] , stringList.getStringList()[0]);
        assertArrayEquals(strings, actualStrings);
    }

    @Test
    public void addIndex_IndexOutOfBoundsException() {
        //входные данные
        int index = 3, size = 2;
        String itemString = "test string";
        stringList = new StringListImpl(size);

        //ожидаемый результат
        String expectedError = "Index: " + index + ", Size: " + size;

        //начало теста
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> stringList.add(index, itemString));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    public void addItem_success() {
        //ожидаемый результат
        String expectedString = "test string";

        //начало теста
        String actualString = stringList.add(expectedString);
        assertEquals(expectedString, actualString);
    }


    @Test
    public void set_success() {
        //входные данные
        String[] strings = new String[2];
        stringList = new StringListImpl(2);

        //ожидаемый результат
        String expectedString = "test string";
        strings[0] = expectedString;

        //начало теста
        String actualString = stringList.set(0, expectedString);
        String[] actualStrings = stringList.getStringList();

        assertEquals(expectedString, actualString);
        assertArrayEquals(strings, actualStrings);
    }

    @Test
    public void set_IndexOutOfBoundsException() {
        //входные данные
        int index = 4, size = 3;
        String itemString = "test string";
        stringList = new StringListImpl(size);

        //ожидаемый результат
        String expectedError = "Index " + index + " out of bounds for length " + size;

        //начало теста
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> stringList.set(index, itemString));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    public void removeItem_success() {
        //входные данные
        int size = 2;
        stringList = new StringListImpl(size);

        //ожидаемый результат
        String expectedString = "test string";
        stringList.add(expectedString);
        String[] expectedStrings = new String[size + 1];

        //начало теста
        String actualString = stringList.remove(expectedString);
        String[] actualStrings = stringList.getStringList();

        assertEquals(expectedString, actualString);
        assertArrayEquals(expectedStrings, actualStrings);
    }

    @Test
    public void removeItem_StringListNotFoundException() {
        //входные данные
        String itemString = "test string";
        stringList = new StringListImpl();

        //ожидаемый результат
        String expectedError = "Element doesn't found";

        //начало теста
        Exception exception = assertThrows(StringListNotFoundException.class, () -> stringList.remove(itemString));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    public void removeIndex_success() {
        //входные данные
        int index = 0;
        stringList = new StringListImpl();

        //ожидаемый результат
        String expectedString = "test string";
        stringList.add(expectedString);

        //начало теста
        String actualString = stringList.remove(index);

        assertEquals(expectedString, actualString);
    }

    @Test
    public void removeIndex_IndexOutOfBoundsException() {
        //входные данные
        int index = 2, size = 1;
        stringList = new StringListImpl(size);

        //ожидаемый результат
        String expectedError = "Index " + index + " out of bounds for length " + size;

        //начало теста
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> stringList.remove(index));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    public void contains_success() {
        //ожидаемый результат
        String expectedString = "test string";
        String expectedString2 = "dgfdgfd";
        stringList.add(expectedString);

        //начало теста
        boolean isContains = stringList.contains(expectedString);
        boolean isNotContains = stringList.contains(expectedString2);

        assertTrue(isContains);
        assertTrue(!isNotContains);
    }

    @Test
    public void indexOf_success() {
        //входные данные
        String expectedString = "test string";
        String expectedString2 = "dgfdgfd";

        //ожидаемый результат
        stringList.add(expectedString);
        int expectedIndex = 0, indexNotFound = -1;

        //начало теста
        int actualIndex = stringList.indexOf(expectedString);
        int actualIndex1 = stringList.indexOf(expectedString2);

        assertTrue(expectedIndex == actualIndex);
        assertTrue(indexNotFound == actualIndex1);
    }

    @Test
    public void lastIndexOf_success() {
        //входные данные
        String expectedString = "test string";
        String expectedString2 = "dgfdgfd";

        //ожидаемый результат
        stringList.add(expectedString);
        stringList.add(expectedString);
        stringList.add(expectedString);
        int expectedIndex = 2, indexNotFound = -1;

        //начало теста
        int actualIndex = stringList.lastIndexOf(expectedString);
        int actualIndex1 = stringList.lastIndexOf(expectedString2);

        assertTrue(expectedIndex == actualIndex);
        assertTrue(indexNotFound == actualIndex1);
    }

    @Test
    public void get_success() {
        //входные данные
        int index = 0;
        stringList = new StringListImpl();

        //ожидаемый результат
        String expectedString = "test string";
        stringList.add(expectedString);

        //начало теста
        String actualString = stringList.get(index);

        assertEquals(expectedString, actualString);
    }

    @Test
    public void get_IndexOutOfBoundsException() {
        //входные данные
        int index = 2, size = 1;
        stringList = new StringListImpl(size);

        //ожидаемый результат
        String expectedError = "Index " + index + " out of bounds for length " + size;

        //начало теста
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(index));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    public void equals_success() {
        //входные данные
        int size = 1;
        StringListImpl stringList1 = new StringListImpl(size);
        stringList = new StringListImpl(size);
        String itemString = "test string";

        //ожидаемый результат
        stringList1.add(itemString);
        stringList.add(itemString);

        //начало теста
        assertTrue(stringList.equals(stringList1));
    }

    @Test
    public void equals_StringListNullPointerException() {
        //ожидаемый результат
        String expectedError = "StringList is NULL";

        //начало теста
        Exception exception = assertThrows(StringListNullPointerException.class, () -> stringList.equals(null));
        assertEquals(expectedError, exception.getMessage());
    }

    @Test
    public void size_success() {
        //входные данные
        int size = 2;
        String itemString = "test string";

        //ожидаемый результат
        stringList.add(itemString);
        stringList.add(itemString);

        //начало теста
        assertTrue(size == stringList.size());
    }

    @Test
    public void isEmpty_success() {
        //входные данные
        stringList = new StringListImpl();

        //начало теста
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void clear_success() {
        //входные данные
        int size = 0;
        String itemString = "test string";

        //ожидаемый результат
        stringList.add(itemString);
        stringList.add(itemString);

        //начало теста
        stringList.clear();
        assertTrue(size == stringList.size());
    }

    @Test
    public void toArray_success() {
        //входные данные
        int size = 2;
        String itemString = "test string";

        stringList.add(itemString);
        stringList.add(itemString);

        //ожидаемый результат
        String[] expectedStrings = new String[size];
        expectedStrings[0] = itemString;
        expectedStrings[1] = itemString;

        //начало теста
        String[] actualStrings = stringList.toArray();
        assertArrayEquals(expectedStrings, actualStrings);
    }

}