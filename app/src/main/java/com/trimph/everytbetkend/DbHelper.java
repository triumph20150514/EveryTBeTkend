package com.trimph.everytbetkend;

import android.content.Context;
import com.trimph.everytbetend.model.db.DaoMaster;
import org.greenrobot.greendao.database.Database;

/**
 * Created by tao on 2016/11/7.
 */

public class DbHelper extends DaoMaster.OpenHelper {
    public Context context;
    public String name;

    public DbHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        DaoMaster.createAllTables(db, true);  // greenDao升级时要加上  若是要添加其他字段
        db.execSQL("Alter table Picture Add sex Integer");
    }
}
