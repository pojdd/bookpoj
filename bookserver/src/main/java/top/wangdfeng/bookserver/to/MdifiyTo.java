package top.wangdfeng.bookserver.to;

public class MdifiyTo {
    private String account;
    private String email;
    private String password;

    @Override
    public String toString() {
        return "MdifiyTo{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public MdifiyTo() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MdifiyTo(String account, String email, String password) {
        this.account = account;
        this.email = email;
        this.password = password;
    }
}
