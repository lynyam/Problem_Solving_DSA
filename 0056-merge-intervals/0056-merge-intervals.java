class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty() || interval[0] > result.getLast()[1]) {
                result.add(interval);
            } else {
                int end = Math.max(interval[1], result.getLast()[1]);
                result.getLast()[1] = end;
            }
        }
        return (result.toArray(new int[result.size()][]));
    }
}