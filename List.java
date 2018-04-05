package com.homework;

public interface List {
    /**
     *线性表中指定位置插入一个元素
     * @param e     需要插入的元素
     * @param index 插入元素的位置
     * @return      是否成功插入
     */
    boolean add(String s,int index);

    /**
     * 添加元素
     * @param s     数组中添加元素
     * @return      添加是否成功
     */
    boolean add(String s);

    /**
     *在线性表中指定位置删除一个元素
     * @param index     数组中删除元素所在的位置
     * @return      返回删除的元素的值
     */
    String remove(int index);

    /**
     *
     * @param index     查找数组指定位置位置的元素
     * @param newValue  将指定位置的元素进行修改
     */
    void set(int index,String newValue);

    /**
     *
     * @param s 查找元素在数组中的位置
     * @return
     */
    int indexOf(String s);

    /**
     *
     * @return  显示当前线性表
     */
    String toString();
}
