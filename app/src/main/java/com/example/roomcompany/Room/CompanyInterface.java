package com.example.roomcompany.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CompanyInterface {

    @Insert
    void creatcomapny(CompanyModel model);

    @Update
    void  updatedetails(CompanyModel model);

    @Query("delete from companyDetails where companyId=:id")
    void deleteCompany(int id);

    @Query("select * from companyDetails")
    List<CompanyModel> getAllCompany();
}
