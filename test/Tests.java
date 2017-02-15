import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import DirectedGraph.Graph;
import DirectedGraph.MatrixSquad;


public class Tests {

    @Test
    @Tag("deletePoint")
    void deletePoint() {
        Graph graph = new Graph(new MatrixSquad(5, -1));
        graph.setMatrix(new int[][]{
                {0 ,2 ,-1,-1, 8},
                {-1,0 ,4 ,7 ,-1},
                {1 ,-1,0 ,6 ,-1},
                {-1,-1,5 ,0 ,-1},
                {-1,3,-1 ,0 ,-1},
        });
        Graph graph1 = new Graph(new MatrixSquad(4, -1));
        graph1.setMatrix(new int[][]{
                {0 ,2 ,-1,-1},
                {-1,0 ,4 ,7 },
                {1 ,-1,0 ,6 },
                {-1,-1,5 ,0 },
        });
        assertEquals(graph.deletePoint(4), graph1);
    }
}
