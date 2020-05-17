import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxAvg {


//    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    static int [] nums ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //鸡场个数
        int n = sc.nextInt();
        //天数
        int m = sc.nextInt();
        //每天增加
        int k = sc.nextInt();
        nums = new int[n];
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            if (tmp>max){
                max = tmp;
                maxIndex = i;
            }
            nums[i]=tmp;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nums.length; j++) {
                nums[j]+=k;
            }
            nums[maxIndex]=nums[maxIndex]/2;
            max = 0;
            maxIndex = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]>max){
                    max = nums[j];
                    maxIndex = j;
                }
            }
        }
        int result = 0;
        for (int num : nums) {
            result+=num;
        }
        System.out.println(result);
    }

}
