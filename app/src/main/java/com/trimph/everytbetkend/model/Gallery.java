package com.trimph.everytbetkend.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 相册
 * Created by tao on 2016/11/7.
 */

@Entity
public class Gallery {
    @Id
    public long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Generated(hash = 549927093)
    public Gallery(long id) {
        this.id = id;
    }

    @Generated(hash = 1045653000)
    public Gallery() {
    }

    

}
