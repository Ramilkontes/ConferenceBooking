<#include "security.ftl">

<#macro inside times flag>

<#if times?size==2>
<table>
    <tr>
        <div class="alert alert-primary" role="alert">
            <#list 0..times?size-2 as i>
            <div class="form-style-2-heading">Event name: ${times[0].name}</div>
            <div class="form-style-2-heading">Time start: ${times[0].dateStart}</div>
            <div class="form-style-2-heading">Time finish ${times[0].dateFinish}</div>
        </#list>
        </div>
    </tr>
    <tr>
        <div class="alert alert-primary" role="alert">
            <#list 1..time?size-1 as i>
            <div class="form-style-2-heading">Event name: ${times[1].name}</div>
            <div class="form-style-2-heading">Time start: ${times[1].dateStart}</div>
            <div class="form-style-2-heading">Time finish: ${times[1].dateFinish}</div>
        </#list>
        </div>
    </tr>
</table>
<#else>
<div class="alert alert-primary" role="alert">
    <#list times as time>
    <p><small>Event name: ${time.name}</small></p>
    <p><small>Time start: ${time.dateStart}</small></p>
    <p><small>Time finish: ${time.dateFinish}</small></p>

    <#if flag>
    <form action="\users\${id}" method="post" id="joinToRoom">
        <div class="form-group">
            <input type="hidden" value="${time.dateStart}" name="date">
        </div>
        <div class="form-group">
            <button button type="submit" class="btn  btn-outline-primary">Join</button>
        </div>
    </form>
    </#if>
</#list>
</div>
</#if>
</#macro>