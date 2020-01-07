package com.oktobro.fondo.model;

import java.time.LocalDateTime;

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2020/01/07
 */
public class BaseModel {

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtUpdate;

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(LocalDateTime gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}
