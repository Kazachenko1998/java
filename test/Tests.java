import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import DirectedGraph.Graph;
import DirectedGraph.MatrixSquad;
public class Tests {

    @Test
    @Tag("deletePoint")
    void test() {

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


        assertEquals(graph.deletePoint("E"), graph1);
        matr.setMatrix(new Object[][]{
                {"A" ,2 ,-1,-1, -1},
                {-1,"B" ,4 ,7 ,-1},
                {1 ,-1,"C" ,6 ,-1},
                {-1,-1,5 ,"D" ,-1},
                {-1,-1,-1 ,-1 ,"E"},
        });
        graph1 = new Graph(matr);
        assertEquals(graph.deletePoint("E").addPoint("E"), graph1);
        graph=graph.deletePoint("E").addPoint("E");
        matr.setMatrix(new Object[][]{
                {"A" ,2 ,-1,-1, -1},
                {999,"B" ,4 ,7 ,-1},
                {1 ,-1,"C" ,6 ,-1},
                {-1,-1,5 ,"D" ,-1},
                {-1,-1,-1 ,-1 ,"E"},
        });
        graph1 = new Graph(matr);
        graph.addTrack("A","B",999);
        assertEquals(graph, graph1);
        graph.deleteTrack("A","B");
        System.out.println(graph + "\n удал путь");
        System.out.println(graph.input("B"));
        System.out.println(graph + "\n вход");
        System.out.println(graph.output("B"));
        System.out.println(graph + "\n выход");
        graph.renamePoint("A","Lena");
        System.out.println(graph + "\n переименование");
        System.out.println(graph + "\n конечн");

    }
}
