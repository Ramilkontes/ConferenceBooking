<#macro calendarPage>

    <div id="custom-event-tooltip-popup" class="md-tooltip">
        <div id="tooltip-event-header" class="md-tooltip-header">
            <span id="tooltip-event-name-age" class="md-tooltip-name-age"></span>
            <span id="tooltip-event-time" class="md-tooltip-time"></span>
        </div>
        <div class="md-tooltip-info">
            <div id="tooltip-event-title" class="md-tooltip-title">
                Status: <span class="md-tooltip-status md-tooltip-text"></span>
                <button id="tooltip-event-status" mbsc-button data-color="warning" data-variant="outline" class="md-tooltip-status-button"></button>
            </div>
            <div id="tooltip-event-reason" class="md-tooltip-title">Reason for visit: <span class="md-tooltip-reason md-tooltip-text"></span></div>
            <div id="tooltip-event-location" class="md-tooltip-title">Location: <span class="md-tooltip-location md-tooltip-text"></span></div>
            <button id="tooltip-event-view" mbsc-button data-color="secondary" class="md-tooltip-view-button">View patient file</button>
            <button id="tooltip-event-delete" mbsc-button data-color="danger" data-variant="outline" class="md-tooltip-delete-button">Delete appointment</button>
        </div>
    </div>
    <div id="demo-custom-event-tooltip"></div>

   <#-- <#assign heightCell = "113.39px" >
    <#assign widthCell = "200px" >
    <#assign heightColumn = "36px" >
    <#assign widthColumn = "200px" >
    <div class="table-responsive-sm">

        <div style="height: ${heightCell}; width: ${widthCell}"> </div>
        <span id="monday" style="height: ${heightCell}; width: ${widthCell}">Monday</span>
        <span id="tuesday" style="height: ${heightCell}; width: ${widthCell}">Tuesday</span>
        <span id="wednesday" style="height: ${heightCell}; width: ${widthCell}">Wednesday</span>
        <span id="thursday" style="height: ${heightCell}; width: ${widthCell}">Thursday</span>
        <span id="friday" style="height: ${heightCell}; width: ${widthCell}">Friday</span>
        <span id="saturday" style="height: ${heightCell}; width: ${widthCell}">Saturday</span>
        <span id="Sunday" style="height: ${heightCell}; width: ${widthCell}">Sunday</span>
        <div id="00" style="height: ${heightCell}; width: ${widthCell}">00:00</div>
        <div id="01" style="height: ${heightCell}; width: ${widthCell}">01:00</div>
        <div id="02" style="height: ${heightCell}; width: ${widthCell}">02:00</div>
        <div id="03" style="height: ${heightCell}; width: ${widthCell}">03:00</div>
        <div id="04" style="height: ${heightCell}; width: ${widthCell}">04:00</div>
        <div id="05" style="height: ${heightCell}; width: ${widthCell}">05:00</div>
        <div id="06" style="height: ${heightCell}; width: ${widthCell}">06:00</div>
        <div id="07" style="height: ${heightCell}; width: ${widthCell}">07:00</div>
        <div id="08" style="height: ${heightCell}; width: ${widthCell}">08:00</div>
        <div id="09" style="height: ${heightCell}; width: ${widthCell}">09:00</div>
        <div id="10" style="height: ${heightCell}; width: ${widthCell}">10:00</div>
        <div id="11" style="height: ${heightCell}; width: ${widthCell}">11:00</div>
        <div id="12" style="height: ${heightCell}; width: ${widthCell}">12:00</div>
        <div id="13" style="height: ${heightCell}; width: ${widthCell}">13:00</div>
        <div id="14" style="height: ${heightCell}; width: ${widthCell}">14:00</div>
        <div id="15" style="height: ${heightCell}; width: ${widthCell}">15:00</div>
        <div id="16" style="height: ${heightCell}; width: ${widthCell}">16:00</div>
        <div id="17" style="height: ${heightCell}; width: ${widthCell}">17:00</div>
        <div id="18" style="height: ${heightCell}; width: ${widthCell}">18:00</div>
        <div id="19" style="height: ${heightCell}; width: ${widthCell}">19:00</div>
        <div id="20" style="height: ${heightCell}; width: ${widthCell}">20:00</div>
        <div id="21" style="height: ${heightCell}; width: ${widthCell}">21:00</div>
        <div id="22" style="height: ${heightCell}; width: ${widthCell}">22:00</div>
        <div id="23" style="height: ${heightCell}; width: ${widthCell}">23:00</div>
    </div>-->
</#macro>