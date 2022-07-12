class Insert {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node tmp = new Node(insertVal);
            tmp.next = tmp;
            return tmp;
        }
        Node p = head;
        Node pre = head;
        Node r = p;
        head = head.next;
        while (!(head.val >= insertVal && pre.val <= insertVal)) {
            pre = head;
            head = head.next;
            if (pre.val >= r.val)
                r = pre;
            if (head == p.next) {
                r.next = new Node(insertVal, r.next);
                return p;
            }
        }
        pre.next = new Node(insertVal, head);
        return p;
    }
}