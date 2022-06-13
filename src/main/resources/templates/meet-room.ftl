<#import "parts/common.ftl" as c>
<#import "parts/calendar.ftl" as cal>
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
<@cal.calendar />

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
    Add new Event
</a>
<div class="collapse <#if form??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="\events">
            <div class="form-group">
                <input type="text" class="form-control ${(nameError??)?string('is-invalid', '')}"
                       value="<#if form??>${form.name}</#if>" name="name" placeholder="Enter the name"/>
                <#if nameError??>
                    <div style="color:red" class="invalid-feedback">
                        ${nameError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="datetime-local" class="form-control ${(dateStartError??)?string('is-invalid', '')}"
                       value="<#if form??>${dateStart}</#if>" name="dateStart"
                       placeholder="Date Start">
                <#if dateStartError??>
                    <div style="color:red" class="invalid-feedback">
                        ${dateStartError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="datetime-local" class="form-control ${(dateFinishError??)?string('is-invalid', '')}"
                       value="<#if form??>${dateFinish}</#if>" name="dateFinish" placeholder="Date Finish">
                <#if dateFinishError??>
                    <div style="color:red" class="invalid-feedback">
                        ${dateFinishError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
        </form>
    </div>
</div>

</@c.page>