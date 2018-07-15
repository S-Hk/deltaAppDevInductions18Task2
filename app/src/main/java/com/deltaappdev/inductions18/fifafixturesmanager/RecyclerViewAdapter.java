package com.deltaappdev.inductions18.fifafixturesmanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<matchFixtures> mDataList;


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView venueList;
        public TextView mdateList;
        public TextView mtimeList;
        public TextView teamANameList;
        public TextView teamBNameList;
        public ImageView teamALogoList;
        public ImageView teamBLogoList;


        public MyViewHolder(View view){
            super(view);
            teamANameList = (TextView) view.findViewById(R.id.l_teamAName);
            teamALogoList = (ImageView) view.findViewById(R.id.l_teamALogo);
            teamBNameList = (TextView) view.findViewById(R.id.l_teamBName);
            teamBLogoList = (ImageView) view.findViewById(R.id.l_teamBLogo);
            venueList = (TextView) view.findViewById(R.id.l_venue);
            mdateList = (TextView) view.findViewById(R.id.l_date);
            mtimeList = (TextView) view.findViewById(R.id.l_time);
        }
    }

        public RecyclerViewAdapter(List<matchFixtures> dataList){
            this.mDataList = dataList;
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_view_main_layout, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            matchFixtures data = mDataList.get(position);
            holder.teamANameList.setText(data.getTeamName(true));
            //holder.teamALogoList.setImageResource(data.getTeamImage(true));
            holder.teamANameList.setText(data.getTeamName(false));
            //holder.teamALogoList.setImageResource(data.getTeamImage(false));
            holder.venueList.setText(data.getMatchVenue());
            holder.mdateList.setText(data.getMatchDate());
            holder.mtimeList.setText(data.getMatchTime());
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }
}

