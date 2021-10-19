package quiz;


import java.util.ArrayList;

public class Database {

    private String question;
    public ArrayList<Quiz> quizList = new ArrayList<>();
    private ArrayList<QA> qaArrayList = new ArrayList<>();

    public Database() {
    }

    public ArrayList<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(ArrayList<Quiz> quizList) {
        this.quizList = quizList;
    }

}

