package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        StringListImpl stringList = new StringListImpl();
        stringList.add("dsdsfs");
        stringList.add("1111");
        stringList.add("22222");
        stringList.add("33333");
        stringList.add(2, "9999");
        System.out.println(stringList.toString());
        stringList.clear();
        System.out.println(stringList.toString());
    }
}