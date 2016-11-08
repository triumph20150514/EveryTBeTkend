package com.trimph.everytbetkend.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.trimph.everytbetend.model.db.DaoMaster;
import com.trimph.everytbetend.model.db.DaoSession;
import com.trimph.everytbetend.model.db.PictureDao;
import com.trimph.everytbetkend.DbHelper;

import java.util.List;

/**
 * Created by tao on 2016/11/7.
 */

public class PictureUtil {

    public static PictureDao pictureDao;
    public DaoMaster.DevOpenHelper devOpenHelper;
    public DaoMaster daoMaster;
    public static PictureUtil pictureUtil;
    public Context context;
    public String sp;

    public PictureUtil(Context context, String picture) {
        this.context = context;
        this.sp = picture;
    }

    public static PictureUtil getInstance(Context context, String picture) {
        if (pictureUtil == null) {
            pictureUtil = new PictureUtil(context, picture);
        }
        return pictureUtil;
    }

    //    DaoMaster.DevOpenHelper a = new DaoMaster.DevOpenHelper(this,"database_name",null);
//    try {
//        daoSession = new DaoMaster(a.getEncryptedWritableDb(MY_PWD)).newSession();
//        daoSession.getUserDao().insert(man1);
    public DaoSession daoSession;

    public void saveToDb(Picture picture) {
        if (devOpenHelper == null) {
            //使用自己继承的DbHelper可用于数据库版本升级
            daoMaster = new DaoMaster(new DbHelper(context, sp).getWritableDatabase());

            devOpenHelper = new DaoMaster.DevOpenHelper(context, sp);
        }
        daoSession = daoMaster.newSession();
        daoSession.getPictureDao().insert(picture);
    }


    public void updateDb(Picture picture) {
        if (devOpenHelper == null) {
            devOpenHelper = new DaoMaster.DevOpenHelper(context, sp);
        }
        daoSession = new DaoMaster(devOpenHelper.getEncryptedWritableDb("Pwd")).newSession();
        daoSession.getPictureDao().update(picture);
    }

    public DaoMaster getDaoMaster() {
        return  new DaoMaster(new DbHelper(context, sp).getWritableDatabase());
    }

    public List<Picture> getDb() {
        if (devOpenHelper == null) {
            devOpenHelper = new DaoMaster.DevOpenHelper(context, sp);
        }
        daoMaster = new DaoMaster(new DbHelper(context, sp).getWritableDatabase());
        daoSession = daoMaster.newSession();
        return daoSession.getPictureDao().loadAll();
    }

    public void getVersion() {
        if (devOpenHelper == null) {
            devOpenHelper = new DaoMaster.DevOpenHelper(context, sp);
        }
        daoSession = new DaoMaster(devOpenHelper.getReadableDb()).newSession();

        Log.e("DB version", devOpenHelper.getReadableDatabase().getVersion() + "");
        Log.e("DB tablename", daoSession.getPictureDao().getTablename() + "");
        Toast.makeText(context, "version:" + devOpenHelper.getReadableDatabase().getVersion() + " name:" + daoSession.getPictureDao().getTablename(), Toast.LENGTH_LONG).show();
//        Toast.makeText(context, "tablename:" + daoSession.getPictureDao().getTablename() + "", Toast.LENGTH_LONG).show();
    }

}
