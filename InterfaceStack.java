package com.homework;

public interface InterfaceStack {
    /**
     *
     * @param s    将元素S添加到栈中
     * @return  判断元素是否入栈
     */
    boolean push(String s);

    /**
     *
     * @return  删除栈顶的元素并返回栈顶元素
     */
    String pop();

    /**
     *
     * @return  访问当前栈顶的元素
     */
    String peek();
}
