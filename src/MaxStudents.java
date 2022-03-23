import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxStudents {

    int s, t, n, m, num;
    int[] head;
    boolean[] vis;
    List<Edge> edges;
    int[][] seats;

    List<Integer> test;

    // 使用链式前向星进行存储
    static class Edge {
        int to, next;
        boolean w;

        public Edge(){}

        public Edge(int _to, boolean _w, int _next) {
            to = _to;
            w = _w;
            next = _next;
        }
    }

    // 链式前向星存储下添加边
    public void addEdge(int from, int to, boolean w) {
        edges.add(new Edge(to, w, head[from]));
        head[from] = edges.size() - 1;
    }

    // 添加一正一反两条边
    public void add2Edge(int from, int to) {
        addEdge(from, to, true);
        addEdge(to, from, false);
    }

    public boolean dfs(int u) {
        if (u == t) {
            System.out.println(test);
            return true;
        }

        for (int p = head[u]; p != -1; p = edges.get(p).next) {
            Edge e = edges.get(p);
            Edge eR = edges.get(p ^ 1);
            if (!vis[e.to] && e.w) {
                e.w = false;
                eR.w = true;
                vis[e.to] = true;
                test.add(e.to);
                boolean reached = dfs(e.to);
                test.remove(test.size() - 1);
                vis[e.to] = false;
                if (reached)
                    return true;
                e.w = true;
                eR.w = false;
            }
        }
        return false;
    }

    public int maxStudents(char[][] seats) {

        test = new ArrayList<>();

        num = 2;
        s = 0;
        t = 1;
        n = seats.length;
        m = seats[0].length;
        for (char[] seat: seats)
            for (char s: seat)
                if (s == '.')
                    num++;
        if (num == 2) return 0;

        edges = new ArrayList<>();
        head = new int[num];
        vis = new boolean[num];
        Arrays.fill(head, -1);
        this.seats = new int[n][m];

        int cur = 1;
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (seats[i][j] != '.') continue;
                cur++;
                this.seats[i][j] = cur;
                if ((j & 1) == 1)
                    add2Edge(s, cur);
                else
                    add2Edge(cur, t);
            }
        }

        for (int j = 0; j < m; j++)
            for (int i = 0; i < n; i++) {
                if (seats[i][j] == '#')
                    continue;
                int seat = this.seats[i][j];
                if (i > 0 && j < m - 1 && seats[i - 1][j + 1] != '#')
                    if ((j & 1) == 1)
                        add2Edge(seat, this.seats[i - 1][j + 1]);
                    else
                        add2Edge(this.seats[i - 1][j + 1], seat);
                if (i > 0 && j > 0 && seats[i - 1][j - 1] != '#')
                    if ((j & 1) == 1)
                        add2Edge(seat, this.seats[i - 1][j - 1]);
                    else
                        add2Edge(this.seats[i - 1][j - 1], seat);
                if (j < m - 1 && seats[i][j + 1] != '#')
                    if ((j & 1) == 1)
                        add2Edge(seat, this.seats[i][j + 1]);
                    else
                        add2Edge(this.seats[i][j + 1], seat);
            }

        int maxflow = 0;
        vis[0] = true;
        test.add(0);
        while (dfs(s))
            maxflow += 1;
        return num - 2 - maxflow;
    }
}
