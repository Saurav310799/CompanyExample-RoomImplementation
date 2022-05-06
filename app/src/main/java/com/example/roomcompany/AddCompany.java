package com.example.roomcompany;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.roomcompany.Room.CompanyDatabase;
import com.example.roomcompany.Room.CompanyInterface;
import com.example.roomcompany.Room.CompanyModel;
import com.example.roomcompany.databinding.ActivityAddCompanyBinding;

public class AddCompany extends AppCompatActivity {

    ActivityAddCompanyBinding binding;
    CompanyDatabase database;
    CompanyInterface myInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddCompanyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database=CompanyDatabase.getInstance(this);
        myInterface=database.getInterface();

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cname=binding.nameId.getText().toString() ;
                String clocation=binding.locationId.getText().toString();
                if (cname.trim().length()==0 && clocation.trim().length()==0 ){
                    Toast.makeText(AddCompany.this, "Fields are Empty!", Toast.LENGTH_SHORT).show();
                    return;
                }

                CompanyModel companyModel=new CompanyModel();
                companyModel.setCompanyName(cname);
                companyModel.setLocation(clocation);
                myInterface.creatcomapny(companyModel);

                finish();
                Toast.makeText(AddCompany.this, "Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}