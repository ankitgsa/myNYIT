package com.darwin.ankitsrivastava.mynyit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StudentConnect extends AppCompatActivity  {
    Button acadamicsButton, financesButton, personalInfoButton;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_connect);

        acadamicsButton = (Button) findViewById(R.id.acadamicsButton);
        financesButton = (Button) findViewById(R.id.financesButton);
        personalInfoButton = (Button) findViewById(R.id.personalInfoButton);

        acadamicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Acadamics", "click");
     intent=new Intent(StudentConnect.this,Acadamics.class);
                startActivity(intent);
//String type="showSubject";
//BackgroundWorker bw=new BackgroundWorker(StudentConnect.this);
//           bw.execute(type);
            }
        });
        financesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Finance", "click");
            }
        });
        personalInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("PersonalInfo", "click");
            }
        });

    }

}

