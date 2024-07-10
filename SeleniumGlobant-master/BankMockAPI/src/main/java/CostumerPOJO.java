public class CostumerPOJO {
    public String email;
    public String password;
    public String username;
    public double accountBalance;

    public CostumerPOJO() {
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public CostumerPOJO(String username, String password, String email, double accountBalance) {
        this.email = email+"@email.com";
        this.password = password;
        this.username = username;
        this.accountBalance = accountBalance;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public double getAccountBalance() {
        return accountBalance;
    }
}
