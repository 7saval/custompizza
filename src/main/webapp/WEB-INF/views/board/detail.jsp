<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ include file="../include/include.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>������ȸȭ��</title>
</head>
<body>


	<%@ include file="../header.jsp" %>
	<h2>��ۻ���ȸ</h2>
	<%-- ${board} --%>
	<%-- ${bflist} --%>
	<table border="1">
		<tr>
			<th>NO</th>
			<td id="bnum">${board.bnum}</td>
		</tr>
		<tr>
			<th>�ۼ���</th>
			<td>${board.email}</td>
		</tr>
		<tr>
			<th>����</th>
			<td>${board.subject}</td>
		</tr>
		
		
		<tr>
			<th>�������</th>
			<td><fmt:formatDate value="${board.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
		</tr>
		
		<tr>
			<th>��ȸ��</th>
			<td>${board.readcnt}</td>
		</tr>
		<tr>
			<!-- ���ƿ� -->
			<th><i class="fas fa-thumbs-up" id="like"></i></th>
			<td id="likecnt">${board.likecnt}</td>
		</tr>	
		<tr>
			<!-- �Ⱦ�� -->
			<th><i class="fas fa-thumbs-down" id="dislike"></i></th>
			<td id="dislikecnt">${board.dislikecnt}</td>
		</tr>
		
		
		<tr>
			<td colspan="2">
				<button onclick="location.href='${path}/board/modify?bnum=${board.bnum}'">�����ϱ�</button>
				<button id="replyAddShow">���</button>
				<button onclick="removeCheck('${path}', ${board.bnum})">�����ϱ�</button>
				<button onclick="location.href='${path}/board/list'">����Ʈ</button>
			</td>
		</tr>
	</table>
	<hr id="hr">
	
	
	
	<!-- ����߰� -->
	
	
	<!-- �ϴ��ּ�ó�� @@@@@@@@@@@@@����?? -->
	<%-- <div class="card mb-2" id="divReplyAdd">
		<div class="card-header bg-light">
		        <i class="fa fa-comment fa"></i> REPLY �߰�
		        <input type="hidden" id="restep" size="3">
		        <input type="hidden" id="relevel" size="3">
		</div>
		<div class="card-body">
			<ul class="list-group list-group-flush">
			    <li class="list-group-item">
				<div class="form-inline mb-2">
					<label for="replyemail"><i class="fas fa-envelope"></i></label>
					<input type="email" class="form-control ml-2" id="replyemail" value="${sessionScope.email}" readonly>
				</div>
				<textarea class="form-control" id="replycontent" rows="3"></textarea>
				<button type="button" class="btn btn-dark mt-3" id="replyAdd">�߰�</button>
				<button type="button" class="btn btn-dark mt-3" id="replyCancel">���</button>
			    </li>
			</ul>
		</div>
	</div>	
	
	<!-- ��ۼ��� -->
	
	<div class="card mb-2" id="divReplyModify">
		<div class="card-header bg-light">
			<i class="fa fa-comment fa"></i> REPLY ����
			<input type="hidden" id="replyrnumModify">
		</div>
		<div class="card-body">
			<ul class="list-group list-group-flush">
			    <li class="list-group-item">
				<textarea class="form-control" id="replycontentModify" rows="3"></textarea>
				<button type="button" class="btn btn-dark mt-3" id="replyModify">����</button>
				<button type="button" class="btn btn-dark mt-3" id="replyModifyCancel">���</button>
			    </li>
			</ul>
		</div>
	</div>

	
	
	<!-- ��۸���Ʈ -->
	<div id="divReplyList"></div>
</div>	 --%>

</body>
</html>