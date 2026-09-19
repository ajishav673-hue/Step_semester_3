import java.util.Arrays;

public class ThreeSum {

    public static int[][] threeSum(int[] nums) {

        Arrays.sort(nums);

        int[][] result = new int[nums.length * nums.length][3];
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result[count][0] = nums[i];
                    result[count][1] = nums[left];
                    result[count][2] = nums[right];
                    count++;

                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        int[][] finalResult = new int[count][3];

        for (int i = 0; i < count; i++) {
            finalResult[i] = result[i];
        }

        return finalResult;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};

        int[][] result = threeSum(nums);

        for (int[] triplet : result) {
            System.out.println(Arrays.toString(triplet));
        }
    }
}