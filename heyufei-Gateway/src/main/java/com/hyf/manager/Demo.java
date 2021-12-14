package com.hyf.manager;

import lombok.extern.java.Log;

public class Demo {
    public static void main(String[] args) {
        String a1 = "25*64";
        if (a1.contains("\\*"))
            System.out.println("1");
        else
            System.out.println("2");
        if (a1.indexOf('*') != -1)
            System.out.println("3");
        else
            System.out.println("4");
    }

}
