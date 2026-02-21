<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="jakarta.servlet.RequestDispatcher"%>
<%@page import="com.royal.bean.UserBean"%>
<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Records</title>

<style>

/* ===== GLOBAL ===== */
body {
	margin: 0;
	font-family: Inter, Segoe UI, Arial;
	background: #f5f7fb;
	color: #111827;
}

/* ===== TOPBAR ===== */
.topbar {
	background: white;
	height: 70px;
	padding: 0 40px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.04);
	position: sticky;
	top: 0;
	z-index: 999;
}

.brand {
	font-size: 18px;
	font-weight: 600;
}

.logout-btn {
	background: #f3f4f6;
	border: none;
	padding: 10px 18px;
	border-radius: 10px;
	cursor: pointer;
}

.logout-btn:hover {
	background: #ef4444;
	color: white;
}

/* ===== LAYOUT ===== */
.container {
	width: 92%;
	margin: 40px auto;
}

.card {
	background: white;
	border-radius: 16px;
	padding: 30px;
	box-shadow: 0 20px 40px rgba(0, 0, 0, 0.05);
}

/* ===== HEADER ===== */
.header-flex {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 25px;
}

.search-box {
	padding: 12px 16px;
	border-radius: 12px;
	border: 1px solid #e5e7eb;
	width: 260px;
	font-size: 14px;
}

/* ===== TABLE ===== */
table {
	width: 100%;
	border-collapse: collapse;
}

thead {
	background: #f9fafb;
	position: sticky;
	top: 70px;
}

th {
	text-align: left;
	padding: 16px;
	font-size: 12px;
	text-transform: uppercase;
	color: #6b7280;
}

td {
	padding: 16px;
	border-bottom: 1px solid #f3f4f6;
}

tbody tr {
	transition: 0.2s;
}

tbody tr:hover {
	background: #f8fbff;
}

/* ===== ACTION BUTTONS ===== */
.action-btn {
	padding: 8px 14px;
	border-radius: 8px;
	text-decoration: none;
	font-size: 13px;
}

.edit-btn {
	background: #e6f4ea;
	color: #15803d;
}

.delete-btn {
	background: #fee2e2;
	color: #b91c1c;
}

/* ===== PAGINATION ===== */
.pagination {
	text-align: center;
	margin-top: 30px;
}

.pagination a {
	padding: 10px 14px;
	border-radius: 10px;
	margin: 4px;
	text-decoration: none;
	background: #f3f4f6;
}

.pagination a:hover {
	background: #2563eb;
	color: white;
}

.pagination .active {
	background: #2563eb;
	color: white;
}

/* ===== FLOATING ADD BUTTON ===== */
.fab {
	position: fixed;
	right: 30px;
	bottom: 30px;
	background: #2563eb;
	color: white;
	width: 55px;
	height: 55px;
	border-radius: 50%;
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 28px;
	text-decoration: none;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.15);
}
</style>
</head>

<body>

<%
	UserBean userBean = (UserBean)session.getAttribute("userBean");

	RequestDispatcher rd = null;
	
	if(userBean == null)
	{
		request.setAttribute("logoutErr", "<font color='red'>Invalid User,Login First</font>");
		rd= request.getRequestDispatcher("login.jsp");
		
		rd.forward(request,response);
		
		return ;	
	}
%>

	Welcome, ${sessionScope.userBean.name}



	<a href="LogoutServlet">Logout</a>

	<!-- ===== TOPBAR ===== -->

	<div class="topbar">
		<div class="brand">Student Management System | Admin Panel</div>

		<form action="LogoutServlet" method="post">
			<button class="logout-btn"
				onclick="return confirm('Are you sure you want to logout?');">
				Logout</button>
		</form>
	</div>

	<!-- ===== MAIN CONTAINER ===== -->

	<div class="container">

		<div class="card">

			<!-- HEADER TOOLBAR -->

			<div class="header-flex">

				<h3>Student Records</h3>

				<div style="display: flex; gap: 10px;">

					<button form="multiDeleteForm" type="submit"
						style="background: #dc2626; color: white; border: none; padding: 10px 16px; border-radius: 8px; cursor: pointer;">
						Delete Selected</button>

					<input type="text" id="searchInput" placeholder="Search..."
						class="search-box">
				</div>

			</div>

			${deleteSuccess} ${deleteDbError}

			<%
			ArrayList<StudentBean> list = (ArrayList<StudentBean>) request.getAttribute("list");

			int currentPage = (request.getAttribute("currentPage") != null) ? (Integer) request.getAttribute("currentPage") : 1;

			int totalPages = (request.getAttribute("totalPages") != null) ? (Integer) request.getAttribute("totalPages") : 1;
			%>

			<!-- MULTI DELETE FORM -->

			<form id="multiDeleteForm" action="DeleteMultipleStudentServlet"
				method="post" onsubmit="return confirmDeleteMultiple();">

				<table>

					<thead>
						<tr>
							<th><input type="checkbox" id="selectAll"></th>
							<th>ID</th>
							<th>Full Name</th>
							<th>Age</th>
							<th>Course</th>
							<th>Gender</th>
							<th>Hobbies</th>
							<th>DOB</th>
							<th>Email</th>
							<th>Mobile</th>
							<th>Address</th>
							<th>Action</th>
						</tr>
					</thead>

					<tbody>

						<%
						if (list != null && !list.isEmpty()) {
							for (StudentBean s : list) {
						%>

						<tr>

							<td><input type="checkbox" name="studentIds"
								value="<%=s.getId()%>" class="rowCheckbox"></td>

							<td><%=s.getId()%></td>
							<td><%=s.getFullname()%></td>
							<td><%=s.getAge()%></td>
							<td><%=s.getCourse()%></td>
							<td><%=s.getGender()%></td>
							<td><%=s.getHobbiesStr()%></td>
							<td><%=s.getDob()%></td>
							<td><%=s.getEmail()%></td>
							<td><%=s.getMobile()%></td>
							<td><%=s.getAddress()%></td>

							<td><a href="EditStudentServlet?id=<%=s.getId()%>"
								class="action-btn edit-btn">Edit</a> <a
								href="DeleteStudentServlet?id=<%=s.getId()%>"
								class="action-btn delete-btn"
								onclick="return confirm('Delete this record?');"> Delete </a></td>

						</tr>

						<%
						}
						} else {
						%>

						<tr>
							<td colspan="12">No Student Records Found</td>
						</tr>

						<%
						}
						%>

					</tbody>

				</table>

			</form>

			<!-- PAGINATION -->

			<div class="pagination">

				<%
				if (currentPage > 1) {
				%>
				<a href="ListStudentServlet?page=<%=currentPage - 1%>">Prev</a>
				<%
				} else {
				%>
				<a class="disabled">Prev</a>
				<%
				}
				%>

				<%
				for (int i = 1; i <= totalPages; i++) {
				%>
				<a href="ListStudentServlet?page=<%=i%>"
					class="<%=(i == currentPage) ? "active" : ""%>"><%=i%></a>
				<%
				}
				%>

				<%
				if (currentPage < totalPages) {
				%>
				<a href="ListStudentServlet?page=<%=currentPage + 1%>">Next</a>
				<%
				} else {
				%>
				<a class="disabled">Next</a>
				<%
				}
				%>

			</div>

		</div>
	</div>

	<!-- JAVASCRIPT -->

	<script>

document.getElementById("selectAll").addEventListener("change", function()
	{
	
		let checkboxes = document.querySelectorAll(".rowCheckbox");
		
		checkboxes.forEach(cb => cb.checked = this.checked);
	
	}
);

function confirmDeleteMultiple()
{
	let checked = document.querySelectorAll(".rowCheckbox:checked");
	
	if(checked.length === 0)
	{
		alert("Please select at least one record.");
		return false;
	}
	return confirm("Delete selected records?");
}

</script>

</body>

</html>