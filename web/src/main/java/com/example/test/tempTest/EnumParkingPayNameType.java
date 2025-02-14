package com.example.test.tempTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hejing
 * @date 2025/1/9:上午11:04
 */
public enum EnumParkingPayNameType {
    NULLTYPE(0, ""),
    BX_WEIXIN(1, "保信车场-微信"),
    BX_ALIPAY(4, "保信车场-支付宝"),
    BX_CASH(14, "保信车场-现金"),
    BX_OTHER(21, "保信车场-城市大脑"),
    MW_WEIXIN(1, "咪网车场-微信"),
    MW_ALIPAY(4, "咪网车场-支付宝"),
    MW_CASH(14, "咪网车场-现金"),
    MW_OTHER(21, "咪网车场-城市大脑");

    private final int code;
    private final String name;

    // 使用HashMap来存储code与Enum的对应关系
    private static final Map<EnumParkingCustomer, Map<Integer, EnumParkingPayNameType>> codeMap = new HashMap<>();

    static {
        Map<Integer, EnumParkingPayNameType> baoxinPayMap = new HashMap<>();
        Map<Integer, EnumParkingPayNameType> miwangPayMap = new HashMap<>();

        baoxinPayMap.put(0, NULLTYPE);
        baoxinPayMap.put(1, BX_WEIXIN);
        baoxinPayMap.put(4, BX_ALIPAY);
        baoxinPayMap.put(14, BX_CASH);
        baoxinPayMap.put(21, BX_OTHER);

        miwangPayMap.put(0, NULLTYPE);
        miwangPayMap.put(1, MW_WEIXIN);
        miwangPayMap.put(4, MW_ALIPAY);
        miwangPayMap.put(14, MW_CASH);
        miwangPayMap.put(21, MW_OTHER);

        codeMap.put(EnumParkingCustomer.NULL_CUSTOMER, new HashMap<>());
        codeMap.put(EnumParkingCustomer.MIWANG_LINTING, miwangPayMap);
        codeMap.put(EnumParkingCustomer.MIWANG_BAOYUE, miwangPayMap);
        codeMap.put(EnumParkingCustomer.BAOXIN_LINTING, baoxinPayMap);
        codeMap.put(EnumParkingCustomer.BAOXIN_BAOYUE, baoxinPayMap);

    }

    EnumParkingPayNameType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    // 根据传入的code值获取对应的枚举实例，若不存在则返回NULLTYPE
    public static EnumParkingPayNameType getByCode(int code, EnumParkingCustomer customerType) {
        Map<Integer, EnumParkingPayNameType> enumParkingPayNameTypeMap = codeMap.getOrDefault(customerType, new HashMap<>());
        return enumParkingPayNameTypeMap.getOrDefault(code, NULLTYPE);
    }

}
