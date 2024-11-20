package com.example.system.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuditWaivApproveDTO extends AuditWaivApprove implements Serializable {
    private static final long serialVersionUID = 1L;
    /**项目名称*/
    @ExcelProperty(value = "项目名称",index = 0)
    private String projectName;
    /** 资源编号 */
    @ExcelProperty(value = "资源编号",index = 5)
    private String resourceCode;
    /** 客户名称 */
    @ExcelProperty(value = "客户名称",index = 6)
    private String clientName;
    /** 管家名称 */
    @ExcelProperty(value = "管家名称",index = 7)
    private String houseKeeperName;
    /** 收费科目 */
    @ExcelProperty(value = "收费科目",index = 9)
    private String costName;
    /** 公司收费科目 */
    @ExcelIgnore
    private String corpCostId;
    /** 发起人 */
    @ExcelIgnore
    private String createUserName;
    @ExcelIgnore
    private String[] waivClassArray;
    @ExcelIgnore
    private String[] costNameArray;
    @ExcelIgnore
    private String[] publishTimeCreateDate;
    @ExcelIgnore
    private String[] publishTimeFeeDate;
    @ExcelIgnore
    private String[] publishTimeFeeStartDate;
    @ExcelIgnore
    private String[] ids;
    @ExcelIgnore
    private String instanceId;
    /**保存或提交*/
    @ExcelIgnore
    private String saveOrFail;
    /**申请名字*/
    @ExcelIgnore
    private String approveName;
    @ExcelIgnore
    private String waivTypeName;
    /**表计*/
    @ExcelIgnore
    private List<LabelValueDTO> meterIdList;
    @ExcelIgnore
    private String chargeUrl;
    @ExcelIgnore
    private List<LabelValueDTO> annexAddressUrl;

}
