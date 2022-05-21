package com.example.buylap.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.buylap.bean.BeanAnswer;
import com.example.buylap.controller.graphic.TakeQuizGraphicController;
import com.example.buylap.R;

public class TakeQuizActivity extends AppCompatActivity {


    private TextView question;
    private TextView op1;
    private TextView op2;
    private TextView op3;
    private CardView cardOp1;
    private CardView cardOp2;
    private CardView cardOp3;
    private Button nextBtn;

    private TakeQuizGraphicController takeQuizGraphicController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz);

        this.takeQuizGraphicController = new TakeQuizGraphicController(this);

        question = findViewById(R.id.txtqst);
        op1 = findViewById(R.id.text_a);
        op2 = findViewById(R.id.editEmail);
        op3 = findViewById(R.id.text_c);

        cardOp1 = findViewById(R.id.cardView1);
        cardOp2 = findViewById(R.id.cardView2);
        cardOp3 = findViewById(R.id.cardView3);

        nextBtn = findViewById(R.id.next_btn);


        takeQuizGraphicController.setQuiz();

    }

    public void setQuestion(String question) {
        this.question.setText(question);
    }

    public void setOp1(String op1) {
        this.op1.setText(op1);
    }

    public void setOp2(String op2) {
        this.op2.setText(op2);
    }

    public void setOp3(String op3) {
        this.op3.setText(op3);
    }


    public void resetColor() {
        cardOp1.setCardBackgroundColor(getResources().getColor(R.color.bluebutton));
        cardOp2.setCardBackgroundColor(getResources().getColor(R.color.bluebutton));
        cardOp3.setCardBackgroundColor(getResources().getColor(R.color.bluebutton));
    }

    public void finished(BeanAnswer beanAnswer) {

        Intent intent = new Intent(TakeQuizActivity.this, QuizResultActivity.class);

        intent.putExtra("beanAnswer1", beanAnswer.getAnswer1());
        intent.putExtra("beanAnswer2", beanAnswer.getAnswer2());
        intent.putExtra("beanAnswer3", beanAnswer.getAnswer3());
        startActivity(intent);
    }
    public void choice(CardView cardview, String answer){
        cardview.setCardBackgroundColor(getResources().getColor(R.color.green));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeQuizGraphicController.goNext(answer);
            }
        });
    }
    public void Op1Click (View view){
        resetColor();
        cardOp1.setCardBackgroundColor(getResources().getColor(R.color.green));
        choice(cardOp1, takeQuizGraphicController.getAnswer1());
    }
    public void Op2Click (View view){
        resetColor();
        cardOp2.setCardBackgroundColor(getResources().getColor(R.color.green));

        choice(cardOp2, takeQuizGraphicController.getAnswer2());
    }
    public void Op3Click (View view){
        resetColor();
        cardOp3.setCardBackgroundColor(getResources().getColor(R.color.green));
        choice(cardOp3, takeQuizGraphicController.getAnswer3());
    }
    public void setNumberQuestion(int index){
        TextView numberQuestion = findViewById(R.id.numberOfQuestion);

        numberQuestion.setText(String.valueOf(index+2));
    }

}