class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<TreeMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (String s: strs){
             TreeMap<Character, Integer> charCountMap = new TreeMap<>();
            for (char c : s.toCharArray()) {
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
            if (!map.containsKey(charCountMap)) {
                map.put(charCountMap, new ArrayList<>());
            }
            map.get(charCountMap).add(s);

        }
        return new ArrayList<>(map.values());
    }
}
