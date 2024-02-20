package com.example.oracleandroid;

public class UserDTO {
    private String EMP_NO;
    private String NAME;
    private String DEPT_NM;
    private String TEL_NO;

    public UserDTO(String EMP_NO, String NAME, String DEPT_NM, String TEL_NO) {
        this.EMP_NO = EMP_NO;
        this.NAME = NAME;
        this.DEPT_NM = DEPT_NM;
        this.TEL_NO = TEL_NO;
    }

    public String getEMP_NO() {
        return EMP_NO;
    }

    public void setEMP_NO(String EMP_NO) {
        this.EMP_NO = EMP_NO;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDEPT_NM() {
        return DEPT_NM;
    }

    public void setDEPT_NM(String DEPT_NM) {
        this.DEPT_NM = DEPT_NM;
    }

    public String getTEL_NO() {
        return TEL_NO;
    }

    public void setTEL_NO(String TEL_NO) {
        this.TEL_NO = TEL_NO;
    }
}
