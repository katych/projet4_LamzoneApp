package com.example.mareu.model;


public class Meeting {

    private String mSubject;
    private Room mRoom;
    private String mHour;
    private String mDate;
    private String mEmails;//max3

    public Meeting(String mSubject, Room mRoom, String mHour,String mDate, String mEmails) {
        this.mSubject = mSubject;
        this.mRoom = mRoom;
        this.mHour = mHour;
        this.mDate= mDate;
        this.mEmails= mEmails;
    }

    public String getmSubject() {
        return mSubject;
    }

    public void setmSubject(String mSubject) {
        this.mSubject = mSubject;
    }


    public String getmHour() {
        return mHour;
    }

    public void setmHour(String mHour) {
        this.mHour = mHour;
    }


    public Room getmRoom() {
        return mRoom;
    }

    public void setmRoom(Room mRoom) {
        this.mRoom = mRoom;
    }



    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmEmails() {
        return mEmails;
    }

    public void setmEmails(String mEmails) {
        this.mEmails = mEmails;
    }
}
