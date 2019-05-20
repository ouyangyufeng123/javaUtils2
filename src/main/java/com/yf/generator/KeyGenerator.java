package com.yf.generator;

import org.apache.commons.lang.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author ouyangyufeng
 * @date 2019/4/3
 */
public class KeyGenerator extends JFrame {

    public KeyGenerator() {
        setUIFont();
        this.setTitle("签名密钥生成器");
        Container con = this.getContentPane();
        con.setLayout(new FlowLayout());
        /**
         * 定义组件
         */
        JLabel label = new JLabel("                                                                                                                                        签名密钥生成器                                                                                                                                        ");
        JLabel labelUrl = new JLabel("url：");
        JLabel labelKey = new JLabel("key：");
        JLabel labelCode = new JLabel("enterpriseCode：");
        JLabel labelData = new JLabel("encryptedData：");
        JTextField textUrl = new JTextField(20);
        JTextField textKey = new JTextField(20);
        JTextField textCode = new JTextField(20);
        JTextField textData = new JTextField(20);
        JButton clear = new JButton("清除");
        JButton generate = new JButton("生成签名");
        JTextArea area = new JTextArea(10, 30);

        /**
         * 添加组件
         */
        con.add(BorderLayout.NORTH, label);
        con.add(BorderLayout.CENTER, labelUrl);
        con.add(textUrl);
        con.add(BorderLayout.CENTER, labelKey);
        con.add(textKey);
        con.add(BorderLayout.CENTER, labelCode);
        con.add(textCode);
        con.add(BorderLayout.CENTER, labelData);
        con.add(textData);
        con.add(clear);
        con.add(generate);
        con.add(area);

        /**
         * 清除输入框
         */
        clear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                textUrl.setText("");
                textKey.setText("");
                textCode.setText("");
                textData.setText("");
                textUrl.requestFocus();
                area.setText("");
            }

        });

        /**
         * 生成签名密钥
         */
        generate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String sign = null;
                String url = textUrl.getText();
                String key = textKey.getText();
                String enterpriseCode = textCode.getText();
                String encryptedData = textData.getText();
                HashMap params = new HashMap();
                params.put("key", key);
                params.put("enterpriseCode", enterpriseCode);
                if(StringUtils.isNotBlank(encryptedData)){
                    params.put("encryptedData", encryptedData);
                }
                try {
                    //调用签名
                    sign = generate(url, params, "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAgmZzTy2Bb");
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                area.setText(sign);
            }

        });

        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new KeyGenerator();
    }


    /**
     * 签名验证计算规则
     * @param urlResourcePart：URL资源地址
     * @param params：请求参数
     * @param secretKey：签名计算配置秘钥securetKey
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static String generate(String urlResourcePart, Map<String, String> params, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        LinkedList parameters = new LinkedList(params.entrySet());
        Collections.sort(parameters, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Map.Entry<String, String> map1 = (Map.Entry<String, String>)o1;
                Map.Entry<String, String> map2 = (Map.Entry<String, String>)o2;
                return ((String)map1.getKey()).compareTo((String)map2.getKey());
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append(urlResourcePart).append("_");
        Iterator baseString = parameters.iterator();

        while(baseString.hasNext()) {
            Map.Entry param = (Map.Entry)baseString.next();
            sb.append((String)param.getKey()).append("=").append((String)param.getValue()).append("_");
        }
        sb.append(secretKey);
        String baseString1 = URLEncoder.encode(sb.toString(), "UTF-8");
        return md5(baseString1);
    }


    /**
     * md5加密
     * @param s
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static final String md5(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        byte[] inputBytes = s.getBytes("UTF-8");
        MessageDigest mdInst = MessageDigest.getInstance("md5");
        mdInst.update(inputBytes);
        byte[] md = mdInst.digest();
        int j = md.length;
        char[] str = new char[j * 2];
        int k = 0;

        for(int i = 0; i < j; ++i) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 15];
            str[k++] = hexDigits[byte0 & 15];
        }

        return new String(str);
    }


    public static void setUIFont()
    {
        Font f = new Font("宋体",Font.PLAIN,18);
        String   names[]={ "Label", "CheckBox", "PopupMenu","MenuItem", "CheckBoxMenuItem",
                "JRadioButtonMenuItem","ComboBox", "Button", "Tree", "ScrollPane",
                "TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
                "OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
                "ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
                "PasswordField","TextField", "Table", "Label", "Viewport",
                "RadioButtonMenuItem","RadioButton", "DesktopPane", "InternalFrame"
        };
        for (String item : names) {
            UIManager.put(item+ ".font",f);
        }
    }
}
