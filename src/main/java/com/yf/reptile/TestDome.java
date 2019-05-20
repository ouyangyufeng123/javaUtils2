package com.yf.reptile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yf.file.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by ouyangyufeng on 2019/5/8.
 */
public class TestDome {

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
        //Element eletitle = doc.getElementsByClass("p").get(0);
        // System.out.println(eletitle);
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
        //FileUtils.writeByteDoc("E:\\file\\test.txt", new String(eletitle.toString()).getBytes());
    }


    public static void main(String[] args) {
//        try {
//            for (int i = 1; i <= 1; i++) {
//                getText(true, true, "https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2019-06-06&leftTicketDTO.from_station=SHH&leftTicketDTO.to_station=NJH&purpose_codes=ADULT");
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        String data = sendHttp();
        JSONObject jsonObject = JSONObject.parseObject(data);
        JSONArray jsonArray = JSONArray.parseArray(JSONObject.parseObject(jsonObject.getString("data")).getString("result"));

        try {
            for (int i = 0, n = jsonArray.size(); i < n; i++) {
                FileUtils.method2("E:\\file\\test.txt", jsonArray.get(i).toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    /**
     * 发起一个http请求
     */
    public static String sendHttp() {
        URL url;
        int responsecode;
        HttpURLConnection urlConnection;
        BufferedReader reader;
        String line;
        try {
            //忽略Ssl(针对12306)
            SslUtils.ignoreSsl();
            //生成一个URL对象
            url = new URL("https://kyfw.12306.cn/otn/leftTicket/query?leftTicketDTO.train_date=2019-06-06&leftTicketDTO.from_station=SHH&leftTicketDTO.to_station=NJH&purpose_codes=ADULT");
            /**
             * 这是为了防止12306对同一ip多次访问进行限制
             * 这里填的ip是暂时有效的，想要获取更多就得自己去找 搜索代理ip
             */
            System.getProperties().setProperty("proxySet", "true");
            System.setProperty("http.proxyHost", "120.78.15.63");
            System.setProperty("http.proxyPort", "80");
            //打开URL
            urlConnection = (HttpURLConnection) url.openConnection();
            //伪造一个请求头 一般网页不用，有些网站会看你有没有请求头，比如 12306......
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:55.0) Gecko/20100101 Firefox/55.0");
            urlConnection.setRequestProperty("Host", "kyfw.12306.cn");
            urlConnection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            urlConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
            urlConnection.setRequestProperty("Accept-Encoding", "identity");
            urlConnection.setRequestProperty("Connection", "keep-alive");
            urlConnection.setRequestProperty("Upgrade-Insecure-Requests", "1");
            //获取服务器响应代码
            responsecode = urlConnection.getResponseCode();
            //假如响应代码为200，就是代表成功
            if (responsecode == 200) {
                reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
                while ((line = reader.readLine()) != null) {
                    //System.out.println(line);//在这里干你想干的事情
                    return line.toString();
                }
            } else {
                System.out.println("获取不到网页的源码，服务器响应代码为：" + responsecode);
            }
        } catch (Exception e) {
            System.out.println("获取不到网页的源码,出现异常：" + e);
        }
        return null;
    }
}
