class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (boxTypes[b][1] - boxTypes[a][1]));
        int i = 0;
        int n = boxTypes.length;
        int ans = 0;

        while (i < n) {
            heap.add(i);
            i++;
        }
        while (truckSize > 0 && !heap.isEmpty()) {
            int index = heap.remove();
            ans += boxTypes[index][1];
            boxTypes[index][0]--;
            if (boxTypes[index][0] > 0)
                heap.add(index);
            truckSize--;
        }
        return (ans);        
    }
}
/**
    - boxTypes int[][]
        - boxTypes[i] = [numberOfBoxes_i, nbrOfUnitsPerBox_i]
            - numberOfBoxes_i = nbr of boxe de type i
            - nbrOfUnitsPerBox_i = nbr of units in each box of the type i
    - trucSize int = max of boxes can put on the truck
    - u can choose any boxes to put on the truck if nbr of box <= trucSize
    - ret max total number of units that can be put on the truck
    - ex: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 */