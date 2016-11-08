package com.trimph.everytbetkend.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by tao on 2016/11/7.
 */

@Entity()
public class User {
    @Id
    public long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Generated(hash = 936488051)
    public User(long id) {
        this.id = id;
    }

    @Generated(hash = 586692638)
    public User() {
    }
}
