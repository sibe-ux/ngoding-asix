package com.javaoop.programmer_zaman_now.java_collection;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueApp {
    public static void main(String[] args) {
        
        // Queue<String> queue = new java.util.LinkedList<>();

        // Queue<String> queue = new ArrayDeque<>();

        // data urut
        Queue<String> queue = new PriorityQueue<>();

        queue.add("m");
        queue.add("nasrul");
        queue.add("wahabi");
        queue.add("okejek");

        // poll : mengambil dan delete data paling atas
        for (String next = queue.poll(); next != null; next = queue.poll()) {
            System.out.println(next);
            System.out.println(queue);
        }

        System.out.println(queue.size());
    }
}
