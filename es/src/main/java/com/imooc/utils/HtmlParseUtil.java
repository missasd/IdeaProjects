package com.imooc.utils;

import com.imooc.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component // 丢到spring中，使用的时候直接注入就行
public class HtmlParseUtil {

//    public static void main(String[] args) throws IOException {
//        new HtmlParseUtil().parseJD("java").forEach(System.out::println);
//
//    }

    public List<Content> parseJD(String keyworkds) throws IOException {
        String url = "https://search.jd.com/Search?keyword=" + keyworkds;
        // 如果获取ajax则需要模拟浏览器请求

        // 解析网页, Jsoup返回Document就是Docuemnt对象
        Document document = Jsoup.parse(new URL(url), 30000);
        //
        Element element = document.getElementById("J_goodsList");
//        System.out.println(j_goodList.html());
        // 获取所有li元素
        Elements lis = element.getElementsByTag("li");

        //
        ArrayList<Content> result = new ArrayList<>();

        for (Element li: lis) {
            String title = li.getElementsByClass("p-name").eq(0).text();

            String img = li.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = li.getElementsByClass("p-price").eq(0).text();

            // 将每条记录封装为一个对象
            Content content = new Content();
            content.setTitle(title);
            content.setImg(img);
            content.setPrice(price);

            result.add(content);


        }
        return result;
    }
}
