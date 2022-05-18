<#import "parts/common.ftl" as c>

<@c.page>
List of users
<table>
    <thead>
    <tr>
        <th>Login</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>State</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
          <td>${user.login}</td>
          <td>${user.firstName}</td>
          <td>${user.lastName}</td>
          <td>${user.state}</td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>