package com.example.buylap.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.buylap.Bean.BeanAnswer;
import com.example.buylap.Controller.Grafico.TakeQuizGraphicController;
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

    private TakeQuizGraphicController takeQuizController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz);

        this.takeQuizController = new TakeQuizGraphicController(this);

        question = findViewById(R.id.txtqst);
        op1 = findViewById(R.id.text_a);
        op2 = findViewById(R.id.text_b);
        op3 = findViewById(R.id.text_c);

        cardOp1 = findViewById(R.id.cardView1);
        cardOp2 = findViewById(R.id.cardView2);
        cardOp3 = findViewById(R.id.cardView3);

        nextBtn = findViewById(R.id.next_btn);


        takeQuizController.setQuiz();

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
        cardOp1.setCardBackgroundColor(getResources().getColor(R.color.bluebuttom));
        cardOp2.setCardBackgroundColor(getResources().getColor(R.color.bluebuttom));
        cardOp3.setCardBackgroundColor(getResources().getColor(R.color.bluebuttom));
    }

    public void finished(BeanAnswer beanAnswer) {

        Intent intent = new Intent(TakeQuizActivity.this, QuizResultActivity.class);
        intent.putExtra("beanAnswer1", beanAnswer.getOp1());
        intent.putExtra("beanAnswer2", beanAnswer.getOp2());
        intent.putExtra("beanAnswer3", beanAnswer.getOp3());
        startActivity(intent);
    }
    public void choice(CardView cardview, String answer){
        cardview.setCardBackgroundColor(getResources().getColor(R.color.green));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeQuizController.goNext(answer);
            }
        });
    }
    public void Op1Click (View view){
        resetColor();
        cardOp1.setCardBackgroundColor(getResources().getColor(R.color.green));
        choice(cardOp1, takeQuizController.getAnswer1());
    }
    public void Op2Click (View view){
        resetColor();
        cardOp2.setCardBackgroundColor(getResources().getColor(R.color.green));

        choice(cardOp2, takeQuizController.getAnswer2());
    }
    public void Op3Click (View view){
        resetColor();
        cardOp3.setCardBackgroundColor(getResources().getColor(R.color.green));
        choice(cardOp3, takeQuizController.getAnswer3());
    }


}