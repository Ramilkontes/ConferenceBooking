<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        login = user.getUsername()
        isAdmin = user.isAdmin()
        id = user.getId()
    >
<#else>
    <#assign
        login = "unknown"
        isAdmin = false
        id = -1
    >
</#if>