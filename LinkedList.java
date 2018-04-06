package com.homework;

//用单链表实现增删改查功能

import java.util.Objects;

public class LinkedList implements List {
    private class Node{
        String data;
        Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    //头节点和尾节点以及链表的长度
    private Node first;
    private Node last;
    private int size;

    @Override
    public boolean add(String s, int index) {
        rangeCheck(index);
        Node pre=findPre(index);
        link(pre,s);
        return true;
    }

    private void link(Node pre, String s) {
        if(pre==null){
            //新节点添加到第一个位置
            first=new Node(s,first);
            if(size==0){//空链表
                last=first;
            }
        }else {
            Node node=pre.next;
            pre.next=new Node(s,node);
            //表尾
            if(pre.next==null){
                last=pre.next;
            }
        }
        size++;

    }

    //找到链表的前一个结点
    private Node findPre(int index) {
        //添加的元素是线性表中的第一个元素(第一个元素的前面是没有结点的)
        if(index==0)
            return null;
        //找到index位置的前面一个结点
        Node node=first;
        for (int i = 1; i <index ; i++) {
            node=node.next;
        }
        return node;
    }

    /**
     * Checks if the given index is in range.  If not, throws an appropriate
     * runtime exception.  This method does *not* check if the index is
     * negative: It is always used immediately prior to an array access,
     * which throws an ArrayIndexOutOfBoundsException if index is negative.
     */
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    //尾插法
    @Override
    public boolean add(String s) {
        link(last,s);//前缀是尾节点
        return true;
    }
    //实现头插法
    public boolean addHead(String e) {
        link(null, e);
        return true;
    }

        @Override
    public String remove(int index) {
        rangeCheck(index);
        Node pre=findPre(index);
        String delete=deleNode(pre);
        return delete;
    }

    private String deleNode(Node pre) {
        String delete=null;
        if(pre==null){//删除头节点
            delete=first.data;
            if(first.next==null){
                last=null;
            }
        }else {
            Node willDele=pre.next;
            delete=willDele.data;
            pre.next=willDele.next;     //删除节点
        }
        size--;
        return delete;
    }


    @Override
    public void set(int index, String newValue) {
        rangeCheck(index);
        Node node=findPre(index+1);
        node.data=newValue;

    }

    @Override
    public int indexOf(String s) {
        int index=0;
        for (Node node=first; node !=null ; node=node.next) {
            if(Objects.equals(s,node.data))
                return index;
            index++;
        }
        return -1;
    }
    @Override
    public String toString(){
        if(size==0){
            return "[]";
        }
        StringBuilder sb=new StringBuilder("[");
        for (Node node=first;node.next!=null;node=node.next){
            sb.append(node.data);
            sb.append(",");
        }
        sb.append(last.data);
        sb.append("]");
        return sb.toString();
    }
}



