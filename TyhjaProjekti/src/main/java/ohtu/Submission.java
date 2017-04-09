package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Submission {

    private CourseInfo courseInfo = new CourseInfo();
    private String student_number;
    private String week;
    private int hours;
    private List<Boolean> tasks = new ArrayList<Boolean>();
    private List<Boolean> tasksDone = new ArrayList<Boolean>();
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;

    public String getStudent_number() {
        return student_number;
    }

    public int getHours() {
        return hours;
    }

    public String getWeek() {
        return week;
    }

    public List<Boolean> getTasks() {
        return tasks;
    }

    public List<Boolean> getTasksDone() {
        return tasksDone;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public void setTasks() {
        List<Boolean> tempTasks = new ArrayList<>();
        tempTasks.add(a1);
        tempTasks.add(a2);
        tempTasks.add(a3);
        tempTasks.add(a4);
        tempTasks.add(a5);
        tempTasks.add(a6);
        tempTasks.add(a7);
        tempTasks.add(a8);
        tempTasks.add(a9);
        tempTasks.add(a10);
        tempTasks.add(a11);
        tempTasks.add(a12);

        for (int i = 0; i < tempTasks.size(); i++) {
            Boolean b = tempTasks.get(i);
            if (b != null) {
                tasks.add(b);
            }

            if (b) {
                tasksDone.add(b);
            }

        }
    }

    public String tasksDoneToString() {
        String taskString = "";
        for (int i = 0; i < tasksDone.size(); i++) {
            taskString += " " + (i + 1);
        }
        return taskString;
    }
}
