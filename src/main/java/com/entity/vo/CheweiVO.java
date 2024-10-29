package com.entity.vo;

import com.entity.CheweiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车位
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-03-22
 */
@TableName("chewei")
public class CheweiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 车位名字
     */

    @TableField(value = "chewei_name")
    private String cheweiName;


    /**
     * 状态
     */

    @TableField(value = "chewei_types")
    private Integer cheweiTypes;


    /**
     * 车主
     */

    @TableField(value = "chezhu_id")
    private Integer chezhuId;


    /**
     * 车牌号
     */

    @TableField(value = "chepai_number")
    private String chepaiNumber;


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
	 * 设置：车位名字
	 */
    public String getCheweiName() {
        return cheweiName;
    }


    /**
	 * 获取：车位名字
	 */

    public void setCheweiName(String cheweiName) {
        this.cheweiName = cheweiName;
    }
    /**
	 * 设置：状态
	 */
    public Integer getCheweiTypes() {
        return cheweiTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setCheweiTypes(Integer cheweiTypes) {
        this.cheweiTypes = cheweiTypes;
    }
    /**
	 * 设置：车主
	 */
    public Integer getChezhuId() {
        return chezhuId;
    }


    /**
	 * 获取：车主
	 */

    public void setChezhuId(Integer chezhuId) {
        this.chezhuId = chezhuId;
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
