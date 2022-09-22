import org.junit.FixMethodOrder;

public class LinkedListDeque<Blorp> implements Deque<Blorp>{
    private int size;
    private Node sentinel;

    public class Node {
        private Blorp item;
        private Node next;

        private Node back;

        public Node(Node b, Blorp i, Node n) {
            item = i;
            next = n;
            back = b;
        }

        public Blorp getRecrusive(int i) {
            if (i == 0) {
                return this.item;
            }
            return this.next.getRecrusive(i - 1);
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.back = sentinel;
        sentinel.next = sentinel;
    }

    public LinkedListDeque(Blorp x) {
        size = 1;
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(sentinel, x, sentinel);
        sentinel.back = sentinel.next;
    }

    public LinkedListDeque(LinkedListDeque<Blorp> other) {
        sentinel = new Node(sentinel, null, sentinel);
        sentinel.back = sentinel;
        sentinel.next = sentinel;
        Node p = other.sentinel.next;
        while (p != other.sentinel) {
            this.addFirst(p.item);
            p = p.next;
        }
    }

    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        return false;
    }

    @Override
    public void addFirst(Blorp x) {
        size += 1;
        Node oldNode = sentinel.next;
        Node newNode = new Node(sentinel, x, oldNode);
        oldNode.back = newNode;
        sentinel.next = newNode;
    }

    @Override
    public void addLast(Blorp x) {
        size += 1;
        Node oldNode = sentinel.back;
        Node newNode = new Node(oldNode, x, sentinel);
        oldNode.next = newNode;
        sentinel.back = newNode;
    }

    @Override
    public Blorp getLast() {
        return sentinel.back.item;
    }

    @Override
    public Blorp getFirst() {
        return sentinel.next.item;
    }

    @Override
    public Blorp removeFirst() {
        size -=1;
        Node RemoveItem = sentinel.next;
        sentinel.next = RemoveItem.next;
        if (size==0){
            sentinel.back = sentinel;
        }
        return RemoveItem.item;
    }

    @Override
    public Blorp removeLast() {
        size-=1;
        Node RemoveItem = sentinel.back;
        sentinel.back = RemoveItem.back;
        if (size==0){
            sentinel.next=sentinel;
        }
        return RemoveItem.item;
    }

    @Override
    public Blorp get(int i) {
        Node p = sentinel.next;
        while (i != 0) {
            p = p.next;
            i -= 1;
        }
        return p.item;
    }

    public Blorp getRecrusive(int i) {
        Node p = sentinel.next;
        return p.getRecrusive(i);
    }

    @Override
    public int size(){return size;}

    public void printDeque(){
        Node p = sentinel.next;
        while(p!=sentinel){
            System.out.print(p.item+" ");
            p = p.next;
        }
    }

}
