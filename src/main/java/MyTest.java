import java.util.LinkedList;
import java.util.List;

public class MyTest {

    static String a = "abcde";
    static String b = "12345";

    public static void main(String[] args) {

        System.out.println(new MyTest().test("aabb"));
    }

    public List<List<String>> test(String target){
        List<List<String>> res = new LinkedList<>();
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i)=='a'){
                res = test0(res, a);
            }else {
                res = test0(res, b);
            }
        }
        return res;
    }

    private List<List<String>> test0(List<List<String>> res, String b) {
        if (res.size()==0){
            for (int j = 0; j < b.length(); j++) {
                List<String> tmp = new LinkedList<>();
                tmp.add(b.substring(j,j+1));
                res.add(tmp);
            }
        }else {
            List<List<String>> copy = new LinkedList<>();
            for (List<String> re : res) {
                for (int j = 0; j < b.length(); j++) {
                    List<String> tmp = new LinkedList<>(re);
                    tmp.add(b.substring(j,j+1));
                    copy.add(tmp);
                }
            }
            res = copy;
        }
        return res;
    }

}
