import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class demo {
    public static void main(String[] args) {
        try {
            //下面这行代码是连接我们的目标站点，并且get到他的静态HTML代码
            Document document= Jsoup.connect("https://gaokao.chsi.com.cn/sch/search--ss-on,option-qg,searchType-1,start-0.dhtml").get();
            //我们把获取到的document打印一下，看看里面到底是啥？
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
