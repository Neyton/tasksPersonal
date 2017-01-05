$(function () {
    $("#selecter").each(function () {
        $(this).change(function () {
            var rel = $(this).val();
            if (rel == 1) {
                $("#inputStart").val(lastStartDate(new Date(), 3));
                $("#inputEnd").val(lastEndDate(new Date()));
            }
            if (rel == 2) {
                $("#inputStart").val(lastStartDate(new Date(), 1));
                $("#inputEnd").val(lastEndDate(new Date()));
            }
            if (rel == 3) {
                $("#inputStart").val(lastCalendarYear(new Date(), "start"));
                $("#inputEnd").val(lastCalendarYear(new Date(), "end"));
            }
            if (rel == 4) {
                $("#inputStart").val(currentToDateStart(new Date(), 12));
                $("#inputEnd").val(currentToDateEnd(new Date()));
            }
            if (rel == 5) {
                $("#inputStart").val(currentToDateStart(new Date(), 3));
                $("#inputEnd").val(currentToDateEnd(new Date()));
            }
            if (rel == 6) {
                $("#inputStart").val(currentToDateStart(new Date(), 1));
                $("#inputEnd").val(currentToDateEnd(new Date()));
            }

        });
    });



    function findMonth(month) {
        switch (month) {
            case 0:
                fMonth = "Jan";
                break;
            case 1:
                fMonth = "Feb";
                break;
            case 2:
                fMonth = "Mar";
                break;
            case 3:
                fMonth = "Apr";
                break;
            case 4:
                fMonth = "May";
                break;
            case 5:
                fMonth = "Jun";
                break;
            case 6:
                fMonth = "Jul";
                break;
            case 7:
                fMonth = "Aug";
                break;
            case 8:
                fMonth = "Sep";
                break;
            case 9:
                fMonth = "Oct";
                break;
            case 10:
                fMonth = "Nov";
                break;
            case 11:
                fMonth = "Dec";
                break;
        }
        return fMonth;
    }

    function getLastDayOfMonth() {
        var now = new Date();
        var date = new Date(now.getFullYear(), now.getMonth(), 0);
        return date.getDate();
    }

    function lastStartDate(today, kol) {
        today.setMonth(today.getMonth() - kol);
        var month = today.getMonth();
        var year = today.getFullYear();
        var textMonth = findMonth(month);
        return textMonth + " " + "1," + year;
    }

    function lastEndDate(today) {
        today.setMonth(today.getMonth() - 1);
        var month = today.getMonth();
        var year = today.getFullYear();
        var textMonth = findMonth(month);
        var day = getLastDayOfMonth();
        return textMonth + " " + day + "," + year;
    }

    function lastCalendarYear(today, se) {
        var year = today.getFullYear() - 1;
        if (se == "start") {
            var textMonth = findMonth(0);
            return textMonth + " " + "1," + year;
        }
        if (se == "end") {
            var textMonth = findMonth(11);
            return textMonth + " " + "31," + year;
        }
    }

    function currentToDateStart(today, kol) {
        today.setMonth(today.getMonth() - kol);
        var day = today.getDate();
        var month = today.getMonth();
        var year = today.getFullYear();
        var textMonth = findMonth(month);
        return textMonth + " " + day + "," + year;
    }

    function currentToDateEnd(today) {
        var day = today.getDate();
        var month = today.getMonth();
        var year = today.getFullYear();
        var textMonth = findMonth(month);
        return textMonth + " " + day + "," + year;
    }

});
