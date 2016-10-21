@charset "UTF-8";
// JavaScript Document// form.js
// 提交之前检查邮箱地址是否为空
function checkField() {
	document.getElementById("frmPerson").onsubmit = function() {
        
		// 如果邮箱地址为空
		if (document.getElementById("email").value == "") {
			document.getElementById("errorMessage").innerHTML = "邮箱地址不能为空！";
			return false; //阻止表单数据提交
		} else {
			// 允许表单数据被提交到服务器   
			document.getElementById("errorMessage").innerHTML = "";
			return true; //允许表单数据提交
		}
	};
}
//显示或隐藏爱好特长调查表
function displayFavor() {
	document.getElementById("yourFavor").onclick=function() {
	if (document.getElementById("yourFavor").checked) {
		document.getElementById("personFavor").style.display="block";
	} else {
		document.getElementById("personFavor").style.display="none";
		}
	}
	//页面初始化时不显示
	document.getElementById("yourFavor").checked=false;
	document.getElementById("personFavor").style.display="none";
}

//判断输入的EMAIL格式是否正确    
function IsEmail()     
{   
    document.getElementById('email').onblur=function() {
       var str = document.getElementById('email').value.trim();    
       if(str.length!=0){    
        reg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;    
        if(!reg.test(str)){    
            alert("对不起，您输入的邮箱格式不正确!");
        } //end if   
       }  //end if  
    };   
}     
// 当页面加载完成后
window.onload =  function() {
    checkPhone();
	displayFavor();
	checkField(); 
    IsEmail();
};