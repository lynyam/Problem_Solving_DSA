class Solution {
    public String simplifyPath(String path) {
        List<String> wordsList = new ArrayList<>();
        String[] words = path.split("/");

        for (String s : words) {
            if (wordsList.size() > 0 && s.equals("..")) {
                wordsList.remove(wordsList.size() - 1);
            } else if (!s.isEmpty() && !s.equals(".") && !s.equals("..")) {
                wordsList.add(s);
            }
        }
        //System.out.println(wordsList);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String s : wordsList) {
            sb.append("/");
            sb.append(s);
        }
        return (sb.length() > 0 ? sb.toString() : "/");
    }
}