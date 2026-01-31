<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>

<style>
    body {
        margin: 0;
        padding: 0;
        background: #f4f6f9;
        font-family: "Segoe UI", Arial, sans-serif;
    }

    .container {
        width: 480px;
        background: #ffffff;
        margin: 40px auto;
        padding: 25px 30px;
        border-radius: 8px;
        box-shadow: 0 6px 16px rgba(0,0,0,0.1);
    }

    h2 {
        text-align: center;
        color: #2c3e50;
        margin-bottom: 25px;
        border-bottom: 2px solid #007bff;
        padding-bottom: 10px;
    }

    .form-group {
        margin-bottom: 16px;
    }

    label {
        display: block;
        font-size: 14px;
        font-weight: 600;
        color: #333;
        margin-bottom: 4px;
    }

    .error {
        color: #dc3545;
        font-size: 12px;
        margin-left: 4px;
    }

    input[type="text"],
    input[type="number"],
    input[type="email"],
    input[type="tel"],
    input[type="date"],
    select,
    textarea {
        width: 100%;
        padding: 9px 10px;
        border: 1px solid #ced4da;
        border-radius: 5px;
        font-size: 14px;
        box-sizing: border-box;
        transition: border 0.2s;
    }

    input:focus,
    select:focus,
    textarea:focus {
        outline: none;
        border-color: #007bff;
    }

    .option-group {
        padding: 8px 0;
        font-size: 14px;
    }

    .option-group label {
        display: inline-block;
        font-weight: normal;
        margin-right: 15px;
        cursor: pointer;
    }

    .option-group input {
        margin-right: 5px;
        cursor: pointer;
    }

    textarea {
        resize: none;
    }

    .btn-container {
        text-align: center;
        margin-top: 25px;
    }

    .btn {
        width: 120px;
        padding: 10px;
        border: none;
        border-radius: 5px;
        font-size: 14px;
        font-weight: 600;
        cursor: pointer;
        margin: 0 5px;
        transition: 0.2s;
    }

    .btn-submit {
        background: #007bff;
        color: #ffffff;
    }

    .btn-submit:hover {
        background: #0056b3;
    }

    .btn-reset {
        background: #dc3545;
        color: #ffffff;
    }

    .btn-reset:hover {
        background: #b52a37;
    }
</style>
</head>

<body>

<div class="container">
    <h2>Student Registration Form</h2>

    <form action="UpdateStudentServlet" method="post">

        <div class="form-group">
            <label>Full Name <span class="error">${fullnameErr}</span></label>
            <input type="text" name="fullname" value="${sbean.fullname}">
        </div>

        <div class="form-group">
            <label>Age <span class="error">${ageErr}</span></label>
            <input type="number" name="age" value="${sbean.age}">
        </div>

        <div class="form-group">
            <label>Select Course <span class="error">${courseErr}</span></label>
            <select name="course">
                <option value="">-- Select Course --</option>
                <option value="C Programming" ${sbean.course=='C Programming' ? 'selected' : ''}>C Programming</option>
                <option value="C++" ${sbean.course=='C++' ? 'selected' : ''}>C++</option>
                <option value="Core Java" ${sbean.course=='Core Java' ? 'selected' : ''}>Core Java</option>
                <option value="Advanced Java" ${sbean.course=='Advanced Java' ? 'selected' : ''}>Advanced Java</option>
                <option value="Python" ${sbean.course=='Python' ? 'selected' : ''}>Python</option>
            </select>
        </div>

        <div class="form-group">
            <label>Gender <span class="error">${genderErr}</span></label>
            <div class="option-group">
                <label><input type="radio" name="gender" value="Male" ${sbean.gender=='Male' ? 'checked' : ''}> Male</label>
                <label><input type="radio" name="gender" value="Female" ${sbean.gender=='Female' ? 'checked' : ''}> Female</label>
                <label><input type="radio" name="gender" value="Other" ${sbean.gender=='Other' ? 'checked' : ''}> Other</label>
            </div>
        </div>

        <div class="form-group">
            <label>Hobbies <span class="error">${hobbiesErr}</span></label>
            <div class="option-group">
                <label><input type="checkbox" name="hobby" value="Reading" ${sbean.isAvailableHobbies("Reading") ? 'checked' : ''}> Reading</label>
                <label><input type="checkbox" name="hobby" value="Music" ${sbean.isAvailableHobbies("Music") ? 'checked' : ''}> Music</label>
                <label><input type="checkbox" name="hobby" value="Sports" ${sbean.isAvailableHobbies("Sports") ? 'checked' : ''}> Sports</label>
                <label><input type="checkbox" name="hobby" value="Coding" ${sbean.isAvailableHobbies("Coding") ? 'checked' : ''}> Coding</label>
            </div>
        </div>

        <div class="form-group">
            <label>Date of Birth <span class="error">${dobErr}</span></label>
            <input type="date" name="dob" value="${sbean.dob}">
        </div>

        <div class="form-group">
            <label>Email ID <span class="error">${emailErr}</span></label>
            <input type="email" name="email" value="${sbean.email}">
        </div>

        <div class="form-group">
            <label>Mobile Number <span class="error">${mobileErr}</span></label>
            <input type="tel" name="mobile" value="${sbean.mobile}">
        </div>

        <div class="form-group">
            <label>Address <span class="error">${addressErr}</span></label>
            <textarea name="address" rows="3">${sbean.address}</textarea>
        </div>

        <div class="btn-container">
            <button type="submit" class="btn btn-submit">Update</button>
            <button type="reset" class="btn btn-reset">Clear</button>
        </div>

    </form>
</div>

</body>
</html>