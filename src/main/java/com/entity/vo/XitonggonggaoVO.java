package com.entity.vo;

import com.entity.XitonggonggaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 系统公告
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-22
 */
@TableName("xitonggonggao")
public class XitonggonggaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Long id;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "addtime")
    private Date addtime;


    /**
     * 标题 Search
     */

    @TableField(value = "biaoti")
    private String biaoti;


    /**
     * 类型
     */

    @TableField(value = "leixing")
    private String leixing;


    /**
     * 内容
     */

    @TableField(value = "neirong")
    private String neirong;


    /**
     * 日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "riqi")
    private Date riqi;


    /**
	 * 设置：主键
	 */
    public Long getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Long id) {
        this.id = id;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getAddtime() {
        return addtime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
    /**
	 * 设置：标题 Search
	 */
    public String getBiaoti() {
        return biaoti;
    }


    /**
	 * 获取：标题 Search
	 */

    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }
    /**
	 * 设置：类型
	 */
    public String getLeixing() {
        return leixing;
    }


    /**
	 * 获取：类型
	 */

    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }
    /**
	 * 设置：内容
	 */
    public String getNeirong() {
        return neirong;
    }


    /**
	 * 获取：内容
	 */

    public void setNeirong(String neirong) {
        this.neirong = neirong;
    }
    /**
	 * 设置：日期
	 */
    public Date getRiqi() {
        return riqi;
    }


    /**
	 * 获取：日期
	 */

    public void setRiqi(Date riqi) {
        this.riqi = riqi;
    }

}
