package datastructures.builtin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * I Can Guess the Data Structure!
 *
 * @author Izhari Ishak Aksa
 */
public class Problem11995YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            boolean isQ = true, isS = true, isPQ = true;
            Queue<Integer> qq = new LinkedList<Integer>();
            Stack<Integer> st = new Stack<Integer>();
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    if (o1 >= o2) {
                        return -1;
                    }
                    return 1;
                }
            });
            for (int i = 0; i < n; i++) {
                s = br.readLine();
                if (!isQ && !isS && !isPQ) {
                    continue;
                }
                StringTokenizer temp = new StringTokenizer(s, " ");
                int t = Integer.parseInt(temp.nextToken());
                int x = Integer.parseInt(temp.nextToken());
                if (t == 1) {
                    if (isQ) {
                        qq.offer(x);
                    }
                    if (isS) {
                        st.add(x);
                    }
                    if (isPQ) {
                        pq.offer(x);
                    }
                } else {
                    if (isQ && !qq.isEmpty()) {
                        int y1 = qq.poll();
                        if (y1 != x) {
                            isQ = false;
                        }
                    } else {
                        isQ = false;
                    }
                    if (isS && !st.isEmpty()) {
                        int y2 = st.pop();
                        if (y2 != x) {
                            isS = false;
                        }
                    } else {
                        isS = false;
                    }
                    if (isPQ && !pq.isEmpty()) {
                        int y3 = pq.poll();
                        if (y3 != x) {
                            isPQ = false;
                        }
                    } else {
                        isPQ = false;
                    }
                }
            }
            if (!isQ && !isS && !isPQ) {
                bw.write("impossible\n");
            } else if (isQ && !isS && !isPQ) {
                bw.write("queue\n");
            } else if (isS && !isQ && !isPQ) {
                bw.write("stack\n");
            } else if (isPQ && !isS && !isQ) {
                bw.write("priority queue\n");
            } else {
                bw.write("not sure\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
