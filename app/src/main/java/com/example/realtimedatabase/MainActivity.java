package com.example.realtimedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) this.findViewById(R.id.button2);

        Map<String,Object> m=new HashMap<>();
        m.put("ID","205282");
        m.put("Name","Fatima Javed");
        m.put("CGPA","3.25");
        m.put("Department","Computer Science");
        m.put("Semester","4th");
        FirebaseDatabase.getInstance().getReference().child("Student").updateChildren(m);
    }

    public void click(View view) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }
}