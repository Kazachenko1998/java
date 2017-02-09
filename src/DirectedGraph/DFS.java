package DirectedGraph;

/**
 * Created by Konstantin on 09.02.2017.
 */

import java.util.ArrayList;
        import java.util.Collections;
        import java.util.LinkedHashMap;
        import java.util.HashSet;
        import java.util.Iterator;
        import java.util.Set;
        import java.util.List;
        import java.util.Map;

public class DFS {

    static class Mark {
        public Mark(int pre, int post) {
            this.pre  = pre;
            this.post = post;
        }
        public int pre;
        public int post;
    };

    // our graph
    static UndirectedGraph1 graph;
    // map of visited vertices
    static Map<String, Mark> visitedMap = new LinkedHashMap<String, Mark>();
    // time counter
    static int counter = 1;

    public static void main(String[] args) {

        graph = new UndirectedGraph1();
        graph.addEdge("A", "B");
        graph.addEdge("A", "E");
        graph.addEdge("B", "C");
        graph.addEdge("B", "E");
        graph.addEdge("C", "F");
        graph.addEdge("E", "F");
        graph.addEdge("F", "I");

        graph.addEdge("D", "G");
        graph.addEdge("D", "H");
        graph.addEdge("G", "H");

        Map<String, List<String>> vm = graph.getVertexMap();

        List<String> vertexList = new ArrayList<String>(vm.size());
        vertexList.addAll(vm.keySet());
        Collections.sort(vertexList);

        for (String v : vertexList) {
            dfs(v);
        }

        for (Map.Entry<String, Mark> entry : visitedMap.entrySet()) {
            Mark m = entry.getValue();
            System.out.format("%1$s : (%2$d, %3$d)\n", entry.getKey(), m.pre, m.post);
        }
    }

    static void dfs(String vertexName) {
        if (visitedMap.containsKey(vertexName)) return;

        // set pre (time of enter)
        visitedMap.put(vertexName, new Mark(counter,-1));
        counter++;

        // retrieve adjacent vertices
        Map<String, List<String>> vm = graph.getVertexMap();
        List<String> adjacentVertices = vm.get(vertexName);

        for (String v : adjacentVertices) {
            if (visitedMap.containsKey(v)) continue;
            dfs(v);
        }

        // set post (time of exit)
        Mark m = visitedMap.get(vertexName);
        m.post = counter++;
    }
}
