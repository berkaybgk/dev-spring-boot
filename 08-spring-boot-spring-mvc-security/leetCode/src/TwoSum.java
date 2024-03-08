import java.util.Arrays;

class TwoSum {

    public static void main(String[] args) {
        int[] array = {3,2,4};
        System.out.println(Arrays.toString(twoSum(array,6)));
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] soln = new int[2];

        for (int i = 0; i<nums.length; i++) {
            for (int j = i+1; j<nums.length; j++) {

                if ((nums[i] + nums[j]) == target) {
                    soln[0] = i;
                    soln[1] = j;
                    return soln;
                }
            }
        }
        return soln;

    }
}