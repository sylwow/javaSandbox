import java.util.Scanner;
import java.util.*;
import java.math.*;
import java.lang.*;

class Scratch {
    public static void main(String[] args) {
        kwadratowa();
    }

    public static void kwadratowa() {
        Scanner oi = new Scanner(System.in);
        int len = oi.nextInt();
        BigDecimal del, B, A, del2;
        while (len-- != 0) {
            int a = oi.nextInt(), b = oi.nextInt(), c = oi.nextInt(), k = oi.nextInt();
            long delta = b * b - 4 * a * c;
            MathContext mc
                    = new MathContext(k + 1);
            if (delta > 0) {
                System.out.print("2 ");
                B = new BigDecimal(-b);
                A = new BigDecimal(2 * a);
                del = new BigDecimal(delta);
                del = del.sqrt(mc);
                del2 = new BigDecimal(del.toString());
                del = del.negate();
                del = del.add(B, mc);
                del = del.divide(A, mc);
                del2 = del2.add(B, mc);
                del2 = del2.divide(A, mc);
                if (del.compareTo(del2) < 0)
                    System.out.println(del.toString() + " " + del2.toString());
                else
                    System.out.println(del2.toString() + " " + del.toString());
            } else if (delta == 0) {
                System.out.print("1 ");
                B = new BigDecimal(-b);
                A = new BigDecimal(2 * a);
                System.out.println(B.divide(A, mc).toString());
            } else
                System.out.println("0");
        }
    }

    public static void kreslarka() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        Map<Integer, Integer> mapa = new HashMap<>();
        int obw = myObj.nextInt(), x = 0, y = 0, sum = 0;
        int i = 0;
        String data = myObj.nextLine();
        data = myObj.nextLine();
        char dir = data.charAt(0), nextDir = 'f';
        while (obw != 0) {
            sum = x + y;
            Integer value = mapa.get(sum);
            nextDir = data.charAt(i);
            if (!((nextDir == 'S' && dir == 'E') || (nextDir == 'W' && dir == 'N') || (nextDir == 'E' && dir == 'S') || (nextDir == 'N' && dir == 'W')))
                if (value != null)
                    mapa.put(sum, value + 1);
                else
                    mapa.put(sum, 1);
            obw--;
            switch (nextDir) {
                case 'N':
                    x++;
                    break;
                case 'S':
                    x--;
                    break;
                case 'E':
                    y++;
                    break;
                case 'W':
                    y--;
                    break;
                default:
                    break;
            }
            i++;
            dir = nextDir;
        }
        //if(data.charAt(0) != dir)
        //  data.put(0, data.get(0) - 1);
        int fin = 0;
        for (Map.Entry<Integer, Integer> it : mapa.entrySet()) {
            int l = it.getValue();
            fin += l / 2;
        }
        System.out.println(fin);
    }
}