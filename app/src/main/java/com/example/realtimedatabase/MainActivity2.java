package com.example.realtimedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity
{
    Spinner spi;
    Button btn;
    EditText name,city,contact;
    TextView blood_group;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spi=(Spinner) findViewById(R.id.spinner);
        btn=(Button) findViewById(R.id.button);
        name=(EditText) findViewById(R.id.nam);
        city=(EditText)findViewById(R.id.cit);
        contact=(EditText)findViewById(R.id.con);
        blood_group=(TextView) findViewById(R.id.b);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.BloodType, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spi.setAdapter(adapter);


       /* ArrayAdapter adapter_spinner=new ArrayAdapter(this,android.R.layout.simple_spinner_item,blood);
        adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi.setAdapter(adapter_spinner);*/

        FirebaseDatabase database=FirebaseDatabase.getInstance();



    }


    public void Click(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Donor");
        HashMap<String,Object>m=new HashMap<String,Object>();
        m.put("Name",name.getText().toString());
        m.put("City",city.getText().toString());
        m.put("Contact",contact.getText().toString());
        m.put("BloodGroup",spi.getSelectedItem().toString());
        FirebaseDatabase.getInstance().getReference().child("User").push().setValue(m);
        Toast.makeText(this, "Successfully Record Added", Toast.LENGTH_SHORT).show();

    }


}