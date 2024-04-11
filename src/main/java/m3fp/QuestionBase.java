import java.util.ArrayList;
import java.util.List;

public class QuestionBase {
    private static QuestionBase instance;
    private List<Question> questionList;

    private int currentQuestionIndex;
    private QuestionBase(){
        questionList = new ArrayList<>();

        questionList.add(new Question("questions/albania.jpeg",
                "Tirana",
                "Paris",
                "Oslo",
                "Bratislava",1));

        questionList.add(new Question("questions/avstria.jpeg",
                "Baku",
                "Brussels",
                "Vienna",
                "Copenhagen",3));

        questionList.add(new Question("questions/czechia.jpeg",
                "Chisinau",
                "Amsterdam",
                "Monaco",
                "Prague",4));

        questionList.add(new Question("questions/dania.jpeg",
                "Vienna",
                "Copenhagen",
                "Chisinau",
                "Ljubljana",2));

        questionList.add(new Question("questions/france.jpeg",
                "Stockholm",
                "Paris",
                "Oslo",
                "Prague",2));

        questionList.add(new Question("questions/germany.jpeg",
                "Ankara",
                "Kyiv",
                "London",
                "Berlin",4));

        questionList.add(new Question("questions/greece.jpeg",
                "Riga",
                "Paris",
                "Rome",
                "Copenhagen",3));

        questionList.add(new Question("questions/norway.jpeg",
                "Monaco",
                "Paris",
                "Oslo",
                "Bratislava",3));

        questionList.add(new Question("questions/sweden.jpeg",
                "Stockholm",
                "Sofia",
                "Tbilisi",
                "Luxembourg City",1));

        questionList.add(new Question("questions/ukraine.jpeg",
                "Sarajevo",
                "Kyiv",
                "Copenhagen",
                "Brussels",2));

        currentQuestionIndex = 0;
    }


    public static synchronized QuestionBase getInstance(){
        if(instance == null){
            instance = new QuestionBase();
        }
        return instance;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}
