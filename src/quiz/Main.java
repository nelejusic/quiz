
package quiz;

import quiz.Database;
import quiz.Quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Database database = new Database();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        boolean quit = false;

        while (!quit) {

            System.out.println("Unesite akciju: " +
                    "\n1) Kreiranje kviza" +
                    "\n2) Lista svih dostupnih kvizova" +
                    "\n3) Igranje kviza" +
                    "\n4) Izlaz");

            int choice = scanner.nextInt();

            if (choice == 1) {
                Quiz quiz = new Quiz();
                quiz = quiz.makeQuiz();
                database.quizList.add(quiz);


            } else if (choice == 2) {


                System.out.println("Lista svih kvizova: ");
                for (Quiz quiz1 : database.getQuizList())
                    System.out.println(quiz1.getNameOfQuiz() + " | " + quiz1.getId());
            } else if (choice == 3) {
                playQuiz();
            } else if (choice == 4) {

                quit = true;
            }
        }


    }

    public static void playQuiz() {

        System.out.println("Koji kviz zelite igrati (unesite ID kviza): ");
        for (Quiz quiz : database.getQuizList())
            System.out.println(quiz.getNameOfQuiz() + " | " + quiz.getId());

        String id = scanner.next().toUpperCase();


        for (Quiz quiz : database.getQuizList()) {
            if (quiz.getId().equals(id)) {
                System.out.println("Odabrali ste kviz " + quiz.getNameOfQuiz());

                System.out.println("Mozete osvojiti  " + quiz.getTotalPoints() + " bodova.");
                for (int i = 0; i < quiz.getQuestionNumber(); i++) {
                    System.out.println(i + 1 + ". pitanje: ");
                    quiz.question(i);
                    quiz.answer(i);
                    String answer = scanner.next().toUpperCase();
                    String correct = quiz.correct(i).toUpperCase();
                    if (answer.equals(correct)) {
                        System.out.println("Odgovor je tacan.");
                       // quiz.setWonPoints(quiz.getWonPoints()+quiz.getQaList().get(i).getPoints());
                     //   System.out.println("Imate " + quiz.getWonPoints() + " bodova.");




                    } else
                        System.out.println("Odgovor nije tacan. Tacan odgovor je " + correct);
                }
            }
        }
    }


}




