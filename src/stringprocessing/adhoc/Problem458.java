package stringprocessing.adhoc;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 *
 * @author Izhari Ishak Aksa
 */
public class Problem458 {

    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream(System.in);
        DataOutputStream out = new DataOutputStream(System.out);
        int s;
        while ((s = in.read()) != -1) {
            if (s == 10) {
                out.writeByte(10);
            } else {
                out.writeByte(s - 7);
            }
            out.flush();
        }
    }
}
