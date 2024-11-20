package com.example.system.domain;

/**
 * 报事性质枚举
 *
 * @author tw
 */
public enum EnumIncidentNature {
    CONSULTING(1, "BS","报事"),
    PRAISE(2, "BX","报修"),
    ADVICE(3, "ZX","咨询"),
    COMPLAINTS(4, "TS","投诉"),
    REPAIR(5, "JY","建议"),
    SERVICE(6, "BY","表扬");


    private final Integer code;
    private final String info;
    private final String describe;

    EnumIncidentNature(Integer code, String info, String describe) {
        this.code = code;
        this.info = info;
        this.describe = describe;
    }

    public Integer getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public String getDescribe() {
        return describe;
    }

    public static EnumIncidentNature getEnum(Integer code) {
        EnumIncidentNature[] incidentNatures = values();

        for (EnumIncidentNature incidentNature : incidentNatures
        ) {
            if (incidentNature.code.equals(code)) {
                return incidentNature;
            }
        }
        return null;
    }

    public static EnumIncidentNature getEnumByDescribe(String info){
        EnumIncidentNature[] incidentNatures=values();
        for (EnumIncidentNature incidentNature:incidentNatures
        ) {
            if(incidentNature.getInfo().equals(info)){
                return incidentNature;
            }
        }
        return  null;
    }

}
