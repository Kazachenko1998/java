package DirectedGraph;


import javafx.util.Pair;

import java.util.*;


public class Graph {
    private List<List<Integer>> matrix;
    private List<String> name;

    public Graph(List<List<Integer>> m, List<String> n) {//конструктор графа
        List<List<Integer>> matr = new ArrayList<>();
        for (int i = 0; i < m.size(); i++) {
            matr.add(new ArrayList<>());
            for (int j = 0; j < m.get(i).size(); j++) {
                List<Integer> list = matr.get(i);
                list.add(m.get(i).get(j));
                matr.set(i, list);
            }
        }
        List<String> str = new ArrayList<>();
        for (int i = 0; i < n.size(); i++) {
            str.add(n.get(i));
        }
        this.matrix = matr;
        this.name = str;
        int i;
        int size = matr.size();
        for (i = 0; i < matr.size(); i++) {
            if (matr.get(i).size() > size) size = matr.get(i).size();
        }

        for (i = 0; i < size; i++)
            if (name.size() <= i) {
                String str2 = java.lang.Integer.toString(i + 1);
                this.name.add(str2);
            }
        Set<String> nameFailed = new HashSet<>();
        for (i = 0; i < name.size(); i++) nameFailed.add(name.get(i));
        if (name.size() != nameFailed.size()) throw new IllegalArgumentException("Повторение имени");

        for (i = 0; i < str.size(); i++)
            if (matrix.size() <= i) {
                this.matrix.add(new ArrayList<>());
            }

        for (i = 0; i < str.size(); i++)
            for (int j = this.matrix.get(i).size(); j < str.size(); j++) {
                List<Integer> list = this.matrix.get(i);
                list.add(null);
                this.matrix.set(i, list);
            }
    }

    public Graph(List<String> name) {
        this(new ArrayList<>(), name);
    }

    public Graph() {
        this(new ArrayList<>(), new ArrayList<>());
    }


    public Graph(Integer[][] matrix, List<String> name) {
        this(Util(matrix), name);
    }

    private static List<List<Integer>> Util(Integer[][] x) {
        List<List<Integer>> matr = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            matr.add(new ArrayList<>());
            for (int j = 0; j < x[i].length; j++) {
                List<Integer> list = matr.get(i);
                list.add(x[i][j]);
                matr.set(i, list);
            }
        }
        return matr;
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

    public List<List<Integer>> getMatrix() {
        List<List<Integer>> mmm = new ArrayList<>();
        for (int i = 0; i < this.getSize(); i++) {
            mmm.add(new ArrayList<>());
            for (int j = 0; j < this.getSize(); j++) {
                List<Integer> list = mmm.get(i);
                list.add(this.matrix.get(i).get(j));
                mmm.set(i, list);
            }
        }
        return mmm;
    }

    public List<String> getName() {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < this.getSize(); i++) {
            str.add(this.name.get(i));
        }
        return str;
    }

    public int getSize() {
        return this.matrix.size();
    }

    public Graph setMatrix(List<List<Integer>> matrix) {
        return new Graph(matrix, this.name);
    }

    public Graph setName(List<String> name) {
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

    private Graph help(Graph graph) {
        int i;
        int size = graph.name.size();
        if (graph.matrix.size() > graph.name.size()) size = graph.matrix.size();
        for (i = 0; i < graph.matrix.size(); i++) {
            if (graph.matrix.get(i).size() > size) size = graph.matrix.get(i).size();
        }

        for (i = graph.name.size(); i < size; i++) {
            String str2 = java.lang.Integer.toString(i + 1);
            graph.name.add(str2);
        }
        for (i = 0; i < graph.name.size(); i++)
            if (graph.name.lastIndexOf(graph.name.get(i)) != i) throw new IllegalArgumentException("Повторение имени");
        List<List<Integer>> mat = graph.matrix;
        for (i = 0; i < size; i++)
            if (i >= graph.matrix.size()) mat.add(new ArrayList<>());
        graph.matrix = mat;
        for (i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (j >= graph.matrix.get(i).size()) {
                    List<Integer> list = graph.matrix.get(i);
                    list.add(null);
                    mat.set(i, list);
                }
        graph.matrix = mat;
        return graph;
    }

    public List<Pair<String, Integer>> output(String k) {
        int i, point;
        point = this.name.indexOf(k);
        if (point == -1) throw new IllegalArgumentException("Нет такой вершины");
        List<Pair<String, Integer>> list = new ArrayList<>();
        for (i = 0; i < this.getSize(); i++) {
            if (this.matrix.get(i).get(point) != null) {
                list.add(new Pair(this.name.get(i), this.matrix.get(i).get(point)));
            }
        }
        return list;
    }

    public List<Pair<String, Integer>> input(String k) {
        int i, point;
        point = this.name.indexOf(k);
        if (point == -1) throw new IllegalArgumentException("Нет такой вершины");
        List<Pair<String, Integer>> list = new ArrayList<>();
        for (i = 0; i < this.getSize(); i++) {
            if (this.matrix.get(i).get(point) != null) {
                list.add(new Pair(this.name.get(i), this.matrix.get(point).get(i)));
            }
        }
        return list;
    }

    public Graph addPoint(String nameP) {
        this.name.add(nameP);
        return help(this);//help для добавл. путей
    }

    public Graph addTrack(String begin, String end, Integer value) {
        int end1 = this.name.indexOf(end);
        int begin1 = this.name.indexOf(begin);
        if ((end1 == -1) || (begin1 == -1))
            throw new IllegalArgumentException("Не существует вершины");
        List<Integer> list = this.matrix.get(end1);
        list.remove(begin1);
        list.add(begin1, value);
        this.matrix.set(end1, list);
        return help(this);
    }

    public Graph deleteTrack(String begin, String end) {
        this.addTrack(begin, end, null);
        return this;
    }

    public Graph renameTrack(String begin, String end, Integer value) {
        return this.addTrack(begin, end, value);
    }

    public Graph renamePoint(String old, String now) {
        int end1 = this.name.indexOf(old);
        if (end1 == -1)
            throw new IllegalArgumentException("Вершины не существует");
        this.name.set(end1, now);
        return help(this);//help для проверки на повтор
    }

    public Graph deletePoint(String Y) {//работает
        int i, Point;
        Point = this.name.indexOf(Y);
        if (Point == -1)
            throw new IllegalArgumentException("Вершины не существует");
        for (i = 0; i < this.matrix.size(); i++) {
            List<Integer> list = this.matrix.get(i);
            list.remove(Point);
            this.matrix.set(i, list);
        }
        this.matrix.remove(Point);
        this.name.remove(Point);
        return this;
    }

    public static void main(String[] D) {
        List<List<Integer>> matr = new ArrayList<>();
        List<Integer> matr1 = new ArrayList<>();
        matr1.add(0);
        matr1.add(2);
        matr1.add(-1);
        matr1.add(-1);
        matr.add(matr1);
        List<Integer> matr2 = new ArrayList<>();
        matr2.add(8);
        matr2.add(0);
        matr2.add(-1);
        matr2.add(2);
        matr.add(matr2);
        List<Integer> matr3 = new ArrayList<>();
        matr3.add(1111);
        matr3.add(-10);
        matr3.add(0);
        matr3.add(999);
        matr.add(matr3);
        List<Integer> matr4 = new ArrayList<>();
        matr4.add(-1);
        matr4.add(0);
        matr4.add(4);
        matr4.add(0);
        matr.add(matr4);
        List<String> nnnn = new ArrayList<>();
        nnnn.add("Kost");
        nnnn.add("ghbd");
        nnnn.add("100");
        nnnn.add("rrr");
        Graph graph = new Graph(matr, nnnn);

        System.out.println(graph.output("Kost"));
        System.out.println(graph.input("Kost"));
        System.out.println(graph.addPoint("priv"));
        System.out.println(graph.deletePoint("priv"));
        System.out.println(graph.renamePoint("Kost", "Lena"));
        System.out.println(graph.addTrack("Lena", "100", 8888));
        System.out.println(graph.deleteTrack("Lena", "100"));
        System.out.println(graph.renameTrack("Lena", "100", 1000));
    }
}