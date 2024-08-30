package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyStudentRecordsMgmtApp {

    public static void main(String[] args) {
        Student[] students = {
                new Student(110001, "Dave", "11/18/1951"),
                new Student(110002, "Anna", "12/07/1990"),
                new Student(110003, "Erica", "01/31/1974"),
                new Student(110004, "Carlos", "08/22/2009"),
                new Student(110005, "Bob", "03/05/1990")
        };

        printListOfStudents(students);
        List<Student> platinumAlumni = getListOfPlatinumAlumniStudents(students);
        platinumAlumni.forEach(s -> System.out.println(s.getName() + " - " + s.getDateOfAdmission()));
    }

    public static void printListOfStudents(Student[] students) {
        Arrays.stream(students)
                .sorted(Comparator.comparing(Student::getName))
                .forEach(s -> System.out.println(s.getName()));
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        return Arrays.stream(students)
                .filter(s -> {
                    return s.getDateOfAdmission().compareTo("1990/01/01") < 0;
                })
                .sorted(Comparator.comparing(Student::getDateOfAdmission).reversed())
                .collect(Collectors.toList());
    }

    public static void printHelloWorld(int[] array) {
        for (int num : array) {
            if (num % 35 == 0) {
                System.out.println("HelloWorld");
            } else if (num % 5 == 0) {
                System.out.println("Hello");
            } else if (num % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    public static int findSecondBiggest(int[] array) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int number : array) {
            if (number > highest) {
                secondHighest = highest;
                highest = number;
            } else if (number > secondHighest) {
                secondHighest = number;
            }
        }
        return secondHighest;
    }

}
