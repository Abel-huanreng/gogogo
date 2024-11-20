package com.example.system.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 减免申请审批对象 tb_charge_audit_waiv_approve
 *
 * @author tw
 * @date 2021-03-28
 */
@Data
public class AuditWaivApprove implements Serializable {
    private static final long serialVersionUID = 1L;

    /**减免申请编码*/
    @ExcelIgnore
    private String id;

    /**项目编码*/
    @ExcelIgnore
    private String commId;

    /**申请类型 （0新增,1变更）*/
    @ExcelProperty(value = "申请类型 ",index = 1)
    private String approveType;

    /**减免类型*/
    @ExcelProperty(value = "减免类型",index=3)
    private String waivClass;

    /**减免原因*/
    @ExcelProperty(value = "减免原因",index=4)
    private String waivReason;

    /**减免单号*/
    @ExcelProperty(value = "减免单号",index = 2)
    private String busiCode;

    /**客户编码*/
    @ExcelIgnore
    private String customerId;

    /**资源编码*/
    @ExcelIgnore
    private String resourceId;

    /**表计名称*/
    @ExcelProperty(value = "表计名称",index = 8)
    private String meterName;

    /**减免科目编码*/
    @ExcelIgnore
    private String costId;

    /**减免方式*/
    @ExcelProperty(value = "减免方式",index = 10)
    private String waivType;

    /**按总额减免方式*/
    @ExcelIgnore
    private Integer waivIsTotal;

    /**减免金额*/
    @ExcelProperty(value = "减免金额(元)",index = 11)
    private BigDecimal waivAmount;

    /**减免比率*/
    @ExcelProperty(value = "减免比率(%)",index= 12)
    private BigDecimal waivRate;

    /**费用时间从*/
    @ExcelProperty(value = "费用时间从", index = 13)
    private Date feeDateStart;

    /**费用时间到*/
    @ExcelProperty(value = "费用时间到", index = 14)
    private Date feeDateEnd;

    /**费用开始时间从*/
    @ExcelProperty(value = "费用开始时间从", index = 15)
    private Date feeStartDateStart;

    /**费用结束时间到*/
    @ExcelProperty(value = "费用结束时间到", index = 16)
    private Date feeEndDateEnd;

    /**预计减免总额*/
    @ExcelProperty(value = "减免总额(元)",index = 17)
    private BigDecimal expectWaivAmount;

    /**已经减免金额*/
    @ExcelProperty(value = "已经减免金额(元)",index = 18)
    private BigDecimal hasWaivAmount;

    /**减免协议编号*/
    @ExcelIgnore
    private String waivAgreementCode;

    /**减免协议签订时间*/
    @ExcelIgnore
    private Date waivAgreementDate;

    /**减免协议内容*/
    @ExcelIgnore
    private String waivAgreementContent;

    /**减免备注*/
    @ExcelIgnore
    private String waivMemo;

    /**操作时间*/
    @ExcelIgnore
    private Date dealDate;

    /**操作人*/
    @ExcelIgnore
    private String dealUser;

    /**审核状态*/
    @ExcelProperty(value = "审核状态",index = 21)
    private Long isAudit;

    /**发起人*/
    @ExcelProperty(value = "发起人",index = 19)
    private String createUser;

    /**发起时间*/
    @ExcelProperty(value = "发起时间", index = 20)
    private Date createDate;

    /**是否冻结*/
    @ExcelProperty(value = "冻结状态",index = 22)
    private Integer isFreeze;

    /**冻结操作人*/
    @ExcelProperty(value = "操作人",index = 23)
    private String freezeUser;

    /**冻结操作时间*/
    @ExcelProperty(value = "操作时间",index = 24)
    private Date freezeDate;

    /**冻结操作原因*/
    @ExcelProperty(value = "冻结/解冻原因",index = 25)
    private String freezeReason;

    /**变更说明*/
    @ExcelIgnore
    private String changeMemo;

    /**附件*/
    @ExcelIgnore
    private String annexAddress;
}
