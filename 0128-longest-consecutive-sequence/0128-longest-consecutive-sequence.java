class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> s=new HashSet<>();

        for(int i:nums){
            s.add(i);
        }

        int maxCnt=1;

        for(int i:s){
            if(s.contains(i-1)){
                continue;
            }
            if(s.contains(i)){
                int cnt=1;

                while(s.contains(i+1)){
                    cnt++;
                    maxCnt=Math.max(cnt,maxCnt);
                    i++;
                }
            }
        }

        return maxCnt;
    }
}