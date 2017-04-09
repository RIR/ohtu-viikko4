package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

      

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        int tasks=0;
        int hours = 0;
        
        System.out.println("Opiskelijanumero: " + studentNr);
        System.out.println("");
        for (Submission submission : subs) {
            System.out.println(submission);
            tasks+=submission.getTasks().size();
            hours +=submission.getHours();
        }
        System.out.println("");
        System.out.println("Yhteensä " + tasks + " tehtävää " + hours + " tuntia.");

    }
}