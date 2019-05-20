package com.yf.reptile.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * java爬虫工具类
 * @author ouyangyufeng
 * @date 2019/5/13
 */
public class ReptileUtils {

    /**
     * 获取Document对象
     * @return
     * @throws Exception
     */
    public static Document getDocument(String url)throws IOException {
        return Jsoup.connect(url).get();
    }


}
