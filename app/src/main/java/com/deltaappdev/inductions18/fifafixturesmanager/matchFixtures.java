package com.deltaappdev.inductions18.fifafixturesmanager;

import android.media.Image;

import java.sql.Time;
import java.util.Date;

public class matchFixtures {
    //int matchNo;
    private String matchTeamA, matchTeamB;
    private String matchDate;
    private String matchTime;
    private String matchVenue;

    private byte[] teamALogo, teamBLogo;

    public matchFixtures() {

    }


    public matchFixtures(String tA, String tB, byte[] tIA, byte[] tIB, String venue, String mDate, String mTime) {

        matchTeamA=tA;
        matchTeamB=tB;
        teamALogo=tIA;
        teamBLogo=tIB;
        matchVenue=venue;
        matchDate=mDate;
        matchTime=mTime;

    }

    public matchFixtures(String matchTeamA, String matchTeamB, String matchDate, String matchTime, String matchVenue, byte[] teamALogo, byte[] teamBLogo) {
        this.matchTeamA = matchTeamA;
        this.matchTeamB = matchTeamB;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.matchVenue = matchVenue;
        this.teamALogo = teamALogo;
        this.teamBLogo = teamBLogo;
    }

    public void setTeamALogo(byte[] teamALogo) {
        this.teamALogo = teamALogo;
    }

    public void setTeamBLogo(byte[] teamBLogo) {
        this.teamBLogo = teamBLogo;
    }

    public String getTeamName(boolean A) {
        if (A) {
            return matchTeamA;
        } else {
            return matchTeamB;
        }
    }

    public byte[] getTeamImage(boolean A){
        if (A) {
            return teamALogo;
        } else {
            return teamBLogo;
        }
    }

    public String getMatchVenue() {
        return matchVenue;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getMatchTime() {
        return matchTime;
    }


}

// https://www.youtube.com/watch?v=_xIWkCJZCu0
// https://www.youtube.com/watch?v=Jc8EJ_2SnzI
// https://imagecolorpicker.com/en
