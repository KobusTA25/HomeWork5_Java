package org.homework5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Пример заполнения телефонной книги данными
        addContact(phoneBook, "Иванов", "123456789");
        addContact(phoneBook, "Петров", "987654321");
        addContact(phoneBook, "Сидоров", "555555555");
        addContact(phoneBook, "Иванов", "777777777");

        // Вывод телефонной книги
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Если имя уже присутствует в телефонной книге, добавляем номер к существующему списку номеров
        if (phoneBook.containsKey(name)) {
            List<String> numbers = phoneBook.get(name);
            numbers.add(phoneNumber);
        } else {
            // Если имя отсутствует, создаем новую запись в телефонной книге с одним номером
            List<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            phoneBook.put(name, numbers);
        }
    }

    // Метод для вывода телефонной книги, отсортированной по убыванию числа телефонов
    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        // Создаем список для хранения записей имен с количеством телефонов
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем список по убыванию количества телефонов
        Collections.sort(entries, new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> o1, Map.Entry<String, List<String>> o2) {
                return Integer.compare(o2.getValue().size(), o1.getValue().size());
            }
        });

        // Выводим отсортированные записи на экран
        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> numbers = entry.getValue();
            System.out.println(name + ": " + numbers);
        }
    }

}