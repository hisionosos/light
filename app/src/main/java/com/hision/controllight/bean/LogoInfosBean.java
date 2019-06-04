package com.hision.controllight.bean;

import java.io.Serializable;

public class LogoInfosBean implements Serializable {

    /**
     * uuid : 526c7fde-e39e-458a-a13d-21f3c0dd23f3
     * createDate : 2019-05-09T09:35:50.000+0000
     * modifyDate : 2019-05-09T11:05:53.000+0000
     * sn : xxx12345
     * status : init
     * name : null
     * wifiInfo : null
     * playState : null
     */
    private String sn;
    private String status;
    private String name;
    private String bleAddress;
    private boolean isSelected;
    private boolean isEditable = false;
    private String uuid;
    private String createDate;
    private String modifyDate;
    private String wifiInfo;
    private String playState;
    private String bindingStatus;

    public String getBindingStatus() {
        return bindingStatus;
    }

    public void setBindingStatus(String bindingStatus) {
        this.bindingStatus = bindingStatus;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean editable) {
        isEditable = editable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return bleAddress;
    }

    public void setAddress(String bleAddress) {
        this.bleAddress = bleAddress;
    }



    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getWifiInfo() {
        return wifiInfo;
    }

    public void setWifiInfo(String wifiInfo) {
        this.wifiInfo = wifiInfo;
    }

    public String getPlayState() {
        return playState;
    }

    public void setPlayState(String playState) {
        this.playState = playState;
    }
}
