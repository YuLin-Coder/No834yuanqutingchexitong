package com.entity.model;

import com.entity.XitonggonggaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 系统公告
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-22
 */
public class XitonggonggaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Long id;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date addtime;


    /**
     * 标题 Search
     */
    private String biaoti;


    /**
     * 类型
     */
    private String leixing;


    /**
     * 内容
     */
    private String neirong;


    /**
     * 日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date riqi;


    /**
	 * 获取：主键
	 */
    public Long getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Long id) {
        this.id = id;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getAddtime() {
        return addtime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
    /**
	 * 获取：标题 Search
	 */
    public String getBiaoti() {
        return biaoti;
    }


    /**
	 * 设置：标题 Search
	 */
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }
    /**
	 * 获取：类型
	 */
    public String getLeixing() {
        return leixing;
    }


    /**
	 * 设置：类型
	 */
    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }
    /**
	 * 获取：内容
	 */
    public String getNeirong() {
        return neirong;
    }


    /**
	 * 设置：内容
	 */
    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }
    /**
	 * 获取：日期
	 */
    public Date getRiqi() {
        return riqi;
    }


    /**
	 * 设置：日期
	 */
    public void setRiqi(Date riqi) {
        this.riqi = riqi;
    }

    }
