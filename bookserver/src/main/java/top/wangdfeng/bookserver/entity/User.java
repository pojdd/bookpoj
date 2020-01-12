package top.wangdfeng.bookserver.entity;

public class User {
    private int userid;
    private String account;
    private String password;
    private String email;
    private String recentime;
    private int sumreadtime;

    public User(int userid, String account, String password, String email, String recentime, int sumreadtime) {
        this.userid = userid;
        this.account = account;
        this.password = password;
        this.email = email;
        this.recentime = recentime;
        this.sumreadtime = sumreadtime;
    }

    public String getRecentime() {
        return recentime;
    }

    public void setRecentime(String recentime) {
        this.recentime = recentime;
    }

    public int getSumreadtime() {
        return sumreadtime;
    }

    public void setSumreadtime(int sumreadtime) {
        this.sumreadtime = sumreadtime;
    }

    public User() {
    }

    public User(int userid, String account, String password, String email) {
        this.userid = userid;
        this.account = account;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
