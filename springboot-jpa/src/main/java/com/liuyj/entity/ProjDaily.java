package com.liuyj.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * @author liuyuanju1
 * @date 2018/5/8
 * @description:
 */
@Entity
@Table(name = "pmp_stat_proj_daily_report")
public class ProjDaily {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "statId")
    String statId;
    @Column(name = "dealTime")
    Date dealTime;
    @Column(name = "orgId")
    String orgId;
    @Column(name = "parentId")
    String parentId;
    @Column(name = "orgName")
    String orgName;
    @Column(name = "orgTierCode")
    String orgTierCode;
    @Column(name = "orgTierName")
    String orgTierName;

    @Column(name = "erp")
    String erp;
    @Column(name = "name")
    String name;
    @Column(name = "projectId")
    String projectId;
    @Column(name = "projName")
    String projName;

    @Column(name = "taskId")
    String taskId;
    @Column(name = "taskName")
    String taskName;
    @Column(name = "taskPlanStartTime")
    Date taskPlanStartTime;
    @Column(name = "taskPlanEndTime")
    Date taskPlanEndTime;
    @Column(name = "taskStartTime")
    Date taskStartTime;
    @Column(name = "taskEndTime")
    Date taskEndTime;
    @Column(name = "taskPlannedHours")
    Double taskPlannedHours;
    @Column(name = "taskNeedHours")
    Double taskNeedHours;
    @Column(name = "taskSubmitHours")
    Double taskSubmitHours;
}
