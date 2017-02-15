package DirectedGraph;

import java.util.Arrays;

public class MatrixSquad {
    private final int size;
    public Object[][] matrix;

    public MatrixSquad(int size, Object e) {//конструктор матрицы
        if (size <= 0) throw new IllegalArgumentException("");
        this.matrix = new Object[size][size];
        this.size = size;
        int i, j;
        for (i = 0; i < size; i++)
            for (j = 0; j < size; j++) {
                matrix[i][j] = e;
            }
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
        if (!(o instanceof MatrixSquad)) return false;

        MatrixSquad that = (MatrixSquad) o;

        if (getSize() != that.getSize()) return false;
        return Arrays.deepEquals(matrix, that.matrix);
    }

    @Override
    public int hashCode() {
        int result = getSize();
        result = 31 * result + Arrays.deepHashCode(matrix);
        return result;
    }

    public String toString() {//вывод в консоли
        int i, j;
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                sb.append(this.matrix[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
