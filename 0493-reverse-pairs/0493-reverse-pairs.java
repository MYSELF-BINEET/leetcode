class Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        int left=0,right=n-1;

        return mergeSort(nums,left,right);
    }

    private int mergeSort(int nums[],int left,int right){
        if (left >= right) {
            return 0;
        }
        int mid=left+(right-left)/2;
        int reversePair=0;

        reversePair+=mergeSort(nums,left,mid);
        reversePair+=mergeSort(nums,mid+1,right);
        reversePair+=countReversePair(nums,left,mid,right);

        merge(nums,left,mid,right);

        return reversePair;
    }

    private int countReversePair(int[] nums,int left,int mid,int right){
        int reversePair=0;
        int rightIndex=mid+1;

        for(int i=left;i<=mid;i++){
            int leftValue=nums[i];
            while(rightIndex<=right && leftValue>2L*nums[rightIndex]){
                rightIndex++;
            }
            reversePair+=rightIndex-(mid+1);
        }

        return reversePair;
    }

    private void merge(int[] nums,int left,int mid,int right){
        int write=0;
        int first=left,second=mid+1;
        int merged[]=new int[right-left+1];

        while(first<=mid && second<=right){
            if(nums[first]<=nums[second]){
                merged[write]=nums[first];
                first++;
            }else{
                merged[write]=nums[second];
                second++;
            }
            write++;
        }

        while(first<=mid){
            merged[write]=nums[first];
            write++;
            first++;
        }

        while(second<=right){
            merged[write]=nums[second];
            write++;
            second++;
        }

        for(int i=0;i<merged.length;i++){
            nums[left+i]=merged[i];
        }
    }
}