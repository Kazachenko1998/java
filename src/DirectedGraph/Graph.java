package DirectedGraph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private final int size;
    private int[][] matrix;

    public Graph(MatrixSquad m) {//конструктор графа
        this.matrix = new int[m.getSize()][m.getSize()];
        this.size = m.getSize();
        int i, j;
        for (i = 0; i < size; i++)
            for (j = 0; j < size; j++) {
                if (m.matrix[i][j] == null) matrix[i][j] = -1;
                else matrix[i][j] = (int) m.matrix[i][j];
            }
        for (i = 0; i < size; i++) {
            if ((matrix[i][i] != -1) && (matrix[i][i] != 0))
                throw new IllegalArgumentException("Неверный граф");
            else matrix[i][i] = 0;
        }
    }
    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
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
        return Arrays.deepEquals(getMatrix(), graph.getMatrix());
    }

    @Override
    public int hashCode() {
        int result = getSize();
        result = 31 * result + Arrays.deepHashCode(matrix);
        return result;
    }

    @Override
    public String toString() {//вывод в консоли
        int i, j, k, p;
        StringBuilder sb = new StringBuilder();
        sb.append("    ");
        for (i = 0; i < this.getSize(); i++) {
            sb.append("|" + i);
            p = i;
            k = 0;
            while (p > 0) {
                p /= 10;
                k++;
            }
            if (k == 0) k = 1;
            for (p = 0; p < 4 - k; p++) {
                sb.append(" ");
            }
        }
        sb.append("|" + "\n");
        for (i = 0; i < this.getSize() * 5 + 5; i++) {
            sb.append("_");
        }
        sb.append("\n");
        for (i = 0; i < this.getSize(); i++) {
            sb.append(i);
            p = i;
            k = 0;
            while (p > 0) {
                p /= 10;
                k++;
            }
            if (k == 0) k = 1;
            for (p = 0; p < 4 - k; p++) {
                sb.append(" ");
            }
            sb.append("|");
            for (j = 0; j < this.getSize(); j++) {
                if (this.matrix[i][j] > -1) {
                    sb.append(this.matrix[i][j]);
                    p = this.matrix[i][j];
                    k = 0;
                    while (p > 0) {
                        p /= 10;
                        k++;
                    }
                    if (k == 0) k = 1;
                    for (p = 0; p < 5 - k; p++) {
                        sb.append(" ");
                    }
                } else sb.append("-    ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public ArrayList output(int point) {
        ArrayList<String> list = new ArrayList<>();
        int i;
        for (i = 0; i < this.getSize() - 1; i++) {
            if (this.matrix[i][point] > 0) {
                list.add(point + " -> " + i + " = " + this.matrix[i][point]);
            }
        }
        return list;
    }

    public ArrayList input(int point) {
        ArrayList<String> list = new ArrayList<>();
        int i;
        for (i = 0; i < this.getSize() - 1; i++) {
            if (this.matrix[point][i] > 0) {
                list.add(i + " -> " + point + " = " + this.matrix[point][i]);
            }
        }
        return list;
    }

    public Graph addPoint() {

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

    public void addTrack(int begin, int end, int value) {
        if ((begin == end) && (begin >= this.getSize()) && (begin < 0) && (end >= this.getSize()) && (end < 0) && (value > 0))
            throw new IllegalArgumentException("Неверные границы или значение");
        this.matrix[end][begin] = value;
    }

    public void deleteTrack(int begin, int end) {
        this.addTrack(begin, end, -1);
    }

    public Graph deletePoint(int Point) {//работает
        if ((Point >= this.getSize()) && (Point < 0))
            throw new IllegalArgumentException("Неверная граница");
        MatrixSquad matr = new MatrixSquad(this.getSize() - 1, -1);
        int i, j, k, p, max;
        i = 0;
        max = matr.getSize();
        for (k = 0; k < max; k++) {
            j = 0;
            for (p = 0; p < max; p++) {
                if ((p != Point) && (k != Point)) {
                    matr.matrix[i][j] = this.matrix[k][p];
                    j++;
                }
            }
            if ((k != Point)) i++;
        }
        return new Graph(matr);
    }


    public static void main(String[] D) {
        MatrixSquad graph = new MatrixSquad(13, -1);
        graph.matrix[0][1] = 1;
        graph.matrix[1][2] = 2;
        graph.matrix[3][2] = 3777;
        graph.matrix[1][3] = 47;
        graph.matrix[0][3] = 599;
        graph.matrix[2][1] = 6;
        Graph g = new Graph(graph);
        System.out.println(g);
        g = g.addPoint();
        System.out.println(g);
        System.out.println(g.input(2));
        System.out.println(g.output(2));
        System.out.println(g);
        g = g.deletePoint(2);
        System.out.println(g);
    }
}
