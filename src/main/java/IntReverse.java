class Solution2 {
    public int reverse(int x) {
        long result=0;
        int flag = x>0?1:-1;
        x = x*flag;
        if (x<0){
            return 0;
        }
        do{
            result = result*10+(x%10);
        }while ((x=x/10)>0);
        if (result>Integer.MAX_VALUE){
            result = 0;
        }
        return (int) (result*flag);
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().reverse(-120));
    }
}