package com.entity.model;

import com.entity.CheweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车位
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-22
 */
public class CheweiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 车位名字
     */
    private String cheweiName;


    /**
     * 状态
     */
    private Integer cheweiTypes;


    /**
     * 车主
     */
    private Integer chezhuId;


    /**
     * 车牌号
     */
    private String chepaiNumber;


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
	 * 获取：车位名字
	 */
    public String getCheweiName() {
        return cheweiName;
    }


    /**
	 * 设置：车位名字
	 */
    public void setCheweiName(String cheweiName) {
        this.cheweiName = cheweiName;
    }
    /**
	 * 获取：状态
	 */
    public Integer getCheweiTypes() {
        return cheweiTypes;
    }


    /**
	 * 设置：状态
	 */
    public void setCheweiTypes(Integer cheweiTypes) {
        this.cheweiTypes = cheweiTypes;
    }
    /**
	 * 获取：车主
	 */
    public Integer getChezhuId() {
        return chezhuId;
    }


    /**
	 * 设置：车主
	 */
    public void setChezhuId(Integer chezhuId) {
        this.chezhuId = chezhuId;
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
