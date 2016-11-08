package com.trimph.everytbetkend.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by tao on 2016/11/7.
 */

@Entity
public class Picture {
    @Id(autoincrement = true)
    public long id;
    @Property(nameInDb = "imageUrl")
    public String url;
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Generated(hash = 391631954)
    public Picture(long id, String url) {
        this.id = id;
        this.url = url;
    }
    @Generated(hash = 1602548376)
    public Picture() {
    }

}
