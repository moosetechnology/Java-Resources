package parametric;

public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY ;

    static public String whatAmI() {
        return "I am an Enum";
    }

    public static void main(String[] args) {
        String theAnswer = Day.whatAmI(); // The Enum Day is the receiver.
        String monday = Day.MONDAY.name(); // The enum value MONDAY is the receiver.

        System.out.println(theAnswer);
        System.out.println(monday);
    }

}