package com.mybook.user.bean;
public class Myuser {
    private int id;
    private String username;
    private String password;
    private int identity;
    public Myuser() {
    }
    public Myuser(int id, String username, String password, int identity) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.identity = identity;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public int getIdentity() {
        return identity;
    }
    public void setIdentity(int identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Myuser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", identity=" + identity +
                '}';
    }
}
