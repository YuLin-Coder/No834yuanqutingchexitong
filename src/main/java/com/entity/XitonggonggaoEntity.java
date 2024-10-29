package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 系统公告
 *
 * @author 
 * @email
 * @date 2021-03-22
 */
@TableName("xitonggonggao")
public class XitonggonggaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XitonggonggaoEntity() {

	}

	public XitonggonggaoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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

    @Override
    public String toString() {
        return "Xitonggonggao{" +
            "id=" + id +
            ", addtime=" + addtime +
            ", biaoti=" + biaoti +
            ", leixing=" + leixing +
            ", neirong=" + neirong +
            ", riqi=" + riqi +
        "}";
    }
}
