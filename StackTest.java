package com.homework;

public class Test {
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        for (int i = 0; i <20 ; i++) {
            myStack.push(i+"");
        }
        System.out.println(myStack.toString());
        myStack.pop();
        System.out.println(myStack.toString());
        myStack.peek();
        System.out.println(myStack.toString());


    }
}
