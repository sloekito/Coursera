
import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
    public class TreeHeight {
        int n;
        int parent[];

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
        }

        int computeHeight() {
            // Replace this code with a faster implementation
            int maxHeight = 0;
            for (int vertex = 0; vertex < n; vertex++) {
                int height = 0;
                for (int i = vertex; i != -1; i = parent[i])
                    height++;
                maxHeight = Math.max(maxHeight, height);
            }
            return maxHeight;
        }
    }

    class FastScanner2 {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner2(String input) {
            //in = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes())));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class TreeHeight2 {
        int n;
        int parent[];
        Tree tree = new Tree();
        int source;

        Graph g;
        void read() throws IOException {
            String input = "5\n" +
                    "4 -1 4 1 1";
//            String input = "10\n" +
//                    "9 7 5 5 2 9 9 9 2 -1";
            FastScanner2 in = new FastScanner2(input);

            n = in.nextInt();
            parent = new int[n];

            g = new Graph(n);
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
                if(parent[i] == -1)
                {
                    source = i;
                }
                else
                {
                    g.addEdge(parent[i], i);
                }

            }
        }

        int computeHeight() {
//            // Replace this code with a faster implementation
//            int maxHeight = 0;
//            for (int vertex = 0; vertex < n; vertex++) {
//                int height = 0;
//                for (int i = vertex; i != -1; i = parent[i])
//                    height++;
//                maxHeight = Math.max(maxHeight, height);
//            }
//            return maxHeight;

            g.getHeight(source);
            return g.maxHeight;
        }
    }

    public class Graph
    {
        int V; // number of vertices

        private LinkedList<Integer> adj[];

        int height;

        int maxHeight;
        Graph(int v)
        {
            V = v;
            adj = new LinkedList[v];
            height = 0;
            maxHeight = 0;
        }

        void addEdge(int v, int w)
        {
            if(adj[v] == null)
            {
                adj[v] = new LinkedList<Integer>();
            }

            adj[v].add(w);
        }

        // A function used by DFS
        void DFSUtil(int v,boolean visited[])
        {
            //
            // Mark the current node as visited and print it
            //visited[v] = true;
            System.out.println("vertex==== " + v+" ");


            if(adj[v] == null) {
                return;
            }

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
            {

                System.out.println("height " + height);
                if(maxHeight < height)
                {
                    maxHeight = height;
                }
                int n = i.next();
                //if (!visited[n]) {
                    height++;
                    DFSUtil(n, visited);
                //}
            }
            height = 0;
        }

        // The function to do DFS traversal. It uses recursive DFSUtil()
        void DFS(int v)
        {
            // Mark all the vertices as not visited(set as
            // false by default in java)
            boolean visited[] = new boolean[V];

            // Call the recursive helper function to print DFS traversal
            DFSUtil(v, visited);
        }


        void getHeight(int v)
        {
            System.out.println("vertex==== " + v+" ");

            // Recur for all the vertices adjacent to this vertex
            if(adj[v] == null) {

                return;
            }
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext())
            {

                System.out.println("height " + height);
                if(maxHeight < height)
                {
                    maxHeight = height;
                }
                int n = i.next();
                height++;
                getHeight(n);
            }
            height = 0;
        }

    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_height().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        TreeHeight2 tree = new TreeHeight2();
        tree.read();
        System.out.println(tree.computeHeight());
    }
}
