class Solution {
    public List<String> fullJustify(String[] word,  int maxWidth) {
		int n = word.length;
//1- track new list to format with two variable
	//a- use variable start , end and count len of line without space
	    int start = 0, end = 0, count = 0, space = 0;
        List<String> result = new ArrayList<>();
	    while (end < n) {
		    count += word[end].length();
		    space = end - start;
	//b- stop end and back to end - 1 if count + space > maxWith / space = end - start
		    if (count + space  <= maxWidth) {
			    end++;
			    continue ;
		    }
//2- have new list format and add to result
	//a - compute reelSpace = maxWith - (count)
		    
	//b- compute normalSpace = reelSpace / (space) => space = end - start || restSpace = reelSpace % space
            space = (end - 1) - start;
            count -= word[end].length();
            int allSpace = maxWidth - count;
		    int normalSpace = (space == 0) ? 0 :  allSpace / (space);
		    int restSpace =  (space == 0)? 0 :  allSpace % space;
            System.out.println(normalSpace);
	//c- construct and Add line to result
		    StringBuilder line = new StringBuilder();
//- walk through to start to end (inclusive)
	        for (int i = start; i < end; i++) {
			//-  add word[start] to result 
				line.append(word[i]);
			//- if start # end
				if (i < end - 1) {
//-add normalSpace time “space” 
	                for (int k = 0; k  < normalSpace; k++)
		                line.append(" ");
				//-  if it is for first add reelSpace
				    if (restSpace > 0) {
						line.append(" ");
                        restSpace--;
                    }
                }
            }
            while (line.length() < maxWidth) {
                line.append(" ");
            }
            result.add(line.toString());
            start = end;
            count = 0;
        }
//3- treated a special last case left justified end == n
        if (start < n) {
 //- normal space btw word, loop from start to end
	        StringBuilder line = new StringBuilder();
            for (int i = start; i < end; i++) {
	//-  add word[start] to line
	            line.append(word[i]);
		//- if start # end
			    if (i < n - 1) {
				//-add normalSpace time “space” 
				    line.append(" ");
                }
            }
            while (line.length() < maxWidth) {
                line.append(" ");
            }	
	// while count < MaxWith add space
//-add line to result
		    result.add(line.toString());
	    }
	    return (result);
//4- return result
    }
}
