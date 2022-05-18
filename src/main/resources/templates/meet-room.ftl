<#import "parts/common.ftl" as c>

<@c.page>
<!--<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}"
                   placeholder="Search by tag">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>-->
<#if error??>
<div class="alert alert-danger" role="alert">Sorry, event in the past can't be create.</div>
</#if>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
    Add new Event
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="\events">
            <div class="form-group">
                <input type="text" class="form-control" name="name" placeholder="Enter the name"/>
            </div>
            <div class="form-group">
                <input type="datetime-local" class="form-control" name="dateStart" placeholder="Date Start">
            </div>
            <div class="form-group">
                <input type="datetime-local" class="form-control" name="dateFinish" placeholder="Date Finish">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
        </form>
    </div>
</div>

</@c.page>