package com.entity.model;

import com.entity.XingliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 行李托运
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XingliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 行李托运编号
     */
    private String xingliUuidNumber;


    /**
     * 行李名称
     */
    private String xingliName;


    /**
     * 行李照片
     */
    private String xingliPhoto;


    /**
     * 行李类型
     */
    private Integer xingliTypes;


    /**
     * 重量(公斤)
     */
    private Double xingliZhongliang;


    /**
     * 总金额
     */
    private Double xingliZongjine;


    /**
     * 行李内物品清单
     */
    private String xingliContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 行李状态
     */
    private Integer xingliZhuangtaiTypes;


    /**
     * 审核状态
     */
    private Integer xingliYesnoTypes;


    /**
     * 审核意见
     */
    private String xingliYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date xingliShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：行李托运编号
	 */
    public String getXingliUuidNumber() {
        return xingliUuidNumber;
    }


    /**
	 * 设置：行李托运编号
	 */
    public void setXingliUuidNumber(String xingliUuidNumber) {
        this.xingliUuidNumber = xingliUuidNumber;
    }
    /**
	 * 获取：行李名称
	 */
    public String getXingliName() {
        return xingliName;
    }


    /**
	 * 设置：行李名称
	 */
    public void setXingliName(String xingliName) {
        this.xingliName = xingliName;
    }
    /**
	 * 获取：行李照片
	 */
    public String getXingliPhoto() {
        return xingliPhoto;
    }


    /**
	 * 设置：行李照片
	 */
    public void setXingliPhoto(String xingliPhoto) {
        this.xingliPhoto = xingliPhoto;
    }
    /**
	 * 获取：行李类型
	 */
    public Integer getXingliTypes() {
        return xingliTypes;
    }


    /**
	 * 设置：行李类型
	 */
    public void setXingliTypes(Integer xingliTypes) {
        this.xingliTypes = xingliTypes;
    }
    /**
	 * 获取：重量(公斤)
	 */
    public Double getXingliZhongliang() {
        return xingliZhongliang;
    }


    /**
	 * 设置：重量(公斤)
	 */
    public void setXingliZhongliang(Double xingliZhongliang) {
        this.xingliZhongliang = xingliZhongliang;
    }
    /**
	 * 获取：总金额
	 */
    public Double getXingliZongjine() {
        return xingliZongjine;
    }


    /**
	 * 设置：总金额
	 */
    public void setXingliZongjine(Double xingliZongjine) {
        this.xingliZongjine = xingliZongjine;
    }
    /**
	 * 获取：行李内物品清单
	 */
    public String getXingliContent() {
        return xingliContent;
    }


    /**
	 * 设置：行李内物品清单
	 */
    public void setXingliContent(String xingliContent) {
        this.xingliContent = xingliContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：行李状态
	 */
    public Integer getXingliZhuangtaiTypes() {
        return xingliZhuangtaiTypes;
    }


    /**
	 * 设置：行李状态
	 */
    public void setXingliZhuangtaiTypes(Integer xingliZhuangtaiTypes) {
        this.xingliZhuangtaiTypes = xingliZhuangtaiTypes;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getXingliYesnoTypes() {
        return xingliYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setXingliYesnoTypes(Integer xingliYesnoTypes) {
        this.xingliYesnoTypes = xingliYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getXingliYesnoText() {
        return xingliYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setXingliYesnoText(String xingliYesnoText) {
        this.xingliYesnoText = xingliYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getXingliShenheTime() {
        return xingliShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setXingliShenheTime(Date xingliShenheTime) {
        this.xingliShenheTime = xingliShenheTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
