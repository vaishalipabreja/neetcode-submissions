class Solution {
    public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> dictT = new HashMap<>();
        for(int i =0 ;i< t.length();i++){
            dictT.put(t.charAt(i), dictT.getOrDefault(t.charAt(i),0)+1);
        }

        int left = 0;
        int formed = 0;
        int right =0;
        int required = dictT.size();

        int[] ans = {-1, 0, 0};

        Map<Character, Integer> windowCounts = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // If the current character's count matches its target count, increment formed
            if (dictT.containsKey(c) && windowCounts.get(c).equals(dictT.get(c))) {
                formed++;
            }

            while (left <= right && formed == required) {
                 c = s.charAt(left);

                // Update the smallest window found so far
                int currentWindowLength = right - left + 1;
                if (ans[0] == -1 || currentWindowLength < ans[0]) {
                    ans[0] = currentWindowLength;
                    ans[1] = left;
                    ans[2] = right;
                }

                // Remove the leftmost character from the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                
                // If removing it breaks the validity, decrement formed
                if (dictT.containsKey(c) && windowCounts.get(c) < dictT.get(c)) {
                    formed--;
                }

                left++; // Move left pointer inward
            }
            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
