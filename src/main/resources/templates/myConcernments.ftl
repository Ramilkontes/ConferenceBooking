<#import "parts/common.ftl" as c>

<@c.page>

<#if concernments?size!=0>
<div>My concernments</div>
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
  <#list concernments as concernment>
  <tr>
    <td>${concernment.name}</td>
    <td>${concernment.dateStart}</td>
    <td>${concernment.dateFinish}</td>
    <td>${concernment.amountPeople}</td>
    <td>${concernment.status}</td>
  </tr>
  </#list>
  </tbody>
</table>

<#else>
<div>Sorry, at this moment you aren't a member of any event</div>
</#if>
</@c.page>