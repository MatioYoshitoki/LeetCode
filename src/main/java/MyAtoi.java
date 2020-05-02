class Solution3 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length()==0){
            return 0;
        }
        if ((str.charAt(0)<'0' || str.charAt(0)>'9') && (str.charAt(0)!='-' && str.charAt(0)!='+')){
            return 0;
        }
        int result = 0;
        int flag = 1;
        char[] chars = str.toCharArray();

        byte[] bit = new byte[10];
        byte[] max = {2, 1, 4, 7, 4, 8, 3, 6, 4, 7};
        int idx = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i==0&&(chars[i]=='-' || chars[i]=='+')){
                flag=chars[i]=='-'?-1:1;
            }else if (chars[i]>='0' && chars[i]<='9'){
                if (idx>=bit.length){
                    return flag>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                if (idx==0&&chars[i]=='0'){
                    continue;
                }
                bit[idx++]=(byte) (chars[i]-'0');
            }else {
                break;
            }
        }
        if (idx==bit.length){
            for (int i = 0; i < idx; i++) {
                if (bit[i]<max[i]){
                    break;
                }else if (bit[i]>max[i]){
                    return flag>0?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
            }
        }
        for (int i = 0; i < idx; i++) {
            result = result*10 + bit[i];
        }
        return result*flag;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().myAtoi("1095502006p8"));
    }
}