function openMessageBox()
{
    var msgbox1=document.getElementById("msgbox1").style;
    var msgbox2=document.getElementById("msgbox2").style;
    msgbox1.transitionDuration="0.5s";
    msgbox1.transformOrigin="top";
    if( msgbox1.transform=="rotateX(90deg)")
        {
            msgbox1.transform="rotateX(0deg)";
            msgbox2.transform="rotateX(90deg)";
        }
        else{
            msgbox1.transform="rotateX(90deg)";
        }
}

function sendMessageBox()
{
    var msgbox2=document.getElementById("msgbox2").style;
    var msgbox1=document.getElementById("msgbox1").style;
    msgbox2.transitionDuration="0.5s";
    msgbox2.transformOrigin="top";
    if( msgbox2.transform=="rotateX(90deg)")
        {
            msgbox2.transform="rotateX(0deg)";
            msgbox1.transform="rotateX(90deg)";
        }
        else{
            msgbox2.transform="rotateX(90deg)";
        } 
}