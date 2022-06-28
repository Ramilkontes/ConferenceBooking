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
            <@inside.inside times = mondayZero flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayZero??>
            <@inside.inside times = tuesdayZero flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayZero??>
            <@inside.inside times = wednesdayZero flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayZero??>
            <@inside.inside times = thursdayZero flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayZero??>
            <@inside.inside times = fridayZero flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayZero??>
            <@inside.inside times = saturdayZero flag = SATURDAY />
        </#if>
        </th>
        <th>
            <#if sundayZero??>
            <@inside.inside times = sundayZero flag = SUNDAY />
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
            <@inside.inside times = mondayOne flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayOne??>
            <@inside.inside times = tuesdayOne flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayOne??>
            <@inside.inside times = wednesdayOne flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayOne??>
            <@inside.inside times = thursdayOne flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayOne??>
            <@inside.inside times = fridayOne flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayOne??>
            <@inside.inside times = saturdayOne flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayOne??>
            <@inside.inside times = sundayOne flag = SUNDAY />
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
            <@inside.inside times = mondayTwo flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayTwo??>
            <@inside.inside times = tuesdayTwo flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayTwo??>
            <@inside.inside times = wednesdayTwo flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayTwo??>
            <@inside.inside times = thursdayTwo flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayTwo??>
            <@inside.inside times = fridayTwo flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayTwo??>
            <@inside.inside times = saturdayTwo flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayTwo??>
            <@inside.inside times = sundayTwo flag = SUNDAY />
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
            <@inside.inside times = mondayThree flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayThree??>
            <@inside.inside times = tuesdayThree flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayThree??>
            <@inside.inside times = wednesdayThree flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayThree??>
            <@inside.inside times = thursdayThree flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayThree??>
            <@inside.inside times = fridayThree flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayThree??>
            <@inside.inside times = saturdayThree flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayThree??>
            <@inside.inside times = sundayThree flag = SUNDAY />
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
            <@inside.inside times = mondayFour flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayFour??>
            <@inside.inside times = tuesdayFour flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayFour??>
            <@inside.inside times = wednesdayFour flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayFour??>
            <@inside.inside times = thursdayFour flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayFour??>
            <@inside.inside times = fridayFour flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayFour??>
            <@inside.inside times = saturdayFour flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayFour??>
            <@inside.inside times = sundayFour flag = SUNDAY />
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
            <@inside.inside times = mondayFive flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayFive??>
            <@inside.inside times = tuesdayFive flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayFive??>
            <@inside.inside times = wednesdayFive flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayFive??>
            <@inside.inside times = thursdayFive flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayFive??>
            <@inside.inside times = fridayFive flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayFive??>
            <@inside.inside times = saturdayFive flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayFive??>
            <@inside.inside times = sundayFive flag = SUNDAY />
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
            <@inside.inside times = mondaySix flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdaySix??>
            <@inside.inside times = tuesdaySix flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdaySix??>
            <@inside.inside times = wednesdaySix flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdaySix??>
            <@inside.inside times = thursdaySix flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridaySix??>
            <@inside.inside times = fridaySix flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdaySix??>
            <@inside.inside times = saturdaySix flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundaySix??>
            <@inside.inside times = sundaySix flag = SUNDAY />
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
            <@inside.inside times = mondaySeven flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdaySeven??>
            <@inside.inside times = tuesdaySeven flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdaySeven??>
            <@inside.inside times = wednesdaySeven flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdaySeven??>
            <@inside.inside times = thursdaySeven flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridaySeven??>
            <@inside.inside times = fridaySeven flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdaySeven??>
            <@inside.inside times = saturdaySeven flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundaySeven??>
            <@inside.inside times = sundaySeven flag = SUNDAY />
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
            <@inside.inside times = mondayEight flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayEight??>
            <@inside.inside times = tuesdayEight flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayEight??>
            <@inside.inside times = wednesdayEight flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayEight??>
            <@inside.inside times = thursdayEight flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayEight??>
            <@inside.inside times = fridayEight flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayEight??>
            <@inside.inside times = saturdayEight flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayEight??>
            <@inside.inside times = sundayEight flag = SUNDAY />
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
            <@inside.inside times = mondayNine flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayNine??>
            <@inside.inside times = tuesdayNine flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayNine??>
            <@inside.inside times = wednesdayNine flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayNine??>
            <@inside.inside times = thursdayNine flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayNine??>
            <@inside.inside times = fridayNine flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayNine??>
            <@inside.inside times = saturdayNine flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayNine??>
            <@inside.inside times = sundayNine flag = SUNDAY />
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
            <@inside.inside times = mondayTen flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayTen??>
            <@inside.inside times = tuesdayTen flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayTen??>
            <@inside.inside times = wednesdayTen flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayTen??>
            <@inside.inside times = thursdayTen flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayTen??>
            <@inside.inside times = fridayTen flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayTen??>
            <@inside.inside times = saturdayTen flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayTen??>
            <@inside.inside times = sundayTen flag = SUNDAY />
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
            <@inside.inside times = mondayEleven flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayEleven??>
            <@inside.inside times = tuesdayEleven flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayEleven??>
            <@inside.inside times = wednesdayEleven flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayEleven??>
            <@inside.inside times = thursdayEleven flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayEleven??>
            <@inside.inside times = fridayEleven flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayEleven??>
            <@inside.inside times = saturdayEleven flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayEleven??>
            <@inside.inside times = sundayEleven flag = SUNDAY />
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
            <@inside.inside times = mondayTwelve flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayTwelve??>
            <@inside.inside times = tuesdayTwelve flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayTwelve??>
            <@inside.inside times = wednesdayTwelve flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayTwelve??>
            <@inside.inside times = thursdayTwelve flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayTwelve??>
            <@inside.inside times = fridayTwelve flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayTwelve??>
            <@inside.inside times = saturdayTwelve flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayTwelve??>
            <@inside.inside times = sundayTwelve flag = SUNDAY />
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
            <@inside.inside times = mondayThirteen flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayThirteen??>
            <@inside.inside times = tuesdayThirteen flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayThirteen??>
            <@inside.inside times = wednesdayThirteen flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayThirteen??>
            <@inside.inside times = thursdayThirteen flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayThirteen??>
            <@inside.inside times = fridayThirteen flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayThirteen??>
            <@inside.inside times = saturdayThirteen flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayThirteen??>
            <@inside.inside times = sundayThirteen flag = SUNDAY />
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
            <@inside.inside times = mondayFourteen flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayFourteen??>
            <@inside.inside times = tuesdayFourteen flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayFourteen??>
            <@inside.inside times = wednesdayFourteen flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayFourteen??>
            <@inside.inside times = thursdayFourteen flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayFourteen??>
            <@inside.inside times = fridayFourteen flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayFourteen??>
            <@inside.inside times = saturdayFourteen flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayFourteen??>
            <@inside.inside times = sundayFourteen flag = SUNDAY />
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
            <@inside.inside times = mondayFifteen flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayFifteen??>
            <@inside.inside times = tuesdayFifteen flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayFifteen??>
            <@inside.inside times = wednesdayFifteen flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayFifteen??>
            <@inside.inside times = thursdayFifteen flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayFifteen??>
            <@inside.inside times = fridayFifteen flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayFifteen??>
            <@inside.inside times = saturdayFifteen flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayFifteen??>
            <@inside.inside times = sundayFifteen flag = SUNDAY />
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
            <@inside.inside times = mondaySixteen flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdaySixteen??>
            <@inside.inside times = tuesdaySixteen flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdaySixteen??>
            <@inside.inside times = wednesdaySixteen flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdaySixteen??>
            <@inside.inside times = thursdaySixteen flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridaySixteen??>
            <@inside.inside times = fridaySixteen flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdaySixteen??>
            <@inside.inside times = saturdaySixteen flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundaySixteen??>
            <@inside.inside times = sundaySixteen flag = SUNDAY />
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
            <@inside.inside times = mondaySeventeen flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdaySeventeen??>
            <@inside.inside times = tuesdaySeventeen flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdaySeventeen??>
            <@inside.inside times = wednesdaySeventeen flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdaySeventeen??>
            <@inside.inside times = thursdaySeventeen flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridaySeventeen??>
            <@inside.inside times = fridaySeventeen flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdaySeventeen??>
            <@inside.inside times = saturdaySeventeen flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundaySeventeen??>
            <@inside.inside times = sundaySeventeen flag = SUNDAY />
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
            <@inside.inside times = mondayEighteen flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayEighteen??>
            <@inside.inside times = tuesdayEighteen flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayEighteen??>
            <@inside.inside times = wednesdayEighteen flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayEighteen??>
            <@inside.inside times = thursdayEighteen flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayEighteen??>
            <@inside.inside times = fridayEighteen flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayEighteen??>
            <@inside.inside times = saturdayEighteen flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayEighteen??>
            <@inside.inside times = sundayEighteen flag = SUNDAY />
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
            <@inside.inside times = mondayNineteen flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayNineteen??>
            <@inside.inside times = tuesdayNineteen flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayNineteen??>
            <@inside.inside times = wednesdayNineteen flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayNineteen??>
            <@inside.inside times = thursdayNineteen flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayNineteen??>
            <@inside.inside times = fridayNineteen flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayNineteen??>
            <@inside.inside times = saturdayNineteen flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayNineteen??>
            <@inside.inside times = sundayNineteen flag = SUNDAY />
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
            <@inside.inside times = mondayTwenty flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayTwenty??>
            <@inside.inside times = tuesdayTwenty flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayTwenty??>
            <@inside.inside times = wednesdayTwenty flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayTwenty??>
            <@inside.inside times = thursdayTwenty flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayTwenty??>
            <@inside.inside times = fridayTwenty flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayTwenty??>
            <@inside.inside times = saturdayTwenty flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayTwenty??>
            <@inside.inside times = sundayTwenty flag = SUNDAY />
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
            <@inside.inside times = mondayTwentyOne flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayTwentyOne??>
            <@inside.inside times = tuesdayTwentyOne flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayTwentyOne??>
            <@inside.inside times = wednesdayTwentyOne flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayTwentyOne??>
            <@inside.inside times = thursdayTwentyOne flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayTwentyOne??>
            <@inside.inside times = fridayTwentyOne flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayTwentyOne??>
            <@inside.inside times = saturdayTwentyOne flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayTwentyOne??>
            <@inside.inside times = sundayTwentyOne flag = SUNDAY />
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
            <@inside.inside times = mondayTwentyTwo flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayTwentyTwo??>
            <@inside.inside times = tuesdayTwentyTwo flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayTwentyTwo??>
            <@inside.inside times = wednesdayTwentyTwo flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayTwentyTwo??>
            <@inside.inside times = thursdayTwentyTwo flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayTwentyTwo??>
            <@inside.inside times = fridayTwentyTwo flag = FRIDAY/>
        </#if>
        </th>
        <th>
            <#if saturdayTwentyTwo??>
            <@inside.inside times = saturdayTwentyTwo flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayTwentyTwo??>
            <@inside.inside times = sundayTwentyTwo flag = SUNDAY />
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
            <@inside.inside times = mondayTwentyThree flag = MONDAY />
        </#if>
        </th>
        <th>
            <#if tuesdayTwentyThree??>
            <@inside.inside times = tuesdayTwentyThree flag = TUESDAY />
        </#if>
        </th>
        <th>
            <#if wednesdayTwentyThree??>
            <@inside.inside times = wednesdayTwentyThree flag = WEDNESDAY />
        </#if>
        </th>
        <th>
            <#if thursdayTwentyThree??>
            <@inside.inside times = thursdayTwentyThree flag = THURSDAY />
        </#if>
        </th>
        <th>
            <#if fridayTwentyThree??>
            <@inside.inside times = fridayTwentyThree flag = FRIDAY />
        </#if>
        </th>
        <th>
            <#if saturdayTwentyThree??>
            <@inside.inside times = saturdayTwentyThree flag = SATURDAY  />
        </#if>
        </th>
        <th>
            <#if sundayTwentyThree??>
            <@inside.inside times = sundayTwentyThree flag = SUNDAY />
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