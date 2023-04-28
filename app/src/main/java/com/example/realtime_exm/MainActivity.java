package com.example.realtime_exm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText name,price,desc;
    Button enter,display;
    FirebaseDatabase fd;
    Modal modal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        desc = findViewById(R.id.dew);
        enter = findViewById(R.id.enter);
        display = findViewById(R.id.display);
        fd = FirebaseDatabase.getInstance();


        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Display.class));
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String price1 = price.getText().toString();
                String desc1 = desc.getText().toString();

                 modal = new Modal();
                 modal.setName(name1);
                 modal.setPrice(price1);
                 modal.setDescription(desc1);

//                Map<String,Object> useraA = new HashMap<>();
//                useraA.put("name",name1);
//                useraA.put("price",price1);
//                useraA.put("description",desc1);
                fd.getReference("product").setValue(modal).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "data added", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "data not added", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }
}