<%@ page import="com.ust.webapp.model.Trainee" isELIgnored="false"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Trainee List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Trainee List</h1>

        <%
        List<Trainee> trainees = (List<Trainee>) request.getAttribute("traineesList");
        if (trainees != null && !trainees.isEmpty()) {
        %>
            <table class="table table-striped mt-3">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Location</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Trainee trainee : trainees) { %>
                        <tr>
                            <td><%= trainee.id() %></td>
                            <td><%= trainee.name() %></td>
                            <td><%= trainee.location() %></td>
                            <td>
                                <form action="/update-trainee" method="get" style="display:inline;">
                                    <input type="hidden" name="id" value="<%= trainee.id() %>">
                                    <button type="submit" class="btn btn-warning btn-sm">Update</button>
                                </form>
                                <form action="/delete-trainee" method="post" style="display:inline;">
                                    <input type="hidden" name="id" value="<%= trainee.id() %>">
                                    <button type="submit" class="btn btn-danger btn-sm">Delete</button>
                                </form>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } else { %>
            <p>No trainees found.</p>
        <% } %>

        <a href="/index.jsp" class="btn btn-primary mt-3">Add New Trainee</a>
    </div>
</body>
</html>
