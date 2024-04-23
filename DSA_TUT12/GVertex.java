package DSAall.DSA_TUT12;

public class GVertex {
    private int idx, row, column, numOfAdjVertex;
    private boolean marked;
    private int[] adjVertex;

    public GVertex(int idx, char[][] map, int m, int n) {
        this.idx = idx;
        this.row = idx / n;
        this.column = idx % n;
        this.numOfAdjVertex = 0;
        this.marked = false;
        this.adjVertex = new int[4];

        if (row > 0 && map[row - 1][column] != 'X') {
            adjVertex[numOfAdjVertex++] = (row - 1) * n + column;
        }

        if (column > 0 && map[row][column - 1] != 'X') {
            adjVertex[numOfAdjVertex++] = row * n + column - 1;
        }

        if (row < m - 1 && map[row + 1][column] != 'X') {
            adjVertex[numOfAdjVertex++] = (row + 1) * n + column;
        }

        if (column < n - 1 && map[row][column + 1] != 'X') {
            adjVertex[numOfAdjVertex++] = row * n + column + 1;
        }
    }

    public int getIdx() {
        return this.idx;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public int getNumOfAdjVertex() {
        return this.numOfAdjVertex;
    }

    public boolean getMarked() {
        return this.marked;
    }

    public int[] getAdjVertex() {
        return this.adjVertex;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(String.format("Vertex %d Row %d Column %d Marked %b Number of AdjVertex %d\n{", this.idx, this.row,
                this.column, this.marked, this.numOfAdjVertex));

        for (int i = 0; i < numOfAdjVertex; i++) {
            s.append(String.format("%d", this.adjVertex));
        }

        return s.append("}").toString();
    }

}
