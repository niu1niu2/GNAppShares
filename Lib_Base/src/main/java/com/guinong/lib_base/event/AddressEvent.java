package com.guinong.lib_base.event;

import org.greenrobot.eventbus.Subscribe;

/**
 * @author csn
 * @date 2017/6/9 0009 14:52
 * @content
 */
public class AddressEvent extends BaseEvent {
    private String name;
    private String phone;
    private String detail;
    private int addressId;
    private int regionId;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
