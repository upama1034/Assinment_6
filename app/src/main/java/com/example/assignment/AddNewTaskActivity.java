package com.example.assignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddNewTaskActivity extends Activity {

    private EditText taskNameEditText;
    private Button addTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_task);

        taskNameEditText = findViewById(R.id.taskNameEditText);
        addTaskButton = findViewById(R.id.addTaskButton);

        addTaskButton.setOnClickListener(v -> {
            String taskName = taskNameEditText.getText().toString();
            Intent resultIntent = new Intent();
            resultIntent.putExtra("newTask", taskName);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
