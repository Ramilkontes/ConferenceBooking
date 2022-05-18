<#import "parts/common.ftl" as c>

<@c.page>
Events

<table>
    <thead>
     <tr>
        <th>Name</th>
        <th>Date Start</th>
        <th>Date Finish</th>
        <th>Amount people</th>
        <th>Status</th>
        <th></th>
     </tr>
     </thead>
      <tbody>
      <#list events as event>
           <tr>
              <td>${event.name}</td>
              <td>${event.dateStart}</td>
              <td>${event.dateFinish}</td>
              <td>${event.amountPeople}</td>
              <td>${event.status}</td>
           </tr>
      </#list>
      </tbody>
</table>
</@c.page>