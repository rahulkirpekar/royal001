<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.royal.bean.StudentBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Records</title>

<style>
    body {
        margin: 0;
        padding: 0;
        background: #f4f6f9;
        font-family: "Segoe UI", Arial, sans-serif;
    }

    .container {
        width: 95%;
        margin: 30px auto;
        background: #ffffff;
        padding: 20px 25px;
        border-radius: 8px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.08);
    }

    h3 {
        margin-bottom: 20px;
        color: #2c3e50;
        border-left: 5px solid #007bff;
        padding-left: 10px;
        font-size: 22px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        font-size: 14px;
    }

    table thead tr {
        background: #007bff;
        color: #ffffff;
    }

    table th, table td {
        padding: 10px 12px;
        text-align: center;
        border-bottom: 1px solid #e0e0e0;
    }

    table tbody tr:hover {
        background-color: #f1f7ff;
        transition: 0.2s;
    }

    table th {
        font-weight: 600;
        text-transform: uppercase;
        font-size: 13px;
    }

    .action-btn {
        text-decoration: none;
        padding: 6px 10px;
        border-radius: 4px;
        font-size: 13px;
        font-weight: 500;
        margin: 0 3px;
        display: inline-block;
    }

    .edit-btn {
        background: #28a745;
        color: white;
    }

    .edit-btn:hover {
        background: #218838;
    }

    .delete-btn {
        background: #dc3545;
        color: white;
    }

    .delete-btn:hover {
        background: #c82333;
    }

    .no-record {
        text-align: center;
        color: #888;
        font-size: 16px;
        padding: 20px;
    }
</style>

</head>
<body>

<div class="container">
    <h3>List of Student Records</h3>

    <%
        ArrayList<StudentBean> list = 
            (ArrayList<StudentBean>) request.getAttribute("list");
    %>

    <table>
        <thead>
            <tr>
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
                <td>
                    <a href="" class="action-btn edit-btn">Edit</a>
                    <a href="" 
                       class="action-btn delete-btn"
                       onclick="return confirm('Are you sure you want to delete this record?');">
                       Delete
                    </a>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="11" class="no-record">No Student Records Found</td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

</body>
</html>