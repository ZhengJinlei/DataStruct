package com.homework;

import java.util.Arrays;

public class MyStack implements InterfaceStack {

    String[] data;      //存放元素
    int top;         //栈帧，top=0

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE;
    private static final int DEFAULT_NUM = 10;

    //初始化
    public MyStack() {
        data= new String[DEFAULT_NUM];
        top=0;
    }
    public MyStack(int capacity) {
        data = new String[capacity];
        top=0;
    }

    //判断元素是否入栈
    // 入栈顺序：元素入栈，++top
    @Override
    public boolean push(String s) {
        if (top == MAX_ARRAY_SIZE)
            System.out.println("栈满，元素不能入栈");
        ensureCapacity(top+1);
        data[top]=s;
       top++;

        return true;
    }

    private void ensureCapacity(int minCapacity) {

        if (minCapacity - data.length > 0) {
            grow(minCapacity);
        }
    }

    //确定将栈扩容多少
    private void grow(int minCapacity) {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = MAX_ARRAY_SIZE;
        data = Arrays.copyOf(data, newCapacity);
    }
    //出栈顺序:--top,元素出栈
    @Override
    public String pop() {
        if (top == 0)
            System.out.println("空栈，元素不能出栈");
        checkPositionIndex(top-1);
        //checkPositionIndex(top);
        String oldValue = data[--top];
        data[top] = null;
        //--top;
        return oldValue;
    }


    //插入的位置index只能在栈范围之内
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= top;
    }

    //超出范围抛出异常
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + top;
    }

    //查看栈顶元素
    @Override
    public String peek() {

        checkPositionIndex(top-1);
        String topValue = data[top-1];
        return topValue;
    }

    public String toString() {
        if (top == 0)
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <top-1 ; i++) {
            sb.append(data[i]);
            sb.append(",");
        }
        sb.append(data[top-1]);

        sb.append("]");
        return sb.toString();
    }

}
