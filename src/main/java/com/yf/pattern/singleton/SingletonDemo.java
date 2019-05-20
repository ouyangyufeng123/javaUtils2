package com.yf.pattern.singleton;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/25
 */
public enum SingletonDemo {

    ADMIN("admin","123456");

    String username;

    String password;

    private SingletonDemo(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login(String username, String password){
        if(this.username.equals(username) && this.password.equals(password)){
            System.out.println("登陆成功!");
        }else {
            System.out.println("用户名或者密码错误!");
        }
    }

}
