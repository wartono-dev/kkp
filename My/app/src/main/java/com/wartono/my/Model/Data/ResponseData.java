package com.wartono.my.Model.Data;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseData implements Parcelable
{

    @SerializedName("kode")
    @Expose
    private Integer kode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<ModelData> data = null;
    public final static Parcelable.Creator<ResponseData> CREATOR = new Creator<ResponseData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ResponseData createFromParcel(Parcel in) {

            return new ResponseData(in);
        }

        public ResponseData[] newArray(int size) {

            return (new ResponseData[size]);
        }

    }
            ;

    protected ResponseData(Parcel in) {
        this.kode = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.data, (com.wartono.my.Model.Data.ModelData.class.getClassLoader()));
    }

    public ResponseData() {
    }

    public Integer getKode() {
        return kode;
    }

    public void setKode(Integer kode) {
        this.kode = kode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ModelData> getData() {
        return data;
    }

    public void setData(List<ModelData> data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(kode);
        dest.writeValue(message);
        dest.writeList(data);
    }

    public int describeContents() {
        return 0;
    }

}