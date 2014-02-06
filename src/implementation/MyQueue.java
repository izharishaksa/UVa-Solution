package implementation;

/**
 * Implementing Queue.
 *
 * @author Izhari Ishak Aksa
 */
public class MyQueue {

    int maxSize;
    int[] arr;
    int nItem;
    int front;
    int rear;

    public MyQueue(int N) {
        maxSize = N;
        arr = new int[N];
        nItem = 0;
        front = 0;
        rear = -1;
    }

    public void insert(int x) throws Exception {
        if (nItem == maxSize) {
            throw new Exception("Q is full");
        }
        arr[++rear] = x;
        if (rear == maxSize - 1) {
            rear = -1;
        }
        nItem++;
    }

    public int size() {
        return nItem;
    }

    public int poll() {
        nItem--;
        int res = arr[front++];
        if (front == maxSize) {
            front = 0;
        }
        return res;
    }

    public boolean isEmpty() {
        if (nItem == 0) {
            front = 0;
            rear = -1;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return (nItem == maxSize - 1);
    }

    public static void main(String[] args) throws Exception {
        MyQueue mq = new MyQueue(10);
        mq.insert(0);
        mq.insert(-1);
        mq.insert(20);
        mq.insert(21);
        int ind = 0;
        while (!mq.isEmpty()) {
            System.out.println(mq.poll());
            ind++;
            if (ind == 1) {
                break;
            }
        }
        System.out.println("size : " + mq.size());
        mq.insert(4);
        mq.insert(3);
        mq.insert(2);
        mq.insert(1);
        mq.insert(0);
        mq.insert(-1);
        mq.insert(-2);
        while (!mq.isEmpty()) {
            System.out.println(mq.poll());
        }
        mq.insert(4);
        mq.insert(3);
        mq.insert(2);
        while (!mq.isEmpty()) {
            System.out.println(mq.poll());
        }
    }
}
