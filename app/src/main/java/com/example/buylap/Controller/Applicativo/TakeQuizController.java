package com.example.buylap.Controller.Applicativo;

import static com.example.buylap.View.HomeFragment.listQuest;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.buylap.Bean.BeanAnswer;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.Answer;
import com.example.buylap.Model.QuizList;
import com.example.buylap.R;
import com.example.buylap.View.QuizResultActivity;
import com.example.buylap.View.TakeQuizActivity;

import java.util.List;

public class TakeQuizController {

    private List<QuizList> allQuestion;
    private QuizList quizList;
    private int index = 0;


    public void takequiz() {

        allQuestion=listQuest;
        quizList=listQuest.get(index);

/*
        question.setText(quizList.getQuestion());
        op1.setText(quizList.getOp1());
        op2.setText(quizList.getOp2());
        op3.setText(quizList.getOp3());


        public void choice (CardView cardview){
            cardview.setCardBackgroundColor(getResources().getColor(R.color.green));
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    index++;

                    if (index >= listQuest.size()) {
                        try {

                            finished();
                        } catch (DAOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        quizList = listQuest.get(index);
                        resetColor();
                        setAllData();
                    }
                }
            });
        }
        public void enableButton () {
            cardOp1.setClickable(true);
            cardOp2.setClickable(true);
            cardOp3.setClickable(true);
        }
        public void disableButton () {
            cardOp1.setClickable(false);
            cardOp2.setClickable(false);
            cardOp3.setClickable(false);
        }
        public void resetColor () {
            cardOp1.setCardBackgroundColor(getResources().getColor(R.color.bluebuttom));
            cardOp2.setCardBackgroundColor(getResources().getColor(R.color.bluebuttom));
            cardOp3.setCardBackgroundColor(getResources().getColor(R.color.bluebuttom));
        }
        public void Op1Click (View view){
            resetColor();
            cardOp1.setCardBackgroundColor(getResources().getColor(R.color.green));
            choice(cardOp1);
            answers.setOp1(quizList.getOp1());
        }

        public void Op2Click (View view){
            resetColor();
            cardOp2.setCardBackgroundColor(getResources().getColor(R.color.green));
            choice(cardOp2);
            answers.setOp2(quizList.getOp2());
        }
        public void Op3Click (View view){
            resetColor();
            cardOp3.setCardBackgroundColor(getResources().getColor(R.color.green));
            choice(cardOp3);
            answers.setOp3(quizList.getOp3());
        }

        private void finished () throws DAOException {

            Intent intent = new Intent(TakeQuizActivity.this, QuizResultActivity.class);
            startActivity(intent);
        }
        public BeanAnswer sendAnswer (Answer answer){
            BeanAnswer beanAnswer = new BeanAnswer();
            beanAnswer.setOp1(answer.getOp1());
            beanAnswer.setOp2(answer.getOp2());
            beanAnswer.setOp3(answer.getOp3());
            return beanAnswer;
        }



 */
    }
}
