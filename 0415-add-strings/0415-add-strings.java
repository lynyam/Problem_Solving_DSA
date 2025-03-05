class Solution {
	public String	addStrings(String num1, String num2) {
		int n1 = num1.length();
		int n2 = num2.length();


		int rest = 0;
		int i = n1 - 1;
		int j = n2 - 1;
		StringBuilder sum  = new StringBuilder();
		while (i >= 0 && j >= 0) {
            int d1 = num1.charAt(i) - '0';//1
            int d2 = num2.charAt(j) - '0';//9
            int temp = d1 + d2 + rest;//11
            sum.append(temp % 10);//2 2 1
            rest = temp / 10;//1
            i--;
            j--;
        }
        while (i >= 0) {//1
            int temp = num1.charAt(i) - '0' + rest;//2
            sum.append(temp % 10);//2 2 1 2
            rest = temp / 10;//0
            i--;
        }
        while (j >= 0) {
            int temp = num2.charAt(j) - '0' + rest;
            sum.append(temp % 10);
            rest = temp / 10;
            j--;
        }
        if (rest > 0)
            sum.append(rest);
        sum.reverse();//2 1 2 2
        return (sum.toString());
    }
}
