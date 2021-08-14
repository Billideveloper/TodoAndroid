package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addtaskActivity extends AppCompatActivity {

    private String newtask;
    private EditText taskedittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_addtask);
        taskedittext = (EditText) findViewById(R.id.addtask);
    }

    public void addBtnclickLiistner(View view) {

        String myNewTask = "ToDo Next : " + taskedittext.getText().toString();
        // go to previous Screen:-
        constant.setDefaults("key", myNewTask, this);
        finish();
    }
}