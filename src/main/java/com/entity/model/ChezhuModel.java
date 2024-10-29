package com.entity.model;

import com.entity.ChezhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车主
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-03-22
 */
public class ChezhuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 姓名
     */
    private String chezhuName;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 身份证号
     */
    private String chezhuIdNumber;


    /**
     * 手机号
     */
    private String chezhuPhone;


    /**
     * 车牌号
     */
    private String chezhuChepaiNumber;


    /**
     * 照片
     */
    private String chezhuPhoto;


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
	 * 获取：姓名
	 */
    public String getChezhuName() {
        return chezhuName;
    }


    /**
	 * 设置：姓名
	 */
    public void setChezhuName(String chezhuName) {
        this.chezhuName = chezhuName;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：身份证号
	 */
    public String getChezhuIdNumber() {
        return chezhuIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setChezhuIdNumber(String chezhuIdNumber) {
        this.chezhuIdNumber = chezhuIdNumber;
    }
    /**
	 * 获取：手机号
	 */
    public String getChezhuPhone() {
        return chezhuPhone;
    }


    /**
	 * 设置：手机号
	 */
    public void setChezhuPhone(String chezhuPhone) {
        this.chezhuPhone = chezhuPhone;
    }
    /**
	 * 获取：车牌号
	 */
    public String getChezhuChepaiNumber() {
        return chezhuChepaiNumber;
    }


    /**
	 * 设置：车牌号
	 */
    public void setChezhuChepaiNumber(String chezhuChepaiNumber) {
        this.chezhuChepaiNumber = chezhuChepaiNumber;
    }
    /**
	 * 获取：照片
	 */
    public String getChezhuPhoto() {
        return chezhuPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setChezhuPhoto(String chezhuPhoto) {
        this.chezhuPhoto = chezhuPhoto;
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
