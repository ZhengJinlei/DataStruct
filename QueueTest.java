package exercise.ds;

public class QueueTest {
    public static void main(String[] args) {
        MyQueue queue=new MyQueue();
        for (int i = 0; i <20;i++) {
            queue.addQueue(i+",");
        }
        System.out.println(queue.toString());
        queue.addQueue("20");
        System.out.println(queue.toString());

        System.out.println(queue.dleteQueue());
        System.out.println(queue.backFontQueue());

    }
}
