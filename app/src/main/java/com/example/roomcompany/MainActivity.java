package com.example.roomcompany;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.roomcompany.Room.CompanyDatabase;
import com.example.roomcompany.Room.CompanyInterface;
import com.example.roomcompany.Room.CompanyModel;
import com.example.roomcompany.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CompanyAdapterInterface{

    ActivityMainBinding binding;

    CompanyDatabase companyDatabase;
    CompanyInterface companyInterface;
    List<CompanyModel> companyModelList;
    CompanyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        companyDatabase=CompanyDatabase.getInstance(this);
        companyInterface=companyDatabase.getInterface();

        companyModelList=new ArrayList<>();

        binding.addcompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( MainActivity.this,AddCompany.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        companyModelList=companyInterface.getAllCompany();
        CompanyAdapter adapter=new CompanyAdapter(this,this);

        for (int i = 0; i < companyModelList.size(); i++) {
            adapter.addCompany(companyModelList.get(i));
        }
        adapter.notifyDataSetChanged();
        binding.companyRecycler.setAdapter(adapter);
        binding.companyRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void LongClick(int pos, int id) {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Delete").setMessage("You sure ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        adapter.removeCompany(pos);
                        companyInterface.deleteCompany(id);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    @Override
    public void SimpleClick(int po, int id) {
        Intent intent =new Intent(MainActivity.this,UpdateActivity.class);
        intent.putExtra("name",companyModelList.get(po).getCompanyName());
        intent.putExtra("location",companyModelList.get(po).getLocation());
        intent.putExtra("id",companyModelList.get(po).getCompanyId());
        startActivity(intent);

    }
}