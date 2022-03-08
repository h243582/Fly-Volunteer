package com.test2;


import com.test1.A;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Arr extends A {
    private int anInt;

    public void add() {
        this.anInt = tree;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arr arr = (Arr) o;
        return anInt == arr.anInt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt);
    }

    public static void method1(String... args) {


    }

}
