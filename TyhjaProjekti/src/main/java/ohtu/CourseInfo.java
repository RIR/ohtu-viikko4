package ohtu;

public class CourseInfo {

    private String name;
    private String term;
    private String week1;
    private String week2;
    private String week3;
    private String week4;
    private String week5;
    private String week6;

    public String getName() {
        return name;
    }

    public String getTerm() {
        return term;
    }

    public String getWeek(int week) {
        switch (week) {
            case 1:
                return week1;
            case 2:
                return week2;
            case 3:
                return week3;
            case 4:
                return week4;
            case 5:
                return week5;
            case 6:
                return week6;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Kurssi: " + getName() + ", " + getTerm();
    }

}
