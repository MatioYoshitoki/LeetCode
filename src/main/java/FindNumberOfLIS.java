import javax.jws.Oneway;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int numLen = nums.length;

        //定义状态变量
        int[] count = new int[numLen];//每个元素为结尾的最长子序列个数
        int[] length = new int[numLen];//每个元素为结尾的最长子序列长度
        Arrays.fill(count, 1);
        Arrays.fill(length, 1);

        //遍历并求解每个元素为结尾的最长子序列个数和长度
        for(int j = 0; j < numLen; j++){
            for(int i = 0; i <= j; i++){
                if(nums[j] > nums[i]){
                    if(length[j] <= length[i]){
                        length[j] = length[i] + 1;
                        count[j] = count[i];
                    }else if(length[j] == length[i] + 1){
                        count[j] = count[i] + count[j];
                    }
                }
            }
        }

        //遍历length，取最大值
        int maxLength = 0;
        for(int len:length){
            maxLength = Math.max(maxLength, len);
        }

        int result = 0;
        for(int i = 0; i < numLen; i++){
            if(maxLength == length[i]){
                result += count[i];
            }
        }

        return result;
    }

    public String test(String s){
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
//        System.out.println(new FindNumberOfLIS().findNumberOfLIS(new int[]{1,3,2,4,7}));
//        HashMap<Object, Object> map = new HashMap<>();
//        map.remove(null);
//        System.out.println(map);
    }

}
