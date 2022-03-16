import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {

    int n;
    Node minNode;
    Node maxNode;
    Map<String, Node> strNodeMap;

    static class Node {
        Node pre;
        Node nxt;
        int cnt;
        Set<String> str;

        public Node(int _cnt) {
            cnt = _cnt;
            str = new HashSet<>();
        }
    }

    public AllOne() {
        n = 0;
        minNode = null;
        maxNode = null;
        strNodeMap = new HashMap<>();
    }

    public void inc(String key) {
        Node cur = strNodeMap.getOrDefault(key, null);
        if (cur == null) {
            if (minNode == null || minNode.cnt != 1) {
                n++;
                Node tmp = new Node(1);
                if (minNode != null) {
                    tmp.nxt = minNode;
                    minNode.pre = tmp;
                }
                if (maxNode == null) maxNode = tmp;
                minNode = tmp;
            }
            minNode.str.add(key);
            strNodeMap.put(key, minNode);
        }
        else {
            Node tmp;
            if (cur.nxt == null) {
                n++;
                tmp = new Node(cur.cnt + 1);
                cur.nxt = tmp;
                tmp.pre = cur;
                maxNode = tmp;
            }
            else if (cur.nxt.cnt == cur.cnt + 1)
                tmp = cur.nxt;
            else {
                n++;
                tmp = new Node(cur.cnt + 1);
                tmp.pre = cur;
                tmp.nxt = cur.nxt;
                cur.nxt.pre = tmp;
                cur.nxt = tmp;
            }
            cur.str.remove(key);
            tmp.str.add(key);
            strNodeMap.put(key, tmp);
            if (cur.str.isEmpty()) {
                tmp.pre = cur.pre;
                if (cur.pre != null)
                    cur.pre.nxt = tmp;
                else
                    minNode = tmp;
                n--;
            }
        }
    }

    public void dec(String key) {
        Node cur = strNodeMap.get(key);
        if (cur.cnt == 1) {
            cur.str.remove(key);
            strNodeMap.remove(key);
        }
        else {
            Node tmp;
            if (cur.pre == null) {
                n++;
                tmp = new Node(cur.cnt - 1);
                cur.pre = tmp;
                tmp.nxt = cur;
                minNode = tmp;
            }
            else if (cur.pre.cnt == cur.cnt - 1)
                tmp = cur.pre;
            else {
                n++;
                tmp = new Node(cur.cnt - 1);
                tmp.nxt = cur;
                tmp.pre = cur.pre;
                cur.pre.nxt = tmp;
                cur.pre = tmp;
            }
            cur.str.remove(key);
            tmp.str.add(key);
            strNodeMap.put(key, tmp);
        }
        if (cur.str.isEmpty()) {
            n--;
            Node tmpN = cur.nxt;
            Node tmpP = cur.pre;
            if (tmpP != null)
                tmpP.nxt = tmpN;
            else
                minNode = tmpN;
            if (tmpN != null)
                tmpN.pre = tmpP;
            else
                maxNode = tmpP;
        }
    }

    public String getMaxKey() {
        if (n == 0)
            return "";
        else
            return maxNode.str.iterator().next();
    }

    public String getMinKey() {
        if (n == 0)
            return "";
        else
            return minNode.str.iterator().next();
    }
}

