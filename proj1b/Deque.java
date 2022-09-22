public interface Deque<Blorp> {
    public int size();

    public Blorp get(int i);

    public Blorp getLast();

    public Blorp getFirst();

    public Blorp removeFirst();

    public Blorp removeLast();

    public void addFirst(Blorp x);

    public void addLast(Blorp x);

    default public boolean isEmpty() {
        if (size() == 0){
            return true;
        }
        return false;
    }
}