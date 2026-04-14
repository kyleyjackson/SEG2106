import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n = 0;
        try (Scanner s = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter the number of Queens:");
                n = s.nextInt();
                if (n == 2 || n == 3) {
                    System.out.println("No Solution possible for " + n
                            + " Queens. Please enter another number.");
                } else {
                    break;
                }
            }
        }

        long timestamp1 = System.currentTimeMillis();
        System.out.println("Solution to " + n + " queens using hill climbing search:");

        // reset common state before restart
        HillClimbingSearch.resetShared();
        int numThreads = Runtime.getRuntime().availableProcessors();

        ThreadGroup group = new ThreadGroup("HillClimbingGroup");
        HillClimbingSearch[] searches = new HillClimbingSearch[numThreads];
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            searches[i] = new HillClimbingSearch(n);
            threads[i] = new Thread(group, searches[i], "HCS-Thread-" + i);
            threads[i].setDaemon(true); // die automatically if main exits
            threads[i].start();
        }

        // wait until one thread stores a solution
        while (HillClimbingSearch.getSharedSolution() == null) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // stop all remaining threads in the group
        group.interrupt();

        // print solution
        NQueen[] solution = HillClimbingSearch.getSharedSolution();
        searches[0].printState(solution); // printState only needs n, same for all instances

        long timestamp2 = System.currentTimeMillis();
        System.out.println("Execution Time: " + (timestamp2 - timestamp1) + " ms");
    }
}