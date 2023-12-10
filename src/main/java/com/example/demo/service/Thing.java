package com.example.demo.service;

public class Thing {

    public static void main(String[] args) {
        int i=0;
        addTwo(i++);
        System.out.println(i);
    }

    private static void addTwo(int i) {
        i+=2;
    }
}
