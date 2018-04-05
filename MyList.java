package com.homework;

import java.util.Arrays;
import java.util.Objects;

public class MyList implements List {

    String[] data;
    int size;
    private static final int maxSize=Integer.MAX_VALUE;
    private static final int DEFAULT_NUM=10;
    private static final String[] EMPTY_ELEMENTDATA = {};
    //构造方法初始化
    public MyList() {
        data=new String[DEFAULT_NUM];
    }

    /**
     * @param initialCapacity   初始容量可能发生的情况
     */
    public MyList(int initialCapacity){
        if (initialCapacity > 0) {
            this.data = new String[initialCapacity];
        } else if (initialCapacity == 0) {
            this.data = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    @Override
    public boolean add(String s, int index) {
        rangeCheckForAdd(index);
        ensureCapacity(size+1);
        //数组中元素像后移位:将index后面的元素复制到俩一个数组中
        System.arraycopy(data,index,data,index+1,size-index);
        data[index]=s;
        size++;
        return true;
    }

    /**
     * A version of rangeCheck used by add and addAll.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
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

    /**
     * @param mincapacity   在数组中添加元素后的容量超过数组的长度
     *                      需要对数组进行扩容
     */
    private void ensureCapacity(int mincapacity) {
        if(mincapacity-data.length>0){
            grow(mincapacity);
        }
    }

    /**
     * @param mincapacity   增加容量，能容纳由最小容量参数指定的元素的数量
     *                      详细代码可参照API：ArrayList
     */
    private void grow(int mincapacity) {
        int oldcapacity=data.length;
        int newcapacity=oldcapacity+(oldcapacity>>1);
        if(newcapacity-mincapacity<0)
            newcapacity=mincapacity;
        if(newcapacity-maxSize>0)
            newcapacity=hugeCapacity(mincapacity);

        data=Arrays.copyOf(data,newcapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > maxSize) ?
                Integer.MAX_VALUE :
                maxSize;
    }
    //数组尾部添加元素
    @Override
    public boolean add(String s) {
        ensureCapacity(size+1);
        data[size++]=s;
        return true;
    }

    @Override
    public String remove(int index) {
        rangeCheckForAdd(index);
        String removeS=data[index];
        System.arraycopy(data,index+1,data,index,size-index-1);
        data[size--]=null;
        return removeS;
    }

    @Override
    public void set(int index, String newValue) {
        rangeCheckForAdd(index);
       data[index]=newValue;
    }
    //只能返回数组中s第一次出现的位置
    @Override
    public int indexOf(String s) {
        //若查找的元素是null
        for (int i=0; i <size ; i++) {
            if(Objects.equals(s,data[i]))
                return i;
        }
        return -1;
    }
   public  String toString(){
        if(size==0)
            return "[]";
        StringBuilder sb=new StringBuilder("[");
       for (int i = 0; i <size ; i++) {
           sb.append(data[i]);
           if(i == size -1) {
               sb.append(']');
               break;
           }
           sb.append(",");
       }
       return sb.toString();
    }
}
