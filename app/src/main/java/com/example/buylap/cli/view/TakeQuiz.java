package com.example.buylap.cli.view;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.buylap.cli.graphic_controller.QuizGraphicController;
import com.example.buylap.exceptions.BeanException;
import com.example.buylap.exceptions.DAOException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class TakeQuiz {
    private TakeQuiz(){
        //View TakeQuiz
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main() throws IOException, DAOException, BeanException, SQLException {

        System.out.println("---------------- TAKE QUIZ ----------------");
        QuizGraphicController quizGraphicController = new QuizGraphicController();
        System.out.println("\nChoose budget(up to 2000 $ ) ->");
        String price = null;
        String firstAnswer = null;
        String secondAnswer = null;
        String thirdAnswer = null;
        try {

            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            price = bufferRead.readLine();


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println("\nWho are you?");
        System.out.println(
                "1️⃣ Beginner\n" +
                        "2️Nerd\n" +
                        "3️Don't know\n");
        try {

            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            firstAnswer = bufferRead.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        System.out.println("\nWhat is your profession?");
        System.out.println(
                "1️⃣ Student\n" +
                        "2️Worker\n" +
                        "3️Business man\n");
        try {

            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            secondAnswer = bufferRead.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();

        }
        System.out.println("\nClick your category");
        System.out.println(
                "1️⃣ Gaming\n" +
                        "2️Office use\n" +
                        "3️Home use\n");
        try {

            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            thirdAnswer = bufferRead.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        quizGraphicController.startQuiz(firstAnswer, secondAnswer, thirdAnswer, price);

    }
}
