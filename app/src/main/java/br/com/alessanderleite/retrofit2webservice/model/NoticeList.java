package br.com.alessanderleite.retrofit2webservice.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NoticeList {

    @SerializedName("notice_list")
    private ArrayList<Notice> noticeList;

    public ArrayList<Notice> getNoticeArrayList() {
        return noticeList;
    }

    public void setNoticeList(ArrayList<Notice> noticeList) {
        this.noticeList = noticeList;
    }
}
