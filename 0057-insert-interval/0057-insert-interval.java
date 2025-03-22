class Solution {
    /*public int[][] insert1(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) return (new int[][] {newInterval});
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(new int[]{newInterval[0], newInterval[1]});
         while (i < n) {
            result.add(intervals[i++]);
        }
        return (result.toArray(new int[result.size()][]));
        [[1,3],[6,9]]
        [2,5]

        1 6 / 2 => 1
        [[1,3],[2,5],[6,9]]
        [[1,5],[6,9]]

        [2,5]
        [1,3]
         2 <= 3 [1,5]
         [6,9]
         6 > 5

    }*/

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) return (new int[][]{newInterval});
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (intervals[mid][0] > newInterval[0])
                right = mid - 1;
            else if (intervals[mid][0] < newInterval[0])
                left = mid + 1;
            else {
                left = mid;
                break;
            }
        }
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < left) {
            result.add(intervals[i]);
            i++;
        }
        if (result.size() != 0 && newInterval[0] <= result.get(result.size() - 1)[1]) {
            result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], newInterval[1]);
        } else {
            result.add(newInterval);
        }
        
        while (i < n && intervals[i][0] <= result.get(result.size() - 1)[1]) {
             System.out.println(result.get(result.size() - 1)[1]);
             System.out.println(intervals[i][1]);
            result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
           
            i++;
        }
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return (result.toArray(new int[result.size()][]));
    }
}