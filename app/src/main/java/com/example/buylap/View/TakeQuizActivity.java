package com.example.buylap.View;

import static com.example.buylap.View.HomeFragment.listQuest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.buylap.Bean.BeanAnswer;
import com.example.buylap.Controller.Applicativo.BuildController;
import com.example.buylap.Controller.Applicativo.TakeQuizController;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.Model.Answer;
import com.example.buylap.Model.QuizList;
import com.example.buylap.R;
import java.util.List;

public class TakeQuizActivity extends AppCompatActivity {

    public Answer answers;
    private TextView question;
    private TextView op1;
    private TextView op2;
    private TextView op3;
    private CardView cardOp1;
    private CardView cardOp2;
    private CardView cardOp3;
    private Button nextBtn;
    private TakeQuizController takeQuizController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_quiz);
        this.answers = new Answer("", "", "");

        this.takeQuizController = new TakeQuizController();

        question=findViewById(R.id.txtqst);
        op1=findViewById(R.id.text_a);
        op2=findViewById(R.id.text_b);
        op3=findViewById(R.id.text_c);

        cardOp1=findViewById(R.id.cardView1);
        cardOp2=findViewById(R.id.cardView2);
        cardOp3=findViewById(R.id.cardView3);

        nextBtn=findViewById(R.id.next_btn);


        takeQuizController.takequiz();

    }
    public void setQuestion(String question){
        this.question.setText(question);
    }




}