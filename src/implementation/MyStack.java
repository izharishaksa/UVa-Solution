package implementation;

/**
 * Implementing Stack.
 *
 * @author Izhari Ishak Aksa
 */
public class MyStack {

    int maxSize;
    char[] arr;
    int top;

    public MyStack(int N) {
        maxSize = N;
        arr = new char[N];
        top = -1;
    }

    public void push(char c) {
        arr[++top] = c;
    }

    public char pop() {
        return arr[top--];
    }

    public char peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) throws Exception {
        MyStack ms = new MyStack(10);
        String s = "a{b(c[d]e)f}";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                ms.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if (!ms.isEmpty()) {
                    char cc = ms.pop();
                    if (!((cc == '{' && c == '}') || (cc == '(' && c == ')') || (cc == '[' && c == ']'))) {
                        throw new Exception("Error, doesn't match!");
                    }
                } else {
                    System.out.println("Error, doesn't match!");
                    break;
                }
            }
        }
        s = "a{b(c[d]e[f}";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                ms.push(c);
            } else if (c == '}' || c == ')' || c == ']') {
                if (!ms.isEmpty()) {
                    char cc = ms.pop();
                    if (!((cc == '{' && c == '}') || (cc == '(' && c == ')') || (cc == '[' && c == ']'))) {
                        throw new Exception("Exception: Error, doesn't match!");
                    }
                } else {
                    System.out.println("Error, doesn't match!");
                    break;
                }
            }
        }
        if (!ms.isEmpty()) {
            System.err.println("Error, doesn't match!");
        }
    }
}
