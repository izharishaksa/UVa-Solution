package series2014.problemsolvingparadigms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Assemble.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem12124YES {

    static class Detail {

        int price, quality;

        public Detail(int price, int quality) {
            this.price = price;
            this.quality = quality;
        }
    }

    static class Component {

        List<Integer> price, quality;
        List<Detail> detail;

        public Component() {
            price = new ArrayList<Integer>();
            quality = new ArrayList<Integer>();
        }

        public void rebuild() {
            detail = new ArrayList<Detail>();
            for (int i = 0; i < price.size(); i++) {
                detail.add(new Detail(price.get(i), quality.get(i)));
            }
            Collections.sort(detail, new Comparator<Detail>() {
                public int compare(Detail o1, Detail o2) {
                    if (o1.price < o2.price) {
                        return -1;
                    } else if (o1.price == o2.price) {
                        return o2.quality - o1.quality;
                    }
                    return 1;
                }
            });
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        while (TC-- > 0) {
            int N = sc.nextInt();
            int budget = sc.nextInt();
            Map<String, Integer> map = new HashMap<String, Integer>();
            int ind = 0;
            List<Component> list = new ArrayList<Component>();
            for (int i = 0; i < N; i++) {
                String type = sc.next();
                sc.next();
                int price = sc.nextInt();
                int quality = sc.nextInt();
                if (!map.containsKey(type)) {
                    map.put(type, ind++);
                    list.add(new Component());
                }
                int x = map.get(type);
                Component c = list.get(x);
                c.price.add(price);
                c.quality.add(quality);
            }
            for (int i = 0; i < list.size(); i++) {
                Component c = list.get(i);
                c.rebuild();
            }
            int min = 0, size = list.size();
            long cur = 0L;
            int[] minC = new int[size];
            int[] used = new int[size];
            boolean bisa = true;
            while (bisa) {
                bisa = false;
                for (int i = 0; i < size; i++) {
                    Component c = list.get(i);
                    if (minC[i] > min) {
                        continue;
                    }
                    for (int j = 0; j < c.price.size(); j++) {
                        int x = c.detail.get(j).price;
                        int y = c.detail.get(j).quality;
                        if (y > min && cur - used[i] + x <= budget) {
                            minC[i] = y;
                            cur -= used[i];
                            used[i] = x;
                            cur += used[i];
                            bisa = true;
                            break;
                        }
                    }
                }
                int curQ = minC[0];
                for (int i = 0; i < size; i++) {
                    curQ = Math.min(curQ, minC[i]);
                }
                min = Math.max(min, curQ);
            }
            System.out.println(min);
        }
    }
}
