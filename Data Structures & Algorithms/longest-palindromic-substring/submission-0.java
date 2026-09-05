class Solution {
    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;
        int length = 0;

        for(int i =0 ; i<s.length(); i++){
        int oddLength = expand(s, i, i);
        int evenLength = expand(s, i, i + 1);
        
        if(oddLength>=evenLength && oddLength>length){
            start = i - (oddLength - 1) / 2; 
            end = i + (oddLength - 1) / 2;
            length = oddLength;
        }
        if(evenLength>oddLength && evenLength>length){
            start = i - evenLength / 2 + 1; 
            end = i + evenLength / 2;
            length = evenLength;
        }
        }
        System.out.println(length);
        return s.substring(start,end+1);
    }

    private int expand(String s, int left, int right) {
    while (left >= 0 &&
           right < s.length() &&
           s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }

    return right - left - 1;
    }
}
