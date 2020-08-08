package com.example.homeassignment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataSetHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView tv;
    public  OnClickInterface onClickInterface;


    public DataSetHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
        itemView.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        onClickInterface.onClick(v,false);
    }

    public void OnClickInterface(OnClickInterface onClickInterface){
        this.onClickInterface = onClickInterface;

    }


}
