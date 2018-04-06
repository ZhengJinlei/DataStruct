package com.homework;

public interface Linked {
    /**
     *
     * @param index     在链表指定位置中添加元素
     * @param element
     */
    public boolean  add(int index,String element);

    /**
     *
     * @param index
     * @return
     */
    public boolean remove(int index);

    /**
     *
     * @return
     */
    String toString();
}
