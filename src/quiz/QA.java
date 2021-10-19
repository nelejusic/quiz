package quiz;

import java.util.ArrayList;

public class QA {


    private int points;
    private String question;
    ArrayList<String> answers = new ArrayList<>();

    private String CorrectAnswer;


    public QA() {
    }

    public QA(String question, ArrayList<String> answers, String correctAnswer, int points) {
        this.question = question;
        this.answers = answers;
        this.CorrectAnswer = correctAnswer;
        this.points = points;

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.CorrectAnswer = correctAnswer;
    }


}

