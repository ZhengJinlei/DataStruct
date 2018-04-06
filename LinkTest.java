package com.homework;

public class LinkTest {
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        for (int i = 0; i <20 ; i++) {
            linkedList.add(i+"");
        }
        System.out.println(linkedList);
        System.out.println(linkedList.remove(4));
        System.out.println(linkedList.add("1000"));
        System.out.println(linkedList.toString());
    }
}
