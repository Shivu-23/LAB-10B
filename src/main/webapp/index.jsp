<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Result Form</title>

<script>
function validateForm() {
    let marks = document.getElementsByClassName("marks");

    for(let i = 0; i < marks.length; i++) {
        let value = marks[i].value;

        if(value === "" || value < 0 || value > 100) {
            alert("Enter valid marks (0-100)");
            return false;
        }
    }

    return true;
}
</script>

</head>
<body>

<h2>Student Result Form</h2>

<form action="ResultServlet" method="post" onsubmit="return validateForm()">

Roll No: <input type="text" name="rollno" required><br><br>

Student Name: <input type="text" name="name" required><br><br>

Sub1: <input type="number" name="sub1" class="marks" required><br><br>
Sub2: <input type="number" name="sub2" class="marks" required><br><br>
Sub3: <input type="number" name="sub3" class="marks" required><br><br>
Sub4: <input type="number" name="sub4" class="marks" required><br><br>
Sub5: <input type="number" name="sub5" class="marks" required><br><br>

<input type="submit" value="Calculate Result">

</form>

</body>
</html>