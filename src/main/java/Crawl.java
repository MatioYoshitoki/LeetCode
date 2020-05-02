import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Solution11 {

//    private final ExecutorService executorService = new ThreadPoolExecutor(0, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());//Executors.newCachedThreadPool();//Executors.newFixedThreadPool(5);
    private String hostName ;
    private final Set<String> all = new CopyOnWriteArraySet<>();
    private final AtomicInteger flag = new AtomicInteger(0);
    private HtmlParser htmlParser ;

    public List<String> crawl(String startUrl, HtmlParser htmlParser)  {
        this.hostName = "http://"+startUrl.replace("http://","").split("/")[0];
        this.htmlParser = htmlParser;
        all.add(startUrl);
        filterUrl(htmlParser.getUrls(startUrl));
        while (flag.get()>0);
        String[] strings = new String[all.size()];
        all.toArray(strings);
        return Arrays.asList(strings);
    }

    private void filterUrl(List<String> startUrl) {
        for (String url : startUrl) {
            if (!url.startsWith(hostName)||all.contains(url)){
                continue;
            }
            all.add(url);
            List<String> tmp = new ArrayList<>();
            for (String s :  htmlParser.getUrls(url)) {
                if (s.startsWith(hostName)&&!all.contains(s)){
                    tmp.add(s);
                }
            }
            startThread(tmp);
        }

    }

    private void startThread(List<String> url) {
        System.out.println(flag.incrementAndGet());
//        executorService.execute(()-> spider(url));
        new Thread(()->{
            spider(url);
        }).start();
    }

    public void spider(List<String> url) {
        filterUrl(url);
        flag.decrementAndGet();
    }

    public static void main(String[] args) {
        List<String> a = new Solution11().crawl("http://news.google.com", url -> {
            List<String> result = new ArrayList<>();
            switch (url){
                case "http://news.yahoo.com/news/topics/":
                    result = Arrays.asList("http://news.yahoo.com/news");
                    break;
                case "http://news.yahoo.com":
                    result = Arrays.asList("http://news.yahoo.com/news");
                    break;
                case "http://news.yahoo.com/news":
                    result = Arrays.asList("http://news.yahoo.com/news/topics/","http://news.google.com", "http://news.yahoo.com/us");
                    break;
                case "http://news.yahoo.com/us":
                    result = Arrays.asList("http://news.yahoo.com/news/topics/","http://news.google.com","http://news.yahoo.com");
                    break;
                case "http://news.google.com":
                    result = Arrays.asList("http://news.yahoo.com/news/topics/","http://news.yahoo.com/news","http://news.yahoo.com");
                    break;
            }
            return result;
        });
        System.out.println(a);
    }
}
interface HtmlParser {
    List<String> getUrls(String url);
}
