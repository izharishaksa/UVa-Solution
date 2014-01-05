package mathematics.adhoc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Average Speed.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem10281YES {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int speed = 0;
        double dist = 0;
        int start = 0;
        int end = 0;
        String s = "";
        while ((s = br.readLine()) != null) {
            String[] temp = s.split(" ");
            if (temp.length == 2) {
                end = start;
                int tempSp = speed;
                speed = Integer.parseInt(temp[1]);
                temp = temp[0].split("[:]");
                start = 0;
                start += Integer.parseInt(temp[0]) * 3600;
                start += Integer.parseInt(temp[1]) * 60;
                start += Integer.parseInt(temp[2]);
                double x = (start - end) * 1.0 / 3600;
                dist += (tempSp * x);
                end = 0;
            } else {
                temp = temp[0].split("[:]");
                end += Integer.parseInt(temp[0]) * 3600;
                end += Integer.parseInt(temp[1]) * 60;
                end += Integer.parseInt(temp[2]);
                double x = (end - start) * 1.0 / 3600;
                dist += (speed * x);
                start = end;
                end = 0;
                System.out.print(s + " ");
                System.out.printf("%.2f km\n", dist);
            }
        }
    }
}
