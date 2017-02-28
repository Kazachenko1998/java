import static org.junit.jupiter.api.Assertions.assertEquals;

import DirectedGraph.Graph;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;


import java.util.ArrayList;

public class Tests {

    @Test
    @Tag("deletePoint")
    void deletePoint() {
        ArrayList<ArrayList<Integer>> matr = new ArrayList<>();
        ArrayList<Integer> matr1 = new ArrayList<>();
        matr1.add(0);
        matr1.add(2);
        matr1.add(-1);
        matr1.add(-1);
        matr.add(matr1);
        ArrayList<Integer> matr2 = new ArrayList<>();
        matr2.add(8);
        matr2.add(0);
        matr2.add(-1);
        matr2.add(2);
        matr.add(matr2);
        ArrayList<Integer> matr3 = new ArrayList<>();
        matr3.add(1111);
        matr3.add(-10);
        matr3.add(0);
        matr3.add(999);
        matr.add(matr3);
        ArrayList<Integer> matr4 = new ArrayList<>();
        matr4.add(-1);
        matr4.add(0);
        matr4.add(4);
        matr4.add(0);
        matr.add(matr4);
        ArrayList<String> nnnn = new ArrayList<>();
        nnnn.add("Kost");
        nnnn.add("ghbd");
        nnnn.add("100");
        nnnn.add("rrr");
        Graph graphTest = new Graph(matr, nnnn);
        Graph graph = new Graph(matr, nnnn);
        ArrayList<ArrayList<Integer>> matr0 = new ArrayList<>();
        ArrayList<Integer> matr12 = new ArrayList<>();
        matr12.add(0, 0);
        matr12.add(1, 2);
        matr12.add(2, -1);
        matr0.add(matr12);
        ArrayList<Integer> matr22 = new ArrayList<>();
        matr22.add(0, 8);
        matr22.add(1, 0);
        matr22.add(2, -1);

        matr0.add(matr22);
        ArrayList<Integer> matr32 = new ArrayList<>();
        matr32.add(0, 1111);
        matr32.add(1, -10);
        matr32.add(2, 0);
        matr0.add(matr32);
        ArrayList<String> nnnn2 = new ArrayList<>();
        nnnn2.add(0, "Kost");
        nnnn2.add(1, "ghbd");
        nnnn2.add(2, "100");
        graph = new Graph(matr0, nnnn2);
        assertEquals(graphTest.deletePoint("rrr"), graph);
    }

    @Test
    @Tag("addPoint")
    void addPoint() {
        ArrayList<ArrayList<Integer>> matr = new ArrayList<>();
        ArrayList<Integer> matr1 = new ArrayList<>();
        matr1.add(0);
        matr1.add(2);
        matr1.add(-1);
        matr.add(matr1);
        ArrayList<Integer> matr2 = new ArrayList<>();
        matr2.add(8);
        matr2.add(0);
        matr2.add(-1);
        matr.add(matr2);
        ArrayList<Integer> matr3 = new ArrayList<>();
        matr3.add(1111);
        matr3.add(-10);
        matr3.add(0);
        matr.add(matr3);
        ArrayList<Integer> matr4 = new ArrayList<>();
        matr4.add(-1);
        matr4.add(0);
        matr4.add(4);

        ArrayList<String> nnnn = new ArrayList<>();
        nnnn.add("Kost");
        nnnn.add("ghbd");
        nnnn.add("100");
        nnnn.add("rrr");
        Graph graphTest = new Graph(matr, nnnn);
        Graph graph = new Graph(matr, nnnn);
        ArrayList<ArrayList<Integer>> matr0 = new ArrayList<>();
        ArrayList<Integer> matr12 = new ArrayList<>();
        matr12.add(0, 0);
        matr12.add(1, 2);
        matr12.add(2, -1);
        matr0.add(matr12);
        ArrayList<Integer> matr22 = new ArrayList<>();
        matr22.add(0, 8);
        matr22.add(1, 0);
        matr22.add(2, -1);

        matr0.add(matr22);
        ArrayList<Integer> matr32 = new ArrayList<>();
        matr32.add(0, 1111);
        matr32.add(1, -10);
        matr32.add(2, 0);
        matr0.add(matr32);
        ArrayList<String> nnnn2 = new ArrayList<>();
        nnnn2.add(0, "Kost");
        nnnn2.add(1, "ghbd");
        nnnn2.add(2, "100");
        graph = new Graph(matr0, nnnn2);
        assertEquals(graph.addPoint("rrr"), graphTest);
    }


    @Test
    @Tag("addTrack")
    void addTrack() {
        ArrayList<ArrayList<Integer>> matr = new ArrayList<>();
        ArrayList<Integer> matr1 = new ArrayList<>();
        matr1.add(0);
        matr1.add(2);
        matr1.add(-1);
        matr1.add(10);
        matr.add(matr1);
        ArrayList<Integer> matr2 = new ArrayList<>();
        matr2.add(8);
        matr2.add(0);
        matr2.add(-1);
        matr2.add(2);
        matr.add(matr2);
        ArrayList<Integer> matr3 = new ArrayList<>();
        matr3.add(1111);
        matr3.add(-10);
        matr3.add(0);
        matr3.add(999);
        matr.add(matr3);
        ArrayList<Integer> matr4 = new ArrayList<>();
        matr4.add(-1);
        matr4.add(0);
        matr4.add(4);
        matr4.add(0);
        matr.add(matr4);
        ArrayList<String> nnnn = new ArrayList<>();
        nnnn.add("Kost");
        nnnn.add("ghbd");
        nnnn.add("100");
        nnnn.add("rrr");
        Graph graphTest = new Graph(matr, nnnn);
        Graph graph = new Graph(matr, nnnn);
        ArrayList<ArrayList<Integer>> matr0 = new ArrayList<>();
        ArrayList<Integer> matr12 = new ArrayList<>();
        matr12.add(0, 0);
        matr12.add(1, 2);
        matr12.add(2, -1);
        matr12.add(3, -1);
        matr0.add(matr12);
        ArrayList<Integer> matr22 = new ArrayList<>();
        matr22.add(0, 8);
        matr22.add(1, 0);
        matr22.add(2, -1);
        matr22.add(3, 2);
        matr0.add(matr22);
        ArrayList<Integer> matr32 = new ArrayList<>();
        matr32.add(0, 1111);
        matr32.add(1, -10);
        matr32.add(2, 0);
        matr32.add(3, 999);
        matr0.add(matr32);
        ArrayList<Integer> matr42 = new ArrayList<>();
        matr42.add(-1);
        matr42.add(0);
        matr42.add(4);
        matr42.add(0);
        matr0.add(matr42);
        ArrayList<String> nnnn2 = new ArrayList<>();
        nnnn2.add(0, "Kost");
        nnnn2.add(1, "ghbd");
        nnnn2.add(2, "100");
        nnnn2.add(3, "rrr");

        graph = new Graph(matr0, nnnn2);
        assertEquals(graphTest, graph.addTrack("rrr","Kost",10));
    }

    @Test
    @Tag("addTrack")
    void funny() {
        ArrayList<ArrayList<Integer>> matr = new ArrayList<>();
        ArrayList<Integer> matr1 = new ArrayList<>();
        matr1.add(0);
        matr1.add(2);
        matr1.add(-1);
        matr1.add(10);
        matr.add(matr1);
        ArrayList<Integer> matr2 = new ArrayList<>();
        matr2.add(8);
        matr2.add(0);
        matr2.add(-1);
        matr2.add(2);
        matr.add(matr2);
        ArrayList<Integer> matr3 = new ArrayList<>();
        matr3.add(1111);
        matr3.add(-10);
        matr3.add(0);
        matr3.add(999);
        matr.add(matr3);
        ArrayList<Integer> matr4 = new ArrayList<>();
        matr4.add(-1);
        matr4.add(0);
        matr4.add(4);
        matr4.add(0);
        matr.add(matr4);
        ArrayList<String> nnnn = new ArrayList<>();
        nnnn.add("Kost");
        nnnn.add("ghbd");
        nnnn.add("100");
        nnnn.add("rrr");
        Graph graphTest = new Graph(matr, nnnn);

        System.out.println(graphTest+ "\n начальный");
        System.out.println(graphTest.input("ghbd"));
        System.out.println(graphTest + "\n вход");
        System.out.println(graphTest.output("ghbd"));
        System.out.println(graphTest + "\n выход");
        graphTest.renamePoint("100", "Lena");
        System.out.println(graphTest + "\n переименование");
        System.out.println(graphTest + "\n конечн");

    }

    /**
        System.out.println(graph.input("B"));
        System.out.println(graph + "\n вход");
        System.out.println(graph.output("B"));
        System.out.println(graph + "\n выход");
        graph.renamePoint("A", "Lena");
        System.out.println(graph + "\n переименование");
        System.out.println(graph + "\n конечн");
*/

}
