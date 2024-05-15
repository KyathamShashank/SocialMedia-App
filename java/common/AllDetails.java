package insta.common;

import java.util.ArrayList;

public class AllDetails {
 private static ArrayList<String> usersList= new ArrayList<>();
 private static String userName;
 private static String password;
 
 private static String friendName;
 
 
 
 

 
 
 



public static String getFriendName() {
	return friendName;
}

public static void setFriendName(String friendName) {
	AllDetails.friendName = friendName;
}

public static String getUserName() {
	return userName;
}

public static void setUserName(String userName) {
	AllDetails.userName = userName;
}

public static String getPassword() {
	return password;
}

public static void setPassword(String password) {
	AllDetails.password = password;
}

public static ArrayList<String> getUsersList() {
	return usersList;
}

public static void setUsersList(ArrayList<String> usersList) {
	AllDetails.usersList = usersList;
}

static {
	usersList.add("");
}

 

 
}
