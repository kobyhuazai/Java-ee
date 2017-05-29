<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加英雄信息</title>  

<script type="text/javascript">  
    function check(form) {  
        with (form) {  
            if (name.value == "") {  
                alert("姓名不能为空");  
                return false;  
            }  
  
            if (hp.value == "") {  
                alert("血量不能为空");  
                return false;  
            }  
  
            if (damage.value == "") {  
                alert("伤害不能为空");  
                return false;  
            }  
  
        }  
    }  
</script>          
</head>
<body>


<form action="HeroServlet" method="post" onsubmit="check(this)">  
    <input type="hidden" name="method" value="add">
    <table align="center" width="450">  
        <tr>  
            <td align="center" colspan="2">  
                <h2>添加英雄信息</h2>  
                <hr>  
            </td>  
        </tr>  
  
        <tr>  
            <td align="right">名字：</td>  
            <td><input type="text" name="name"></td>  
        </tr>  
  
        <tr>  
            <td align="right">血量：</td>  
            <td><input type="text" name="hp"></td>  
        </tr>  
  
        <tr>  
            <td align="right">伤害： </td>  
            <td><input type="text" name="damage" /></td>  
        </tr>  
            <td align="center" colspan="2">
            <input type="submit" value="添　加">  
            </td>  
        
    </table>  
</form>  


</body>
</html>