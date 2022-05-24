<#assign objectConstructor = "freemarker.template.utility.ObjectConstructor"?new()>
<#assign clock = objectConstructor("java.util.GregorianCalendar")>
<#assign yymmdd = objectConstructor("java.text.SimpleDateFormat","yyyy-MM-dd")>
<#assign date = clock.getTime()>
<#assign now = yymmdd.format(date)>

<#macro calendar>
<table class="table table-striped">
    <thead class="table-dark">
    <tr>
        <th scope="col" class="prev">
                <div class="form-group">
                    <form method="post" action="/">
                        <div>
                            <input type="hidden" value="-1" name="pointer">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-dark">&#10094;</button>
                        </div>
                    </form>
                </div>
            </form>
        </th>
        <th scope="col">
            Monday
            <#list 0..week?size-7 as i>
            <div>${week[0]}</div>
            </#list>
        </th>
        <th scope="col">
            Tuesday
            <#list 1..week?size-6 as i>
            <div>${week[1]}</div>
            </#list>
        </th>
        <th scope="col">
            Wednesday
            <#list 2..week?size-5 as i>
            <div>${week[2]}</div>
            </#list>
        </th>
        <th scope="col">
            Thursday
            <#list 3..week?size-4 as i>
            <div>${week[3]}</div>
            </#list>
        </th>
        <th scope="col">
            Friday
            <#list 4..week?size-3 as i>
            <div>${week[4]}</div>
            </#list>
        </th>
        <th scope="col">
            Saturday
            <#list 5..week?size-2 as i>
            <div>${week[5]}</div>
            </#list>
        </th>
        <th scope="col">
            Sunday
            <#list 6..week?size-1 as i>
            <div>${week[6]}</div>
            </#list>
        </th>
        <th scope="col" class="next">
            <div class="form-group">
                <form method="post" action="/">
                    <div>
                        <input type="hidden" value="1" name="pointer">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-dark">&#10095;</button>
                    </div>
                </form>
            </div>
            </form>
        </th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th>00:00</th>
    </tr>
    <tr>
        <th>01:00</th>
    </tr>
    <tr>
        <th>02:00</th>
    </tr>
    <tr>
        <th>03:00</th>
    </tr>
    <tr>
        <th>04:00</th>
    </tr>
    <tr>
        <th>05:00</th>
    </tr>
    <tr>
        <th>06:00</th>
    </tr>
    <tr>
        <th>07:00</th>
    </tr>
    <tr>
        <th>08:00</th>
    </tr>
    <tr>
        <th>09:00</th>
    </tr>
    <tr>
        <th>10:00</th>
    </tr>
    <tr>
        <th>11:00</th>
    </tr>
    <tr>
        <th>12:00</th>
    </tr>
    <tr>
        <th>13:00</th>
    </tr>
    <tr>
        <th>14:00</th>
    </tr>
    <tr>
        <th>15:00</th>
    </tr>
    <tr>
        <th>16:00</th>
    </tr>
    <tr>
        <th>17:00</th>
    </tr>
    <tr>
        <th>18:00</th>
    </tr>
    <tr>
        <th>19:00</th>
    </tr>
    <tr>
        <th>20:00</th>
    </tr>
    <tr>
        <th>21:00</th>
    </tr>
    <tr>
        <th>22:00</th>
    </tr>
    <tr>
        <th>23:00</th>
    </tr>
    </tbody>
</table>
</#macro>



