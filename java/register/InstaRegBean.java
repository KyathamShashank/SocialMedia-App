package insta.register;

public class InstaRegBean {
static InstaRegBean b = new InstaRegBean();

private String userName;
private String password;
private String mailId;
private int number;

private InstaRegBean() {}
public static InstaRegBean getBean()
{
	return b;
}



public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}



}
