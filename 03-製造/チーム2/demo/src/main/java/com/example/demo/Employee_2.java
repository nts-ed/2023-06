//package com.example.demo;
//
//import java.util.Random;
//
//public class Employee_2 {
//    private static final String[] DEPARTMENTS = {"所属A", "所属B", "所属C", "所属D"};
//
//    private String id;
//    private String department;
//
//    public Employee_2(String id, String department) {
//        this.id = id;
//        this.department = department;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public static Employee_2 generateRandomEmployee() {
//        Random random = new Random();
//        String id = String.format("EMP%04d", random.nextInt(10000));
//        String department = DEPARTMENTS[random.nextInt(DEPARTMENTS.length)];
//        return new Employee_2(id, department);
//    }
//}
