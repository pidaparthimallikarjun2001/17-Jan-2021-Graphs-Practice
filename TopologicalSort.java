import java.util.*;
public class TopologicalSort {

    static class Edge {
        int src;
        int nbr;
        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
        public String toString() {
            return src + " " + nbr;
        }
    }

    public static void topologicalSort(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited, Stack<Integer> stack) {
        visited[src] = true;
        for(Edge edge: graph.get(src)) {
            if(!visited[edge.nbr]) {
                topologicalSort(graph, edge.nbr, visited, stack);
            }
        }
        stack.push(src);
    }

    //Permutation of vertices such that for all the edges (u, v), u must appear before v.
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<Edge>());
        }

        boolean[] visited = new boolean[V];

        for(int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph.get(v1).add(new Edge(v1, v2));
        }

        //System.out.println(graph);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                topologicalSort(graph, i, visited, stack);
            }
        }

        while(stack.size() > 0) {
            System.out.print(stack.pop() + " ");
        }
    

    }
}
