class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        //System.out.println("Début de l'analyse du tableau : " + java.util.Arrays.toString(nums));

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
           // System.out.println("À l'index " + i + ", portée possible : i + nums[i] = " + i + " + " + nums[i] + " = " + (i + nums[i]));
            //System.out.println("Portée maximale actuelle (farthest) mise à jour à : " + farthest);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
              //  System.out.println("==> Fin de fenêtre atteinte à l'index " + i + ", saut #" + jumps);
               // System.out.println("    Nouvelle fenêtre va jusqu’à l’index " + currentEnd);
            }

            //System.out.println("------------");
        }

        //System.out.println("Nombre total de sauts : " + jumps);
        return jumps;
    }
}