class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int i = 0;
        int n = boxTypes.length;
        int ans = 0;

        while (i < n) {
            int nbrBox = boxTypes[i][0];
            int units = boxTypes[i][1];
            if (truckSize > nbrBox) {
                ans += nbrBox * units;
                truckSize -= nbrBox;
            }
            else {
                return (ans + (truckSize * units));
            }
            i++;
        }
        return (ans);
    }
}
/**
    - boxTypes, 
        - boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]
        - numberOfBoxesi: number of boxes of type i
        - numberOfUnitsPerBoxi: number of. units in each box of type i
    - truckSize int: max nbr of boxes  that can be put on truck
    - u can choose any boxes to put on truck if numberOfBoxe >trucSize
    - ret max unit can be put on truck
 */