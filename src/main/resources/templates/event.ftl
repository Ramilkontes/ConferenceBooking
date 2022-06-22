<#import "parts/common.ftl" as c>

<@c.page>
<#if form?? || engagedTime?? || notCorrectness??>
<div class="alert alert-danger" role="alert">
    Something wrong... Check your data
</div>
    <#else>
<div class="alert alert-success alert-dismissible" role="alert">
    <div>New event has created:
        <div class="form-style-2-heading">Name: ${event.name}</div>
        <div class="form-style-2-heading">Time start: ${event.dateStart}</div>
        <div class="form-style-2-heading">Time finish: ${event.dateFinish}</div>
    </div>
</div>
</#if>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
    Edit
</a>
<div class="collapse <#if form?? || engagedTime?? || notCorrectness??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="\events\${event.id}">
            <div class="form-group">
                <input type="hidden" value="${event.id}" name="eventId">
            </div>
            <div class="form-group">
                <input type="text" class="form-control ${(nameError??)?string('is-invalid', '')}"
                       value="<#if form??>${form.name}<#else>${event.name}</#if>" name="name">
                <#if nameError??>
                <div style="color:red" class="invalid-feedback">
                    ${nameError}
                </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="datetime-local" class="form-control ${(dateStartError??)?string('is-invalid', '')}"
                 value="<#if form??>${form.dateStart}<#else>${event.dateStart}</#if>" name="dateStart">
                <#if dateStartError??>
                <div style="color:red" class="invalid-feedback">
                    ${dateStartError}
                </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="datetime-local" class="form-control ${(dateFinishError??)?string('is-invalid', '')}"
                       value="<#if form??>${form.dateFinish}<#else>${event.dateFinish}</#if>" name="dateFinish">
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
                <button button type="submit" class="btn btn-primary">Save </button>
            </div>
        </form>
    </div>
</div>
<br/>
<a href="/">Come back</a>

</@c.page>