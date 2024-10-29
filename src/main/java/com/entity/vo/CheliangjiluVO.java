package com.entity.vo;

import com.entity.CheliangjiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车辆记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-22
 */
@TableName("cheliangjilu")
public class CheliangjiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 车牌号
     */

    @TableField(value = "chepai_number")
    private String chepaiNumber;


    /**
     * 车位id
     */

    @TableField(value = "chewei_id")
    private Integer cheweiId;


    /**
     * 状态
     */

    @TableField(value = "cheliangjilu_types")
    private Integer cheliangjiluTypes;


    /**
     * 泊车时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 取车时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "update_time")
    private Date updateTime;


    /**
     * 停车小时
     */

    @TableField(value = "xiaoshi")
    private Integer xiaoshi;


    /**
     * 金额
     */

    @TableField(value = "monery")
    private Integer monery;


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
	 * 设置：车牌号
	 */
    public String getChepaiNumber() {
        return chepaiNumber;
    }


    /**
	 * 获取：车牌号
	 */

    public void setChepaiNumber(String chepaiNumber) {
        this.chepaiNumber = chepaiNumber;
    }
    /**
	 * 设置：车位id
	 */
    public Integer getCheweiId() {
        return cheweiId;
    }


    /**
	 * 获取：车位id
	 */

    public void setCheweiId(Integer cheweiId) {
        this.cheweiId = cheweiId;
    }
    /**
	 * 设置：状态
	 */
    public Integer getCheliangjiluTypes() {
        return cheliangjiluTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setCheliangjiluTypes(Integer cheliangjiluTypes) {
        this.cheliangjiluTypes = cheliangjiluTypes;
    }
    /**
	 * 设置：泊车时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：泊车时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：取车时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：取车时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 设置：停车小时
	 */
    public Integer getXiaoshi() {
        return xiaoshi;
    }


    /**
	 * 获取：停车小时
	 */

    public void setXiaoshi(Integer xiaoshi) {
        this.xiaoshi = xiaoshi;
    }
    /**
	 * 设置：金额
	 */
    public Integer getMonery() {
        return monery;
    }


    /**
	 * 获取：金额
	 */

    public void setMonery(Integer monery) {
        this.monery = monery;
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
