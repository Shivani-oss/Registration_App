package com.example.homeassignment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Locale;

public class TabTwo extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<DataSet> arrayList = new ArrayList<>();
    FirebaseRecyclerAdapter<DataSet,DataSetHolder> adapter;
    DataSet2 dataSet2;
    FirebaseDatabase database;
    DatabaseReference reference;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Student").child("Profile");

        recyclerView = view.findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        showlist();

        return view;
    }

    private  void  showlist () {
        FirebaseRecyclerOptions<DataSet>  options = new FirebaseRecyclerOptions.Builder<DataSet>()
                .setQuery(reference, DataSet.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<DataSet, DataSetHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull DataSetHolder dataSetHolder, int i, @NonNull final DataSet dataSet) {
                dataSetHolder.tv.setText(dataSet.getId());
                dataSetHolder.OnClickInterface(new OnClickInterface() {
                    @Override
                    public void onClick(View view, boolean isLongPresses) {
                        Intent intent = new Intent(getContext(), Data.class);
                        intent.putExtra("ID",dataSet.getId());
                        startActivity(intent);

                    }
                });
            }

            @NonNull
            @Override
            public DataSetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_id, parent, false);
                return new DataSetHolder(view);
            }
        };

        adapter.startListening();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }
}

