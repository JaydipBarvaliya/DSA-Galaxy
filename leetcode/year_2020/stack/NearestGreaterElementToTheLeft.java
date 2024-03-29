package com.leetcode.year_2020.stack;

import com.util.LogUtil;

import java.util.Stack;

/**
 * @author jaydip on 13/05/20
 * Copyright (c) 2019, data-structures.
 * All rights reserved.
 */
public class NearestGreaterElementToTheLeft {

    public static void main(String[] args) {
        printAllNearestGreaterElementToTheLeft(new int[]{1, 3, 2, 4});
        printAllNearestGreaterElementToTheLeft(new int[]{1, 8, 2, 4});
        printAllNearestGreaterElementToTheLeft(new int[]{1, 3, 0, 0, 1, 2, 4});
    }

    private static void printAllNearestGreaterElementToTheLeft(int[] arr) {
        LogUtil.logIt("Printing All Nearest Greater Element to the Left", true);
        /**
         * In {@link NearestGreaterElementToTheRight} we started from right
         * here we will start the iteration from left.
         */
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (stack.isEmpty()) {
                System.out.println(i + " ===> " + -1);
            } else {
                while (!stack.isEmpty() && stack.peek() <= i) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    System.out.println(i + " ===> " + -1);
                } else {
                    System.out.println(i + " ===> " + stack.peek());
                }
            }
            stack.push(i);
        }
    }
}
