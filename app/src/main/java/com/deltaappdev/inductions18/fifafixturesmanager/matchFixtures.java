package com.deltaappdev.inductions18.fifafixturesmanager;

import android.media.Image;

import java.sql.Time;
import java.util.Date;

public class matchFixtures {
    //int matchNo;
    private String matchTeamA, matchTeamB;
    private Date matchDate;
    private Time matchTime;
    private String matchVenue;

    int teamALogo, teamBLogo;

    public matchFixtures() {
    }


    public matchFixtures(String tA, String tB, int tIA, int tIB) {
        matchTeamA=tA;
        matchTeamB=tB;
        teamALogo=tIA;
        teamBLogo=tIB;

    }

    public String getTeamName(boolean A) {
        if (A) {
            return matchTeamA;
        } else {
            return matchTeamB;
        }
    }

    public int getTeamImage(boolean A){
        if (A) {
            return teamALogo;
        } else {
            return teamBLogo;
        }
    }

    public String getMatchVenue() {
        return matchVenue;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public Time getMatchTime() {
        return matchTime;
    }



}

// https://www.youtube.com/watch?v=_xIWkCJZCu0
// https://www.youtube.com/watch?v=Jc8EJ_2SnzI
// https://imagecolorpicker.com/en
