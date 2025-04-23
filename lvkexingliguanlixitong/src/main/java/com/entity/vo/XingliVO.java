package com.entity.vo;

import com.entity.XingliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 行李托运
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xingli")
public class XingliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 行李托运编号
     */

    @TableField(value = "xingli_uuid_number")
    private String xingliUuidNumber;


    /**
     * 行李名称
     */

    @TableField(value = "xingli_name")
    private String xingliName;


    /**
     * 行李照片
     */

    @TableField(value = "xingli_photo")
    private String xingliPhoto;


    /**
     * 行李类型
     */

    @TableField(value = "xingli_types")
    private Integer xingliTypes;


    /**
     * 重量(公斤)
     */

    @TableField(value = "xingli_zhongliang")
    private Double xingliZhongliang;


    /**
     * 总金额
     */

    @TableField(value = "xingli_zongjine")
    private Double xingliZongjine;


    /**
     * 行李内物品清单
     */

    @TableField(value = "xingli_content")
    private String xingliContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 行李状态
     */

    @TableField(value = "xingli_zhuangtai_types")
    private Integer xingliZhuangtaiTypes;


    /**
     * 审核状态
     */

    @TableField(value = "xingli_yesno_types")
    private Integer xingliYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "xingli_yesno_text")
    private String xingliYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xingli_shenhe_time")
    private Date xingliShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：行李托运编号
	 */
    public String getXingliUuidNumber() {
        return xingliUuidNumber;
    }


    /**
	 * 获取：行李托运编号
	 */

    public void setXingliUuidNumber(String xingliUuidNumber) {
        this.xingliUuidNumber = xingliUuidNumber;
    }
    /**
	 * 设置：行李名称
	 */
    public String getXingliName() {
        return xingliName;
    }


    /**
	 * 获取：行李名称
	 */

    public void setXingliName(String xingliName) {
        this.xingliName = xingliName;
    }
    /**
	 * 设置：行李照片
	 */
    public String getXingliPhoto() {
        return xingliPhoto;
    }


    /**
	 * 获取：行李照片
	 */

    public void setXingliPhoto(String xingliPhoto) {
        this.xingliPhoto = xingliPhoto;
    }
    /**
	 * 设置：行李类型
	 */
    public Integer getXingliTypes() {
        return xingliTypes;
    }


    /**
	 * 获取：行李类型
	 */

    public void setXingliTypes(Integer xingliTypes) {
        this.xingliTypes = xingliTypes;
    }
    /**
	 * 设置：重量(公斤)
	 */
    public Double getXingliZhongliang() {
        return xingliZhongliang;
    }


    /**
	 * 获取：重量(公斤)
	 */

    public void setXingliZhongliang(Double xingliZhongliang) {
        this.xingliZhongliang = xingliZhongliang;
    }
    /**
	 * 设置：总金额
	 */
    public Double getXingliZongjine() {
        return xingliZongjine;
    }


    /**
	 * 获取：总金额
	 */

    public void setXingliZongjine(Double xingliZongjine) {
        this.xingliZongjine = xingliZongjine;
    }
    /**
	 * 设置：行李内物品清单
	 */
    public String getXingliContent() {
        return xingliContent;
    }


    /**
	 * 获取：行李内物品清单
	 */

    public void setXingliContent(String xingliContent) {
        this.xingliContent = xingliContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：行李状态
	 */
    public Integer getXingliZhuangtaiTypes() {
        return xingliZhuangtaiTypes;
    }


    /**
	 * 获取：行李状态
	 */

    public void setXingliZhuangtaiTypes(Integer xingliZhuangtaiTypes) {
        this.xingliZhuangtaiTypes = xingliZhuangtaiTypes;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getXingliYesnoTypes() {
        return xingliYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setXingliYesnoTypes(Integer xingliYesnoTypes) {
        this.xingliYesnoTypes = xingliYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getXingliYesnoText() {
        return xingliYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setXingliYesnoText(String xingliYesnoText) {
        this.xingliYesnoText = xingliYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getXingliShenheTime() {
        return xingliShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setXingliShenheTime(Date xingliShenheTime) {
        this.xingliShenheTime = xingliShenheTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
