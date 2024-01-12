/**
 * This class is performing topological sorting on a directed graph represented by an adjacency matrix.
 * The graph is read from an input file, and the topological sorting result is displayed.
 *
 * @author Kisha Kalra - B00911426
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercise2 {
    //The main method
    public static void main(String[] args) {
        try {
            // Read input from the file
            Scanner input = new Scanner(new File("input1.txt"));

            // Read the number of vertices in the graph
            int numVertices = input.nextInt();
            int[][] adj = new int[numVertices][numVertices];

            // Build adjacency matrix
            while (input.hasNext()) {
                int v0 = input.next().charAt(0) - 'A';
                int v1 = input.next().charAt(0) - 'A';
                adj[v0][v1] = 1;
            }

            input.close();

            // Perform topological sorting
            int[] predecessor = new int[numVertices];
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> result = new LinkedList<>();
            int topnum = 1;

            // Initialize pred array
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    predecessor [j] += adj[i][j];
                }
            }

            // Enqueue vertices with pred(v) == 0
            for (int v = 0; v < numVertices; v++) {
                if (predecessor [v] == 0) {
                    queue.add(v);
                }
            }

            // Perform topological sorting
            while (!queue.isEmpty()) {
                int w = queue.poll();
                result.add(w);

                // Update pred array and enqueue neighbors with pred(p) == 0
                for (int p = 0; p < numVertices; p++) {
                    if (adj[w][p] == 1) {
                        predecessor [p]--;
                        if (predecessor [p] == 0) {
                            queue.add(p);
                        }
                    }
                }
            }

            // Display the result
            System.out.print("topnum: ");
            for (int i : result) {
                System.out.print(topnum + " ");
                topnum++;
            }
            System.out.println();
            for (int i : result) {
                char vertex = (char) (i + 'A');
                System.out.print(vertex + " ");
            }


        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
            e.printStackTrace();
        }
    }
}