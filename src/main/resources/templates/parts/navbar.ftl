<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Meet Room</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/meet-room/events/${id}">My concernments</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/meet-room/people">User list</a>
            </#if>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/meet-room/rooms">Events</a>
            </#if>
            </li>

        </ul>

        <div class="navbar-text mr-3">${login}</div>
        <@l.logout />
    </div>
</nav>