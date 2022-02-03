package com.example.buylap.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.buylap.Controller.Grafico.RegistrationGraphicController;
import com.example.buylap.Exceptions.DAOException;
import com.example.buylap.R;

public class RegistrationActivity extends AppCompatActivity {

    private RegistrationGraphicController registrationGraphicController;
    private RadioButton userRadio;
    private RadioButton sellerRadio;
    private TextView signIn;
    private EditText username;
    private EditText email;
    private EditText password;
    private Button signUp;
    private Boolean User = true;
    public RegistrationActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        this.registrationGraphicController = new RegistrationGraphicController(this);
        userRadio = findViewById(R.id.radio_user);
        sellerRadio = findViewById(R.id.radio_seller);
        username = findViewById(R.id.Username);
        email = findViewById(R.id.Mail);
        password = findViewById(R.id.Password);
        signUp = findViewById(R.id.signup_btn);

        signIn= findViewById(R.id.create_new_one);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(password.getText().toString())) {
                    Toast.makeText(RegistrationActivity.this, "All field required", Toast.LENGTH_SHORT).show();
                } else {
                    if (User) {
                        try {
                            registrationGraphicController.registerNewAccountUser(username.getText().toString(), email.getText().toString(), password.getText().toString());
                        } catch (DAOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        registrationGraphicController.registerNewAccountSeller(username.getText().toString(), email.getText().toString(), password.getText().toString());

                    }
                }
            }
        });



    }
    public void onRadioButtonClicked(View view) throws DAOException {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_user:
                if (checked)
                    User = true;
                    break;
            case R.id.radio_seller:
                if (checked)
                    User = false;
                    break;
        }
    }

}