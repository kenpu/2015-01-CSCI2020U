package part1;

import java.util.*;

public class Distribution implements Comparator<String> {
    Map<String, Integer> counts;

    public Distribution(Map<String, Integer> counts) {
        this.counts = counts;
    }

    // print out the counts in descending order
    public String toString() {
        String s = "";

        Set<String> grams = this.counts.keySet();
        List<String> list = new ArrayList<String>(grams);
        Collections.sort(list, this);
        for(String gram : list) {
            int c = this.counts.get(gram);
            s += gram + ":" + c + "\n";
        }

        return s;
    }

    // compare to grams based on the distribution count
    public int compare(String x, String y) {
        int xCount = 0;
        int yCount = 0;

        if(this.counts.containsKey(x))
            xCount = this.counts.get(x);

        if(this.counts.containsKey(y))
            yCount = this.counts.get(y);

        return -1 * Integer.compare(xCount, yCount);
    }
}
