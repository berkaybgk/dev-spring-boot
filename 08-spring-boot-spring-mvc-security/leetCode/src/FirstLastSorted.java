import java.util.Arrays;


public class FirstLastSorted {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;


        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] indexes = {-1,-1};
        int[] returnList = {-1,-1};

        if (nums.length == 0)
            return indexes;

        // perform a binary search
        indexes[0] = Arrays.binarySearch(nums,0,nums.length,target);

        if (indexes[0] < 0)
            return returnList;
        while(nums[indexes[0]-1] == target)
            indexes[0] -= 1;

        indexes[1] = Arrays.binarySearch(nums,indexes[0]+1,nums.length,target);
        if (indexes[1] < 0)
            indexes[1] = indexes[0];

        return indexes;
    }

//    public static int binarySearch(int[] nums, int target) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int[] newList = new int[nums.length/2+1];
//        Arrays.b
//
//        return binarySearch(newList,target);
//    }

}
