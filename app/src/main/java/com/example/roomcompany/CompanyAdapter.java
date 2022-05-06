package com.example.roomcompany;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomcompany.Room.CompanyModel;

import java.util.ArrayList;
import java.util.List;

public class CompanyAdapter  extends RecyclerView.Adapter<CompanyAdapter.MyViewHolder> {

    private Context context;
    private List<CompanyModel> companyModelList;
    private CompanyAdapterInterface myInterface;

    public CompanyAdapter(Context context, CompanyAdapterInterface myInterface) {
        this.context = context;
        this.myInterface = myInterface;
        companyModelList=new ArrayList<>();
    }

    public CompanyAdapter(Context context) {
        this.context = context;
        companyModelList=new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.comapny_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CompanyModel companyModel=companyModelList.get(position);
        holder.name.setText(companyModel.getCompanyName());
        holder.location.setText(companyModel.getLocation());

    }


    @Override
    public int getItemCount() {
        return companyModelList.size();
    }


    public void addCompany(CompanyModel model){
        companyModelList.add(model);
        notifyDataSetChanged();
    }


    public void removeCompany(int pos){
        companyModelList.remove(pos);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,location;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
          name  =itemView.findViewById(R.id.comapnyName);
            location=itemView.findViewById(R.id.companyLocation);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myInterface.SimpleClick(getAdapterPosition(),companyModelList.get(getAdapterPosition()).getCompanyId());
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    myInterface.LongClick(getAdapterPosition(),companyModelList.get(getAdapterPosition()).getCompanyId());

                    return true;
                }
            });



        }
    }
}
