
import java.util.ArrayList;
import java.util.List;

public class FindtheUnionOfTwoSortedArrays {

    public static void main(String[] args) {
        FindtheUnionOfTwoSortedArrays obj = new FindtheUnionOfTwoSortedArrays();
        int[] nums1 = { 1, 2, 3, 4, 5 };
        int[] nums2 = { 1, 2, 3 };
        System.out.println(obj.findUnion(nums1, nums2));
    }

    // Problem: Find the union of two sorted arrays
    public List<Integer> findUnion(int[] nums1, int[] nums2){
        int n1 = nums1.length, n2 = nums2.length;
        int i=0, j=0;
        List<Integer> union = new ArrayList<>();
        while(i<n1 && j<n2){
            if(nums1[i] <= nums2[j]){
                if(union.isEmpty() || union.get(union.size()-1) != nums1[i]){
                    union.add(nums1[i]);
                }
                i++;
            }else{
                if(union.isEmpty() || union.get(union.size()-1) != nums2[j]){
                    union.add(nums2[j]);
                }
                j++;
            }
        }
        while(i<n1){
            if(union.isEmpty() || union.get(union.size()-1) != nums1[i]){
                union.add(nums1[i]);
            }
            i++;
        }
        while(j<n2){
            if(union.isEmpty() || union.get(union.size()-1) != nums2[j]){
                union.add(nums2[j]);
            }
            j++;
        }
        return union;
    }
}
