package com.java.enums;

public enum DayOfWeek {
    SUNDAY("Sun"), 
    MONDAY("Mon"), 
    TUESDAY("Tue"), 
    WEDNESDAY("Wed"), 
    THURSDAY("Thu"), 
    FRIDAY("Fri"), 
    SATURDAY("Sat");

    // We can have fields for each enum value and a constructor to initialize the field value
    // Make it final so that it cannot be changed by consumer
    final String shortcut;

    DayOfWeek(String shortcut) {
        this.shortcut = shortcut;
    }

    public static void main(String[] args) {
        DayOfWeek day = DayOfWeek.SUNDAY;
        System.out.println(day.ordinal());
        System.out.println(day.name());

        // By default every enum class extends Enum class
        // Enum class has a method values() which returns all the values of the enum class
        for (DayOfWeek d : DayOfWeek.values()) {
            System.out.println(d);
        }

        System.out.println(DayOfWeek.MONDAY.shortcut);
    }
}
