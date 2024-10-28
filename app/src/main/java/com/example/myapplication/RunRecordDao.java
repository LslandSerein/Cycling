package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RunRecordDao {
    @Insert
    void insert(RunRecordEntity record);

    @Query("SELECT * FROM run_records")
    List<RunRecordEntity> getAllRecords();

//    @Query("DELETE FROM run_records")
//    void deleteAll(); // 添加清空记录的方法
}
