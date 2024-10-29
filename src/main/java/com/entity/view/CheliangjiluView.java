package com.entity.view;

import com.entity.CheliangjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-22
 */
@TableName("cheliangjilu")
public class CheliangjiluView extends CheliangjiluEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 状态的值
		*/
		private String cheliangjiluValue;



		//级联表 chewei
			/**
			* 车位名字
			*/
			private String cheweiName;
			/**
			* 状态
			*/
			private Integer cheweiTypes;
				/**
				* 状态的值
				*/
				private String cheweiValue;
			/**
			* 车主
			*/
			private Integer chezhuId;
			/**
			* 车牌号
			*/
			private String chepaiNumber;

	public CheliangjiluView() {

	}

	public CheliangjiluView(CheliangjiluEntity cheliangjiluEntity) {
		try {
			BeanUtils.copyProperties(this, cheliangjiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 状态的值
			*/
			public String getCheliangjiluValue() {
				return cheliangjiluValue;
			}
			/**
			* 设置： 状态的值
			*/
			public void setCheliangjiluValue(String cheliangjiluValue) {
				this.cheliangjiluValue = cheliangjiluValue;
			}






				//级联表的get和set chewei
					/**
					* 获取： 车位名字
					*/
					public String getCheweiName() {
						return cheweiName;
					}
					/**
					* 设置： 车位名字
					*/
					public void setCheweiName(String cheweiName) {
						this.cheweiName = cheweiName;
					}
					/**
					* 获取： 状态
					*/
					public Integer getCheweiTypes() {
						return cheweiTypes;
					}
					/**
					* 设置： 状态
					*/
					public void setCheweiTypes(Integer cheweiTypes) {
						this.cheweiTypes = cheweiTypes;
					}


						/**
						* 获取： 状态的值
						*/
						public String getCheweiValue() {
							return cheweiValue;
						}
						/**
						* 设置： 状态的值
						*/
						public void setCheweiValue(String cheweiValue) {
							this.cheweiValue = cheweiValue;
						}
					/**
					* 获取： 车主
					*/
					public Integer getChezhuId() {
						return chezhuId;
					}
					/**
					* 设置： 车主
					*/
					public void setChezhuId(Integer chezhuId) {
						this.chezhuId = chezhuId;
					}
					/**
					* 获取： 车牌号
					*/
					public String getChepaiNumber() {
						return chepaiNumber;
					}
					/**
					* 设置： 车牌号
					*/
					public void setChepaiNumber(String chepaiNumber) {
						this.chepaiNumber = chepaiNumber;
					}










}
