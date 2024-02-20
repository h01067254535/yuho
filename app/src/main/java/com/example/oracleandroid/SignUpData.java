package com.example.oracleandroid;

import com.google.gson.annotations.SerializedName;

public class SignUpData {
    /**
     * SerializedName 으로 JSON 객체와 해당 변수를 매칭
     * @SerializedName 괄호 안에는 해당 JSON 객체의 변수 명 적기
     * 이때, POST 매핑으로 받아올 값은, 굳이 annotation 을 붙이지 않고, JSON 객체의 변수명과 일치하는 변수만 선언하면 됨
     */
    @SerializedName("empNo")
    private String empNo;
    @SerializedName("name")
    private String name;

    @SerializedName("deptNm")
    private String deptNm;
    @SerializedName("telNo")
    private String telNo;

    public SignUpData(String empNo, String name, String deptNm, String telNo) {
        this.empNo = empNo;
        this.name = name;
        this.deptNm = deptNm;
        this.telNo = telNo;
    }
}