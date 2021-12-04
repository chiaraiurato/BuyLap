package com.example.buylap;

import static com.example.buylap.HomeFragment.listQuest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TakeQuiz1Activity extends AppCompatActivity {

    List<QuizList> allQuestion;
    QuizList quizList;
    int index=0;
    TextView question, op1, op2;
    CardView cardQuestion, cardOp1, cardOp2;
    Button next_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz1);
        hooks();
        allQuestion=listQuest;
        //Collections.shuffle(allQuestion);
        quizList=listQuest.get(index);
        setAllData();
    }

    private void setAllData() {
        question.setText(quizList.getQuestion());
        op1.setText(quizList.getOp1());
        op2.setText(quizList.getOp2());
    }

    private void hooks() {

        question=findViewById(R.id.txtqst);
        op1=findViewById(R.id.text_a);
        op2=findViewById(R.id.text_b);

        cardOp1=findViewById(R.id.cardView2);
        cardOp2=findViewById(R.id.cardView3);
        next_btn=findViewById(R.id.next_btn);
    }
    public void choice(CardView cardview){
        cardview.setCardBackgroundColor(getResources().getColor(R.color.green));
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                quizList=listQuest.get(index);
                resetColor();
                setAllData();

            }
        });
    }
    public void enableButton(){
        cardOp1.setClickable(true);
        cardOp2.setClickable(true);
    }
    public void disableButton(){
        cardOp1.setClickable(false);
        cardOp2.setClickable(false);
    }
    public void resetColor(){
        cardOp1.setCardBackgroundColor(getResources().getColor(R.color.bluebuttom));
        cardOp2.setCardBackgroundColor(getResources().getColor(R.color.bluebuttom));
    }
    public void Op1Click(View view){

     cardOp1.setCardBackgroundColor(getResources().getColor(R.color.green));
     if(index < listQuest.size()-1)
     {
         choice(cardOp1);
     }

    }

    public void Op2Click(View view) {
        resetColor();
        cardOp2.setCardBackgroundColor(getResources().getColor(R.color.green));
        if(index < listQuest.size()-1)
        {
            choice(cardOp2);
        }
    }
}