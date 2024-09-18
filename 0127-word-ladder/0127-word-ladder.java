class Solution {

    public List<String> getAllNeighbors(String s, HashSet<String> seen) {
        List<String> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        int i = 0;
        int n = arr.length;

        while (i < n) {
            char temp = arr[i];
            char c = 'a';
            while (c <= 'z') {
                if (c != temp) {
                    arr[i] = c;
                    String candidate = new String(arr);
                    if (seen.contains(candidate))
                        ans.add(candidate);
                }
                c++;
            }
            arr[i] = temp;
            i++;
        }
        return (ans);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> seen = new HashSet<>();
        for (String s : wordList) {
            seen.add(s);
        }
        if (!seen.contains(endWord))
            return (0);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        seen.add(beginWord);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            while (i < size) {
                String curr = queue.remove();
                if (curr.equals(endWord))
                    return (level +  1);
                seen.remove(curr);
                for (String neighbor : getAllNeighbors(curr, seen)) {
                    queue.add(neighbor);
                }
                i++;
            }
            level++;
        }
        return (0);
    }
}
/**
    - bW-> eW using wL
        - bW->s1->s2->..->sk
            - s1 != s2 => diff by sigl letter
            - si 1<= i<= k is in wL.bW don't need in wL
            - sk == eW
    - ret nbr word in shortest transfo sew | 0

    - HS seen (add all wL)
    - if seen not contains eW return 0
    Queue<> queue
    - add bW to queue
    - while queue is not empty
        - String
 */