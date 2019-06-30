package com.example.dell.xiaoshixuncaseone.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Bean {
    @Id(autoincrement = true)
    private Long id;
    private String img;
    private String name;
    private String title;
    @Generated(hash = 1763533112)
    public Bean(Long id, String img, String name, String title) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.title = title;
    }
    @Generated(hash = 80546095)
    public Bean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
