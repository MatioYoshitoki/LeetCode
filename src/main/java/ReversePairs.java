import java.util.*;

class Solution8 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len==0){
            return 0;
        }
        if (len==1){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (nums[i]>nums[j]){
                    result++;
                }
            }
        }
        return result;
    }

    public int reversePairs2(int[] nums) {
        int len = nums.length;
        if (len==0){
            return 0;
        }
        if (len==1){
            return 0;
        }
        List<TreeMap<Integer, Integer>> list = new ArrayList<>();
        list.add(new TreeMap<>(((a, b) -> b-a)));
        int result = 0;
        boolean flag = false;
        for (int num : nums) {
            flag=false;
            for (TreeMap<Integer, Integer> map : list) {
                if (!map.containsKey(num)) {
                    flag = true;
                    map.put(num, 0);
                }

                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getKey() > num) {
                        result++;
                    }else {
                        break;
                    }
                }
            }
            if (!flag) {
                TreeMap<Integer, Integer> map = new TreeMap<>(((a, b) -> b-a));
                map.put(num, 0);
                list.add(map);

            }
        }
        return result;
    }

    public static void main(String[] args) {
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        map.put(1, 3);
//        map.put(5,3);
//        map.put(4,3);
//
//        System.out.println(2147483647>-2147483647);
        System.out.println(new Solution8().reversePairs2(new int[]{2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647}));
    }
}