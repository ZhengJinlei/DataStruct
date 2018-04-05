package com.homework;

public class ListTest {
    public static void main(String[] args) {
        MyList myList=new MyList();
        for (int i = 0; i <20 ; i++) {
            myList.add(i+"",i);
        }
        System.out.println(myList.toString());
        myList.add(null);
        System.out.println(myList.toString());
        myList.remove(1);
        System.out.println(myList.toString());

        System.out.println(myList.indexOf("10"));
        myList.set(5,"1001");
        System.out.println(myList.toString());

    }


}
