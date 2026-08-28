class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<TreeMap<Character, Integer>,List<String>> map = new HashMap<>();
        for (String s : strs){
            TreeMap<Character, Integer> tm = new TreeMap<>();
            for(char c: s.toCharArray()){
                tm.put(c,tm.getOrDefault(c,0)+1);
            }
            if(!map.containsKey(tm)){
                map.put(tm, new ArrayList<>());
            }
            map.get(tm).add(s);
        }
        return new ArrayList<>(map.values());
}
}
