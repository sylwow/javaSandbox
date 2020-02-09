import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class gimnastyk {
    public static void main(String[] args) {
        int d, v;
        class point {
            public int x = 0;
            public int y = 0;

            public double distance(point p, int d, int v) {
                return (d + Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y)) / v) * 2;
            }
        }
        Scanner oi = new Scanner(System.in);
        int objects = oi.nextInt();
        int time = oi.nextInt();
        d = oi.nextInt();
        point base = new point();
        base.x = oi.nextInt();
        base.y = oi.nextInt();
        v = oi.nextInt();

        List<Double> data = new ArrayList<Double>();
        while (objects-- != 0) {
            point position = new point();
            position.x = oi.nextInt();
            position.y = oi.nextInt();
            double tim = position.distance(base, d, v);
            data.add(tim);
        }
        data.sort(new Comparator<Double>() {
            public int compare(Double l, Double p) {
                return l > p ? 1 : l < p ? -1 : 0;
            }
        });
        int cnt = 0;
        double totalTime = 0;
        for(Double x : data){
            totalTime += x;
            if(totalTime < time)
                cnt++;
            else
                break;
        }
        System.out.println(cnt);
    }
}
