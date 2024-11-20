package com.example.web;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 工单记录
 *
 * @author JockeyXc
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class IncidentRecord implements Serializable {
    /**
     * 报事ID
     */

    private String id;
    /**
     * 模板ID
     */

    private String masterplateId;
    /**
     * 项目ID
     */

    private String commId;

    /**
     * 区域名称
     */
    private String areaName;
    /**
     * 报事编号
     */

    private String incidentNum;
    /**
     * 报事性质
     */

    private Integer incidentNature;
    /**
     * 报事方式
     */

    private Integer incidentMethod;
    /**
     * 报事来源
     */
    private Integer incidentSource;
    /**
     * 报事区域
     */
    private Integer incidentPlace;
    /**
     * 资源编号id
     */
    private String resourceId;
    private String resourceCode;
    private String resourceName;
    /**
     * 客户名称id
     */
    private String customerId;
    /**
     * 公区方位id
     */
    private String publicPositionId;
    /**
     * 公区功能id
     */
    private String publicCharacterId;
    /**
     * 公区名称id
     */
    private String regionalplaceId;
    private String regionPlaceName;
    /**
     * 公区名称
     */
    private String regionalplaceName;
    /**
     * 设备名称id
     */
    private String eqId;
    /**
     * 报事人
     */
    private String incidentman;
    private String incidentmanName;
    /**
     * 联系电话
     */
    private String linktel;
    /**
     * 报事内容
     */
    private String incidentContent;
    /**
     * 报事说明
     */
    private String incidentReasons;
    /**
     * 预约处理时间
     */
    private Date reservedate;
    /**
     * 紧急程度
     */
    private Integer urgency;
    /**
     * 报事大类id
     */
    private String bigtypeId;

    /**
     * 报事大类code
     */
    private String bigtypeCode;
    /**
     * 总体时限
     */
    private Integer allLimit;
    /**
     * 确认时限
     */
    private Integer confirmLimit;
    /**
     * 派单时限
     */
    private Integer assignLimit;
    /**
     * 接单时限
     */
    private Integer takingorderLimit;
    /**
     * 处理时限
     */
    private Integer dealLimit;
    /**
     * 验收时限
     */
    private Integer checkLimit;
    /**
     * 报事细类id
     */
    private String finetypeId;
    /**
     * 报事细类code
     */
    private String finetypeCode;
    /**
     * 责任归属
     */
    private Integer incidentDuty;
    /**
     * 是否有偿
     */

    private Integer isfee;
    /**
     * 提交人
     */

    private String subUser;
    /**
     * 提交时间
     */

    private Date subTime;
    /**
     * 是否确认
     */

    private Integer isConfirm;
    /**
     * 确认人
     */

    private String confirmUser;
    /**
     * 确认时间
     */

    private Date confirmTime;
    /**
     * 是否派单
     */

    private Integer isAssign;
    /**
     * 派单人
     */

    private String assignUser;
    /**
     * 派单时间
     */

    private Date assignTime;
    /**
     * 派单方式
     */

    private Integer assignType;
    /**
     * 是否接单
     */

    private Integer isOrderReceiving;
    /**
     * 接单人
     */

    private String orderReceivingUser;
    /**
     * 接单时间
     */

    private Date orderReceivingTime;
    /**
     * 是否处理
     */

    private Integer isDeal;
    /**
     * 处理人
     */

    private String dealUser;
    /**
     * 协助人
     */

    private String helpUser;
    /**
     * 到场时间
     */

    private Date arrivalTime;
    /**
     * 完成时间
     */

    private Date endTime;
    /**
     * 额定工时
     */

    private Integer workingHours;
    /**
     * 难度系数
     */

    private Double difficultyRatio;
    /**
     * 完成数量
     */

    private Integer dealNum;
    /**
     * 合计工时
     */

    private Double allHours;
    /**
     * 服务费用
     */

    private BigDecimal allfeesAmount;
    /**
     * 逾期原因
     */

    private String overdueReasons;
    /**
     * 是否验收
     */

    private Integer isAcceptor;
    /**
     * 验收人
     */

    private String acceptorUser;
    /**
     * 验收时间
     */

    private Date acceptorTime;
    /**
     * 验收类型
     */

    private String acceptorType;
    /**
     * 强关原因
     */

    private String closeReasons;
    /**
     * 最近验收退单时间
     */

    private Date lastCheckingTime;
    /**
     * 关闭时间
     */

    private Date closeTime;
    /**
     * 是否待回访
     */

    private Integer isReply;
    /**
     * 回访类型
     */

    private Integer replyType;
    /**
     * 回访类型
     */

    private String replyUser;
    /**
     * 回访时间
     */

    private Date replyTime;
    /**
     * 回访结果
     */

    private String replyResults;
    /**
     * 不成功回访原因
     */

    private String unsuccessfulReplyReasons;
    /**
     * 不成功回访跟进方案
     */

    private String unsuccessfulReplyWithplan;
    /**
     * 客户满意度评价
     */

    private String SatisfactionQuality;
    /**
     * 最近回访退单时间
     */

    private Date lastReplyBackTime;
    /**
     * 转单对象
     */

    private String transferObject;
    /**
     * 转单时间
     */

    private Date transferTime;
    /**
     * 是否转单
     */

    private Integer isTransfer;
    /**
     * 是否暂挂
     */

    private Integer isSuspend;
    /**
     * 合计暂挂时间
     */

    private Integer allSuspendTime;
    /**
     * 撤销人
     */

    private String cancelUser;
    /**
     * 撤销时间
     */

    private Date cancelTime;
    /**
     * 撤销原因
     */

    private String cancelReasons;
    /**
     * 工单状态
     */

    private Integer incidentState;
    /**
     * 工单流程ID
     */

    private String incidentProcessId;
    /**
     * 是否删除
     */

    private Integer isDelete;
    /**
     * 删除时间
     */

    private Date deleteTime;
    /**
     * 时间戳
     */

    private Date timeStamp;

    /**
     * 项目名称
     */

    private String commName;

    /**
     * 资源管家
     */

    private String resourceHouseKepper;
    /**
     * 公区管家
     */

    private String publicAreaHouseKepper;
    /**
     * 是否有效投诉
     */

    private Integer isEffectiveComplaint;
    /**
     * 文件
     */

    private String file;

    /**
     * 催办次数
     */
    private Integer urgeFrequency;

    /**
     * 延期次数
     */
    private Integer postponeFrequency;


    /**
     * 是否抢单--该字段不在数据库中 仅作为逻辑标识字段
     */
    private int isRob;

    /**
     * 是否取消
     */

    private Integer isCancel;

    /**
     * 大类名称
     */

    private String bigTypeName;

    /**
     * 细类名称
     */

    private String fineTypeName;

    /**
     * 处理人名字
     */

    private String dealUserName;

    /**
     * 业务类型
     * 0：公区巡查，1：空房巡查，2：装修巡查，3：安全巡更，4：环境巡查
     * 				 * 5：品质核查，6：品质整改，7：设备巡检，8：设备维保，9：消防巡检
     * 				 * 10：任务抽验
     *
     * 	20以上是CRM
     * 	20 ：舆情管理
     */

    private Integer businessType;

    /**
     * 业务Id
     */

    private String businessId;

    /**
     * 空间Id
     */

    private String spaceId;

    /**
     * 报事大类对应的派单岗位id
     */

    private String dealPositionId;
    /**
     * 处理文件
     */
    private String dealFile;

    /**
     * 是否查询最近90天工单（1是;0否）
     */
    private Integer selectRecent;
    /**
     * 舆情预警明细id
     */
    private String warningDetailId;
    /**
     * 预定详情
     */
    private String bookingDetail;
    /**
     * 报事附件
     */
    private String incidentFile;

}
