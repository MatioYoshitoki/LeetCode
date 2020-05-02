class Solution6 {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        int [] m = {1000, 500, 100, 50, 10, 5, 1};
        char[] c = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        for (int i = 0; i < m.length; i++) {
            char[] tmp = new char[0];
            if (i%2==0){
                int t = num / m[i];
                if (t==0){
                    continue;
                }
                if (t==9){
                    tmp = new char[2];
                    tmp[0]=c[i];
                    tmp[1]=c[i-2];
                } else {
                    tmp = new char[t];
                    for (int j = 0; j < t; j++) {
                        tmp[j]=c[i];
                    }
                }
                num = num%m[i];
            }
            result.append(tmp);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution6().intToRoman(9));
    }
}