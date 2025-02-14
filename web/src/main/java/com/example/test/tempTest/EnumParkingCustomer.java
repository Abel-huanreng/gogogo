package com.example.test.tempTest;

import lombok.Getter;

/**
 * @author hejing
 * @date 2024/11/28:上午9:05
 */
public enum EnumParkingCustomer {
    NULL_CUSTOMER(0, "", 0),
    MIWANG_LINTING(1, "咪网临停车虚拟客户", 1),
    MIWANG_BAOYUE(2, "咪网包月车虚拟客户", 2),
    BAOXIN_LINTING(3, "保信临停车虚拟客户", 1),
    BAOXIN_BAOYUE(4, "保信包月车虚拟客户", 2);
    @Getter
    private final int code;
    @Getter
    private final String name;
    //数据类型 1:临停,2:包月
    @Getter
    private final int type;

    EnumParkingCustomer(int code, String name, int type) {
        this.code = code;
        this.name = name;
        this.type = type;
    }

    public static EnumParkingCustomer getEnumByName(String name) {
        for (EnumParkingCustomer customer : values()) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}
