import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AliTest1 {

    public List<String> findKey(String path, String key) throws IOException {

        List<String> list = Files.readAllLines(Paths.get(path));
        List<String> result = new ArrayList<>();

        String last = null;
        int count = 1;
        for (int i=0;i<list.size();i++) {
            String s = list.get(i);
            if (s.contains(key)){
                if (null==last){
                    last = s;
                }else if (last.equals(s)){
                    count ++;
                }else {
                    result.add("\t"+count+" "+last);
                    last = s;
                    count=1;
                }
            }
        }
        if (last!=null){
            result.add("\t"+count+" "+last);
        }
        result.sort(Comparator.reverseOrder());
        for (String tmp : result) {
            System.out.println(tmp);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        new AliTest1().findKey("test.log", "");
    }

}
