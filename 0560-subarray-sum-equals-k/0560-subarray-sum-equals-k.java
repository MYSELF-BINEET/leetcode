class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] prefixSum=new int[nums.length];

        prefixSum[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }

        int cnt=0;
        int sum=0;

        HashMap<Integer,Integer> map=new HashMap<>();
        // map.put(0, 1);

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k){
                cnt++;
            }

            if(map.containsKey(sum-k)){
                cnt += map.get(sum - k);
            }

            // if(!map.containsKey(prefixSum[i])){
                // map.put(prefixSum[i],i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            // }

        }
        return cnt;
    }
}