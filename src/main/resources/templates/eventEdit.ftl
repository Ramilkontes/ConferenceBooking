<#import "parts/common.ftl" as c>

<@c.page>
<div class="alert alert-success alert-dismissible" role="alert">
    <div>The event has updated:
        <div class="form-style-2-heading">Name: ${event.name}</div>
        <div class="form-style-2-heading">Time start: ${event.dateStart}</div>
        <div class="form-style-2-heading">Time finish: ${event.dateFinish}</div>
    </div>
</div>
<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
</button>
<br/>
<a href="/">Come back</a>
</@c.page>