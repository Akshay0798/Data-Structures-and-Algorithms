import java.util.HashSet;
//common element we have to find out between 2 array
public class IntersectionOf2Array {
    public static int Intersection(int[] arr1,int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        int count=0;

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int j = 0; j < arr2.length; j++) {
            if (set.contains(arr2[j])){
                count++;
                set.remove(arr2[j]);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr1={7,3,9};
        int[] arr2={6,3,9,2,9,4};
        System.out.println(Intersection(arr1,arr2));
    }
}
