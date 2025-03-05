class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 0) return new String();
        int n = s.length();
        if (numRows == 1 || numRows > n) return new String(s);
        int numCols;
        double charsByPattern = 2 * numRows - 2.0;
        int numPattern = (int)Math.ceil(n / charsByPattern);
        int numColsByPattern = numRows - 1;
        numCols = numPattern * numColsByPattern;
        char[][] matrix = new char[numRows][numCols];
        int currRow = 0;
        int currCol = 0;
        int i = 0;

        while (i < n) {
            while (currRow < numRows - 1 && i < n) {
                matrix[currRow][currCol] = s.charAt(i++);
                currRow++;
            }
            while (currRow > 0 && currCol < numCols && i < n) {
                matrix[currRow][currCol] = s.charAt(i++);
                currRow--;
                currCol++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            for (int k = 0; k < numCols; k++) {
                if (matrix[j][k] != 0) {
                    result.append(matrix[j][k]);
                }
            }
        }
        return (result.toString());
        
    }
}