package exercise.ds;

public interface IQueue {
    /**
     *
     * @param s     队列中添加元素
     * @return      判断能否在队列中添加元素
     */
    boolean addQueue(String s);

    /**
     *
     * @return  删除队头元素
     */
    String dleteQueue();

    /**
     *
     * @return     查找队头的元素
     */
    String backFontQueue();

    String toString();
}
