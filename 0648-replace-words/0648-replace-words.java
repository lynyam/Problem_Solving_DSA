class TrieNode {
    String root;
    boolean endOfWord;
    HashMap<Character, TrieNode> children;
    public TrieNode() {
        children = new HashMap<>();
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            TrieNode curr = root;
            String prefix = word;
            for (char c : word.toCharArray()) {
                if (curr.children.containsKey(c)) {
                    curr = curr.children.get(c);
                    if (curr.endOfWord) {
                        prefix = curr.root;
                        break ;
                    }
                } else {
                    break ;
                }
            }
            sb.append(prefix + " ");
        }
        sb.deleteCharAt(sb.length() -1);
        return (sb.toString());
    }

    public  TrieNode buildTrie(List<String> dictionary) {
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
            curr.root = word;
        }
        return (root);
    }
}