import java.lang.reflect.Array;
import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class library {
    public static void main(String[] args) throws java.lang.Exception {
        class data {
            public int index;
            public int time;

            data(int ind, int val) {
                index = ind;
                time = val;
            }

            data(data da) {
                index = da.index;
                time = da.time;
            }
        }
        class map extends TreeMap<Integer, ArrayList<Integer>> {
            public Iterator<Map.Entry<Integer, ArrayList<Integer>>> it;
            private LinkedList<data> buffor = new LinkedList<data>(); // value 0 / index 1
            private Map.Entry<Integer, ArrayList<Integer>> entry;
            private int ind = 1;
            private ArrayList<Integer> actualIndexes;
            public data actual = new data(0, 0);
            public data trcking;
            private boolean lock = false;

            public void init() {
                it = this.entrySet().iterator();
                entry = it.next();
                ind = 1;
                actualIndexes = entry.getValue();
                actual.index = actualIndexes.get(0);
                actual.time = entry.getKey();
            }

            public void add(int index, int value) {
                List<Integer> val = this.get(value);
                if (val == null)
                    this.put(value, new ArrayList<Integer>(Arrays.asList(index)));
                else
                    val.add(index);
            }

            public boolean next() {
                if (!lock) {
                    if (ind == actualIndexes.size()) {

                        if (it.hasNext()) {
                            entry = it.next();
                            actualIndexes = entry.getValue();
                            ind = 0;
                        } else
                            return false;
                    }
                    if (ind < actualIndexes.size()) {
                        actual.index = actualIndexes.get(ind++);
                        actual.time = entry.getKey();
                    }
                }
                if (!buffor.isEmpty() && actual.time > buffor.getLast().time) {
                    actual = new data(buffor.pollLast());
                }
                return true;
            }

            public data check(data da) {
                if (!next())
                    ;//cos
                if (da.time > actual.time) {
                    if (buffor.isEmpty())
                        buffor.add(new data(da));
                    if (buffor.getFirst().time <= da.time)
                        buffor.addFirst(new data(da));
                    else if (buffor.getLast().time >= da.time)
                        buffor.addLast(new data(da));
                    //return min
                    return actual;
                } else
                    return da;
            }
        }

        Scanner oi = new Scanner(System.in);
        int tests = oi.nextInt();
        while (tests-- != 0) {
            int len = oi.nextInt(), i = 0, val = 0;
            List<Integer[]> indexes = new ArrayList<Integer[]>();

            map dataset = new map();

            //get values in map <value , index>
            while (i != len) {
                val = oi.nextInt();
                i++;
                dataset.add(i, val);
            }
            dataset.init();
            //System.out.println("xddd")
            data now = new data(dataset.actual);
            int finalTime = 0;
            //calculate min time & put indexes in array
            while (dataset.next()) {
                int max = Math.max(now.index, dataset.actual.index);
                int index = Math.min(now.index, dataset.actual.index);
                indexes.add(new Integer[]{index, max});
                now.time += dataset.actual.time;
                finalTime += now.time;
                now = dataset.check(now);
            }
            System.out.println(finalTime);
            for (Integer[] couple : indexes) {
                System.out.println(couple[0] + " " + couple[1]);
            }
        }
    }

}
