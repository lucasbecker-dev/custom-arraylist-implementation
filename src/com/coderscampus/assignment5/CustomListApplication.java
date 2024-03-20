package com.coderscampus.assignment5;

public class CustomListApplication {
    public static void main(String[] args) {
        CustomList<String> customListString = new CustomArrayList<>();

        for (int i = 0; i < 50; i++) {
            customListString.add("element " + i);
        }

        // test print via for loop
        for (int i = 0; i < customListString.getSize(); i++) {
            System.out.println(customListString.get(i));
        }

        // test print via stream.forEach
        customListString.stream()
                        .forEach(System.out::println);

    }
}