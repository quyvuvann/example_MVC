package com.example.mvc_model_view_controler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editname,editpassword;
    Button btnlogin;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnclickLogin();
            }
        });
    }

    private void OnclickLogin() {
        String email = editname.getText().toString().trim();
        String password = editpassword.getText().toString().trim();

        User user  =  new User(email,password);
        textView.setVisibility(View.VISIBLE);
        if(user.isValidEmail() && user.isValidPassword()){
            textView.setText("Login success");
            textView.setTextColor(getResources().getColor(R.color.teal_700));
        }else{
            textView.setTextColor(getResources().getColor(R.color.red));
            textView.setText("Email or Password invalid");
        }
    }

    private void anhxa() {
        editname = findViewById(R.id.editusername);
        editpassword = findViewById(R.id.editpassword);
        btnlogin = findViewById(R.id.btnlogin);
        textView = findViewById(R.id.txtshowresult);
    }

}