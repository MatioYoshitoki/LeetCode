class Solution1 {
    public String convert(String s, int numRows) {

        int len = s.length();
        if (len==1||numRows==1){
            return s;
        }
        char[] result = new char[len];
        int mpL = numRows==2?(int) Math.ceil((double) len/2): (int) Math.ceil(((double) len*(numRows-1))/(numRows+1));
        char[][] map = new char[numRows][mpL];
        int flag1=0;
        int flag2=0;

        for (int i = 0; i <= len-1; i++) {
            if (flag2%(numRows-1)==0){
                map[flag1][flag2]=s.charAt(i);
                if (flag1==(numRows-1)){
                    flag2++;
                    flag1--;
                }else {
                    flag1++;
                }
            }else {
                map[flag1][flag2]=s.charAt(i);
                flag2++;
                flag1--;
            }
        }
        int i=0;
        for (char[] chars : map) {
            for (char aChar : chars) {
                if (aChar!=0){
                    result[i++]=aChar;
                }
            }
        }
        return new String(result);
    }
}