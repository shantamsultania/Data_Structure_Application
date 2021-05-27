package com.example.datastructureapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private final Timer timer = new Timer();
    private Button arrayBtn, linkedListBtn, hashMapBtn, treeBtn, stringBtn, matrixBtn, sortBtn, stackBtn, graphBtn, dynamicBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayBtn = findViewById(R.id.Harray);
        linkedListBtn = findViewById(R.id.Hlinkedlist);
        hashMapBtn = findViewById(R.id.Hheap);
        treeBtn = findViewById(R.id.Hbinarytree);
        stringBtn = findViewById(R.id.Hstring);
        matrixBtn = findViewById(R.id.Hmatrix);
        sortBtn = findViewById(R.id.Hsort);
        stackBtn = findViewById(R.id.Hstack);
        graphBtn = findViewById(R.id.Hgraph);
        dynamicBtn = findViewById(R.id.Hdynamic);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.equals(arrayBtn)) {
                    timer.schedule(setTimerTask("Array"), 1000);
                } else if (v.equals(linkedListBtn)) {
                    timer.schedule(setTimerTask("LinkedList"), 1000);
                } else if (v.equals(hashMapBtn)) {
                    timer.schedule(setTimerTask("Heap"), 1000);
                } else if (v.equals(treeBtn)) {
                    timer.schedule(setTimerTask("Binary Trees"), 1000);
                } else if (v.equals(stringBtn)) {
                    timer.schedule(setTimerTask("String"), 1000);
                } else if (v.equals(stackBtn)) {
                    timer.schedule(setTimerTask("Stacks & Queues"), 1000);
                } else if (v.equals(matrixBtn)) {
                    timer.schedule(setTimerTask("Matrix"), 1000);
                } else if (v.equals(sortBtn)) {
                    timer.schedule(setTimerTask("Searching & Sorting"), 1000);
                } else if (v.equals(graphBtn)) {
                    timer.schedule(setTimerTask("Graph"), 1000);
                } else if (v.equals(dynamicBtn)) {
                    timer.schedule(setTimerTask("Dynamic Programming"), 1000);
                } else {
                    timer.schedule(setTimerTask("Array"), 1000);
                }
            }
        };

        arrayBtn.setOnClickListener(listener);
        linkedListBtn.setOnClickListener(listener);
        hashMapBtn.setOnClickListener(listener);
        treeBtn.setOnClickListener(listener);
        stringBtn.setOnClickListener(listener);
        matrixBtn.setOnClickListener(listener);
        stackBtn.setOnClickListener(listener);
        sortBtn.setOnClickListener(listener);
        graphBtn.setOnClickListener(listener);
        dynamicBtn.setOnClickListener(listener);

    }

    public TimerTask setTimerTask(String topic) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, newActivity.class);
                intent.putExtra("topic", topic);
                startActivity(intent);
            }
        };
        return timerTask;
    }
}