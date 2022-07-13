package com.local.conferencebooking.services;

import com.local.conferencebooking.models.Event;
import com.local.conferencebooking.models.User;
import com.local.conferencebooking.repositories.EventRepositories;
import com.local.conferencebooking.repositories.UserRepositories;
import com.local.conferencebooking.transfer.AdminEventsDto;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import static com.local.conferencebooking.transfer.AdminEventsDto.*;

@Service
public class MeetRoomServiceImpl implements MeetRoomService {

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private EventRepositories eventRepositories;

    @Autowired
    private UserService userService;

    @Override
    public List<User> getAllPeople() {
        return userRepositories.findAll();
    }

    @Override
    public List<AdminEventsDto> getAllRooms() {
        return from(eventRepositories.findAll());
    }

    @Override
    public void getModels(Model model, LocalDateTime date) {
        List<LocalDate> week = getWeek(date.toLocalDate());
        List<Event> currentEvents = findEventsOfCurrentWeek(date);
        model.addAttribute("week", week);
        model.addAllAttributes(userService.getFlagsByDays(week));
        model.addAllAttributes(getEventsByTime(currentEvents));
        model.addAllAttributes(getEventsByDay(week, currentEvents));
    }

    @Override
    public List<Event> getMyConcernments(Long id) {
        User user = userRepositories.getById(id);
        return user.getEvents();
    }

    @Override
    public List<LocalDate> getWeek(LocalDate dateParam) {
        List<LocalDate> weekDayList = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        Date date = Date.from(dateParam.atStartOfDay(ZoneId.systemDefault()).toInstant());
        cal.setTime(date);
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        return getWeek(weekDayList, cal, dayWeek);
    }

    @Override
    public LocalDateTime getRequiredDate(LocalDateTime day, Integer pointer) {
        LocalDateTime requiredDay;
        if (pointer < 0) {
            requiredDay = day.minusWeeks(1);
        } else {
            requiredDay = day.plusWeeks(1);
        }
        return requiredDay;
    }

    private List<Event> getCurrentEvent(List<LocalDate> week) {
        return eventRepositories.findAll().stream()
                .filter(x -> week.contains(x.getDateStart().toLocalDate()))
                .sorted(Comparator.comparing(Event::getDateStart))
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> findEventsOfCurrentWeek(LocalDateTime currentDate) {
        LocalDateTime from = currentDate.with(DayOfWeek.MONDAY).toLocalDate().atTime(LocalTime.MIN);
        LocalDateTime to = currentDate.with(DayOfWeek.SUNDAY).toLocalDate().atTime(LocalTime.MAX);
        return eventRepositories.findAllByDateStartBetween(from, to).stream()
                .sorted(Comparator.comparing(Event::getDateStart))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Event>> getEventsByDay(List<LocalDate> week, List<Event> events) {
        Map<String, List<Event>> eventsByDay = new HashMap<>();
        if(!events.isEmpty()){
            events.forEach((k)->{
                LocalDate dateStartEvent = k.getDateStart().toLocalDate();
                LocalTime timeStartEvent = k.getDateStart().toLocalTime();
                if(week.contains(dateStartEvent)){
                    eventsByDay.putAll(caseForDay(eventsByDay, k, dateStartEvent, timeStartEvent));
                }
            });
            return eventsByDay;
        }
        else return null;
    }

    @Override
    public Map<String, Boolean> getEventsByTime(List<Event> events) {
        Map<String, Boolean> eventsByTime = new HashMap<>();
        if (!events.isEmpty()) {
            events.forEach(k -> {
                LocalTime timeStartEvent = k.getDateStart().toLocalTime();
                eventsByTime.putAll(caseForTime(eventsByTime, timeStartEvent));
            });
            return eventsByTime;
        }
        else return null;
    }

    private List<LocalDate> getWeek(List<LocalDate> weekDayList, Calendar cal, int dayWeek) {
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cal.add(Calendar.DATE, 1);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cal.add(Calendar.DATE, 1);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cal.add(Calendar.DATE, 1);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cal.add(Calendar.DATE, 1);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cal.add(Calendar.DATE, 1);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        cal.add(Calendar.DATE, 1);
        weekDayList.add(cal.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        return weekDayList;
    }

    private Map<String, List<Event>> caseForDay(Map<String, List<Event>> eventsByDate, Event k, LocalDate dateStartEvent, LocalTime timeStart) {
        if(dateStartEvent.getDayOfWeek().equals(DayOfWeek.MONDAY)){
            mapChangeByDayAndTime(eventsByDate, k, "monday", timeStart);
        }
        else if(dateStartEvent.getDayOfWeek().equals(DayOfWeek.TUESDAY)){
            mapChangeByDayAndTime(eventsByDate, k, "tuesday", timeStart);
        }
        else if(dateStartEvent.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)){
            mapChangeByDayAndTime(eventsByDate, k, "wednesday", timeStart);
        }
        else if(dateStartEvent.getDayOfWeek().equals(DayOfWeek.THURSDAY)){
            mapChangeByDayAndTime(eventsByDate, k, "thursday", timeStart);
        }
        else if(dateStartEvent.getDayOfWeek().equals(DayOfWeek.FRIDAY)){
            mapChangeByDayAndTime(eventsByDate, k, "friday", timeStart);
        }
        else if(dateStartEvent.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
            mapChangeByDayAndTime(eventsByDate, k, "saturday", timeStart);
        }
        else if(dateStartEvent.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
            mapChangeByDayAndTime(eventsByDate, k, "sunday", timeStart);
        }
        return eventsByDate;
    }

    private void mapChangeByDayAndTime(Map<String, List<Event>> eventsByDay, Event k, String day, LocalTime time) {
        List<Event> eventList = new ArrayList<>();
        String key = day+getNameOfTime(time);
        if (eventsByDay.containsKey(key)) {
            eventList = eventsByDay.get(day);
            eventList.add(k);
            eventsByDay.put(day, eventList);
        } else {
            eventList.add(k);
            eventsByDay.put(key, eventList);
        }
    }

    private Map<String, Boolean> caseForTime(Map<String, Boolean> eventsTime, LocalTime timeStartEvent) {
        if (comparison(timeStartEvent, LocalTime.of(0, 0), LocalTime.of(1, 0))) {
            mapChangeByTime(eventsTime, "zero");
        } else if (comparison(timeStartEvent, LocalTime.of(1, 0), LocalTime.of(2, 0))) {
            mapChangeByTime(eventsTime, "one");
        } else if (comparison(timeStartEvent, LocalTime.of(2, 0), LocalTime.of(3, 0))) {
            mapChangeByTime(eventsTime,"two");
        } else if (comparison(timeStartEvent, LocalTime.of(3, 0), LocalTime.of(4, 0))) {
            mapChangeByTime(eventsTime,"three");
        } else if (comparison(timeStartEvent, LocalTime.of(4, 0), LocalTime.of(5, 0))) {
            mapChangeByTime(eventsTime,"four");
        } else if (comparison(timeStartEvent, LocalTime.of(5, 0), LocalTime.of(6, 0))) {
            mapChangeByTime(eventsTime,"five");
        } else if (comparison(timeStartEvent, LocalTime.of(6, 0), LocalTime.of(7, 0))) {
            mapChangeByTime(eventsTime,"six");
        } else if (comparison(timeStartEvent, LocalTime.of(7, 0), LocalTime.of(8, 0))) {
            mapChangeByTime(eventsTime,"seven");
        } else if (comparison(timeStartEvent, LocalTime.of(8, 0), LocalTime.of(9, 0))) {
            mapChangeByTime(eventsTime,"eight");
        } else if (comparison(timeStartEvent, LocalTime.of(9, 0), LocalTime.of(10, 0))) {
            mapChangeByTime(eventsTime,"nine");
        } else if (comparison(timeStartEvent, LocalTime.of(10, 0), LocalTime.of(11, 0))) {
            mapChangeByTime(eventsTime,"ten");
        } else if (comparison(timeStartEvent, LocalTime.of(11, 0), LocalTime.of(12, 0))) {
            mapChangeByTime(eventsTime,"eleven");
        } else if (comparison(timeStartEvent, LocalTime.of(12, 0), LocalTime.of(13, 0))) {
            mapChangeByTime(eventsTime,"twelve");
        } else if (comparison(timeStartEvent, LocalTime.of(13, 0), LocalTime.of(14, 0))) {
            mapChangeByTime(eventsTime,"thirteen");
        } else if (comparison(timeStartEvent, LocalTime.of(14, 0), LocalTime.of(15, 0))) {
            mapChangeByTime(eventsTime,"fourteen");
        } else if (comparison(timeStartEvent, LocalTime.of(15, 0), LocalTime.of(16, 0))) {
            mapChangeByTime(eventsTime,"fifteen");
        } else if (comparison(timeStartEvent, LocalTime.of(16, 0), LocalTime.of(17, 0))) {
            mapChangeByTime(eventsTime,"sixteen");
        } else if (comparison(timeStartEvent, LocalTime.of(17, 0), LocalTime.of(18, 0))) {
            mapChangeByTime(eventsTime, "seventeen");
        } else if (comparison(timeStartEvent, LocalTime.of(18, 0), LocalTime.of(19, 0))) {
            mapChangeByTime(eventsTime, "eighteen");
        } else if (comparison(timeStartEvent, LocalTime.of(19, 0), LocalTime.of(20, 0))) {
            mapChangeByTime(eventsTime, "nineteen");
        } else if (comparison(timeStartEvent, LocalTime.of(20, 0), LocalTime.of(21, 0))) {
            mapChangeByTime(eventsTime, "twenty");
        } else if (comparison(timeStartEvent, LocalTime.of(21, 0), LocalTime.of(22, 0))) {
            mapChangeByTime(eventsTime,"twentyOne");
        } else if (comparison(timeStartEvent, LocalTime.of(22, 0), LocalTime.of(23, 0))) {
            mapChangeByTime(eventsTime, "twentyTwo");
        } else if (comparison(timeStartEvent, LocalTime.of(23, 0), LocalTime.of(23, 59))) {
            mapChangeByTime(eventsTime,"twentyThree");
        }
        return eventsTime;
    }

    private String getNameOfTime (LocalTime timeStartEvent) {
        if (comparison(timeStartEvent, LocalTime.of(0, 0), LocalTime.of(1, 0))) {
           return "Zero";
        } else if (comparison(timeStartEvent, LocalTime.of(1, 0), LocalTime.of(2, 0))) {
            return "One";
        } else if (comparison(timeStartEvent, LocalTime.of(2, 0), LocalTime.of(3, 0))) {
            return "Two";
        } else if (comparison(timeStartEvent, LocalTime.of(3, 0), LocalTime.of(4, 0))) {
            return "Three";
        } else if (comparison(timeStartEvent, LocalTime.of(4, 0), LocalTime.of(5, 0))) {
            return "Four";
        } else if (comparison(timeStartEvent, LocalTime.of(5, 0), LocalTime.of(6, 0))) {
            return "Five";
        } else if (comparison(timeStartEvent, LocalTime.of(6, 0), LocalTime.of(7, 0))) {
            return "Six";
        } else if (comparison(timeStartEvent, LocalTime.of(7, 0), LocalTime.of(8, 0))) {
            return "Seven";
        } else if (comparison(timeStartEvent, LocalTime.of(8, 0), LocalTime.of(9, 0))) {
            return "Eight";
        } else if (comparison(timeStartEvent, LocalTime.of(9, 0), LocalTime.of(10, 0))) {
            return "Nine";
        } else if (comparison(timeStartEvent, LocalTime.of(10, 0), LocalTime.of(11, 0))) {
            return "Ten";
        } else if (comparison(timeStartEvent, LocalTime.of(11, 0), LocalTime.of(12, 0))) {
            return "Eleven";
        } else if (comparison(timeStartEvent, LocalTime.of(12, 0), LocalTime.of(13, 0))) {
           return "Twelve";
        } else if (comparison(timeStartEvent, LocalTime.of(13, 0), LocalTime.of(14, 0))) {
            return "Thirteen";
        } else if (comparison(timeStartEvent, LocalTime.of(14, 0), LocalTime.of(15, 0))) {
           return "Fourteen";
        } else if (comparison(timeStartEvent, LocalTime.of(15, 0), LocalTime.of(16, 0))) {
            return "Fifteen";
        } else if (comparison(timeStartEvent, LocalTime.of(16, 0), LocalTime.of(17, 0))) {
           return "Sixteen";
        } else if (comparison(timeStartEvent, LocalTime.of(17, 0), LocalTime.of(18, 0))) {
            return "Seventeen";
        } else if (comparison(timeStartEvent, LocalTime.of(18, 0), LocalTime.of(19, 0))) {
           return "Eighteen";
        } else if (comparison(timeStartEvent, LocalTime.of(19, 0), LocalTime.of(20, 0))) {
            return "Nineteen";
        } else if (comparison(timeStartEvent, LocalTime.of(20, 0), LocalTime.of(21, 0))) {
            return "Twenty";
        } else if (comparison(timeStartEvent, LocalTime.of(21, 0), LocalTime.of(22, 0))) {
            return "TwentyOne";
        } else if (comparison(timeStartEvent, LocalTime.of(22, 0), LocalTime.of(23, 0))) {
            return "TwentyTwo";
        } else if (comparison(timeStartEvent, LocalTime.of(23, 0), LocalTime.of(23, 59))) {
            return "TwentyThree";
        }
        return null;
    }

    private boolean comparison(LocalTime type, LocalTime first, LocalTime second) {
        return (type.isAfter(first) || type.equals(first)) && type.isBefore(second);
    }

    private void mapChangeByTime(Map<String, Boolean> eventsByTime, String time) {
        eventsByTime.putIfAbsent(time, true);
    }
}
