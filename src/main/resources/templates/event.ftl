<#import "parts/common.ftl" as c>

<@c.page>

<div class="alert alert-success alert-dismissible" role="alert">
    <div>New event has created:
        <div class="form-style-2-heading">Name: ${event.name}</div>
        <div class="form-style-2-heading">Time start: ${event.dateStart}</div>
        <div class="form-style-2-heading">Time finish: ${event.dateFinish}</div>
    </div>
</div>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
    Edit
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="\events\${event.id}">
            <div class="form-group">
                <input type="hidden" value="${event.id}" name="eventId">
            </div>
            <div class="form-group">
                <input type="text" value="${event.name}" name="name">
            </div>
            <div class="form-group">
                <input type="datetime-local" value="${event.dateStart}" name="dateStart">>
            </div>
            <div class="form-group">
                <input type="datetime-local" value="${event.dateFinish}" name="dateFinish">>
            </div>
            <div class="form-group">
                <button button type="submit" class="btn btn-primary">Save </button>
            </div>
        </form>
    </div>
</div>
<br/>
<a href="/">Come back</a>
</@c.page>