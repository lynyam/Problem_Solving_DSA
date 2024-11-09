class Solution {
    public boolean checkIfPangram(String sentence) {
       char	c = 'a';

		while (c <= 'z') {
			if (sentence.indexOf(c) < 0)
				return (false);
			c++;
        }
        return (true);
 
    }
}