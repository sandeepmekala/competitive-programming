package com.java.java8new.li09.dateapi;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateApi {
    public static void main(String[] args) {
        // Date API --------------------------------------------------------
		Clock clock = Clock.systemDefaultZone();
		long millis3 = clock.millis();
		System.out.println("Millis: " + millis3);

		Instant instant = clock.instant();
		System.out.println("Instant: " + instant);
		Date legacyDate = Date.from(instant);
		System.out.println("Date: " + legacyDate);

		System.out.println(ZoneId.getAvailableZoneIds());
		ZoneId zone1 = ZoneId.of("Europe/Berlin");
		ZoneId zone2 = ZoneId.of("Brazil/East");
		System.out.println(zone1.getRules());
		System.out.println(zone2.getRules());

		LocalTime now1 = LocalTime.now(zone1);
		LocalTime now2 = LocalTime.now(zone2);
		System.out.println(now1.isBefore(now2));

		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
		System.out.println(hoursBetween);
		long minutsBetween = ChronoUnit.MINUTES.between(now1, now2);
		System.out.println(minutsBetween);

		LocalTime localTime = LocalTime.of(23, 59, 59);
		System.out.println(localTime);

		DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
				.withLocale(Locale.GERMAN);
		LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
		System.out.println(leetTime);

		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = tomorrow.minusDays(2);
		System.out.println(yesterday);

		LocalDate independenceDay = LocalDate.of(2014, Month.AUGUST, 15);
		DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
		System.out.println(dayOfWeek);

		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
				.withLocale(Locale.GERMAN);
		LocalDate xmas = LocalDate.parse("24.12.2014", dateTimeFormatter2);
		System.out.println(xmas);

		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
		DayOfWeek dayOfWeek2 = sylvester.getDayOfWeek();
		System.out.println(dayOfWeek2);
		Month month = sylvester.getMonth();
		System.out.println(month);
		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
		System.out.println(minuteOfDay);

		Instant instant2 = sylvester.atZone(ZoneId.systemDefault()).toInstant();
		Date legacyDate2 = Date.from(instant2);
		System.out.println(legacyDate2);

		DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");
		LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", dateTimeFormatter3);
		String string = dateTimeFormatter3.format(parsed);
		System.out.println(string);

		// Date API --------------------------------------------------------
    }
}
