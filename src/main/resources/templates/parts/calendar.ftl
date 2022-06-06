<#import "calendarStrings.ftl" as string>
<#import "inside.ftl" as inside>
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
        <th scope="col" >
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
        </th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th>00:00</th>
        <#if zero??>
        <th>
            <#if mondayZero??>
            <@inside.inside times = mondayZero />
        </#if>
        </th>
        <th>
            <#if tuesdayZero??>
            <@inside.inside times = tuesdayZero />
        </#if>
        </th>
        <th>
            <#if wednesdayZero??>
            <@inside.inside times = wednesdayZero />
        </#if>
        </th>
        <th>
            <#if thursdayZero??>
            <@inside.inside times = thursdayZero />
        </#if>
        </th>
        <th>
            <#if fridayZero??>
            <@inside.inside times = fridayZero />
        </#if>
        </th>
        <th>
            <#if saturdayZero??>
            <@inside.inside times = saturdayZero />
        </#if>
        </th>
        <th>
            <#if sundayZero??>
            <@inside.inside times = sundayZero />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
        </#if>
    </tr>
    <tr>
        <th>01:00</th>
        <#if one??>
        <th>
            <#if mondayOne??>
            <@inside.inside times = mondayOne />
        </#if>
        </th>
        <th>
            <#if tuesdayOne??>
            <@inside.inside times = tuesdayOne />
        </#if>
        </th>
        <th>
            <#if wednesdayOne??>
            <@inside.inside times = wednesdayOne />
        </#if>
        </th>
        <th>
            <#if thursdayOne??>
            <@inside.inside times = thursdayOne />
        </#if>
        </th>
        <th>
            <#if fridayOne??>
            <@inside.inside times = fridayOne />
        </#if>
        </th>
        <th>
            <#if saturdayOne??>
            <@inside.inside times = saturdayOne />
        </#if>
        </th>
        <th>
            <#if sundayOne??>
            <@inside.inside times = sundayOne />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>02:00</th>
        <#if two??>
        <th>
            <#if mondayTwo??>
            <@inside.inside times = mondayTwo />
        </#if>
        </th>
        <th>
            <#if tuesdayTwo??>
            <@inside.inside times = tuesdayTwo />
        </#if>
        </th>
        <th>
            <#if wednesdayTwo??>
            <@inside.inside times = wednesdayTwo />
        </#if>
        </th>
        <th>
            <#if thursdayTwo??>
            <@inside.inside times = thursdayTwo />
        </#if>
        </th>
        <th>
            <#if fridayTwo??>
            <@inside.inside times = fridayTwo />
        </#if>
        </th>
        <th>
            <#if saturdayTwo??>
            <@inside.inside times = saturdayTwo />
        </#if>
        </th>
        <th>
            <#if sundayTwo??>
            <@inside.inside times = sundayTwo />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>03:00</th>
        <#if three??>
        <th>
            <#if mondayThree??>
            <@inside.inside times = mondayThree />
        </#if>
        </th>
        <th>
            <#if tuesdayThree??>
            <@inside.inside times = tuesdayThree />
        </#if>
        </th>
        <th>
            <#if wednesdayThree??>
            <@inside.inside times = wednesdayThree />
        </#if>
        </th>
        <th>
            <#if thursdayThree??>
            <@inside.inside times = thursdayThree />
        </#if>
        </th>
        <th>
            <#if fridayThree??>
            <@inside.inside times = fridayThree />
        </#if>
        </th>
        <th>
            <#if saturdayThree??>
            <@inside.inside times = saturdayThree />
        </#if>
        </th>
        <th>
            <#if sundayThree??>
            <@inside.inside times = sundayThree />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>04:00</th>
        <#if four??>
        <th>
            <#if mondaySixFour??>
            <@inside.inside times = mondayFour />
        </#if>
        </th>
        <th>
            <#if tuesdayFour??>
            <@inside.inside times = tuesdayFour />
        </#if>
        </th>
        <th>
            <#if wednesdayFour??>
            <@inside.inside times = wednesdayFour />
        </#if>
        </th>
        <th>
            <#if thursdayFour??>
            <@inside.inside times = thursdayFour />
        </#if>
        </th>
        <th>
            <#if fridayFour??>
            <@inside.inside times = fridayFour />
        </#if>
        </th>
        <th>
            <#if saturdayFour??>
            <@inside.inside times = saturdayFour />
        </#if>
        </th>
        <th>
            <#if sundayFour??>
            <@inside.inside times = sundayFour />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>05:00</th>
        <#if five??>
        <th>
            <#if mondayFive??>
            <@inside.inside times = mondayFive />
        </#if>
        </th>
        <th>
            <#if tuesdayFive??>
            <@inside.inside times = tuesdayFive />
        </#if>
        </th>
        <th>
            <#if wednesdayFive??>
            <@inside.inside times = wednesdayFive />
        </#if>
        </th>
        <th>
            <#if thursdayFive??>
            <@inside.inside times = thursdayFive />
        </#if>
        </th>
        <th>
            <#if fridayFive??>
            <@inside.inside times = fridayFive />
        </#if>
        </th>
        <th>
            <#if saturdayFive??>
            <@inside.inside times = saturdayFive />
        </#if>
        </th>
        <th>
            <#if sundayFive??>
            <@inside.inside times = sundayFive />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>06:00</th>
        <#if six??>
        <th>
            <#if mondaySix??>
            <@inside.inside times = mondaySix />
        </#if>
        </th>
        <th>
            <#if tuesdaySix??>
            <@inside.inside times = tuesdaySix />
        </#if>
        </th>
        <th>
            <#if wednesdaySix??>
            <@inside.inside times = wednesdaySix />
        </#if>
        </th>
        <th>
            <#if thursdaySix??>
            <@inside.inside times = thursdaySix />
        </#if>
        </th>
        <th>
            <#if fridaySix??>
            <@inside.inside times = fridaySix />
        </#if>
        </th>
        <th>
            <#if saturdaySix??>
            <@inside.inside times = saturdaySix />
        </#if>
        </th>
        <th>
            <#if sundaySix??>
            <@inside.inside times = sundaySix />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>07:00</th>
        <#if seven??>
        <th>
            <#if mondaySeven??>
            <@inside.inside times = mondaySeven />
        </#if>
        </th>
        <th>
            <#if tuesdaySeven??>
            <@inside.inside times = tuesdaySeven />
        </#if>
        </th>
        <th>
            <#if wednesdaySeven??>
            <@inside.inside times = wednesdaySeven />
        </#if>
        </th>
        <th>
            <#if thursdaySeven??>
            <@inside.inside times = thursdaySeven />
        </#if>
        </th>
        <th>
            <#if fridaySeven??>
            <@inside.inside times = fridaySeven />
        </#if>
        </th>
        <th>
            <#if saturdaySeven??>
            <@inside.inside times = saturdaySeven />
        </#if>
        </th>
        <th>
            <#if sundaySeven??>
            <@inside.inside times = sundaySeven />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>08:00</th>
        <#if eight??>
        <th>
            <#if mondayEight??>
            <@inside.inside times = mondayEight />
        </#if>
        </th>
        <th>
            <#if tuesdayEight??>
            <@inside.inside times = tuesdayEight />
        </#if>
        </th>
        <th>
            <#if wednesdayEight??>
            <@inside.inside times = wednesdayEight />
        </#if>
        </th>
        <th>
            <#if thursdayEight??>
            <@inside.inside times = thursdayEight />
        </#if>
        </th>
        <th>
            <#if fridayEight??>
            <@inside.inside times = fridayEight />
        </#if>
        </th>
        <th>
            <#if saturdayEight??>
            <@inside.inside times = saturdayEight />
        </#if>
        </th>
        <th>
            <#if sundayEight??>
            <@inside.inside times = sundayEight />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>09:00</th>
        <#if nine??>
        <th>
            <#if mondayNine??>
            <@inside.inside times = mondayNine />
        </#if>
        </th>
        <th>
            <#if tuesdayNine??>
            <@inside.inside times = tuesdayNine />
        </#if>
        </th>
        <th>
            <#if wednesdayNine??>
            <@inside.inside times = wednesdayNine />
        </#if>
        </th>
        <th>
            <#if thursdayNine??>
            <@inside.inside times = thursdayNine />
        </#if>
        </th>
        <th>
            <#if fridayNine??>
            <@inside.inside times = fridayNine />
        </#if>
        </th>
        <th>
            <#if saturdayNine??>
            <@inside.inside times = saturdayNine />
        </#if>
        </th>
        <th>
            <#if sundayNine??>
            <@inside.inside times = sundayNine />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>10:00</th>
        <#if ten??>
        <th>
            <#if mondayTen??>
            <@inside.inside times = mondayTen />
        </#if>
        </th>
        <th>
            <#if tuesdayTen??>
            <@inside.inside times = tuesdayTen />
        </#if>
        </th>
        <th>
            <#if wednesdayTen??>
            <@inside.inside times = wednesdayTen />
        </#if>
        </th>
        <th>
            <#if thursdayTen??>
            <@inside.inside times = thursdayTen />
        </#if>
        </th>
        <th>
            <#if fridayTen??>
            <@inside.inside times = fridayTen />
        </#if>
        </th>
        <th>
            <#if saturdayTen??>
            <@inside.inside times = saturdayTen />
        </#if>
        </th>
        <th>
            <#if sundayTen??>
            <@inside.inside times = sundayTen />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>11:00</th>
        <#if eleven??>
        <th>
            <#if mondayEleven??>
            <@inside.inside times = mondayEleven />
        </#if>
        </th>
        <th>
            <#if tuesdayEleven??>
            <@inside.inside times = tuesdayEleven />
        </#if>
        </th>
        <th>
            <#if wednesdayEleven??>
            <@inside.inside times = wednesdayEleven />
        </#if>
        </th>
        <th>
            <#if thursdayEleven??>
            <@inside.inside times = thursdayEleven />
        </#if>
        </th>
        <th>
            <#if fridayEleven??>
            <@inside.inside times = fridayEleven />
        </#if>
        </th>
        <th>
            <#if saturdayEleven??>
            <@inside.inside times = saturdayEleven />
        </#if>
        </th>
        <th>
            <#if sundayEleven??>
            <@inside.inside times = sundayEleven />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>12:00</th>
        <#if twelve??>
        <th>
            <#if mondayTwelve??>
            <@inside.inside times = mondayTwelve />
        </#if>
        </th>
        <th>
            <#if tuesdayTwelve??>
            <@inside.inside times = tuesdayTwelve />
        </#if>
        </th>
        <th>
            <#if wednesdayTwelve??>
            <@inside.inside times = wednesdayTwelve />
        </#if>
        </th>
        <th>
            <#if thursdayTwelve??>
            <@inside.inside times = thursdayTwelve />
        </#if>
        </th>
        <th>
            <#if fridayTwelve??>
            <@inside.inside times = fridayTwelve />
        </#if>
        </th>
        <th>
            <#if saturdayTwelve??>
            <@inside.inside times = saturdayTwelve />
        </#if>
        </th>
        <th>
            <#if sundayTwelve??>
            <@inside.inside times = sundayTwelve />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>13:00</th>
        <#if thirteen??>
        <th>
            <#if mondayThirteen??>
            <@inside.inside times = mondayThirteen />
        </#if>
        </th>
        <th>
            <#if tuesdayThirteen??>
            <@inside.inside times = tuesdayThirteen />
        </#if>
        </th>
        <th>
            <#if wednesdayThirteen??>
            <@inside.inside times = wednesdayThirteen />
        </#if>
        </th>
        <th>
            <#if thursdayThirteen??>
            <@inside.inside times = thursdayThirteen />
        </#if>
        </th>
        <th>
            <#if fridayThirteen??>
            <@inside.inside times = fridayThirteen />
        </#if>
        </th>
        <th>
            <#if saturdayThirteen??>
            <@inside.inside times = saturdayThirteen />
        </#if>
        </th>
        <th>
            <#if sundayThirteen??>
            <@inside.inside times = sundayThirteen />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>14:00</th>
        <#if fourteen??>
        <th>
            <#if mondayFourteen??>
            <@inside.inside times = mondayFourteen />
        </#if>
        </th>
        <th>
            <#if tuesdayFourteen??>
            <@inside.inside times = tuesdayFourteen />
        </#if>
        </th>
        <th>
            <#if wednesdayFourteen??>
            <@inside.inside times = wednesdayFourteen />
        </#if>
        </th>
        <th>
            <#if thursdayFourteen??>
            <@inside.inside times = thursdayFourteen />
        </#if>
        </th>
        <th>
            <#if fridayFourteen??>
            <@inside.inside times = fridayFourteen />
        </#if>
        </th>
        <th>
            <#if saturdayFourteen??>
            <@inside.inside times = saturdayFourteen />
        </#if>
        </th>
        <th>
            <#if sundayFourteen??>
            <@inside.inside times = sundayFourteen />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>15:00</th>
        <#if fifteen??>
        <th>
            <#if mondayFifteen??>
            <@inside.inside times = mondayFifteen />
        </#if>
        </th>
        <th>
            <#if tuesdayFifteen??>
            <@inside.inside times = tuesdayFifteen />
        </#if>
        </th>
        <th>
            <#if wednesdayFifteen??>
            <@inside.inside times = wednesdayFifteen />
        </#if>
        </th>
        <th>
            <#if thursdayFifteen??>
            <@inside.inside times = thursdayFifteen />
        </#if>
        </th>
        <th>
            <#if fridayFifteen??>
            <@inside.inside times = fridayFifteen />
        </#if>
        </th>
        <th>
            <#if saturdayFifteen??>
            <@inside.inside times = saturdayFifteen />
        </#if>
        </th>
        <th>
            <#if sundayFifteen??>
            <@inside.inside times = sundayFifteen />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>16:00</th>
        <#if sixteen??>
        <th>
            <#if mondaySixteen??>
            <@inside.inside times = mondaySixteen />
        </#if>
        </th>
        <th>
            <#if tuesdaySixteen??>
            <@inside.inside times = tuesdaySixteen />
        </#if>
        </th>
        <th>
            <#if wednesdaySixteen??>
            <@inside.inside times = wednesdaySixteen />
        </#if>
        </th>
        <th>
            <#if thursdaySixteen??>
            <@inside.inside times = thursdaySixteen />
        </#if>
        </th>
        <th>
            <#if fridaySixteen??>
            <@inside.inside times = fridaySixteen />
        </#if>
        </th>
        <th>
            <#if saturdaySixteen??>
            <@inside.inside times = saturdaySixteen />
        </#if>
        </th>
        <th>
            <#if sundaySixteen??>
            <@inside.inside times = sundaySixteen />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>17:00</th>
        <#if seventeen??>
        <th>
            <#if mondaySeven??>
            <@inside.inside times = mondaySeventeen />
        </#if>
        </th>
        <th>
            <#if tuesdaySeventeen??>
            <@inside.inside times = tuesdaySeventeen />
        </#if>
        </th>
        <th>
            <#if wednesdaySeventeen??>
            <@inside.inside times = wednesdaySeventeen />
        </#if>
        </th>
        <th>
            <#if thursdaySeventeen??>
            <@inside.inside times = thursdaySeventeen />
        </#if>
        </th>
        <th>
            <#if fridaySeventeen??>
            <@inside.inside times = fridaySeventeen />
        </#if>
        </th>
        <th>
            <#if saturdaySeventeen??>
            <@inside.inside times = saturdaySeventeen />
        </#if>
        </th>
        <th>
            <#if sundaySeventeen??>
            <@inside.inside times = sundaySeventeen />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>18:00</th>
        <#if eighteen??>
        <th>
            <#if mondayEighteen??>
            <@inside.inside times = mondayEighteen />
        </#if>
        </th>
        <th>
            <#if tuesdayEighteen??>
            <@inside.inside times = tuesdayEighteen />
        </#if>
        </th>
        <th>
            <#if wednesdayEighteen??>
            <@inside.inside times = wednesdayEighteen />
        </#if>
        </th>
        <th>
            <#if thursdayEighteen??>
            <@inside.inside times = thursdayEighteen />
        </#if>
        </th>
        <th>
            <#if fridayEighteen??>
            <@inside.inside times = fridayEighteen />
        </#if>
        </th>
        <th>
            <#if saturdayEighteen??>
            <@inside.inside times = saturdayEighteen />
        </#if>
        </th>
        <th>
            <#if sundayEighteen??>
            <@inside.inside times = sundayEighteen />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>19:00</th>
        <#if nineteen??>
        <th>
            <#if mondayNineteen??>
            <@inside.inside times = mondayNineteen />
        </#if>
        </th>
        <th>
            <#if tuesdayNineteen??>
            <@inside.inside times = tuesdayNineteen />
        </#if>
        </th>
        <th>
            <#if wednesdayNineteen??>
            <@inside.inside times = wednesdayNineteen />
        </#if>
        </th>
        <th>
            <#if thursdayNineteen??>
            <@inside.inside times = thursdayNineteen />
        </#if>
        </th>
        <th>
            <#if fridayNineteen??>
            <@inside.inside times = fridayNineteen />
        </#if>
        </th>
        <th>
            <#if saturdayNineteen??>
            <@inside.inside times = saturdayNineteen />
        </#if>
        </th>
        <th>
            <#if sundayNineteen??>
            <@inside.inside times = sundayNineteen />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>20:00</th>
        <#if twenty??>
        <th>
            <#if mondayTwenty??>
            <@inside.inside times = mondayTwenty />
        </#if>
        </th>
        <th>
            <#if tuesdayTwenty??>
            <@inside.inside times = tuesdayTwenty />
        </#if>
        </th>
        <th>
            <#if wednesdayTwenty??>
            <@inside.inside times = wednesdayTwenty />
        </#if>
        </th>
        <th>
            <#if thursdayTwenty??>
            <@inside.inside times = thursdayTwenty />
        </#if>
        </th>
        <th>
            <#if fridayTwenty??>
            <@inside.inside times = fridayTwenty />
        </#if>
        </th>
        <th>
            <#if saturdayTwenty??>
            <@inside.inside times = saturdayTwenty />
        </#if>
        </th>
        <th>
            <#if sundayTwenty??>
            <@inside.inside times = sundayTwenty />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>21:00</th>
        <#if twentyOne??>
        <th>
            <#if mondayTwentyOne??>
            <@inside.inside times = mondayTwentyOne />
        </#if>
        </th>
        <th>
            <#if tuesdayTwentyOne??>
            <@inside.inside times = tuesdayTwentyOne />
        </#if>
        </th>
        <th>
            <#if wednesdayTwentyOne??>
            <@inside.inside times = wednesdayTwentyOne />
        </#if>
        </th>
        <th>
            <#if thursdayTwentyOne??>
            <@inside.inside times = thursdayTwentyOne />
        </#if>
        </th>
        <th>
            <#if fridayTwentyOne??>
            <@inside.inside times = fridayTwentyOne />
        </#if>
        </th>
        <th>
            <#if saturdayTwentyOne??>
            <@inside.inside times = saturdayTwentyOne />
        </#if>
        </th>
        <th>
            <#if sundayTwentyOne??>
            <@inside.inside times = sundayTwentyOne />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>22:00</th>
        <#if twentyTwo??>
        <th>
            <#if mondayTwentyTwo??>
            <@inside.inside times = mondayTwentyTwo />
        </#if>
        </th>
        <th>
            <#if tuesdayTwentyTwo??>
            <@inside.inside times = tuesdayTwentyTwo />
        </#if>
        </th>
        <th>
            <#if wednesdayTwentyTwo??>
            <@inside.inside times = wednesdayTwentyTwo />
        </#if>
        </th>
        <th>
            <#if thursdayTwentyTwo??>
            <@inside.inside times = thursdayTwentyTwo />
        </#if>
        </th>
        <th>
            <#if fridayTwentyTwo??>
            <@inside.inside times = fridayTwentyTwo/>
        </#if>
        </th>
        <th>
            <#if saturdayTwentyTwo??>
            <@inside.inside times = saturdayTwentyTwo />
        </#if>
        </th>
        <th>
            <#if sundayTwentyTwo??>
            <@inside.inside times = sundayTwentyTwo />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    <tr>
        <th>23:00</th>
        <#if twentyThree??>
        <th>
            <#if mondayTwentyThree??>
            <@inside.inside times = mondayTwentyThree />
        </#if>
        </th>
        <th>
            <#if tuesdayTwentyThree??>
            <@inside.inside times = tuesdayTwentyThree />
        </#if>
        </th>
        <th>
            <#if wednesdayTwentyThree??>
            <@inside.inside times = wednesdayTwentyThree />
        </#if>
        </th>
        <th>
            <#if thursdayTwentyThree??>
            <@inside.inside times = thursdayTwentyThree />
        </#if>
        </th>
        <th>
            <#if fridayTwentyThree??>
            <@inside.inside times = fridayTwentyThree/>
        </#if>
        </th>
        <th>
            <#if saturdayTwentyThree??>
            <@inside.inside times = saturdayTwentyThree />
        </#if>
        </th>
        <th>
            <#if sundayTwentyThree??>
            <@inside.inside times = sundayTwentyThree />
        </#if>
        </th>
        <th></th>
        <#else>
        <@string.emptyStr />
    </#if>
    </tr>
    </tbody>
</table>
</#macro>



