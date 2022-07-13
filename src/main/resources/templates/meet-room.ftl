<#import "parts/common.ftl" as c>
<#import "parts/calendar.ftl" as cal>
<@c.page>

<#if eventIsExist??>
<div class="alert alert-danger alert-dismissible fade show" role="alert">
    <strong>Sorry, but you have already registered at this event</strong>
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>
</#if>

<@cal.calendar />

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
    Add new Event
</a>

<div class="collapse <#if form?? || engagedTime?? || notCorrectness??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" id="createEvent" action="\events">
            <div style="display: none;">
                <input type="hidden" value="${currentDate}" name="currentDate">
            </div>
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
            <#if engagedTime??>
                <div class="alert alert-danger" role="alert">
                     ${engagedTime}
                </div>
            <#elseIf notCorrectness??>
                <div class="alert alert-danger" role="alert">
                    ${notCorrectness}
                </div>
            </#if>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
        </form>
    </div>
</div>

</@c.page>