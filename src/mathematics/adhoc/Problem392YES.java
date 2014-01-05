package mathematics.adhoc;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Polynomial Showdown.
 *
 * @author Izhari Ishak Aksa
 */
public class Problem392YES {

    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] temp = new int[9];
            for (int i = 0; i < 9; i++) {
                temp[i] = sc.nextInt();
            }
            String[] hasil = new String[9];
            Arrays.fill(hasil, "");
            boolean first = true;
            for (int i = 0, k = 8; i < 7; i++, k--) {
                if (first && temp[i] != 0) {
                    if (temp[i] == 1) {
                        hasil[i] = "x^" + k;
                    } else if (temp[i] == -1) {
                        hasil[i] = "-x^" + k;
                    } else if (temp[i] > 1) {
                        hasil[i] = "" + temp[i] + "x^" + k;
                    } else if (temp[i] < -1) {
                        hasil[i] = "-" + (Math.abs(temp[i])) + "x^" + k;
                    }
                    first = false;
                } else if (temp[i] != 0) {
                    if (temp[i] == 1) {
                        hasil[i] = " + x^" + k;
                    } else if (temp[i] == -1) {
                        hasil[i] = " - x^" + k;
                    } else if (temp[i] > 1) {
                        hasil[i] = " + " + temp[i] + "x^" + k;
                    } else if (temp[i] < -1) {
                        hasil[i] = " - " + (Math.abs(temp[i])) + "x^" + k;
                    }
                }
            }
            boolean ada = false;
            for (int i = 0; i < hasil.length; i++) {
                if (hasil[i].compareTo("") != 0) {
                    ada = true;
                    break;
                }
            }
            if (temp[7] != 0) {
                if (ada) {
                    if (temp[7] == 1 || temp[7] == -1) {
                        if (temp[7] < 0) {
                            hasil[7] = " - x";
                        } else {
                            hasil[7] = " + x";
                        }
                    } else {
                        if (temp[7] < 0) {
                            hasil[7] = " - " + (Math.abs(temp[7])) + "x";
                        } else {
                            hasil[7] = " + " + (Math.abs(temp[7])) + "x";
                        }
                    }
                } else {
                    if (temp[7] == 1 || temp[7] == -1) {
                        if (temp[7] < 0) {
                            hasil[7] = "-x";
                        } else {
                            hasil[7] = "x";
                        }
                    } else {
                        if (temp[7] < 0) {
                            hasil[7] = "-" + (Math.abs(temp[7])) + "x";
                        } else {
                            hasil[7] = "" + (Math.abs(temp[7])) + "x";
                        }
                    }
                    ada = true;
                }
            }
            if (temp[8] != 0) {
                if (ada) {
                    if (temp[8] < 0) {
                        hasil[8] = " - " + (Math.abs(temp[8]));
                    } else {
                        hasil[8] = " + " + temp[8];
                    }
                } else {
                    if (temp[8] < 0) {
                        hasil[8] = "-" + (Math.abs(temp[8]));
                    } else {
                        hasil[8] = "" + temp[8];
                    }
                }

            }
            String ret = "";
            for (int i = 0; i < 9; i++) {
                ret += hasil[i];
            }
            if (ret.compareTo("") != 0) {
                System.out.println(ret.trim());
            } else {
                System.out.println("0");
            }
        }
    }
}
