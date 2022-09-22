public class OffByOne implements CharacterComparator {
    private int N;

    public OffByOne(int n) {
        N = n;
    }

    public OffByOne() {
        N = 1;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (Math.abs(x - y) == N) {
            return true;
        }
        return false;
    }
}
