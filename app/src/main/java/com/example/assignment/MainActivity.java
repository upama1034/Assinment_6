package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView taskListView;
    private ArrayList<String> taskList;
    private Button addNewTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskListView = findViewById(R.id.taskListView);
        addNewTaskButton = findViewById(R.id.addNewTaskButton);
        taskList = new ArrayList<>();


        taskList.add("ui ux design");
        taskList.add("web dev");
        taskList.add("android dev");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        taskListView.setAdapter(adapter);


        taskListView.setOnItemClickListener((parent, view, position, id) -> {
            String taskName = taskList.get(position);
            Intent intent = new Intent(MainActivity.this, TaskDetailActivity.class);
            intent.putExtra("taskName", taskName);
            startActivity(intent);
        });


        addNewTaskButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddNewTaskActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && data != null) {
            String newTask = data.getStringExtra("newTask");
            taskList.add(newTask);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
            taskListView.setAdapter(adapter);
        }
    }
}
