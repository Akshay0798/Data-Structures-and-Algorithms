//https://leetcode.com/problems/set-mismatch/
/*
public class FindErrorNo {
    public int[] findErrorNums(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != i + 1) {
                int correctIndex = arr[i] - 1;
                if (arr[i] != arr[correctIndex]) {
                    swap(arr, i, correctIndex);
                } else {
                    i++;
                }
            }
            for (int index = 0; index < arr.length; index++) {
                if (arr[index] != index + 1) {
                    return new int[]{arr[index], index + 1};
                }
            }
            return new int[]{-1, -1};
        }
        static void swap( int[] arr, int first, int second){
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
        }
    }
}

 */

