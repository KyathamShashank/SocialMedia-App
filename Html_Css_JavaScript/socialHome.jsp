<%@page import="java.awt.font.ImageGraphicAttribute"%>
<%@page import="insta.home.UpdateProfileDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.sql.ResultSet, insta.home.ImageDAO"%>
<%@page import="insta.register.InstaRegBean"%>
<%@page import="insta.common.AllDetails"%>
<%@page import="insta.friends.FollowersDAO"%>
<%@page import="insta.friends.FollowingDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
     <style>
        body {
            margin: 0;
            padding: 0;
            background-color: #735DA5;
            color: black;
            font-family: 'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
        }

        a {
            text-decoration: none;
            color: black;
        }

        .s {
            position: fixed;
            height: 10vh;
            width: 43vw;
            margin-left: 30vw;
            z-index: 1;
            background-color: #735DA5;
        }

        .searchBar {
            position: fixed;
            z-index: 1;
        }

        #searchbar {
            position: fixed;
            left: 32vw;
            height: 5vh;
            width: 30vw;
            border: none;
            border-radius: 3px;
            margin-top: 2vh;
        }

        #searchbutton {
            position: fixed;
            left: 63vw;
            height: 5vh;
            width: 9vw;
            border: none;
            border-radius: 3px;
            margin-top: 2vh;
            cursor: pointer;
        }

        #searchedUsers {
            height: 0vh;
            width: 30vw;
            background-color: white;
            margin-top: 8vh;
            border-radius: 5px;
            overflow: hidden;
            position: relative;
            left: 2vw;

        }

        #button1 {
            position: fixed;
            left: 22vw;
            height: 5vh;
            width: 9vw;
            border: none;
            border-radius: 3px;
            margin-top: 2vh;
            background-color: rgb(230, 230, 230);
            cursor: pointer;
        }

        .upload {
            height: 5vh;
            width: 30vw;
            position: fixed;
            left: 73vw;
            margin-top: 2vh;
            cursor: pointer;
        }

        .upload input {
            height: 5vh;
            width: 8vw;
            cursor: pointer;
        }

        #imgcancelbutton {
            position: absolute;
            left: 18vw;
            cursor: pointer;
        }


        .sidebar {
            height: 99vh;
            width: 20vw;
            position: fixed;
            transform: rotateY(90deg);
            border: 2px solid #816ab7;
            border-radius: 5px;
        }

        nav img {
            height: 5vh;
            width: 3vw;
        }

        nav button {
            background-color: #735DA5;
            border: none;
            cursor: pointer;
        }

        .sidebar #profile #profilepic {
            background-image: url(logos/sunny1.jpg);
            height: 130px;
            width: 130px;
            position: relative;
            left: 4vw;
            margin-top: 2vh;
            border: 2px solid black;
            border-radius: 50%;
        }

        .sidebar #profile span {
            position: relative;
            top: 2vh;
            right: -7.2vw;
        }

        #profileOpenButton {
            position: fixed;
            cursor: pointer;
        }

        .sideLinks {
            display: block;
            justify-content: space-evenly;
            align-items: center;
            margin-top: 3.5vh;
        }
        .uploadprofile{
            position: relative;
            top: 4vh;
        }

        .sideLinks img {
            margin: 2vh 1vw;
        }

        .sideLinks span {
            position: relative;
            bottom: 4vh;
        }

        .images {
            height: 70vh;
            width: 30vw;
            border: 2px solid #816ab7;
            position: relative;
            left: 32vw;
            top: 10vh;
            display: flex;
            justify-content: center;
            align-items: center;
            border-radius: 5px;
        }

        .images img {
            height: 60vh;
            width: 28vw;
            border-radius: 3px;
        }

        .sendreq {
            display: inline;
            margin: 2vh 6vw;
        }


        /* follow-division */
        .followersdiv {
            height: 98vh;
            width: 25vw;
            border: 3px solid #816ab7;
            position: fixed;
            right: 0vw;
            top: 12vh;
            border-radius: 5px;
            overflow: hidden;
            transform: rotateY(90deg);
            text-align: center;
        }


        .followersdiv h2 {
            text-decoration-line: underline;
        }



        .followingsdiv {
            height: 98vh;
            width: 25vw;
            border: 3px solid #816ab7;
            position: fixed;
            right: 0vw;
            top: 12vh;
            border-radius: 5px;
            overflow: hidden;
            transform: rotateY(90deg);
            text-align: center;
        }

        .followingsdiv h2 {
            text-decoration-line: underline;
        }

        #followerimg,
        #followingimg {
            margin: 0.5vh 1vw;
        }

        #followerbutton,
        #followingbutton {
            position: relative;
            left: 5vw;
            bottom: 4vh;
            background: none;
            border: none;
            font-size: medium;
        }

        #imguploadbutton,
        #imgcancelbutton {
            border-radius: 3px;
            border: none;
        }

        #profile2{
            border: none;
            background: none;
            height: 3vh;
            width: 8vw;
            border-radius: 5px;
            position: relative;
            bottom: 9vh;
            left: 12.5vw;
            cursor: pointer;
        }
        #profile1{
            position: relative;
            bottom: 5.6vh;
            cursor: pointer;
        }
        #profilepic{
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #pppp{
            height: 100%;
            width: 100%;
            border-radius: 50%;
        }
        
    </style>
    <script src="socialHome.js"></script>
</head>

<body>
    <nav>
        <div class="s">
            <div class="searchBar">
                <form action="search" method="post">
                    <input type="search" name="searchBar" id="searchbar" placeholder="Search Users">
                    <input type="submit" name="" id="searchbutton" value="Search" >
                </form>
                <button onclick="showUsers()" id="button1">ShowUsers</button>
            </div>
            


            <div id="searchedUsers">
               <%  
               ArrayList<String> users= new ArrayList<>();
               users=AllDetails.getUsersList();
             
               for(String u :users)
               {%>
            	   <h4 class="sendreq"> <% out.print(u); %> </h4>
            	   <form action="request" method="post" class="sendreq">
            	   <input type="hidden" value=<%=u%> name="friendname">
                    <input type="submit" name="" id="" value="Follow">
                </form>
              <%}
               %>
            </div>
        </div>
        <div class="upload">
            <form action="uploadimage" method="post" enctype="multipart/form-data">
                <input type="file" id="filebar" name="pic">
                <input type="submit" name="" id="imguploadbutton" value="upload">
                <input type="reset" name="" id="imgcancelbutton" value="Cancel">
            </form>
        </div>
        <div class="sidebar" id="navSidebar">
            <div id="profile">
                <a href=""><div id="profilepic">
                
                  <%
                    String meee=AllDetails.getUserName();
                    ResultSet getProfile=UpdateProfileDAO.getProfile(meee);
                    if(getProfile.next())
                    {%>
                      <img id="pppp" src=<%=getProfile.getString(1) %> >
                    <%}%>
                
                </div><span><%=AllDetails.getUserName() %></span></a>
            </div>
            <div class="sideLinks">
               <div class="uploadprofile">
                    <form action="uploadprofile" method="post" enctype="multipart/form-data"><input type="file" name="profilepic" id="profile1"><input type="submit"
                            value="UpdateProfile" id="profile2"></form>
                </div>
                 <div class="message">
                    <a href="messages.jsp"><img src="icons8-message-50.png" alt=""><span>Messages</span></a>
                </div>
               <div><button onclick="followers()"><img src="icons8-community-50.png"
                            alt="" id="followerimg"></button><form action="getfollowers" method="post"><input type="submit" name="" id="followerbutton" value="Followers"></form></div>
                <div><button onclick="following()"><img src="icons8-friends-50.png"
                            alt="" id="followingimg"></button><form action="getfollowing" method="post"><input type="submit" name="" id="followingbutton" value="Following"></form></div>
                <div><a href=""><img src="icons8-settings-50.png" alt=""></a><span>Settings</span></div>
                <div><a href="#searchbar"><img src="icons8-search-30.png" alt=""></a><span>Search</span></div>
                <div><a href="delete.html"><img src="icons8-delete-100.png" alt=""></a><span>Delete Account</span></div>
                <div><a href="login.html"><img src="icons8-logout-32.png" alt=""></a><span>Logout</span></div>
            </div>
        </div>
        <button onmouseover="openSidebar()"><img src="icons8-bars-50.png" alt="" id="profileOpenButton"></button>
    </nav>

<%!String path;%>

 <%
  InstaRegBean b= InstaRegBean.getBean();
  String userName= b.getUserName();
  ResultSet imgs=ImageDAO.getImages(userName);
  
  while(imgs.next())
  {
     path=imgs.getString("imgname");%>
     
     <div class="r1" >
    <div class="images"> <img alt="" src= <%=path %> > </div>
    </div>
 <% } %>
 
      <div class="followersdiv" id="followers">
        <h2>Followers</h2>
         
         <%
          String user=AllDetails.getUserName();
          ResultSet followers=FollowersDAO.getFollowers(user);
          while(followers.next())
          {%>
            <p><%=followers.getString(1)%></p>
         <%}
        %>
               
    </div>

    <div class="followingsdiv" id="following">
        <h2>Following</h2>
        <%
          String me=AllDetails.getUserName();
          ResultSet following=FollowingDAO.getFollowing(me);
          while(following.next())
          {%>
        	<p><%=following.getString(1)%></p>
         <%}
        %>
        
    </div>


 
	  
 
  
  <script type="text/javascript">
  function openSidebar() {
	    var sideBar = document.getElementById('navSidebar');
	    var sideBarButton = document.getElementById('profileOpenButton');
	    sideBar.style.transitionDuration = "0.6s";
	    sideBarButton.style.transitionDuration = "0.6s";
	    sideBar.style.transformOrigin = "left";
	    if (sideBar.style.transform == "rotateY(90deg)") {
	        sideBar.style.transform = 'rotateY(0deg)';
	        sideBarButton.style.left = "16vw";
	        
	    }
	    else {
	        sideBar.style.transform = 'rotateY(90deg)';
	        sideBarButton.style.left = "0vw";
	        
	    }
	}

	function showUsers()
	{
	var searchUsersWindow= document.getElementById('searchedUsers').style;
	searchUsersWindow.transitionDuration="0.5s";
	searchUsersWindow.transformOrigin="top";
	if(searchUsersWindow.height=="0vh")
	    {
	        searchUsersWindow.height="50vh";
	    }
	    else{
	        searchUsersWindow.height="0vh";
	    }
	}
	
	
	function followers()
	{
	    var followersdiv=document.getElementById('followers');

	    var followingdiv=document.getElementById('following');

	    followersdiv.style.transformOrigin="right";
	    followersdiv.style.transitionDuration="0.5s";
	    if(followersdiv.style.transform=="rotateY(90deg)")
	    {
	     followersdiv.style.transform="rotateY(0deg)";
	     followingdiv.style.transform="rotateY(90deg)";
	   }
	    else{
	        followersdiv.style.transform="rotateY(90deg)";
	    }
	    
	}

	function following()
	{
	    var followingdiv=document.getElementById('following');

	    var followersdiv=document.getElementById('followers');

	    followingdiv.style.transformOrigin="right";
	    followingdiv.style.transitionDuration="0.5s";
	    if(followingdiv.style.transform=="rotateY(90deg)")
	    {
	        followingdiv.style.transform="rotateY(0deg)";
	        followersdiv.style.transform="rotateY(90deg)";
	   }
	    else{
	        followingdiv.style.transform="rotateY(90deg)";
	    }
	    
	}
  </script>
 


    
</body>

</html>