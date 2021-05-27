package com.example.datastructureapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.*;

import java.util.ArrayList;
import java.util.List;

public class newActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    List<Model> modelList;
    ModelAdapter myAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmain);
        Intent intent = getIntent();
        String topic = intent.getStringExtra("topic").trim();
        Log.d("test url", "onCreate: " + topic);

        recyclerView = findViewById(R.id.recview);
        databaseReference = FirebaseDatabase.getInstance().getReference("Topics").child(topic);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelList = new ArrayList<>();
        myAdapter = new ModelAdapter(this, modelList);
        recyclerView.setAdapter(myAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot snapshotChild : snapshot.getChildren()) {
                    Model model = snapshotChild.getValue(Model.class);
                    modelList.add(model);
                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

}
