package DSAall.DSA_TUT12;

import java.util.Arrays;

public class FindMyCoffee {
    private static int m = 5, n = 8, numOfVertex = 0;
    private static char[][] map = {
            { 'G', 'G', 'G', 'G', 'G', 'X', 'G', 'G' },
            { 'G', 'G', 'G', 'G', 'G', 'X', 'G', 'G' },
            { 'G', 'G', 'G', 'G', 'G', 'X', 'G', 'C' },
            { 'G', 'G', 'X', 'G', 'G', 'G', 'G', 'G' },
            { 'Y', 'G', 'X', 'G', 'G', 'G', 'G', 'G' }
    };

    private static GVertex startV, endV;
    private static GVertex[] listV, path;

    private static void buildGraph() {
        listV = new GVertex[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                listV[numOfVertex] = new GVertex(numOfVertex, map, m, n);

                if (map[i][j] == 'Y')
                    startV = listV[numOfVertex];
                if (map[i][j] == 'C')
                    endV = listV[numOfVertex];

                numOfVertex++;
            }
        }
    }

    private static boolean bfs(GVertex s, GVertex t) {
        path = new GVertex[numOfVertex];
        Arrays.fill(path, null);

        ArrayQueue q = new ArrayQueue();
        q.enqueue(s);
        s.setMarked(true);

        while (!q.isEmpty()) {
            GVertex u = q.dequeue();
            if (u.getIdx() == t.getIdx()) {
                showPath(s, t);
                return true;
            }

            int[] adjVertexU = u.getAdjVertex();
            for (int i = adjVertexU.length - 1; i >= 0; i--) {
                GVertex v = listV[adjVertexU[i]];

                if (v.getMarked() == false) {
                    v.setMarked(true);
                    q.enqueue(v);
                    path[v.getIdx()] = u;
                }
            }
        }

        return false;
    }

    private static void showPath(GVertex s, GVertex t) {
        GVertex u = t;
        StringBuilder sb = new StringBuilder();

        while (u != s) {
            sb.append(String.format("{%d,%d}<--", u.getRow(), u.getColumn()));
            u = path[u.getIdx()];
        }
        sb.append(String.format("{%d,%d}", s.getRow(), s.getColumn()));
        System.out.println(sb.toString());
    }

    public static void main(String[] argv) {
        buildGraph();
        bfs(startV, endV);
    }
}
