package Login.servlet;

public class User {
	private String CusName;
    private String CusPass;

    public User(String CusName, String CusPass) {
        this.CusName = CusName;
        this.CusPass = CusPass;
    }

    public String getUsername() {
        return CusName;
    }

    public String getPassword() {
        return CusPass;
    }
}
