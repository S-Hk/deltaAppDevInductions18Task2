package com.deltaappdev.inductions18.fifafixturesmanager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
            byte[] teamIconA = data.getTeamImage(true);
            byte[] teamIconB = data.getTeamImage(false);
            Bitmap bitmapA = BitmapFactory.decodeByteArray(teamIconA, 0,teamIconA.length);
            Bitmap bitmapB = BitmapFactory.decodeByteArray(teamIconB, 0,teamIconB.length);

            holder.teamANameList.setText(data.getTeamName(true));
            //holder.teamALogoList.setImageResource(data.getTeamImage(true));
            holder.teamALogoList.setImageBitmap(bitmapA);
            holder.teamBNameList.setText(data.getTeamName(false));
            //holder.teamBLogoList.setImageResource(data.getTeamImage(false));
            holder.teamBLogoList.setImageBitmap(bitmapB);
            holder.venueList.setText("Venue: "+data.getMatchVenue());
            holder.mdateList.setText("Date: "+data.getMatchDate());
            holder.mtimeList.setText("Time: "+data.getMatchTime());
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

}

