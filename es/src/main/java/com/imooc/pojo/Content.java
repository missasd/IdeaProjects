package com.imooc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于封装爬虫的结果
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    
    //String img = li.getElementsByTag("img").eq(0).attr("data-lazy-img");
    //            String price = li.getElementsByClass("p-price").eq(0).text();
    //            String title
    
    private String title;
    private String img;
    private String price;

}
