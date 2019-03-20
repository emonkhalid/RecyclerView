package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.TimeHolder> {

    private Context context;
    private List<TimeStamp>timeStampList;


    public TimeAdapter(Context context, List<TimeStamp> timeStampList) {
        this.context = context;
        this.timeStampList = timeStampList;
    }

    @NonNull
    @Override
    public TimeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.time_row, viewGroup, false);
        return new TimeHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeHolder timeHolder, final int i) {

        timeHolder.tv.setText(timeStampList.get(i).getTimeStamp());
        timeHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Position:"+ i, Toast.LENGTH_LONG).show();
            }
        });


        timeHolder.tvRowMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Toast.makeText(context,"Clicked", Toast.LENGTH_LONG).show();
                PopupMenu popupMenu = new PopupMenu(context, v);
                popupMenu.getMenuInflater().inflate(R.menu.popup_row_menu, popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId())
                        {
                            case R.id.row_edit:
                                Toast.makeText(context,"Edit Pos:"+ i, Toast.LENGTH_LONG).show();
                                break;

                            case R.id.row_delete:
                                Toast.makeText(context,"Delete Pos:"+ i, Toast.LENGTH_LONG).show();
                                break;
                        }


                        return false;
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return timeStampList.size();
    }


    public void updateList(List<TimeStamp>timeStampList){

        this.timeStampList = timeStampList;
        notifyDataSetChanged();
    }


    class TimeHolder extends RecyclerView.ViewHolder{
        TextView tv,tvRowMenu;
        public TimeHolder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.row_time);
            tvRowMenu = itemView.findViewById(R.id.row_menu);
        }
    }
}
