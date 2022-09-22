public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> a = new LinkedListDeque<>();
        for (int i = 0; i<word.length();i++){
            a.addLast(word.charAt(i)); // charAt以下标i第i个字母
        }
        return a;
    }

    public boolean isPalindrome(String word){
        Deque<Character> a = wordToDeque(word);
        for (int i = 0; i < word.length()/2; i++){
            if (a.removeFirst() != a.removeLast()){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> a = wordToDeque(word);
        for (int i = 0; i < word.length()/2; i++) {
            if (!cc.equalChars(a.removeFirst(),a.removeLast())){
                return false;
            }
        }
        return true;
    }
}
