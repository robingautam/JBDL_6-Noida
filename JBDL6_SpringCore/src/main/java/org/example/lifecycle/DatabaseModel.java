package org.example.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class DatabaseModel implements InitializingBean, DisposableBean {

    String url;
    String username;
    String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        System.out.println("Setting thje password");
        this.password = password;
    }

   /* public void initMethod(){
        System.out.println("Initualizing the database code");
    }

    public void destroyDBConnection(){
        System.out.println("Destroying the database connection");
    }*/
    @Override
    public String toString() {
        return "DatabaseModel{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("inside the creation of db connection");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destryong the db connection");
    }
}
