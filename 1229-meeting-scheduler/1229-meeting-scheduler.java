class Solution {
	public List<Integer> minAvailableDuration(int[][] slot1, int[][] slot2, int duration) {
		List<Integer> result = new ArrayList<>();
		int i = 0;
		int j = 0;
		int n1 = slot1.length;
		int n2 = slot2.length;
		
		while (i < n1 && j < n2){
			int s1Start = slot1[i][0];//10
			int s1End = slot1[i][1];//50
			int s2Start = slot2[j][0];//60
			int s2End = slot2[j][1];//70
			int earliestStart = s1Start >= s2Start ? s1Start : s2Start;//60
			int earliestEnd = earliestStart + duration;//68
			if (earliestEnd <= s1End && earliestEnd <= s2End){
                result.add(earliestStart);
                result.add(earliestEnd);
                break ;
            }
			if (earliestStart >= s1Start && earliestEnd <= s1End)
				j++;//1
			else if (earliestStart >= s2Start && earliestEnd <= s2End)
				i++;
			else  {
	            i++;
	            j++;
            }
        }
		return (result);
    }
}


