package com.entity.vo;

import com.entity.JianyiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 建议
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jianyi")
public class JianyiVO implements Serializable {
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
     * 建议编号
     */

    @TableField(value = "jianyi_uuid_number")
    private String jianyiUuidNumber;


    /**
     * 建议标题
     */

    @TableField(value = "jianyi_name")
    private String jianyiName;


    /**
     * 建议类型
     */

    @TableField(value = "jianyi_types")
    private Integer jianyiTypes;


    /**
     * 建议内容
     */

    @TableField(value = "jianyi_content")
    private String jianyiContent;


    /**
     * 建议时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 回复内容
     */

    @TableField(value = "huifu_text")
    private String huifuText;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "update_time")
    private Date updateTime;


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
	 * 设置：建议编号
	 */
    public String getJianyiUuidNumber() {
        return jianyiUuidNumber;
    }


    /**
	 * 获取：建议编号
	 */

    public void setJianyiUuidNumber(String jianyiUuidNumber) {
        this.jianyiUuidNumber = jianyiUuidNumber;
    }
    /**
	 * 设置：建议标题
	 */
    public String getJianyiName() {
        return jianyiName;
    }


    /**
	 * 获取：建议标题
	 */

    public void setJianyiName(String jianyiName) {
        this.jianyiName = jianyiName;
    }
    /**
	 * 设置：建议类型
	 */
    public Integer getJianyiTypes() {
        return jianyiTypes;
    }


    /**
	 * 获取：建议类型
	 */

    public void setJianyiTypes(Integer jianyiTypes) {
        this.jianyiTypes = jianyiTypes;
    }
    /**
	 * 设置：建议内容
	 */
    public String getJianyiContent() {
        return jianyiContent;
    }


    /**
	 * 获取：建议内容
	 */

    public void setJianyiContent(String jianyiContent) {
        this.jianyiContent = jianyiContent;
    }
    /**
	 * 设置：建议时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：建议时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：回复内容
	 */
    public String getHuifuText() {
        return huifuText;
    }


    /**
	 * 获取：回复内容
	 */

    public void setHuifuText(String huifuText) {
        this.huifuText = huifuText;
    }
    /**
	 * 设置：回复时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：回复时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
