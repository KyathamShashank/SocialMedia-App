<%@page import="insta.message.MessageDAO"%>
<%@page import="insta.common.AllDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="insta.friends.FollowingDAO"%>
<%@page import="java.awt.font.ImageGraphicAttribute"%>
<%@page import="insta.home.UpdateProfileDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.sql.ResultSet, insta.home.ImageDAO"%>
<%@page import="insta.register.InstaRegBean"%>
<%@page import="insta.common.AllDetails"%>
<%@page import="insta.friends.FollowersDAO"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
 <style>
        * {
            margin: 0;
            padding: 0;
        }

        .main {
            height: 100vh;
            border-radius: 3px;
            border: 3px solid #D3C5E5;
            background-color: #735DA5;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        }

        .messages {
            height: 80vh;
            width: 55vw;
            border-radius: 3px;
            border: 2px solid #D3C5E5;
            margin-right: 25vw;
        }

        .head {
            border: 2px solid #D3C5E5;
            width: 98%;
            height: 9vh;
            margin: 1vh;
            border-radius: 3px;
        }

        /* .head img{
            position: relative;
            left: 48vw;
            top: -4vh;
        } */
        .head h2 {
            position: relative;
            left: 3vw;
            top: 2vh;
        }

        .messages button {
            height: 7vh;
            width: 98%;
            border: 1px solid black;
            margin: 1vh;
            border-radius: 1px;
            cursor: pointer;
        }


        .main #msgbox2 {
             border: 1px solid #D3C5E5;
            position: absolute;
            right: 5vw;
            height: 80vh;
            border-radius: 3px;
            width: 25vw;
            display: flex;
            justify-content: center;
            align-items: center;
            transform: rotateX(90deg);
        }

        .main #msgbox1 {
             border: 1px solid #D3C5E5;
            position: absolute;
            right: 5vw;
            height: 80vh;
            border-radius: 3px;
            width: 25vw;
            transform: rotateX(90deg);
            text-align: center;
        }
        .main #msgbox1 p{
            display: block;
            border-radius: 2px;
            border: 1px solid #D3C5E5;
        }



        .head #msgbutton {
            height: 0;
            width: 0;
            position: absolute;
            left: 58vw;
            top: 11vh;
        }

        #textarea1 {
            height: 30vh;
            width: 20vw;
            border-radius: 3px;
            background-color: white;
            border: none;
            resize: none;
        }

        #msgsendbutton {
            height: 6vh;
            width: 10vw;
            border: none;
            background-color: #735DA5;
            color: white;
            border-radius: 3px;
            margin-left: 5vw;
            margin-top: 1vh;
            font-size: large;
            cursor: pointer;
        }

        #friendnamebox {
            height: 6vh;
            width: 12vw;
            border: none;
            border-radius: 3px;
            margin-left: 4vw;
            margin-top: 1vh;
            font-size: large;
        }

        .main .chats {
            width: 52vw;
            height: 65vh;
            position: absolute;
            right: 36.5vw;
            top: 23vh;
            border: 2px solid #D3C5E5;
            border-radius: 4px;
            text-align: center;
        }

        .main .chats .ffff{
            height: 5vh;
            width: 45vw;
            margin: 1vh;
            margin-right: 6vw;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        
        }

        .main .chats button{
            height:5vh ;
            margin-top: 1vh;
            width: 5vw;
            position: relative;
            left: 23vw;
            bottom: 7vh;
            border: none;
            border-radius: 3px ;
            cursor: pointer;
        }
    </style>

</head>

<body>
    <div class="main">
        <div class="messages">
            <nav class="head">
                <h2><%=AllDetails.getUserName() %></h2><button id="msgbutton" onclick="sendMessageBox()"><img src="icons8-message-50.png"
                        alt=""></button>
            </nav>
        </div>

        <div class="chats">
            
            <%!String user1=AllDetails.getUserName();

               ResultSet following;
            %>
            
            <%
            following = FollowingDAO.getFollowing(user1);
              while(following.next())
              {
            	  String f=following.getString(1);
              %>
            	  
            <form  action="getMessages" method="post">
                <input type="hidden" name="friendname" id="" value=<%=f%>>
                <input type="submit" name="" class="ffff" value=<%=f%>>
            </form>
            <button  onclick="openMessageBox()">Open</button>
             <%}
            %>
        </div>

        <div id="msgbox1">
            
           <% String user=AllDetails.getUserName();
	String fr=AllDetails.getFriendName();
	
	
	
	ResultSet rs = MessageDAO.getMessages(user,fr);
	try {
		while(rs.next())
		{%>
		  <p><%= rs.getString("message") %></p><br>
		<%}
	} catch (Exception e) {e.printStackTrace();}%>
            
        </div>



        <div class="msgbox" id="msgbox2">
            <form action="sendmsg" method="post">
                <textarea name="message" id="textarea1" required></textarea><br>
                <input type="text" name="friendname" id="friendnamebox" required placeholder="Enter Friend Name"><br>
                <input type="submit" name="" id="msgsendbutton" value="Send">
            </form>
        </div>

    </div>
    
    
    
    
    
    
    <script type="text/javascript">
    function openMessageBox()
    {
        var msg1 = document.getElementById('msgbox1');
        var msg2 = document.getElementById('msgbox2');
        msg1.style.transitionDuration="0.5s";
        msg1.style.transformOrigin="bottom";
        if(msg1.style.transform=="rotateX(90deg)")
            {
                msg1.style.transform="rotateX(0deg)";
                msg2.style.transform="rotateX(90deg)";
            }
            else{
                msg1.style.transform="rotateX(90deg)";
            }
    }

    function sendMessageBox()
    {
        var msg2 = document.getElementById('msgbox2');
        var msg1 = document.getElementById('msgbox1');
        msg2.style.transitionDuration="0.5s";
        msg2.style.transformOrigin="top";
        if(msg2.style.transform=="rotateX(90deg)")
            {
                msg2.style.transform="rotateX(0deg)";
                msg1.style.transform="rotateX(90deg)";
            }
            else{
                msg2.style.transform="rotateX(90deg)";
            }
    }
    </script>
    
    
    
</body>

</html>