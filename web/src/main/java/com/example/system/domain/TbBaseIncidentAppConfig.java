package com.example.system.domain;

import lombok.Data;

/**
 * @author hejing
 * @date 2024/6/19:下午7:53
 */
@Data
public class TbBaseIncidentAppConfig {
    /**
     * Id
     */
    private String id;

    /**
     * 项目id
     */
    private String commId;

    /**
     * 配置类
     */
    private String incidentRecord;

    /**
     * 限定使用账号
     */
    private String takeEffectUserId;

    /**
     * 是否禁用
     */
    private Integer isDelete;
}
