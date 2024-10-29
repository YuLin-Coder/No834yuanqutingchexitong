package com.entity.model;

import com.entity.CheliangjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车辆记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-22
 */
public class CheliangjiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车牌号
     */
    private String chepaiNumber;


    /**
     * 车位id
     */
    private Integer cheweiId;


    /**
     * 状态
     */
    private Integer cheliangjiluTypes;


    /**
     * 泊车时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 取车时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


    /**
     * 停车小时
     */
    private Integer xiaoshi;


    /**
     * 金额
     */
    private Integer monery;


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
	 * 获取：车牌号
	 */
    public String getChepaiNumber() {
        return chepaiNumber;
    }


    /**
	 * 设置：车牌号
	 */
    public void setChepaiNumber(String chepaiNumber) {
        this.chepaiNumber = chepaiNumber;
    }
    /**
	 * 获取：车位id
	 */
    public Integer getCheweiId() {
        return cheweiId;
    }


    /**
	 * 设置：车位id
	 */
    public void setCheweiId(Integer cheweiId) {
        this.cheweiId = cheweiId;
    }
    /**
	 * 获取：状态
	 */
    public Integer getCheliangjiluTypes() {
        return cheliangjiluTypes;
    }


    /**
	 * 设置：状态
	 */
    public void setCheliangjiluTypes(Integer cheliangjiluTypes) {
        this.cheliangjiluTypes = cheliangjiluTypes;
    }
    /**
	 * 获取：泊车时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：泊车时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：取车时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：取车时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    /**
	 * 获取：停车小时
	 */
    public Integer getXiaoshi() {
        return xiaoshi;
    }


    /**
	 * 设置：停车小时
	 */
    public void setXiaoshi(Integer xiaoshi) {
        this.xiaoshi = xiaoshi;
    }
    /**
	 * 获取：金额
	 */
    public Integer getMonery() {
        return monery;
    }


    /**
	 * 设置：金额
	 */
    public void setMonery(Integer monery) {
        this.monery = monery;
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
