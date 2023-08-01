package org.homework5;

import java.util.*;

public class Main {
    static class Notebook {
        private String model;
        private int RAM;
        private int HDDSize;
        private String operatingSystem;
        private String color;

        public Notebook(String model, int RAM, int HDDSize, String operatingSystem, String color) {
            this.model = model;
            this.RAM = RAM;
            this.HDDSize = HDDSize;
            this.operatingSystem = operatingSystem;
            this.color = color;
        }

        public String toString() {
            return "Модель: " + model + ", ОЗУ: " + RAM + " GB, Размер жесткого диска: " + HDDSize + " GB, ОС: " + operatingSystem + ", Цвет: " + color;
        }
    }

    public static void main(String[] args) {

        Set<Notebook> notebooks = new HashSet<>();

        // Fill the set with notebooks
        notebooks.add(new Notebook("Acer", 8, 512, "Windows 10", "Gray"));
        notebooks.add(new Notebook("Asus", 16, 1000, "Windows 11", "Gray"));
        notebooks.add(new Notebook("Lenovo", 16, 256, "Windows 11", "Black"));
        notebooks.add(new Notebook("HP", 4, 500, "Windows 10", "Gray"));
        notebooks.add(new Notebook("Dell", 8, 1000, "Windows 10", "Black"));

        filterNotebooks(notebooks);
    }

    public static void filterNotebooks(Set<Notebook> notebooks) {

        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "ОЗУ");
        criteria.put(2, "Размер жесткого диска");
        criteria.put(3, "Операционная система");
        criteria.put(4, "Цвет");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите критерии фильтрации:");
        for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        int selectedCriteria = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите значение выбранных критериев:");
        String value = scanner.nextLine();

        Set<Notebook> filteredNotebooks = new HashSet<>();
        for (Notebook notebook : notebooks) {
            switch (selectedCriteria) {
                case 1:
                    if (String.valueOf(notebook.RAM).equals(value)) {
                        filteredNotebooks.add(notebook);
                    }
                    break;
                case 2:
                    if (String.valueOf(notebook.HDDSize).equals(value)) {
                        filteredNotebooks.add(notebook);
                    }
                    break;
                case 3:
                    if (notebook.operatingSystem.equalsIgnoreCase(value)) {
                        filteredNotebooks.add(notebook);
                    }
                    break;
                case 4:
                    if (notebook.color.equalsIgnoreCase(value)) {
                        filteredNotebooks.add(notebook);
                    }
                    break;
                default:
                    System.out.println("Недопустимые критерии фильтрации.");
                    return;
            }
        }

        System.out.println("Отфильтрованные данные:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }
}