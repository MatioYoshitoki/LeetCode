class Solution5 {
    public int maxArea(int[] height) {
        int result = 0;
        int len = height.length;
        int maxL = 0;
        for (int i = 0; i < len; i++) {
            if (height[i]<=maxL){
                continue;
            }
            for (int j = i+1; j < len; j++) {
                int tmp = (j - i) * Math.min(height[i], height[j]);
                if (result<tmp){
                    result = tmp;
                    maxL = height[i];
                }

            }
        }
        return result;
    }
}