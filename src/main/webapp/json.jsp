<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-07-09
  Time: 08:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
<%--    <script type="text/javascript">--%>
<%--        $(function(){--%>
<%--            alert(123);--%>
<%--        })--%>
<%--    </script>--%>

    <script type="text/javascript">
        $(function () {
            var user = {
                "id":1,
                "name":"张三"
            };

            $.ajax({
                url:"/data/json",
                data:JSON.stringify(user),
                type:"POST",
                contentType:"application/json;charset=UTF-8",
                dataType:"JSON", //返回数据
                success:function(data){
                    alert(data.id + " --- " + data.name);
                }
            })
        });
    </script>

</head>
<body>

</body>
</html>
