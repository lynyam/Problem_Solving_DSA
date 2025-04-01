class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        // case arr empty or arr lenght is 1 retrn empty list
        //sort array with countingSort 
        //start with index 1, idea is to calculate difference with i and i -1 and compare with min.
            // if diff > min continue to i++
            //if diff < min clear result min update
            // add list (arr[i -1], arr[i]) it cover equal case

        if (arr == null || arr.length < 2) return (new ArrayList<>());
        int minDiff = Integer.MAX_VALUE;
        int n = arr.length;
        
        int[] sortArr = countingSort(arr);
        
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < sortArr.length; i++) {
            int diff = Math.abs(sortArr[i - 1] - sortArr[i]);
            if (diff > minDiff) {
                continue;
            }
            if (diff < minDiff) {
                result = new ArrayList<>();
                minDiff = diff;
            }
            result.add(Arrays.asList(sortArr[i - 1], sortArr[i]));
        }
        return (result);
    }

    public int[] countingSort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        boolean[] counting = new boolean[max - min + 1];
        int shift = -min; // enfaite c'est 0 - shift pour avoir le decalage qu'il faut
        for (int num : arr) {
            counting[num + shift] = true;
        }
        int[] result = new int[arr.length];
        int k = 0;
        for (int i = 0; i < (max - min + 1); i++) {
            if (counting[i])
                result[k++] = i - shift; 
        }
        return result;
    }
}