package com.coderscampus.assignment5;

public class CustomListApplication {
    public static void main(String[] args) {
        CustomList<String> customListString = new CustomArrayList<>();
        CustomList<Integer> customListInteger = new CustomArrayList<>();

        for (int i = 0; i < 50; i++) {
            customListString.add("element " + i);
        }

        for (int i = 0; i < 100; i++) {
            customListInteger.add(i);
        }

//        for (int i = 0; i < customListString.getSize(); i++) {
//            System.out.println(customListString.get(i));
//        }
        customListString.stream()
                        .forEach(System.out::println);
        customListInteger.stream()
                         .forEach(System.out::println);
    }
}