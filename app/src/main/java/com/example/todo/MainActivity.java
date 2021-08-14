package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button addtaskbtn;
    private String Newtask;
    private RecyclerView taskRecyclerView;
    //List<String> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
        addtaskbtn = (Button) findViewById(R.id.addBtn);
        taskRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);
    }

    @Override
    protected void onStart() {
        // callled whenever screen appears from anywhere
        super.onStart();
        showResult();
    }

    // add new task btn clicked
    public void addBtnclickLiistner(View view) {
        // passing user to next screen
        Intent intentactivity = new Intent(this, addtaskActivity.class);
        startActivity(intentactivity);
    }

    public void showResult(){
        // the saved result in previous activity
        Newtask = constant.getDefaults("key", this);
        if (Newtask != "" || Newtask != null || Newtask != "something"){
            System.out.println(Newtask);
            Toast.makeText(this,  Newtask, Toast.LENGTH_LONG).show();
            // recievd task from previous activity append the task and update the view
            setupRecyclerView(Newtask);
        }
    }

    public void setupRecyclerView(String newaddedTask) {
        constant.tasks.add(newaddedTask);
        TaskAdapter adapter = new TaskAdapter(this, constant.tasks);
        taskRecyclerView.setAdapter(adapter);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}