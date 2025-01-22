class TrieNode {
    boolean endOfWord;
    String word;
    Map<Character, TrieNode> children;

    public TrieNode() {
        children = new HashMap<>();
        word = null;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");
        TrieNode root = buildTrie(dictionary);
        StringBuilder answer = new StringBuilder();
        for (String word : words) {
            String root_word = word;
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children.containsKey(c)) {
                    curr = curr.children.get(c);
                    if (curr.endOfWord && root_word.length() > curr.word.length()) {
                        root_word = curr.word;
                    }
                }
                else
                    break ;
            }
            answer.append(root_word + " ");
        }
        answer.deleteCharAt(answer.length() - 1);
        return (answer.toString());
    }

    public TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.endOfWord = true;
            curr.word = word;
        }
        return (root);
    }
}