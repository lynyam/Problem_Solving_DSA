class Solution {
    public int snakesAndLadders(int[][] board) {
        int i = 0;
        int j = 0;
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n * n + 1];
        boolean[] seen = new boolean[n * n + 1];
        Integer[] colomns = new Integer[n];
        Queue<Integer> queue = new LinkedList<>();
        int label = 1;
        int  row = n - 1;
        int level = 0;

        while (i < n) {
            colomns[i] = i;
            i++;
        }

        while (row >= 0) {
            for (int col : colomns) {
                cells[label++] = new Pair<>(row, col);
            }
            row--;
            Collections.reverse(Arrays.asList(colomns));
        }
        seen[1] = true;
        queue.add(1);
        while (!queue.isEmpty()) {
            i = 0;
            int size = queue.size();
            while (i < size) {
                int curr = queue.remove();
                if (curr == n * n)
                        return (level);
                j = 1;
                while (j <= 6 && curr + j <= n * n) {
                    if (!seen[curr + j]) {
                        seen[curr + j] = true;
                        int neiRow = cells[curr + j].getKey();
                        int neiCol = cells[curr + j].getValue();
                        int nextCell = (board[neiRow][neiCol] == -1) ? curr + j : board[neiRow][neiCol];
                        //seen[nextCell] = true;
                        queue.add(nextCell);
                    }
                    j++;
                }
                i++;
            }
            level++;
        }
        return (-1);
    }
    /*
    numero => x = num % n - 1
              y = num / n

    numero = x % n + y * n

    num = 1 => x = n - 1 && y = 0
    num = n * n => x = 0 && y = 0

    num = x % n + y * n
    ex: 1 = (n - 1) % n + 0 * n = n - 1
        6 = 5 % 6 + (5 * 6d)

    1->n-1, 0        n%row + col%n
    2->n-1, 1
    3->n-1, 2
    4->n-1, 3
    5->n-1, 4
    6->n-1, 5

    7->n-2, 5       n%n-2 = 2 + 5 = 7
    8->n-2, 4
    ..
    12->n-2,0

    13->n-3,0
    14->n-3,1
    */
}