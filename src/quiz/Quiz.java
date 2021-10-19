package quiz;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz {

    private String id;
    private String nameOfQuiz;
    private int questionNumber;
    private ArrayList<QA> qaList = new ArrayList<>();
    private int wonPoints = 0;
    private int totalPoints=0;
    private Scanner scanner = new Scanner(System.in);


    public Quiz() {
    }

    public Quiz(String id, String nameOfQuiz, int questionNumber) {
        this.id = id;
        this.nameOfQuiz = nameOfQuiz;
        this.questionNumber = questionNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameOfQuiz() {
        return nameOfQuiz;
    }

    public void setNameOfQuiz(String nameOfQuiz) {
        this.nameOfQuiz = nameOfQuiz;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public ArrayList<QA> getQaList() {
        return qaList;
    }

    public void setQaList(ArrayList<QA> qaList) {
        this.qaList = qaList;
    }


    public Quiz makeQuiz() {
        Quiz quiz = new Quiz();

        System.out.println("Unesite ID kviza: ");
        String quizID = scanner.nextLine().toUpperCase();

        System.out.println("Unesite naziv kviza: ");
        String name = scanner.nextLine().toUpperCase();

        System.out.println("Unesite broj pitanja: ");

        int number = scanner.nextInt();


        for (int i = 1; i <= number; i++) {

            System.out.println("Unesite kategoriju pitanja) " +
                    "\n (1 predstavlja tip pitanja bez ponuđenih odgovora) " +
                    "\n (2 predstavlja tip pitanja sa ponuđenim odgovorom)");
            int choose = scanner.nextInt();


            if (choose == 1) {

                Answer(i);

            }

            if (choose == 2) {


                Answers(i);

            }

        }

        quiz.setId(quizID);
        quiz.setNameOfQuiz(name);
        quiz.setQuestionNumber(number);
        quiz.setQaList(qaList);
        return quiz;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getWonPoints() {
        return wonPoints;
    }

    public void setWonPoints(int wonPoints) {
        this.wonPoints = wonPoints;
    }

    public void Answer(int i) {
        QA qa = new QA();
        scanner.nextLine();

        System.out.println("Unesite " + i + ". pitanje: ");
        qa.setQuestion(scanner.nextLine().toUpperCase());

        System.out.println("Unesite tacan odgovor na " + i + ". pitanje: ");
        String correct = scanner.nextLine().toUpperCase();
        qa.setCorrectAnswer(correct);

        qa.answers.add(correct);

        System.out.println("Unesite broj bodova");
        int points = scanner.nextInt();
        qa.setPoints(points);

        setTotalPoints(getTotalPoints()+points);

        qaList = getQaList();
        qaList.add(qa);
    }

    public void Answers(int i) {
        QA qa = new QA();
        scanner.nextLine();

        System.out.println("Unesite " + i + " pitanje.");
        qa.setQuestion(scanner.nextLine());

        System.out.println("Koliko odgovora zelite ponuditi?");
        int num = scanner.nextInt();

        if (num > 5 || num < 1) {
            System.out.println("Greska! Nemoguce unijeti manje od 1 ili više od 5 odgovora u opciji 2");
        } else {
            scanner.nextLine();
            for (int j = 0; j < num; j++) {
                System.out.println("Unesite " + (j+1) + " odgovor");
                qa.answers.add(scanner.nextLine());

                qaList = getQaList();
                qaList.add(qa);
            }


            System.out.println("Unesite tacan odgovor: ");
            String correct = scanner.nextLine().toUpperCase();


            qa.setCorrectAnswer(correct);


           // System.out.println("Unesite broj bodova");
         //   int points = scanner.nextInt();
         //   qa.setPoints(points);
          //  setTotalPoints(getTotalPoints()+points);
        }
    }

    public void question(int i) {
        System.out.println(qaList.get(i).getQuestion());
    }

    public void answer(int i) {

        if (getQaList().get(i).answers.size() < 2) {

            System.out.println();
        } else {

            for (String s : qaList.get(i).getAnswers()) {
                System.out.println(s);

            }
        }


    }

    public int points(int i){

        return qaList.get(i).getPoints();

    }

    public String correct(int i) {

        return getQaList().get(i).getCorrectAnswer();
    }

}




