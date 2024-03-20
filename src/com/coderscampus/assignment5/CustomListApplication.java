package com.coderscampus.assignment5;

public class CustomListApplication {
    public static void main(String[] args) {
        CustomList<String> customListString = new CustomArrayList<>();
        final int LIST_SIZE = 21;
        System.out.println("Populating CustomArrayList");
        for (int i = 0; i < LIST_SIZE; i++) {
            customListString.add("element " + i);
        }
        System.out.println("CustomArrayList size after populating: " + customListString.getSize());
        System.out.println("--------------------");
        System.out.println("For loop print:");
        for (int i = 0; i < customListString.getSize(); i++) {
            try {
                System.out.println(customListString.get(i));
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("--------------------");
        System.out.println("Stream print:");
        customListString.stream()
                        .forEach(System.out::println);
        System.out.println("--------------------");
        System.out.println("For loop print with intentional exceptions:");
        for (int i = -5; i < LIST_SIZE + 5; i++) {
            try {
                System.out.println(customListString.get(i));
            } catch (IndexOutOfBoundsException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}