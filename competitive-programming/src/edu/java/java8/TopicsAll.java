package edu.java.java8;

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

//Default Methods for Interfaces
//Lambda expressions
//Functional Interfaces
//Method and Constructor References
//Lamda scopes
//Built-in Functional Interfaces
//Streams
//Parallel Streams
//Map
//Date API
public class TopicsAll {
	static int outerstaticnum;
	int outernum;

	public static void main(String arge[]) {
		TopicsAll java8 = new TopicsAll();
		java8.java();
	}

	private void java() {
		
		
	}

	interface Formula {
		double calculate(int a);

		default double sqrt(int a) {
			return Math.sqrt(a);
		}
	}

	

}
