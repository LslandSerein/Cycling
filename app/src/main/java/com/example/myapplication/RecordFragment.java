package com.example.myapplication;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class RecordFragment extends Fragment {
    private RecyclerView recyclerView;
    private RunRecordAdapter adapter;
    private List<RunRecordEntity> runRecords;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        runRecords = new ArrayList<>();

        adapter = new RunRecordAdapter(runRecords);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadRunRecords(); // 加载记录

        return view;
    }

    private void loadRunRecords() {
        AppDatabase db = AppDatabase.getInstance(getContext());
        new Thread(() -> {
            runRecords.clear();
            runRecords.addAll(db.runRecordDao().getAllRecords());
            getActivity().runOnUiThread(() -> adapter.notifyDataSetChanged());
        }).start(); // 异步加载记录
    }
}
