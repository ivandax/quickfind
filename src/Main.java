import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Main {
    public static void main(String[] args) {
        boolean shouldRunClient = true;

        while(shouldRunClient){
            StdOut.println("Running client");

            String input = StdIn.readString();

            if(input.equals("exit")){
                System.out.println("Exiting...");
                shouldRunClient = false;
            }

            if(input.equals("quickfind")){
                StdOut.println("Enter N");
                int N = StdIn.readInt();
                QuickFind quickFind = new QuickFind(N);
                StdOut.println(Arrays.toString(quickFind.getId()));
                while (!StdIn.isEmpty()){
                    StdOut.println("Enter p and q");
                    int p = StdIn.readInt();
                    int q = StdIn.readInt();
                    System.out.println("Result " + p + " - " + q);
                    if(!quickFind.connected(p, q)){
                        quickFind.union(p, q);
                        System.out.println("Union for " + p + " " + q);
                    }
                    StdOut.println(Arrays.toString(quickFind.getId()));
                }
            }

            if(input.equals("quickunion")){
                StdOut.println("Enter N");
                int N = StdIn.readInt();
                QuickUnion quickUnion = new QuickUnion(N);
                StdOut.println(Arrays.toString(quickUnion.getId()));
                while (!StdIn.isEmpty()){
                    StdOut.println("Enter p");
                    int p = StdIn.readInt();
                    StdOut.println("Enter q");
                    int q = StdIn.readInt();
                    System.out.println("Result " + p + " - " + q);
                    if(!quickUnion.connected(p, q)){
                        quickUnion.union(p, q);
                        System.out.println("Union for " + p + " " + q);
                    }
                    StdOut.println(Arrays.toString(quickUnion.getId()));
                }
            }
        }

    }
}