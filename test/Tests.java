import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import DirectedGraph.Graph;
import DirectedGraph.MatrixSquad;
public class Tests {

    @Test
    @Tag("deletePoint")
    void deletePoint() {
        MatrixSquad matr = new MatrixSquad(5,-1);
        matr.setMatrix(new Object[][]{
                {"A" ,2 ,-1,-1, 8},
                {-1,"B" ,4 ,7 ,-1},
                {1 ,-1,"C" ,6 ,-1},
                {-1,-1,5 ,"D" ,-1},
                {-1,3,-1 ,0 ,"E"},
        });
        Graph graph = new Graph(matr);
        MatrixSquad matr2 = new MatrixSquad(4,-1);
        matr2.setMatrix(new Object[][]{
                {"A" ,2 ,-1,-1},
                {-1,"B" ,4 ,7},
                {1 ,-1,"C" ,6},
                {-1,-1,5 ,"D"},
        });

        Graph graph1 = new Graph(matr2);
        System.out.println(graph);
        System.out.println(graph.output("D"));

        assertEquals(graph.deletePoint("E"), graph1);
    }
}
