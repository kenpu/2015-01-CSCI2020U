import part1.*;

public class InWordDistribution {
    public static void main(String[] args) {
        if(args.length < 3) {
            System.err.println("Usage: <file> <n> [option]");
            System.exit(0);
        }

        String filename = args[0];
        int n = Integer.parseInt(args[1]);
        boolean show = false;
        int option = Integer.parseInt(args[2]);

        try {
            long start = System.currentTimeMillis();
            Dictionary dict = new Dictionary(filename);
            Distribution dist = dict.inWordDistribution(n, option);

            long duration = System.currentTimeMillis() - start;
            System.out.println("Took: " + duration + " ms");

            if(show) System.out.println(dist);
        } catch(Exception e) {
            System.err.println("Err:" + e);
        }
    }
}
