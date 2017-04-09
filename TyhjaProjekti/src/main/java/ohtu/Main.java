package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "014089729";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        String courseUrl = "https://ohtustats2017.herokuapp.com/courses/1.json";
        String courseText = Request.Get(courseUrl).execute().returnContent().asString();
        

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        CourseInfo courseInfo = mapper.fromJson(courseText, CourseInfo.class);

        int tasks = 0;
        int hours = 0;
        int week = 1;

        System.out.println(courseInfo.toString());
        System.out.println("");
        System.out.println("Opiskelijanumero: " + studentNr);
        System.out.println("");

        for (Submission sub : subs) {
            sub.setTasks();
            System.out.println(sub.getWeek() + ": tehtyjä tehtäviä yhteensä: " + sub.getTasksDone().size() + " (maksimi "  + courseInfo.getWeek(week++) + "), aikaa kului " + sub.getHours() + " tuntia, tehdyt tehtävät " + sub.tasksDoneToString());
            tasks += sub.getTasksDone().size();
            hours += sub.getHours();
        }
        System.out.println("");
        System.out.println("Yhteensä " + tasks + " tehtävää " + hours + " tuntia.");

    }
}
