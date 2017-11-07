package com.example.uberv.cloudmessagingsandbox;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Map;

public class NotificationData implements Parcelable {

    private final String mAction;
    private final String mUrl;
    private final String mData;

    public NotificationData(String action, String url, String data) {
        mAction = action;
        mUrl = url;
        mData = data;
    }

    public NotificationData(Map<String, String> dataMap) {
        mAction = dataMap.get("action");
        mUrl = dataMap.get("url");
        mData = dataMap.get("data");
    }

    protected NotificationData(Parcel in) {
        mAction = in.readString();
        mUrl = in.readString();
        mData = in.readString();
    }

    public String getAction() {
        return mAction;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getData() {
        return mData;
    }

    public static Creator<NotificationData> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mAction);
        dest.writeString(mUrl);
        dest.writeString(mData);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NotificationData> CREATOR = new Creator<NotificationData>() {
        @Override
        public NotificationData createFromParcel(Parcel in) {
            return new NotificationData(in);
        }

        @Override
        public NotificationData[] newArray(int size) {
            return new NotificationData[size];
        }
    };

    @Override
    public String toString() {
        return "NotificationData{" +
                "mAction='" + mAction + '\'' +
                ", mUrl='" + mUrl + '\'' +
                ", mData='" + mData + '\'' +
                '}';
    }
}
