package com.example.assignment;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    private TextView taskDetailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        taskDetailTextView = findViewById(R.id.taskDetailTextView);

        // Get the task name from the intent
        String taskName = getIntent().getStringExtra("taskName");
        taskDetailTextView.setText("Task: " + taskName);
    }
}
