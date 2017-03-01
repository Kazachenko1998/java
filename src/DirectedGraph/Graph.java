package DirectedGraph;


import javafx.util.Pair;

import java.util.*;


public class Graph {
    private ArrayList<ArrayList<Integer>> matrix;
    private ArrayList<String> name;

    public Graph(ArrayList<ArrayList<Integer>> m, ArrayList<String> n) {//конструктор графа
        this.matrix = m;
        this.name = n;
        int i;
        int size = -1;

        for (i = 0; i < m.size(); i++) {
            if (m.get(i).size() > size) size = m.get(i).size();
        }
        for (i = 0; i < size; i++)
            if (name.size() <= i) {
                String str = java.lang.Integer.toString(i + 1);
                this.name.add(str);
            }
        Set<String> nameFailed = new HashSet<>();
        for (i = 0; i < name.size(); i++) nameFailed.add(name.get(i));
        if (name.size() != nameFailed.size()) throw new IllegalArgumentException("Повторение имени");

        for (i = 0; i < n.size(); i++)
            if (matrix.size() <= i) {
                this.matrix.add(new ArrayList<>());
            }

        for (i = 0; i < n.size(); i++)
            for (int j = this.matrix.get(i).size(); j < n.size(); j++) {
                ArrayList<Integer> list = this.matrix.get(i);
                list.add(null);
                this.matrix.set(i, list);
            }

    }

    public Graph(int size) {

        ArrayList<String> str = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            str.add(java.lang.Integer.toString(i));
        }
        this.name = str;
        this.matrix = (new Graph(new ArrayList<>(), this.getName())).getMatrix();
    }

    public Graph(ArrayList<String> name) {
        this.name = name;
        this.matrix = (new Graph(new ArrayList<>(), this.getName())).getMatrix();
    }

    public Graph() {

        this.name = new ArrayList<>();
        this.matrix = (new Graph(new ArrayList<>(), this.getName())).getMatrix();
    }

    public Graph(Integer[][] matrix, ArrayList<String> name) {
        ArrayList<ArrayList<Integer>> matr = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            matr.add(new ArrayList<>());
            for (int j = 0; j < matrix[i].length; j++) {
                ArrayList<Integer> list = matr.get(i);
                list.add(matrix[i][j]);
                matr.set(i, list);
            }
        }
        this.name = (new Graph(matr, name)).getName();
        this.matrix = (new Graph(matr, this.name)).getMatrix();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Graph)) return false;

        Graph graph = (Graph) o;

        if (!getMatrix().equals(graph.getMatrix())) return false;
        return getName().equals(graph.getName());
    }

    @Override
    public int hashCode() {
        int result = getMatrix().hashCode();
        result = 31 * result + getName().hashCode();
        return result;
    }

    public ArrayList<ArrayList<Integer>> getMatrix() {
        return matrix;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public int getSize() {
        return this.matrix.size();
    }

    public Graph setMatrix(ArrayList<ArrayList<Integer>> matrix) {
        return new Graph(matrix, this.name);
    }

    public Graph setName(ArrayList<String> name) {
        return new Graph(this.matrix, name);
    }

    @Override
    public String toString() {//вывод в консоли
        int i, j, k, p;
        StringBuilder sb = new StringBuilder();
        if (this.getSize() == 0) {
            sb.append("Пустой граф" + "\n");
        } else {
            sb.append("    ");
            for (i = 0; i < this.name.size(); i++) {
                sb.append("|" + this.name.get(i));
                for (p = 0; p < 4 - this.name.get(i).length(); p++) {
                    sb.append(" ");
                }
            }
            sb.append("|" + "\n");
            for (i = 0; i < this.name.size() * 5 + 5; i++) {
                sb.append("_");
            }
            sb.append("\n");
            for (i = 0; i < this.name.size(); i++) {
                sb.append(this.name.get(i));
                for (p = 0; p < 4 - this.name.get(i).length(); p++) {
                    sb.append(" ");
                }
                sb.append("|");
                for (j = 0; j < this.name.size(); j++) {
                    if (this.matrix.get(i).get(j) != null) {
                        sb.append(this.matrix.get(i).get(j));

                        p = this.matrix.get(i).get(j);
                        if (p < 0) p = -p * 10;
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
        }
        return sb.toString();
    }


    public ArrayList<Pair<String, Integer>> output(String k) {
        int i, point;
        point = -1;
        for (i = 0; i < this.getSize() - 1; i++) {
            if (this.name.get(i) == k) point = i;
        }
        if (point == -1) throw new IllegalArgumentException("Нет такой вершины");
        ArrayList<Pair<String, Integer>> list = new ArrayList<>();
        for (i = 0; i < this.getSize(); i++) {
            if (this.matrix.get(i).get(point) != null) {
                list.add(new Pair(this.name.get(i), this.matrix.get(i).get(point)));
            }
        }
        return list;
    }

    public ArrayList<Pair<String, Integer>> input(String k) {
        int i, point;
        point = -1;
        for (i = 0; i < this.getSize() - 1; i++) {
            if (this.name.get(i) == k) point = i;
        }
        if (point == -1) throw new IllegalArgumentException("Нет такой вершины");
        ArrayList<Pair<String, Integer>> list = new ArrayList<>();
        for (i = 0; i < this.getSize(); i++) {
            if (this.matrix.get(i).get(point) != null) {
                list.add(new Pair(this.name.get(i), this.matrix.get(point).get(i)));
            }
        }
        return list;
    }

    public Graph addPoint(String nameP) {
        int i;
        this.matrix.add(new ArrayList<>());
        for (i = 0; i < this.matrix.size() - 1; i++) {
            ArrayList<Integer> list = this.matrix.get(i);
            list.add(null);
            this.matrix.set(i, list);
            list = this.matrix.get(this.matrix.size() - 1);
            list.add(null);
            this.matrix.set(this.matrix.size() - 1, list);
        }
        this.name.add(nameP);
        return new Graph(this.matrix, this.name);
    }

    public Graph addTrack(String begin, String end, Integer value) {
        int i, end1 = -1, begin1 = -1;
        for (i = 0; i < this.matrix.size(); i++) {
            if (this.name.get(i) == begin) begin1 = i;
            if (this.name.get(i) == end) end1 = i;
        }
        if ((end1 == -1) || (begin1 == -1))
            throw new IllegalArgumentException("Не существует вершины");
        ArrayList<Integer> list = this.matrix.get(end1);
        list.remove(begin1);
        list.add(begin1, value);
        this.matrix.set(end1, list);
        return new Graph(this.matrix, this.name);
    }

    public Graph deleteTrack(String begin, String end) {
        this.addTrack(begin, end, null);
        return new Graph(this.matrix, this.name);
    }

    public Graph renameTrack(String begin, String end, Integer value) {
        return new Graph(this.matrix, this.name).addTrack(begin,end,value);
    }

    public Graph renamePoint(String old, String now) {
        int i, end1 = -1;
        for (i = 0; i < this.matrix.size(); i++) {
            if (this.name.get(i) == old) end1 = i;
        }
        if (end1 == -1)
            throw new IllegalArgumentException("Вершины не существует");
        this.name.set(end1, now);
        Set<String> nameFailed = new HashSet<>();
        for (i = 0; i < this.matrix.size(); i++) nameFailed.add(this.name.get(i));
        if (name.size() != nameFailed.size()) throw new IllegalArgumentException("Такая вершина уже есть");
        return new Graph(this.matrix, this.name);
    }

    public Graph deletePoint(String Y) {//работает
        int i, Point = -1;
        for (i = 0; i < this.matrix.size(); i++) {
            if (this.name.get(i) == Y) Point = i;
        }
        if (Point == -1)
            throw new IllegalArgumentException("Вершины не существует");
        for (i = 0; i < this.matrix.size(); i++) {
            ArrayList<Integer> list = this.matrix.get(i);
            list.remove(Point);
            this.matrix.set(i, list);
        }
        this.matrix.remove(Point);
        this.name.remove(Point);
        return new Graph(this.matrix, this.name);
    }

    public static void main(String[] D) {
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
        Graph graph = new Graph(matr, nnnn);
        System.out.println(graph);
        System.out.println(graph.output("Kost"));
    }
}