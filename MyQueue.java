package exercise.ds;
//循环队列的插入，删除，查找队头元素

public class MyQueue implements IQueue {
    String[] data;
    int front;
    int rear;
    int size;
    private static final int MaxSiza=Integer.MAX_VALUE;
    private static final String[] Empty_QUEUE={};
    public MyQueue(){
        data=Empty_QUEUE;
    }
    public MyQueue(int capacity){
        data=new String[capacity];
    }
    @Override
    public boolean addQueue(String s) {
        if(rear+1==front)
            System.out.println("循环队列已满，无法存储新元素");
        ensureCapacity(size+2);//循环队列额外空了一个元素空间
        data[rear]=s;
        rear=next(rear);
        size++;
        return true;
    }

    private void ensureCapacity(int capacity) {
        if(capacity-data.length>0){
            grow(capacity);
        }
    }

    private void grow(int capacity) {

        int newCapacity=data.length+(data.length>>1);
        if(newCapacity-MaxSiza>0){
            newCapacity=MaxSiza;
        }
        if(newCapacity-capacity<0){
            newCapacity=capacity;
        }
        String[] strings=new String[newCapacity];
        QueueCopy(data,front,strings,0);
        data=strings;
        front=0;        //font是新数组的起始位置
        rear=size;      //rear是新数组的尾部位置
    }

    //定义一个数组接受元素，从原数组的font开始复制直到元素的rear位置，复制后的数组添加到新数组的stringFirst位置开始
    private void QueueCopy(String[] data, int front, String[] strings, int stringsFirst) {
        for (int i = front,k=stringsFirst; i !=rear ; i=next(i)) {
            strings[k++]=data[i];
        }
    }
    //循环队列移位
    private int next(int r) {
        return (r+1)%data.length;
    }

    @Override
    public String dleteQueue() {
        if(rear==front)
            return null;
        String Head=data[front];
        data[front]=null;
        front=next(front);
        size--;
        return Head;
    }


    @Override
    public String backFontQueue() {
        if(isEmpty())
            return null;
        return data[front];
    }
    @Override
    public String toString(){
        if(size == 0) {
            return "[]";
        }
        StringBuilder sb=new StringBuilder("[");
        for (int i = front; i !=rear; i=next(i)) {
            sb.append(data[i]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return rear==front;
    }
}
