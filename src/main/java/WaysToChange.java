class Solution7 {
    public int waysToChange(int n) {
        long result = 0;
        int a=n/25;
        long b;
        for (int i = a; i>=0; i--) {
            b = (n-i*25)/10;//a
            int tmp = (n-i*25)%10;
            if (tmp>=5){
                result+=(((2+(b+1)*2)*(b+1))/2)%1000000007;
            }else {
                result+=(((b+1)*(b+1)))%1000000007;
            }
        }
        return (int) (result%1000000007);
    }

}