//输入框获得焦点时，显示提示内容
function showDesc(id)
{  	
	var obj = document.getElementById(id);
	obj.style.display ="inline";
}
//输入框失去焦点时检验输入内容是否有效
function checkUsername()
{
    //只简单的判断用户名的长度
    var user = document.getElementById("user_id");
    var obj = document.getElementById("clue_user");
    var username=user.value;
    var patrn = /^[a-zA-Z0-9_]{5,15}$/;
    if(username.length==0)
    {
    	obj.style.display="none";
    	return false;
    }
    else if(!patrn.test(username))//
    {
    	obj.style.color = "red";
      	return false;
    }
    else
    {
    	obj.style.color="#008400";	
    	obj.style.display="none";
    	return true;
    }
}
function checkNickname(){
	var nickname = document.getElementById("nick").value;
	var obj = document.getElementById("clue_nick_name");
	var patrn = /^[\\u4e00-\\u9fa5_a-zA-Z0-9\W]{1,18}$/;
	//!patrn.exec(NickName)
	if(nickname.length==0)
	{
		obj.style.display="none";
		return false;
	}
	else if (!patrn.test(nickname)) 
	{	
		obj.style.color="red";
		return false;
	}
	else
	{
		obj.style.color="#008400";
		obj.style.display="none";
		return true;
	}
}
function checkPassword()
{
	var passwd = document.getElementById("password").value;
	var obj = document.getElementById("clue_password");
	var patrn = /^[a-zA-Z0-9_]{6,20}$/;
	if(passwd.length==0)
	{
		obj.style.display="none";
		return false;
	}
	else if (!patrn.test(passwd))
	{	
		obj.style.color="red";
		return false;
	}
	else
	{
		obj.style.color="#008400";
		obj.style.display="none";
		return true;
	}
}
function checkPassword2()
{
     var id=document.getElementById("password");
     var id2=document.getElementById("rptPassword");
     var obj = document.getElementById("clue_rptpassword");
     var password1 = id.value;    
     var password2 = id2.value;
     if(password1!=password2)
     {
        obj.innerHTML="Your confirmed password and new password do not match.";
        obj.style.color="red";
        return false;
     }
     else
     {
     	obj.innerHTML="6 - 16 letters and digits allowed";
     	obj.style.color="#008400";
     	obj.style.display="none";
     	return true;
     }
         
}
function checkSchool(){
	var id =  document.getElementById("school")
   	var Email = id.value;
   	var obj = document.getElementById("clue_school");
	obj.style.display="none";
	return true;
}

function checkEmail()
{
// 利用正则表达式对输入数据匹配
   var id =  document.getElementById("email")
   var Email = id.value;
   var obj = document.getElementById("clue_email");
   var patrn = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
//以字母或数字开头，跟上@,字母数字以.com结尾
    if(Email.length==0)
	{
		obj.style.display="none";
		return true;
	}
	else if (!patrn.exec(Email)) 
	{	
		obj.style.color="red";
		return false;
	}
	else
	{
		obj.style.color="#008400";
		obj.style.display="none";
		return true;
	}
}