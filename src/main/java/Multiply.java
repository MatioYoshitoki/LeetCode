import java.util.ArrayList;
import java.util.List;

class Solution9 {

    public String multiply(String num1, String num2) {

        if (num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder result = new StringBuilder();
        int [][] tmp = new int[len2][len1+len2+1];
        int flag1=0;
        int flag2=len1+len2;
        int flag = 0;
        for (int i = len2-1; i >= 0; i--) {
            flag=0;
            for (int j = len1-1; j >= 0; j--) {
                int bit = (num2.charAt(i) - 48) * (num1.charAt(j) - 48) + flag;
                tmp[flag1][flag2]=bit%10;
                flag = bit/10;
                flag2--;

            }
            tmp[flag1][flag2]=flag;
            flag1++;
            flag2 = len1+len2-flag1;
        }
        flag2=len1+len2;
        flag =0;
        while (flag2>=0){
            int t = flag;
            for (int i = 0; i < flag1; i++) {
                t+=tmp[i][flag2];
            }

            result.append((char) (t%10+48));
            flag = t/10;
            flag2--;
        }
        for (int i = result.length()-1; i >= 0; i--) {
            if (result.charAt(i)=='0'){
                result.deleteCharAt(i);
            }else {
                break;
            }
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution9().multiply(
                "999",
                "999")
        );
    }
}