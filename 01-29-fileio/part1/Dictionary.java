package part1;

import java.util.*;
import java.io.*;

public class Dictionary {
    String filename;

    public Dictionary(String filename) {
        this.filename = filename;
    }

    public Distribution inWordDistribution(int n, int option) throws Exception {
        Map<String, Integer> counts;
        
        if(option == 0)
            counts = new HashMap<String, Integer>(100);
        else if(option == 1)
            counts = new HashMap<String, Integer>(10000);
        else
            counts = new TreeMap<String, Integer>();

        BufferedReader reader = new BufferedReader(
                new FileReader(this.filename));

        String word = reader.readLine();
        while(word != null) {
            word = word.toLowerCase();
            // compute the ngrams
            if(! word.endsWith("'s")) {
                for(String gram : this.ngrams(word, n)) {
                    int c = (counts.containsKey(gram)) 
                                ? counts.get(gram) + 1 
                                : 1;
                    counts.put(gram, c);
                }
            }
            
            word = reader.readLine();
        }
        reader.close();

        return new Distribution(counts);
    }

    // for "present", n=3, it returns:
    // ["pre", "res", "ese", "sen", "ent"]
    public static List<String> ngrams(String word, int n) {
        List<String> list = new ArrayList<String>();
        for(int i=0; i < word.length() - n + 1; i++) {
            list.add(word.substring(i, i + n));
        }
        return list;
    }
}

