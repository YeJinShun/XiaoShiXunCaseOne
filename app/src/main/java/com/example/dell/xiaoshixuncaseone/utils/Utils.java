package com.example.dell.xiaoshixuncaseone.utils;

import com.example.dell.xiaoshixuncaseone.api.App;
import com.example.dell.xiaoshixuncaseone.bean.Bean;
import com.example.dell.xiaoshixuncaseone.db.BeanDao;
import com.example.dell.xiaoshixuncaseone.db.DaoMaster;
import com.example.dell.xiaoshixuncaseone.db.DaoSession;

import java.util.List;

public class Utils {
    private static Utils utils;
    private final BeanDao beanDao;

    public Utils() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(App.getApp(), "yjs.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        beanDao = daoSession.getBeanDao();

    }

    public static Utils getUtils() {
        if (utils == null){
            synchronized (Utils.class){
                utils = new Utils();
            }
        }
        return utils;
    }
    public long insert(Bean bean){
        if (!zh(bean)){
        return beanDao.insert(bean);
        }
        return -1;
    }
    public List<Bean> query(){
        return beanDao.queryBuilder().list();
    }
    private boolean zh(Bean bean) {
        List<Bean> list = beanDao.queryBuilder().where(BeanDao.Properties.Img.eq(bean.getImg())).list();
        if (list.size()>0){
            return true;
        }
        return false;
    }
}
