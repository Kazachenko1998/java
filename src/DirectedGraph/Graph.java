package DirectedGraph;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Graph {
    private final int size;
    private Object[][] matrix;

    public Graph(MatrixSquad m) {//конструктор графа
        this.matrix = new Object[m.getSize()][m.getSize()];
        this.size = m.getSize();
        int i, j;
        for (i = 0; i < size; i++)
            for (j = 0; j < size; j++) {
                if (m.matrix[i][j] == null) matrix[i][j] = -1;
                else matrix[i][j] = m.matrix[i][j];
            }
        for (i = 0; i < size; i++)
        if (this.matrix[i][i]==null) this.matrix[i][i]=i ;
        Set<String> name = new HashSet<>();
            for (i = 0; i < size; i++) name.add(this.matrix[i][i].toString());
    if (name.size()!=this.getSize()) throw new IllegalArgumentException("Повторение имени");
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
        return Arrays.deepEquals(getMatrix(), graph.getMatrix());
    }

    @Override
    public int hashCode() {
        int result = getSize();
        result = 31 * result + Arrays.deepHashCode(getMatrix());
        return result;
    }

    @Override
    public String toString() {//вывод в консоли
        int i, j, k, p;
        StringBuilder sb = new StringBuilder();
        sb.append("    ");
        for (i = 0; i < this.getSize(); i++) {
            sb.append("|" + this.matrix[i][i]);
            for (p = 0; p < 4 - this.matrix[i][i].toString().length(); p++) {
                sb.append(" ");
            }
        }
        sb.append("|" + "\n");
        for (i = 0; i < this.getSize() * 5 + 5; i++) {
            sb.append("_");
        }
        sb.append("\n");
        for (i = 0; i < this.getSize(); i++) {
            sb.append(this.matrix[i][i].toString());
            for (p = 0; p < 4 - this.matrix[i][i].toString().length(); p++) {
                sb.append(" ");
            }
            sb.append("|");
            for (j = 0; j < this.getSize(); j++) {
                if ((i!=j)&&((int) this.matrix[i][j] > -1)) {
                    sb.append(this.matrix[i][j]);
                    p = (int) this.matrix[i][j];
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

    public ArrayList output(String k) {
        int i,point;
        point = -1;
        for (i=0;i<this.getSize() - 1;i++){
            if (this.matrix[i][i] == k) point = i;
        }
        if (point == -1) throw new IllegalArgumentException("Неверное имя");
        ArrayList<String> list = new ArrayList<>();
        for (i = 0; i < this.getSize() - 1; i++) {
            if ((i!=point)&&((int) this.matrix[i][point] > 0)) {
                list.add(this.matrix[point][point] + " -> " + this.matrix[i][i] + " = " + this.matrix[i][point]);
            }
        }
        return list;
    }

    public ArrayList input(String k) {
        int i,point;
        point = -1;
        for (i=0;i<this.getSize() - 1;i++){
            if (this.matrix[i][i] == k) point = i;
        }
        if (point == -1) throw new IllegalArgumentException("Неверное имя");
        ArrayList<String> list = new ArrayList<>();
        for (i = 0; i < this.getSize() - 1; i++) {
            if ((i!=point)&&((int) this.matrix[point][i] > 0)) {
                list.add(this.matrix[i][i] + " -> " + this.matrix[point][point] + " = " + this.matrix[point][i]);
            }
        }
        return list;
    }

    public Graph addPoint(String name) {
        MatrixSquad matr = new MatrixSquad(this.getSize() + 1, -1);
        int i, j;
        for (i = 0; i < this.getSize(); i++) {
            for (j = 0; j < this.getSize(); j++) {
                matr.matrix[i][j] = this.matrix[i][j];
            }
        }
        matr.matrix[this.getSize()][this.getSize()] = name;
        return new Graph(matr);
    }

    public void addTrack(String begin, String end, int value) {
        int i,end1=-1,begin1=-1;
        for (i=0;i<this.getSize()-1;i++){
            if (this.matrix[i][i]==begin) begin1=i;
            if (this.matrix[i][i]==end) end1=i;
        }
        if ((begin == end)  && (value < 0)&&(end1==-1)&&(begin1==-1))
            throw new IllegalArgumentException("Неверные границы или значение");
        this.matrix[end1][begin1] = value;
    }

    public void deleteTrack(String begin, String end) {
        this.addTrack(begin, end, -1);
    }

    public void renamePoint(String old, String now) {
        int i,end1=-1;
        for (i=0;i<this.getSize()-1;i++){
            if (this.matrix[i][i]==old) end1=i;
        }
        if (end1==-1)
            throw new IllegalArgumentException("Неверные границы или значение");

        this.matrix[end1][end1] = now;
    }


    public Graph deletePoint(String Y) {//работает
        int i,Point=-1;
        for (i=0;i<this.getSize();i++){
            if (this.matrix[i][i]==Y) Point=i;
        }
        if (Point==-1)
            throw new IllegalArgumentException("Неверные границы или значение");


        MatrixSquad matr = new MatrixSquad(this.getSize() - 1, -1);
        int  j, k, p, max;
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
        String x = String.format("%02d", 1);//можно сократить toString
       /** g = g.addPoint();
        System.out.println(g);
        System.out.println(g.input(2));
        System.out.println(g.output(2));
        System.out.println(g);
        g = g.deletePoint(2);
        System.out.println(g);
    */}
}
