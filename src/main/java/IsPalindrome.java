class Solution4 {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        if (x<10){
            return true;
        }
        char[] s = String.valueOf(x).toCharArray();
        int len = s.length;
        int flag1=0;
        int flag2= len -1;

        do {
            if (s[flag1]!=s[flag2]){
                return false;
            }else {
                flag1++;
                flag2--;
            }
        }while (flag1<(len%2==0?(flag2+1):flag2));
        return true;
    }

}