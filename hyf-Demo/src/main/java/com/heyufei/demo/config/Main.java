package com.heyufei.demo.config;

import java.util.Scanner;

class Node {
    public int value;
    public Node next;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();

            Node node = new Node(sc.nextInt());
            Node head = node;

            int a, index;

            for (int i = 0; i < n - 1; i++) {
                node = head;
                a = sc.nextInt();
                index = sc.nextInt();
                Node insert = new Node(a);


                while (node.value != index && node != null) {
                    node = node.next;
                }
                Node p = node.next;
                node.next = insert;
                insert.next = p;
            }

            node = head;
            while (node != null) {
                System.out.print(node.value+" ");
                node = node.next;
            }
            System.out.println(
            );
            int del = sc.nextInt();
            node = head;
            while (node != null) {
                if (node.value != del) {
                    System.out.print(node.value);
                    System.out.print(" ");
                    node = node.next;
                } else {
                    node = node.next;
                }
            }


        }
    }
}
