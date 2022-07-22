mobiscroll.setOptions({
    locale: mobiscroll.localeRu,
    theme: 'ios',
    themeVariant: 'light'
});

$(function () {
    var formatDate = mobiscroll.util.datetime.formatDate;
    var currentEvent;
    var timer;
    var $tooltip = $('#custom-event-tooltip-popup');
    var $deleteButton = $('#tooltip-event-delete');
    var $fileButton = $('#tooltip-event-view');
    var $statusButton = $('#tooltip-event-status');
    var $header = $('.md-tooltip-header');
    var $data = $('.md-tooltip-name-age');
    var $time = $('.md-tooltip-time');
    var $status = $('.md-tooltip-status');
    var $reason = $('.md-tooltip-reason');
    var $location = $('.md-tooltip-location');

    var calendar = $('#demo-custom-event-tooltip').mobiscroll().eventcalendar({
        view: {
            calendar: {
                type: 'week',
                startDay: 1,
                endDay: 5,
                allDay: false
            }
        },
        height: 260,
        data: [],
        clickToCreate: false,
        dragToCreate: false,
        showEventTooltip: false,
        onEventHoverIn: function (args, inst) {
            var event = args.event;
            var time = formatDate('hh:mm A', new Date(event.start)) + ' - ' + formatDate('hh:mm A', new Date(event.end));
            var button = {};

            currentEvent = event;

            if (event.confirmed) {
                button.status = 'Confirmed';
                button.text = 'Cancel appointment';
                button.type = 'warning';
            } else {
                button.status = 'Canceled';
                button.text = 'Confirm appointment';
                button.type = 'success';
            }

            $header.css('background-color', event.color);
            $data.text(event.title + ', Age: ' + event.age);
            $time.text(time);

            $status.text(button.status);
            $reason.text(event.reason);
            $location.text(event.location);

            $statusButton.text(button.text);
            $statusButton.mobiscroll('setOptions', { color: button.type });

            clearTimeout(timer);
            timer = null;

            tooltip.setOptions({ anchor: args.domEvent.target });
            tooltip.open();
        },
        onEventHoverOut: function (args) {
            if (!timer) {
                timer = setTimeout(function () {
                    tooltip.close();
                }, 200);
            }
        }
    }).mobiscroll('getInst');

    var tooltip = $tooltip.mobiscroll().popup({
        display: 'anchored',
        touchUi: false,
        showOverlay: false,
        contentPadding: false,
        width: 350
    }).mobiscroll('getInst');

    $tooltip.mouseenter(function (ev) {
        if (timer) {
            clearTimeout(timer);
            timer = null;
        }
    });

    $tooltip.mouseleave(function (ev) {
        timer = setTimeout(function () {
            tooltip.close();
        }, 200);
    });

    $deleteButton.on('click', function (ev) {
        calendar.removeEvent(currentEvent);

        tooltip.close();

        mobiscroll.toast({
            message: 'Appointment deleted'
        });
    });

    $fileButton.on('click', function (ev) {
        tooltip.close();

        mobiscroll.toast({
            message: 'View file'
        });
    });

    $statusButton.on('click', function (ev) {
        tooltip.close();
        currentEvent.confirmed = !currentEvent.confirmed;
        calendar.updateEvent(currentEvent);

        mobiscroll.toast({
            message: 'Appointment ' + (currentEvent.confirmed ? 'confirmed' : 'canceled')
        });
    });

});