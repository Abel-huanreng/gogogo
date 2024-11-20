package com.example.web;

public enum EnumTestType {
    ONE(1, "one"), TWO(2, "two"), THREE(3, "three");
    private final int code;
    private final String name;

    EnumTestType(int i, String one) {
        this.code = i;
        this.name = one;
    }

    public static void main(String[] args) {
        System.out.println(EnumTestType.ONE);
    }
}
