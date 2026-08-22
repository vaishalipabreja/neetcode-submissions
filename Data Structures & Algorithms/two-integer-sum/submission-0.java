class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seenNumbers = new HashMap<>();

        for(int i =0 ; i<nums.length;i++){
            int currentNum = nums[i];
            int complement = target - currentNum;
            if(seenNumbers.containsKey(complement)){
                int smallerIndex = seenNumbers.get(complement);
                return new int[] { smallerIndex, i };
            }
             seenNumbers.put(currentNum, i);
        }
        return new int[] {0,0};
    }
}
