class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i =0; i< s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!hm.containsKey(c)) {
                return false; // Character not even in 's'
            }
            hm.put(c, hm.get(c) - 1);

            if(hm.get(c) == 0){
                hm.remove(c);
            }
        }
        return hm.isEmpty();
    }
}
