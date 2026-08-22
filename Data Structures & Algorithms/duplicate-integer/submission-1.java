class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for(int i:nums){
            System.out.println(i);
            if(hm.containsKey(i)){
                return true;
            }
            hm.put(i,0);

        }
        return false;
    }
}