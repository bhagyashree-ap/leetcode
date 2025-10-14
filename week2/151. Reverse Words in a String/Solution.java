class Solution {
    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        int len=s.length();
        int right =0;
        
        for(int i=0; i<len; ){
            while (i<len && s.charAt(i) == ' ') i++;
            if (i >= len) break;
           
            right=i;

            while(right<len && s.charAt(right) != ' ')right++;

            String subword = s.substring(i, right);
            words.add(subword);
            
            i=right+1;
        }      
        Collections.reverse(words);
        return String.join(" ", words); 
    }
}
