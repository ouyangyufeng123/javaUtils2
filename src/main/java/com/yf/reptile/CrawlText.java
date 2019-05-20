package com.yf.reptile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.yf.reptile.utils.ReptileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by ouyangyufeng on 2019/3/14.
 */
public class CrawlText {

    /***
     * 获取文本
     *
     * @param autoDownloadFile 自动下载文件
     * @param Multithreading   多线程 默认false
     * @param Url              网站链接
     * @throws IOException
     */
    public static void getText(boolean autoDownloadFile, boolean Multithreading, String Url) throws IOException {
        Document doc = Jsoup.connect(Url).get();
        //Elements eletitle = doc.getElementsByClass("readAreaBox content").get(0).getElementsByTag("h1");
        //Elements elecontent = doc.getElementsByClass("readAreaBox content").get(0).getElementsByClass("p");
        //Elements ele = doc.getElementsByClass("p");
        // Elements vipele = doc.getElementsByClass("ellipsis vip");
        // String title = eletitle.text();
        // String ellipsis = elecontent.text();
        //  List<String> vipEllipsis = vipele.eachText();
//        for (int i = 0; i < title.size(); i++) {
//            System.out.println(text.get(i));
//        }
//        System.out.println("-------------------------普通章节------------------------");
//        ellipsis.forEach(e ->{
//            System.out.println(e);
//        });
//
//        System.out.println("-------------------------VIP章节------------------------");
//        ellipsis.forEach(e ->{
//            System.out.println(e);
//        });
        System.out.println(doc);
        // System.out.println(ellipsis.replace(" ", "\n"));

    }


    public static void main(String[] args) {
        try {
            for (int i = 1; i <= 1; i++) {
                CrawlText.getMusicDianYin(true, true, "https://www.kugou.com/yy/rank/home/" + i + "-33161.html?from=rank");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void getAdress(boolean autoDownloadFile, boolean Multithreading, String Url) throws IOException {
        Document doc = Jsoup.connect(Url).get();

        //定位热门榜单
        Elements ele = doc.getElementsByClass("pc_rank_sidebar pc_rank_sidebar_first ");

        //获取热门榜单的地址
        List<String> title = ele.get(0).getElementsByTag("a").eachAttr("title");
        title.remove(0);
        List<String> href = ele.get(0).getElementsByTag("a").eachAttr("href");
        href.remove(0);

        for (int i = 1; i < title.size(); i++) {
            //System.out.println(title.get(i) + ":" + href.get(i));
            CrawlText.getMusic(true, true, href.get(i));
        }
        System.out.println();

        //CrawlText.getMusic(true, true, href.get(0));

//        System.out.println(title);
//        System.out.println(href);


    }


    public static void getMusic(boolean autoDownloadFile, boolean Multithreading, String Url) throws IOException {
        //System.out.println(Url);
        Document doc = ReptileUtils.getDocument(Url);
        //定位歌曲
        Elements ele = doc.getElementsByClass("pc_temp_songlist ");

        List<String> title = ele.get(0).getElementsByTag("li").eachAttr("title");
        List<String> href = ele.get(0).getElementsByClass("pc_temp_songname").eachAttr("href");

        System.out.println();
        for (int i = 0; i < title.size(); i++) {
            System.out.println(title.get(i) + ":" + href.get(i));
        }
        // System.out.println(ele);
        // System.out.println(ele.get(0).getElementsByTag("a"));
    }

    public static void getMusicDianYin(boolean autoDownloadFile, boolean Multithreading, String Url) throws IOException {
        Document doc = Jsoup.connect(Url).get();

        //定位歌曲
        Elements ele = doc.getElementsByClass("pc_temp_songlist ");
//
        List<String> title = ele.get(0).getElementsByTag("li").eachAttr("title");
        List<String> href = ele.get(0).getElementsByClass("pc_temp_songname").eachAttr("href");
        List<String> pc_temp_time = ele.get(0).getElementsByClass("pc_temp_time").eachText();
//        System.out.println();
//        for (int i = 0; i < title.size(); i++) {
//            System.out.println("歌名: "+title.get(i) + "\t|\t播放地址: " + href.get(i)+"\t|\t播放时长: "+pc_temp_time.get(i));
//        }
        //System.out.println(doc);
        for (String h : href) {
            CrawlText.get(true, true, h);
        }
        // System.out.println(ele.get(0).getElementsByTag("a"));
    }


    public static void get(boolean autoDownloadFile, boolean Multithreading, String Url) throws IOException {
        Document doc = Jsoup.connect(Url).get();
        //封面图
        String albumImg = doc.getElementsByClass("album fl").get(0).getElementsByTag("img").attr("src");

        //歌曲
        String audioName = doc.getElementsByClass("audioName").text();

        //歌手
        String singerName = doc.getElementsByClass("songDetail clearfix").get(0).getElementsByClass("singerName").get(0).getElementsByTag("a").text();

        //专辑
        String albumName = doc.getElementsByClass("songDetail clearfix").get(0).getElementsByClass("albumName").get(0).getElementsByTag("a").text();

        //歌词

        //System.out.println(audioName + "---" + singerName + "---" + albumName + "---" + albumImg);
        //System.out.println(doc.getElementsByClass("album fl").get(0).getElementsByTag("img").attr("src"));
        System.out.println(doc);
    }


}
