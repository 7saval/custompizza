<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ include file="../include/include.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����ȭ��</title>
</head>
<body>

<%@ include file="../header.jsp" %>


	<h2>����</h2>
<%-- 	${board}
	${bflist} --%>
	<form action="${path}/board/modify" method="post" enctype="multipart/form-data">
		<table border="1">
					<tr>
				<th>�̸���</th>
				<td><input type="text" name="email" value="${sessionScope.email}" readonly> </td>
			</tr>
			<tr>
				<th>����</th>
				<td><input type="text" name="subject"> </td>
			</tr>
			
			<tr>
				<th>���� <br><button onclick="fileAdd(event)">+</button></th>
				<td>
					<div id="divFiles">
						<input type="file" name="files"> <br>
					</div>
					
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>����</button>
					<button>���</button>
				</td>
			</tr>
			
			
		</table>
	
	</form>



</body>
</html>