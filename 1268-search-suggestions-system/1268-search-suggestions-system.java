class TreeNode {
	List<Integer> products;
	Map<Character, TreeNode> children;
	public TreeNode() {
		products = new ArrayList<>();
		children = new HashMap<>();
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] product, String searchWord) {
		TreeNode root = buildTree(product);
		TreeNode curr = root;
		List<List<String>> result = new ArrayList<>();//0(SxK) SPACE
		for (char c : searchWord.toCharArray()) {//0(SxP) + 0(PK)=>0(P(S + K))
            if (!curr.children.containsKey(c)) {
                result.add(new ArrayList<>());
                curr = new TreeNode();
                continue ;
            }
            curr = curr.children.get(c);
            List<Integer> currPrefixWord = curr.products;
            Collections.sort(currPrefixWord, (a, b) -> product[a].compareTo(product[b]));
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < 3 && i < currPrefixWord.size(); i++) {
                temp.add(product[currPrefixWord.get(i)]);
            }
            result.add(temp);
        }
        return  (result);
    } 

    public TreeNode buildTree(String[] product) {
        TreeNode root = new TreeNode();
        int index = 0;
        for (String word : product) {
            TreeNode curr = root;
            for (char c : word.toCharArray()) {
                Map<Character, TreeNode> children = curr.children;
                children.putIfAbsent(c, new TreeNode());
                curr = children.get(c);
                curr.products.add(index);
            }
            index++;
        }
        return root;
    }
}