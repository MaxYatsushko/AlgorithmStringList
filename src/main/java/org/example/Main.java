package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringListImpl stringList = new StringListImpl();
        stringList.add("dsdsfs");
        stringList.add("1111");
        stringList.add("22222");
        stringList.add("33333");
        System.out.println(stringList.toString());
        System.out.println(stringList.size());
        stringList.clear();
        System.out.println(stringList.toString());
        System.out.println(stringList.size());
        //stringList.remove("2qewdas");
    }
}