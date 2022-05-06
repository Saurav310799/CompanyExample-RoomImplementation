package com.example.roomcompany;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roomcompany.Room.CompanyDatabase;
import com.example.roomcompany.Room.CompanyInterface;
import com.example.roomcompany.Room.CompanyModel;
import com.example.roomcompany.databinding.ActivityUpdateBinding;

public class UpdateActivity extends AppCompatActivity {
    ActivityUpdateBinding binding;
    CompanyDatabase database;
    CompanyInterface companyInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        int id=intent.getIntExtra("id",-1);
        String location=intent.getStringExtra("location");

        binding.nameId.setText(name);
        binding.locationId.setText(location);

        database=CompanyDatabase.getInstance(this);
        companyInterface=database.getInterface();


        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CompanyModel companyModel=new CompanyModel();
                companyModel.setCompanyId(id);
                companyModel.setCompanyName(binding.nameId.getText().toString());
                companyModel.setLocation(binding.locationId.getText().toString());
                companyInterface.updatedetails(companyModel);
                finish();
                Toast.makeText(UpdateActivity.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}