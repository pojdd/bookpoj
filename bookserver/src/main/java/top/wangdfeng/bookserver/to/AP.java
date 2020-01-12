package top.wangdfeng.bookserver.to;

public class AP {
    private String account;
    private String password;

    public AP(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public AP() {
    }

    @Override
    public String toString() {
        return "AP{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
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
}
