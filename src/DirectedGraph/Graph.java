package DirectedGraph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Konstantin on 13.02.2017.
 */
public class Graph {
    private final int size;
    public Object[][] matrix;

    public Graph(MatrixSquad m) {//конструктор графа
        this.matrix = new Object[m.getSize()][m.getSize()];
        this.size = m.getSize();
        int i, j;
        for (i = 0; i < size; i++)
            for (j = 0; j < size; j++) {
                if (m.matrix[i][j] == null) matrix[i][j] = -1;
                else matrix[i][j] = m.matrix[i][j];
            }
    }

    public Object[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(Object[][] matrix) {
        this.matrix = matrix;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Graph)) return false;

        Graph graph = (Graph) o;

        if (getSize() != graph.getSize()) return false;
        return Arrays.deepEquals(matrix, graph.matrix);
    }

    @Override
    public int hashCode() {
        int result = getSize();
        result = 31 * result + Arrays.deepHashCode(matrix);
        return result;
    }

    @Override
    public String toString() {//вывод в консоли
        int i, j;
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if (i == j) sb.append("0" + " ");
                else if ((int) this.matrix[i][j] != -1) sb.append(this.matrix[i][j] + " ");
                else sb.append("- ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public ArrayList output(int point) {
        ArrayList<String> list = new ArrayList<String>();
        int i;
        for (i = 0; i < this.getSize() - 1; i++) {
            if ((int) this.matrix[i][point] > 0) {
                list.add((String) this.matrix[i][point]);
            }
        }
        return list;
    }

    public ArrayList input(int point) {
        ArrayList<String> list = new ArrayList<String>();
        int i;
        for (i = 0; i < this.getSize() - 1; i++) {
            if ((int) this.matrix[point][i] > 0) {
                list.add((String) this.matrix[point][i]);
            }
        }
        return list;
    }

    public Graph add() {

        MatrixSquad matr = new MatrixSquad(this.getSize() + 1, -1);
        int i, j;
        for (i = 0; i < this.getSize(); i++) {
            for (j = 0; j < this.getSize(); j++) {
                matr.matrix[i][j] = this.matrix[i][j];
            }
        }
        matr.matrix[this.getSize()][this.getSize()] = 0;
        return new Graph(matr);
    }

    public void track(int begin, int end, double value) {
        if ((begin == end) && (begin >= this.getSize()) && (begin < 0) && (end >= this.getSize()) && (end < 0) && (value > 0))
            throw new IllegalArgumentException("");
        this.matrix[begin][end] = value;
    }

    public void deleteTrack(int begin, int end) {
        this.track(begin, end, -1);
    }


    public static void main(String[] D) {
        MatrixSquad graph = new MatrixSquad(4, -1);
        graph.matrix[0][1] = 1;
        graph.matrix[1][2] = 2;
        graph.matrix[3][2] = 3;
        graph.matrix[1][3] = 4;
        graph.matrix[0][3] = 5;
        graph.matrix[2][1] = 6;
        Graph g = new Graph(graph);
        System.out.println(g);
        g = g.add();
        System.out.println(g);

    }
}
