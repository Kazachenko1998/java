import static org.junit.jupiter.api.Assertions.assertEquals;

import DirectedGraph.Graph;
import DirectedGraph.MatrixSquad;
import org.junit.jupiter.api.Test;


public class Tests {

    @Test
    void deletePoint() {
        Graph graph = new Graph(new MatrixSquad(5,-1));
        graph.track(0,2,1);
        graph.track(1,0,2);
        graph.track(1,4,3);
        graph.track(2,1,4);
        graph.track(2,3,5);
        graph.track(3,2,6);
        graph.track(3,1,7);
        graph.track(4,0,8);

        Graph graph1 = new Graph(new MatrixSquad(4,-1));
        graph1.track(0,2,1);
        graph1.track(1,0,2);
        graph1.track(2,1,4);
        graph1.track(2,3,5);
        graph1.track(3,2,6);
        graph1.track(3,1,7);

assertEquals(graph.deletePoint(4),graph1);
    }
}
