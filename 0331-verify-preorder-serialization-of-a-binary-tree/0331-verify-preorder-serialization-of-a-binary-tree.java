class Solution {
    public boolean isValidSerialization(String preorder) {
        
        String[] str = preorder.split(",");
        Pair<Boolean, Integer> result = helper(str, 0, str.length);
        return (result.getKey() && result.getValue().equals(str.length - 1));
    }

    public Pair<Boolean, Integer> helper(String[] str, int index, int len) {
        if (index >= len)
            return (new Pair<>(false, index));
        if (str[index].equals("#"))
            return new Pair<>(true, index);
        Pair<Boolean, Integer> left = helper(str, index + 1, len);//3
        if (!left.getKey()) {
            return (new Pair(false, index));
        }
        return (helper(str, left.getValue() + 1, len));
    }
}