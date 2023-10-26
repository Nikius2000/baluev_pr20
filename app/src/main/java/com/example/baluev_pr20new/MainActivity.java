package com.example.baluev_pr20new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edName, edSName, edEmail, edText1, edText2, edText3;
    Button btnSave, btnRead;

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firestore = FirebaseFirestore.getInstance();

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        edName = (EditText)findViewById(R.id.edName);
        edSName = (EditText)findViewById(R.id.edSName);
        edEmail = (EditText)findViewById(R.id.edEmail);
        edText1 = (EditText)findViewById(R.id.edText1);
        edText2 = (EditText)findViewById(R.id.edText2);
        edText3 = (EditText)findViewById(R.id.edText3);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnSave){
            Map<String,Object> users = new HashMap<>();
            users.put("Name", edName.getText().toString());
            users.put("SName", edSName.getText().toString());
            users.put("Email", edEmail.getText().toString());
            users.put("Text1", edText1.getText().toString());
            users.put("Text2", edText2.getText().toString());
            users.put("Text3", edText3.getText().toString());
            firestore.collection("users").add(users);
        }
        if(view.getId() == R.id.btnRead){
            Toast.makeText(this, "Такой функции нет", Toast.LENGTH_SHORT).show();
        }
    }
}