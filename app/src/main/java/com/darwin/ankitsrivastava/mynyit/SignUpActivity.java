package com.darwin.ankitsrivastava.mynyit;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by ankitsrivastava on 10/25/17.
 */


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    //defining view objects
    private EditText full1Name, userName, password, confirmPassword, studentId, email, phoneNo;
    private String str_full1Name, str_userName, str_password, str_confirmPassword, str_studentId, str_email, str_phoneNo;
    private Button buttonSignup;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        //initializing views
        full1Name = (EditText) findViewById(R.id.nameField);
        userName = (EditText) findViewById(R.id.userNameField);
        studentId = (EditText) findViewById(R.id.studentIDField);
        phoneNo = (EditText) findViewById(R.id.phoneField);
        email = (EditText) findViewById(R.id.emailField);
        password = (EditText) findViewById(R.id.passField);
        confirmPassword = (EditText) findViewById(R.id.comfirmPassField);
        buttonSignup = (Button) findViewById(R.id.createButton);

        progressDialog = new ProgressDialog(this);


        //attaching listener to button
        buttonSignup.setOnClickListener(this);
    }

    private void registerUser() {

        //getting email and password from edit texts
        String inEmail = email.getText().toString().trim();
        String email = inEmail + "@nyit.edu";
        String pwd = password.getText().toString().trim();
        String confirmPwd = confirmPassword.getText().toString().trim();
        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email: ", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "Please enter password:", Toast.LENGTH_LONG).show();
            return;
        }

        if (password.length() < 6) {
            Toast.makeText(this, "Please 6 or more characters for password", Toast.LENGTH_LONG).show();
            return;
        }

        if (!pwd.equals(confirmPwd)) {
            Toast.makeText(this, "Passwords do not match. Please try again", Toast.LENGTH_LONG).show();
            Log.e("Tag1 ", pwd);
            Log.e("Tag2 ", confirmPwd);
            return;
        }


        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();



    }

    @Override
    public void onClick(View view) {
         str_full1Name = full1Name.getText().toString();
        str_userName = userName.getText().toString();
        str_password = password.getText().toString();
        str_studentId = studentId.getText().toString();
        str_phoneNo = phoneNo.getText().toString();
        str_email = email.getText().toString();
        str_confirmPassword = confirmPassword.getText().toString();
        String type="Register";

        BackgroundWorker backgroundWorker = new BackgroundWorker(SignUpActivity.this);
        backgroundWorker.execute(type,str_full1Name,str_userName,str_password,str_studentId,str_phoneNo,str_email,str_confirmPassword);
        //calling register method on click
        //registerUser();

    }
}