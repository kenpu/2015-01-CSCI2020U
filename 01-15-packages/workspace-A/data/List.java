package data;

import java.util.ArrayList;

public class List<T> {
    ArrayList<T> array;
    int count;

    public List() {
        this.array = new ArrayList<T>();
        this.count = 0;
    }
    public void add(T element) throws Exception {
        if(count < 10) {
            array.add(element);
            count += 1;
        } else {
            throw new Exception("OVERFLOW");
        }
    }
    public void print() {
        String s = "";
        for(T element: array) {
            s += element + " ";
        }

        System.out.println(s);
    }
}
