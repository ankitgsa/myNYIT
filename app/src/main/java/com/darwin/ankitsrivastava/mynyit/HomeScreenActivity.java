package com.darwin.ankitsrivastava.mynyit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by DELL on 31-10-2017.
 */

public class HomeScreenActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton classSchedule, ConnectStudent;
    Intent intent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        classSchedule = (ImageButton) findViewById(R.id.classSchedule);
        ConnectStudent = (ImageButton) findViewById(R.id.ConnectStudent);

        classSchedule.setOnClickListener(this);
        ConnectStudent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.findViewById(R.id.classSchedule) == classSchedule) {
            Log.e("HomeScreenActivity", "onClick()_ClassSchedule");
            intent = new Intent(HomeScreenActivity.this, CalanderActivity.class);
            startActivity(intent);
        } else if (view.findViewById(R.id.ConnectStudent) == ConnectStudent) {
            Log.e("HomeScreenActivity", "onClick()_StudentConnect");
            intent = new Intent(HomeScreenActivity.this, StudentConnect.class);
            startActivity(intent);
        }
    }
}
