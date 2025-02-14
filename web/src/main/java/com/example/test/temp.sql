CREATE TABLE `tb_base_comm_service_role` (
                                             `id` char(36) NOT NULL,
                                             `comm_id` char(36) NOT NULL,
                                             `role_name` varchar(256) DEFAULT NULL COMMENT '岗位名称',
                                             `role_work_time` varchar(256) DEFAULT NULL COMMENT '岗位工作时间',
                                             `day_role_number` int DEFAULT NULL COMMENT '白班岗位数量',
                                             `night_role_number` int DEFAULT NULL COMMENT '夜班岗位数量',
                                             `is_open` int DEFAULT NULL COMMENT '是否开通系统账号',
                                             `sort` int DEFAULT NULL COMMENT '序号',
                                             `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                             `is_delete` int DEFAULT NULL,
                                             `delete_time` datetime DEFAULT NULL,
                                             `create_user` char(36) DEFAULT NULL,
                                             `create_time` char(36) DEFAULT NULL,
                                             `modify_user` char(36) DEFAULT NULL,
                                             `modify_time` datetime DEFAULT NULL,
                                             `time_spans` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `tb_outsource_supplier_num_info` (
                                                  `id` char(36) NOT NULL,
                                                  `supplier_id` char(36) DEFAULT NULL COMMENT '供方id',
                                                  `comm_num` int DEFAULT NULL COMMENT '服务项目数',
                                                  `user_num` int DEFAULT NULL COMMENT '服务本项目人数',
                                                  `man_num` int DEFAULT NULL COMMENT '男性数量',
                                                  `woman_num` int DEFAULT NULL COMMENT '女性数量',
                                                  `average_age` decimal(18,2) DEFAULT NULL COMMENT '平均年龄',
                                                  `have_age_num` int DEFAULT NULL COMMENT '有年龄员工数量（计算占比使用）',
                                                  `not_thirty_num` int DEFAULT NULL COMMENT '30岁以下数量',
                                                  `thirty_fifty_num` int DEFAULT NULL COMMENT '30-50数量',
                                                  `over_fifty_num` int DEFAULT NULL COMMENT '50以上数量',
                                                  `over_fifty_five_woman_num` int DEFAULT NULL COMMENT '55以上女性数量',
                                                  `over_sixty_man_num` int DEFAULT NULL COMMENT '60以上男性数量',
                                                  `update_time` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='外包数据数量信息表';



ALTER TABLE `tb_mt_supplier`
    ADD COLUMN `is_supplier` int NULL COMMENT '是否四保一服供方（0：否、1：是）' AFTER `time_stamp`;



CREATE TABLE `tb_base_comm_service_outsourcing_personnel` (
                                                              `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                                              `name` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                                              `sex` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '甲方名称',
                                                              `certificates_number` varchar(256) DEFAULT NULL COMMENT '年度服务合同金额',
                                                              `telephone` varchar(256) DEFAULT NULL COMMENT '合同开始时间',
                                                              `outsourcing_unit_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '外包单位编码',
                                                              `department_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '部门编码（服务中心下面的编码）',
                                                              `comm_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目id',
                                                              `comm_code` varchar(256) DEFAULT NULL COMMENT '项目编码',
                                                              `role_type_code` char(36) DEFAULT NULL COMMENT '岗位类别编码（源于字典）',
                                                              `comm_role_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目岗位编码',
                                                              `service_center_code` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '服务中心编码',
                                                              `entry_time` datetime DEFAULT NULL COMMENT '入职时间',
                                                              `eq_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备编码',
                                                              `belong_grid_id` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属网格编码',
                                                              `is_open_account` int DEFAULT NULL COMMENT '是否开通账号',
                                                              `user_id` char(36) DEFAULT NULL COMMENT '用户表ID（非必填）',
                                                              `sort` int DEFAULT NULL COMMENT '序号',
                                                              `is_delete` int DEFAULT NULL,
                                                              `delete_time` datetime DEFAULT NULL,
                                                              `create_user` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                                              `create_time` datetime DEFAULT NULL,
                                                              `modify_user` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                                                              `modify_time` datetime DEFAULT NULL,
                                                              `time_spans` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `tb_base_comm_service_equipment` (
                                                  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                                  `comm_id` char(38) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '项目编码',
                                                  `eq_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '设备名称',
                                                  `eq_sn` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '设备识别序列号',
                                                  `eq_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备编码',
                                                  `eq_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备类型(对应产品名称,字符类型,暂无枚举)',
                                                  `eq_firm` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备厂商',
                                                  `install_date` datetime DEFAULT NULL COMMENT '安装日期',
                                                  `eq_status` tinyint DEFAULT NULL COMMENT '设备状态(0-离线；1-在线)',
                                                  `product_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '产品id',
                                                  `last_report_time` datetime DEFAULT NULL COMMENT '最后数据上报时间',
                                                  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
                                                  `start_time` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '活跃开始时间(坐标上传时间如10:00)',
                                                  `end_time` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '活跃结束时间(坐标上传时间如18:00)',
                                                  `battery_level` decimal(10,2) DEFAULT NULL COMMENT '电池电量%',
                                                  PRIMARY KEY (`id`) USING BTREE,
                                                  KEY `index_sn` (`eq_sn`) USING BTREE COMMENT '设备唯一编码索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;



ALTER TABLE `tb_base_incident_pubarea_regionalplace`
    ADD COLUMN `grid_class` char(36) NULL COMMENT '网格类别（rf_dictionary id）' AFTER `change_user`;


CREATE TABLE `tb_base_comm_service_rostering` (
                                                  `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                                  `comm_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属项目',
                                                  `rostering_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班次名称',
                                                  `rostering_type` int DEFAULT '0' COMMENT '班次类型；0--网格，1--环卫',
                                                  `job_time` float(5,2) NOT NULL COMMENT '上班时长(小时)',
                                                  `clock_in_rules` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '一天两次' COMMENT '打卡规则',
                                                  `work_shift` time DEFAULT NULL COMMENT '上班时间',
                                                  `work_time_begin_type` int DEFAULT '0' COMMENT '上班时间开始类型，0--当日；1--次日',
                                                  `closing_time` time DEFAULT NULL COMMENT '下班时间',
                                                  `closing_time_begin_type` int DEFAULT '0' COMMENT '下班时间开始类型，0--当日；1--次日',
                                                  `sort` int DEFAULT NULL COMMENT '序号',
                                                  `is_deactivate` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '否' COMMENT '是否停用,0--否；1--是',
                                                  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                                  `valid_work_shift_begin` time DEFAULT NULL COMMENT '上班有效打卡开始时间',
                                                  `valid_work_shift_end` time DEFAULT NULL COMMENT '上班有效打卡结束时间',
                                                  `valid_closing_time_begin` time DEFAULT NULL COMMENT '下班有效打卡开始时间',
                                                  `valid_closing_time_end` time DEFAULT NULL COMMENT '下班有效打卡结束时间',
                                                  `clock_range` int DEFAULT '100' COMMENT '打卡范围',
                                                  `is_delete` int DEFAULT '0' COMMENT '是否删除，0-否，1-是（已被删除）',
                                                  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                                  `delete_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '删除人',
                                                  `create_user` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
                                                  `create_time` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建时间',
                                                  `modify_user` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
                                                  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
                                                  `time_stamp` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
                                                  `work_startl` datetime DEFAULT NULL COMMENT '上班次上班有效开始时间',
                                                  `work_startr` datetime DEFAULT NULL COMMENT '上班次上班有效结束时间',
                                                  `work_endl` datetime DEFAULT NULL COMMENT '上班次下班有效开始时间',
                                                  `work_endr` datetime DEFAULT NULL COMMENT '上班次下班有效结束时间',
                                                  `offduty_startl` datetime DEFAULT NULL COMMENT '下班次上班有效开始时间',
                                                  `offduty_startr` datetime DEFAULT NULL COMMENT '下班次上班有效结束时间',
                                                  `offduty_endl` datetime DEFAULT NULL COMMENT '下班班次下班有效开始时间',
                                                  `offduty_endr` datetime DEFAULT NULL COMMENT '下班班次下班有效结束时间',
                                                  `work_times_work_hours` datetime DEFAULT NULL COMMENT '上班次上班时间',
                                                  `work_timeand_off_duty_time` datetime DEFAULT NULL COMMENT '上班次下班时间',
                                                  `work_timeand_off_duty_timeend_type` int DEFAULT NULL COMMENT '上班次下班时间是否跨日',
                                                  `off_duty_time_the_start` datetime DEFAULT NULL COMMENT '下班次上班时间',
                                                  `off_duty_time_start_type` int DEFAULT NULL COMMENT '下班次上班时间是否跨日',
                                                  `off_duty_time_the_end` datetime DEFAULT NULL COMMENT '下班次下班时间',
                                                  `off_duty_time_end_type` int DEFAULT NULL COMMENT '下班次下班时间是否跨日',
                                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='网络排版考勤---设置班次表';


CREATE TABLE `tb_base_comm_rostering_location` (
                                                   `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                                   `comm_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目id',
                                                   `site_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '点位名称',
                                                   `work_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '执勤工作时长',
                                                   `site_type` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '点位类型（来源于字典）',
                                                   `belong_grid_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '归属网格',
                                                   `incident_coord` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '坐标',
                                                   `incident_coord_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '坐标名称',
                                                   `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
                                                   `is_delete` tinyint NOT NULL COMMENT '是否删除',
                                                   `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                                   `create_user` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
                                                   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                                   `modif_user` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
                                                   `modif_time` datetime DEFAULT NULL COMMENT '修改时间',
                                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='固定执勤点位表';


CREATE TABLE `tb_base_comm_rostering_scheduling` (
                                                     `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '排班ID',
                                                     `comm_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目ID',
                                                     `rostering_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班次编码',
                                                     `regionalplace_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '网格ID',
                                                     `user_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '人员ID',
                                                     `location_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '当日' COMMENT '执勤位置id',
                                                     `equipment_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备id',
                                                     `user_type` tinyint DEFAULT NULL COMMENT '人员类型（0-网格人员；1-环卫人员；2-内部人员）',
                                                     `schedu_year` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '排班年度',
                                                     `schedu_month` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '排班月度',
                                                     `schedu_day` int NOT NULL COMMENT '排班日期',
                                                     `is_delete` int NOT NULL COMMENT '是否删除，0-否，1-是（已被删除）',
                                                     `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                                     `create_user` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
                                                     `create_time` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建时间',
                                                     `modify_user` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
                                                     `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
                                                     `time_stamp` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
                                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='网络排版考勤---排班表';


CREATE TABLE `tb_base_sanitation_equipment` (
                                                `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '主键',
                                                `comm_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目id（rf_organize的id）',
                                                `unique_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '唯一码',
                                                `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '设备名称',
                                                `rack_number` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车架号',
                                                `license_plate` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '车牌号码',
                                                `equipment_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设备类型',
                                                `operation_time` datetime NOT NULL COMMENT '投运日期',
                                                `positioning_equip_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '定位设备序列号（tb_base_comm_service_quipment的id）',
                                                `quantity` int NOT NULL COMMENT '数量',
                                                `unit` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '单位',
                                                `specification` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '规格型号',
                                                `tonnage` double DEFAULT NULL COMMENT '吨位',
                                                `brand` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '品牌',
                                                `supplier_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '供应商名称',
                                                `active_status` int NOT NULL DEFAULT '1' COMMENT '使用状态（1正常，2停用，3维修，4报废，见SanitationEquipmentActiveStatus）',
                                                `operation_department` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '使用部门（rf_organize的id，type为2）',
                                                `origin_value` decimal(10,0) DEFAULT NULL COMMENT '资产原值',
                                                `is_delete` int NOT NULL DEFAULT '0',
                                                `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
                                                PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='环卫设备表';


CREATE TABLE `tb_base_comm_rostering_attendance` (
                                                     `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '考勤ID',
                                                     `comm_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目ID',
                                                     `regionalplace_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '网格ID',
                                                     `web_user_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '网格员ID',
                                                     `user_type` tinyint DEFAULT NULL COMMENT '人员类型（0-网格人员；1-环卫人员；2-内部人员）',
                                                     `sign_date` datetime DEFAULT NULL COMMENT '考勤日期',
                                                     `work_time` datetime DEFAULT NULL COMMENT '上班打卡时间',
                                                     `end_time` datetime DEFAULT NULL COMMENT '下班打卡时间',
                                                     `work_location` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '上班打卡位置',
                                                     `end_location` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '下班打卡位置',
                                                     `is_delete` int DEFAULT NULL COMMENT '是否删除，0-否，1-是（已被删除）',
                                                     `delete_user` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '删除人',
                                                     `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                                     `create_user` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
                                                     `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                                     `modify_user` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '修改人',
                                                     `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
                                                     `time_stamp` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
                                                     `work_times_work_hours` datetime DEFAULT NULL COMMENT '上班次上班时间',
                                                     `work_timeand_off_duty_time` datetime DEFAULT NULL COMMENT '上班次下班时间',
                                                     `off_duty_time_the_start` datetime DEFAULT NULL COMMENT '下班次上班时间',
                                                     `off_duty_time_the_end` datetime DEFAULT NULL COMMENT '下班次下班时间',
                                                     `work_location_l` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '上班次上班打卡位置',
                                                     `work_location_r` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '上班次下班打卡位置',
                                                     `end_location_l` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '下班次上班打卡位置',
                                                     `end_location_r` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '下班次下班打卡位置',
                                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='网络排版考勤---考勤表';


CREATE TABLE `tb_base_comm_rostering_attendance_total` (
                                                           `id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '记录ID',
                                                           `comm_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '项目ID',
                                                           `grid_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '网格ID',
                                                           `grid_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '网格名称',
                                                           `web_user_id` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '网格员ID',
                                                           `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '网格员名称',
                                                           `role_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '职务ID',
                                                           `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '职务名称',
                                                           `type` int DEFAULT '0' COMMENT '人员类型（0-网格人员；1-环卫人员；2-内部人员）',
                                                           `sign_month` date DEFAULT NULL COMMENT '考勤月份',
                                                           `sh_arrive_day_num` int DEFAULT NULL COMMENT '应出勤天数',
                                                           `rest_day_num` int DEFAULT NULL COMMENT '休息天数',
                                                           `arrive_day_num` int DEFAULT NULL COMMENT '实际出勤天数',
                                                           `lack_day_num` int DEFAULT NULL COMMENT '缺勤天数',
                                                           `late_num` int DEFAULT NULL COMMENT '迟到次数',
                                                           `late_time` int DEFAULT NULL COMMENT '迟到时长（分钟）',
                                                           `early_num` int DEFAULT NULL COMMENT '早退次数',
                                                           `early_time` int DEFAULT NULL COMMENT '早退时长（分钟）',
                                                           `day1` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '1号,0--黑色勾(出勤),红色√(出勤但有异常)、红色×（缺勤），病假、年假、事假、休假、调休、丧假、婚假表示当天不需要出勤',
                                                           `day2` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '2号',
                                                           `day3` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '3号',
                                                           `day4` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '4号',
                                                           `day5` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '5号',
                                                           `day6` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '6号',
                                                           `day7` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '7号',
                                                           `day8` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '8号',
                                                           `day9` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '9号',
                                                           `day10` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '10号',
                                                           `day11` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '11号',
                                                           `day12` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '12号',
                                                           `day13` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '13号',
                                                           `day14` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '14号',
                                                           `day15` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '15号',
                                                           `day16` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '16号',
                                                           `day17` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '17号',
                                                           `day18` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '18号',
                                                           `day19` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '19号',
                                                           `day20` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '20号',
                                                           `day21` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '21号',
                                                           `day22` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '22号',
                                                           `day23` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '23号',
                                                           `day24` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '24号',
                                                           `day25` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '25号',
                                                           `day26` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '26号',
                                                           `day27` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '27号',
                                                           `day28` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '28号',
                                                           `day29` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '29号',
                                                           `day30` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '30号',
                                                           `day31` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '31号',
                                                           `is_delete` int DEFAULT NULL COMMENT '是否删除，0-否，1-是（已被删除）',
                                                           `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                                           `create_user` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建人',
                                                           `create_time` char(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '创建时间',
                                                           PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='网络排版考勤---考勤统计表';





