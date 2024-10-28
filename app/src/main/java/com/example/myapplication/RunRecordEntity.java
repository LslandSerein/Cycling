package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "run_records")
public class RunRecordEntity {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public String runTime;
    public long duration; // 跑步时长（毫秒）
    public double speed; // 速度（分钟/千米）
    public double distance; // 路程（米）
}