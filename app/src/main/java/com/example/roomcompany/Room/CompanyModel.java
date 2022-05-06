package com.example.roomcompany.Room;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "companyDetails")
public class CompanyModel {

@PrimaryKey(autoGenerate = true)
    private int companyId;
    private String companyName;
    private String location;


    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
