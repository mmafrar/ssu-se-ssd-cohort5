<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="/css/bootstrap.css" rel="stylesheet">

<div class="container">
    <h1>Login Contact</h1>
    <div class="form-group">
        <form:form method="post" action="/login-contact">
            <table>
                <tr class="row">
                    <td>Email: </td>
                    <td><form:input class="form-control" path="email"/></td>
                </tr>
                <tr class="row">
                    <td>Country: </td>
                    <td><form:input class="form-control" path="country"/></td>
                </tr>
                <tr class="row">
                    <td></td>
                    <td><input class="btn btn-primary" type="submit" value="Login"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>

<script src="/js/bootstrap.js"></script>
