import java.util.*;
public class PerfectFriends {

    //We need to get the number of pairs of friends such that 2 friends do not belong to the same group(same connected component)

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

    public static void getConnectedComponents(ArrayList<ArrayList<Edge>> graph, int src, ArrayList<Integer> component, boolean[] visited) {
        visited[src] = true;
        component.add(src);
        for(Edge edge: graph.get(src)) {
            if(!visited[edge.nbr]) {
                getConnectedComponents(graph, edge.nbr, component, visited);
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(V);

        for(int i = 0; i < V; i++) {
            graph.add(new ArrayList<Edge>());
        }

        boolean[] visited = new boolean[V];

        for(int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            graph.get(v1).add(new Edge(v1, v2));
            graph.get(v2).add(new Edge(v2, v1));
        }

        //System.out.println(graph);

        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                getConnectedComponents(graph, i, component, visited);
                connectedComponents.add(component);
            }
        }

        System.out.println(connectedComponents);

        int numberOfPairs = 0;

        for(int i = 0; i < connectedComponents.size(); i++) {
            for(int j = i + 1; j < connectedComponents.size(); j++) {
                int currentNumberOfPairs = connectedComponents.get(i).size() * connectedComponents.get(j).size();
                numberOfPairs += currentNumberOfPairs;
            }
        }        
        System.out.println(numberOfPairs);


    }
}
