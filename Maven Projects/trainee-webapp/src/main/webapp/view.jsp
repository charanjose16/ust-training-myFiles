<%@ page import="traineeapp.model.Trainee" isELIgnored="false"%>
<%@ page import="java.util.List" %>
<!DOC TYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"/>
<% List<Trainee> trainees=(List<Trainee>)request.getAttribute("trainees");
out.println("<table class='table table-warning'><tr><th>ID</th><th>Name</th><th>Location</th><th>Joined Date</th><th>Action</th></tr>");
    for(Trainee trainee : trainees){
        out.println("<tr><td>" + trainee.getId() + "</td><td>" + trainee.getName() + "</td><td>" + trainee.getLocation() + "</td><td>" + trainee.getJoinedDate() + "</td><td><form action='trainees/delete' method='post'><input type='hidden' name='id' value='"+trainee.getId() +"'/><button type='submit' class='btn btn-danger'  >Delete</button></form></td></tr>");
    }
    out.println("</table>");
%>

</body>
</html>