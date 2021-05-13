package com.fastjson;

import java.time.LocalDateTime;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

class Address {
    // serialize默认为true，设置为false表示不能被json序列化;相对的有deserialize
    @JSONField(serialize = false, ordinal = 3)
    private String province;
    @JSONField(ordinal = 2)
    private String city;
    @JSONField(ordinal = 1)
    private String area;
    @JSONField(ordinal = 0)
    private String street;
    @JSONField(name = "streetPhoneNo")
    private String phoneNumber;

    @JSONField(name="visitTime", format = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime dateTime;

    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    
    
}

public class JsonAnnotationDemo {
    public static void main(String[] args) {
        Address a = new Address();
        a.setProvince("四川");
        a.setCity("成都");
        a.setArea("武侯");
        a.setStreet("新光路");
        a.setPhoneNumber("028002XXX12");
        a.setDateTime(LocalDateTime.now());
        String result = JSON.toJSONString(a);
        System.out.println(result);
    }
}
