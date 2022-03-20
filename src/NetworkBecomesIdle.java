import java.util.LinkedList;
import java.util.Queue;

public class NetworkBecomesIdle {

    int n = 0;
    int[] distance;
    Node soldier;
    Node[] adjacentLinkedList;

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node add(int val) {
            Node tmp = new Node(val);
            tmp.next = this;
            return tmp;
        }
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        n = patience.length;
        distance = new int[n];
        adjacentLinkedList = new Node[n];
        soldier = new Node(-1);
        for (Node node: adjacentLinkedList)
            node = soldier;
        for (int[] edge: edges) {
            adjacentLinkedList[edge[0]] = adjacentLinkedList[edge[0]].add(edge[1]);
            adjacentLinkedList[edge[1]] = adjacentLinkedList[edge[1]].add(edge[0]);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            distance[cur[0]] = cur[1];
            Node p = adjacentLinkedList[cur[0]];
            while (p != soldier) {
                if (adjacentLinkedList[p.val] != soldier)
                    queue.offer(new int[]{p.val, cur[1] + 1});
                p = p.next;
            }
            adjacentLinkedList[cur[0]] = soldier;
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
             int cur = distance[i] * 4 - ((distance[i] * 2 - 1) % patience[i]);
             ans = Math.max(ans, cur);
        }
        return ans;
    }
}
