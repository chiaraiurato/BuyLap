package com.example.buylap.View;

import static com.example.buylap.View.HomeFragment.listQuest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.buylap.Model.QuizList;
import com.example.buylap.R;
import java.util.List;

public class TakeQuizActivity extends AppCompatActivity {

    List<QuizList> allQuestion;
    QuizList quizList;
    int index=0;
    TextView question;
    TextView op1;
    TextView op2;
    TextView op3;
    CardView cardOp1;
    CardView cardOp2;
    CardView cardOp3;
    Button nextBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz);
        hooks();
        allQuestion=listQuest;
        quizList=listQuest.get(index);
        setAllData();
    }

    private void setAllData() {
        question.setText(quizList.getQuestion());
        op1.setText(quizList.getOp1());
        op2.setText(quizList.getOp2());
        op3.setText(quizList.getOp3());
    }

    private void hooks() {

        question=findViewById(R.id.txtqst);
        op1=findViewById(R.id.text_a);
        op2=findViewById(R.id.text_b);
        op3=findViewById(R.id.text_c);

        cardOp1=findViewById(R.id.cardView1);
        cardOp2=findViewById(R.id.cardView2);
        cardOp3=findViewById(R.id.cardView3);

        nextBtn=findViewById(R.id.next_btn);
    }
    public void choice(CardView cardview){
        cardview.setCardBackgroundColor(getResources().getColor(R.color.green));
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;

                if ( index >= listQuest.size()) {
                    finished();
                }else {
                    quizList = listQuest.get(index);
                    resetColor();
                    setAllData();
                }
            }
        });
    }
    public void enableButton(){
        cardOp1.setClickable(true);
        cardOp2.setClickable(true);
        cardOp3.setClickable(true);
    }
    public void disableButton(){
        cardOp1.setClickable(false);
        cardOp2.setClickable(false);
        cardOp3.setClickable(false);
    }
    public void resetColor(){
        cardOp1.setCardBackgroundColor(getResources().getColor(R.color.bluebuttom));
        cardOp2.setCardBackgroundColor(getResources().getColor(R.color.bluebuttom));
        cardOp3.setCardBackgroundColor(getResources().getColor(R.color.bluebuttom));
    }
    public void Op1Click(View view) {
        resetColor();
        cardOp1.setCardBackgroundColor(getResources().getColor(R.color.green));
        choice(cardOp1);
    }

    public void Op2Click(View view) {
        resetColor();
        cardOp2.setCardBackgroundColor(getResources().getColor(R.color.green));
        choice(cardOp2);
    }
    public void Op3Click(View view) {
        resetColor();
        cardOp3.setCardBackgroundColor(getResources().getColor(R.color.green));
        choice(cardOp3);
    }

    private void finished() {
        Intent intent = new Intent(TakeQuizActivity.this, QuizResultActivity.class);
        startActivity(intent);
    }

}