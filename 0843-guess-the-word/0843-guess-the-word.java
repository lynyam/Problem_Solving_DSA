/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        Random random = new Random();

        while (true) {
            //String guess = pickWord(wordList);
            String guess = wordList.get(random.nextInt(wordList.size()));
            int matches = master.guess(guess);
            if (matches == 6) return;

            List<String> nextList = new ArrayList<>();
            for (String word : wordList) {
                if (match(guess, word) == matches) {
                    nextList.add(word);
                }
            }
            wordList = nextList;
        }
    }

    private String pickWord(List<String> words) {
        int minMaxGroupSize = Integer.MAX_VALUE;
        String bestWord = words.get(0);

        for (String word : words) {
            int[] count = new int[7]; // matches can be 0..6
            for (String other : words) {
                if (!word.equals(other)) {
                    int m = match(word, other);
                    count[m]++;
                }
            }
            int maxGroup = 0;
            for (int c : count) {
                maxGroup = Math.max(maxGroup, c);
            }
            if (maxGroup < minMaxGroupSize) {
                minMaxGroupSize = maxGroup;
                bestWord = word;
            }
        }
        return bestWord;
    }

    private int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) matches++;
        }
        return matches;
    }
}