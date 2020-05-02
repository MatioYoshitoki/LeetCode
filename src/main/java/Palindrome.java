class Solution0 {
    public String longestPalindrome(String s) {
        if (s.length()<=1){
            return s;
        }
        char[] charArray = s.toCharArray();
        int len = s.length();
        char[] result = new char[len];
        int flag1;
        int flag2;
        int max = 0;
        for (int i = 0; i < (len-1) * 2; i++) {
            if (i%2==0){
                flag1=(i/2);
                flag2=flag1;
            }else {
                flag1=(i/2);
                flag2=flag1+1;
            }
            do{
                if (charArray[flag1]==charArray[flag2]){
                    flag1--;
                    flag2++;
                }else {
                    int nl = (flag2-1)-(flag1+1)+1;
                    if (nl>max){
                        max=nl;
                        System.arraycopy(charArray, flag1+1, result, 0, nl);
                    }
                    break;
                }
            }while (flag1>=0&&flag2<len);
            if (flag1<0||flag2>=len){
                int nl = (flag2-1)-(flag1+1)+1;
                if (nl>max){
                    max=nl;
                    System.arraycopy(charArray, flag1+1, result, 0, nl);
                }
            }
        }

        return new String(result, 0, max);
    }
}