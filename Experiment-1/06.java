class Solution {
    public int search(int[] nums, int target) {
        int si=0;
        int ei=nums.length-1;

        if(si>ei){
            return -1;
        }

        while(si<=ei){
            int mid=si+(ei-si)/2;
            //case found
            if(nums[mid]==target){
                return mid;
            }

            //kaam
            if(nums[si]<=nums[mid]){ //left sorted
                //case a: tar prsnt in left
                if(nums[si]<=target && target<=nums[mid]){
                    ei=mid-1;
                }else{ //case b: tar prsnt in right
                    si=mid+1;
                }
            }else{ //right sorted
                //case c: tar prsnt in right
                if(nums[mid]<=target && target<=nums[ei]){
                    si=mid+1;
                }else{ //case d: tar prsnt in left
                    ei=mid-1;
                }
            }
        }
        //not found
        return -1;
    }
}
