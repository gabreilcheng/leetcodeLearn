package com.cheng.learn.study01;

import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {


    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(10);
        deque.addFirst(20);
        deque.addFirst(30);
        deque.addLast(11);
        System.out.println(deque);

        System.out.println(deque.peek());
        System.out.println(deque);

        Integer integer = deque.removeFirst();
        System.out.println(integer);

        Integer pop = deque.pop();
        System.out.println(pop);


    }


}
