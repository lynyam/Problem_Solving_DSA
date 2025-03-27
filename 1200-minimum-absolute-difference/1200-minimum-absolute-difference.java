class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr == null || arr.length <= 1) return (new ArrayList<>());
        /*int i = 0;
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        Map<Integer, List<List<Integer>>> pairs = new HashMap<>();
            while (i < n) {
                int j = i + 1;
                while (j < n) {
                    int diff = Math.abs(arr[i] - arr[j]);
                    min = Math.min(min, diff);
                    pairs.putIfAbsent(diff, new ArrayList<>());
                    List<Integer> temp = new ArrayList<>();
                    int left = arr[i] < arr[j] ? arr[i] : arr[j];
                    int right = arr[i] > arr[j] ? arr[i] : arr[j];
                    temp.add(left);
                    temp.add(right);
                    pairs.get(diff).add(temp);
                    j++;
                }
                i++;
            }
        Collections.sort(pairs.get(min), (a, b) -> a.get(0) - b.get(0));
        return (pairs.get(min));*/

        Arrays.sort(arr);
        List<List<Integer>> stack = new ArrayList<>();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int currDifference = Math.abs(arr[i] - arr[i - 1]);
            boolean legible = true;
            while (!stack.isEmpty()) {
                List<Integer> last = stack.get(stack.size() - 1);
                int lastDifference = Math.abs(last.get(0) - last.get(1));
                if (currDifference < lastDifference)
                    stack.remove(stack.size() - 1);
                else if (currDifference >= lastDifference) {
                    if (currDifference > lastDifference) legible = false;
                    break;
                }
            }
            if (legible) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(arr[i - 1]);
                temp.add(arr[i]);
                stack.add(temp);
            }
        }
        return (stack);
    }
}