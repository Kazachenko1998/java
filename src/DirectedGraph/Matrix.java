package DirectedGraph;

public class Matrix {
    public static void main(String[] D) {
        int m = 2;
        MatrixSquad a = new MatrixSquad(m,-1);
        a.matrix[0][0] = 0;
        a.matrix[0][1] = 2;
        a.matrix[1][0] = 1;
        System.out.println(a);
    }
}