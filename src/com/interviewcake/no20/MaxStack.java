package com.interviewcake.no20;

/*
Created by TahinDani on 2017.08.28..
*/

// Use the built-in Stack class to implement a new class MaxStack
// with a function getMax() that returns the largest element in the
// stack. getMax() should not remove the item.

import java.util.Stack;

public class MaxStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> maxesStack = new Stack<>();

    public void push(Integer i){
        if (maxesStack.empty() || i >= maxesStack.peek()){
            maxesStack.push(i);
        }
        stack.push(i);

    }

    public int pop(){
        int item = stack.pop();
        if (item == maxesStack.peek()){
            maxesStack.pop();
        }
        return item;
    }

    public Integer getMax(){
        return maxesStack.peek();
    }

    public void printStacks(){
        System.out.println("Stack: " + stack.toString());
        System.out.println("Maxes: " + maxesStack.toString());
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(1);
        maxStack.push(2);
        maxStack.push(3);
        maxStack.push(4);
        maxStack.push(2);

        maxStack.pop();
        maxStack.pop();

        maxStack.printStacks();
        System.out.println(maxStack.getMax());
    }

}
