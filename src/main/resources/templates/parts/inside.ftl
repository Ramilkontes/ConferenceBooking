<#include "security.ftl">

<#macro inside times flag>

    <#if times?size==2>
        <table>
            <tr>
                <div class="alert alert-primary" role="alert" style="height: 113.39px; width: 200px">
                    <#list 0..times?size-2 as i>
                        <div class="form-style-2-heading">Event name: ${times[0].name}</div>
                        <div class="form-style-2-heading">Time start: ${times[0].dateStart}</div>
                        <div class="form-style-2-heading">Time finish ${times[0].dateFinish}</div>

                        <#if flag>
                            <form action="\users\${id}" method="post">
                                <div class="form-group">
                                    <input type="hidden" value="${times[0].dateStart}" name="date">
                                </div>
                                <div class="form-group">
                                    <button button type="submit" class="btn  btn-outline-primary">Join</button>
                                </div>
                            </form>
                        </#if>
                    </#list>
                </div>
            </tr>
            <tr>
                <div class="alert alert-primary" role="alert" style="height: 113.39px; width: 200px">
                    <#list 1..time?size-1 as i>
                        <div class="form-style-2-heading">Event name: ${times[1].name}</div>
                        <div class="form-style-2-heading">Time start: ${times[1].dateStart}</div>
                        <div class="form-style-2-heading">Time finish: ${times[1].dateFinish}</div>

                        <#if flag>
                            <form action="\users\${id}" method="post">
                                <div class="form-group">
                                    <input type="hidden" value="${times[1].dateStart}" name="date">
                                </div>
                                <div class="form-group">
                                    <button button type="submit" class="btn  btn-outline-primary">Join</button>
                                </div>
                            </form>
                        </#if>
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

<#macro example times flag>
    <#list times as time>
        <div id="custom-event-tooltip-popup" class="md-tooltip">
            <div id="tooltip-event-header" class="md-tooltip-header">
                <span id="tooltip-event-name-age" class="md-tooltip-name-age"></span>
                <span id="tooltip-event-time" class="md-tooltip-time"></span>
            </div>
            <div class="md-tooltip-info">
                <div id="tooltip-event-title" class="md-tooltip-title">
                    Status: <span class="md-tooltip-status md-tooltip-text"></span>
                    <button id="tooltip-event-status" mbsc-button data-color="warning" data-variant="outline"
                            class="md-tooltip-status-button"></button>
                </div>
                <div id="tooltip-event-reason" class="md-tooltip-title">Reason for visit: <span
                            class="md-tooltip-reason md-tooltip-text"></span></div>
                <div id="tooltip-event-location" class="md-tooltip-title">Location: <span
                            class="md-tooltip-location md-tooltip-text"></span></div>
                <button id="tooltip-event-view" mbsc-button data-color="secondary" class="md-tooltip-view-button">View
                    patient file
                </button>
                <button id="tooltip-event-delete" mbsc-button data-color="danger" data-variant="outline"
                        class="md-tooltip-delete-button">Delete appointment
                </button>
            </div>
        </div>
        <div id="demo-custom-event-tooltip"></div>
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
</#macro>