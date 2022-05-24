<#import "parts/common.ftl" as c>

<@c.page>
<div class="alert alert-success alert-dismissible" role="alert">
    <div>The event has updated:
        <div class="form-style-2-heading">Name: ${event.name}</div>
        <div class="form-style-2-heading">Time start: ${event.dateStart}</div>
        <div class="form-style-2-heading">Time finish: ${event.dateFinish}</div>
    </div>
</div>
<br/>
<a href="/">Come back</a>
</@c.page>