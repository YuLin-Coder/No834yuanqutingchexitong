package com.entity.view;

import com.entity.CheweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 车位
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-22
 */
@TableName("chewei")
public class CheweiView extends CheweiEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 状态的值
		*/
		private String cheweiValue;



		//级联表 chezhu
			/**
			* 姓名
			*/
			private String chezhuName;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
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

	public CheweiView() {

	}

	public CheweiView(CheweiEntity cheweiEntity) {
		try {
			BeanUtils.copyProperties(this, cheweiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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








				//级联表的get和set chezhu
					/**
					* 获取： 姓名
					*/
					public String getChezhuName() {
						return chezhuName;
					}
					/**
					* 设置： 姓名
					*/
					public void setChezhuName(String chezhuName) {
						this.chezhuName = chezhuName;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 身份证号
					*/
					public String getChezhuIdNumber() {
						return chezhuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setChezhuIdNumber(String chezhuIdNumber) {
						this.chezhuIdNumber = chezhuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getChezhuPhone() {
						return chezhuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setChezhuPhone(String chezhuPhone) {
						this.chezhuPhone = chezhuPhone;
					}
					/**
					* 获取： 车牌号
					*/
					public String getChezhuChepaiNumber() {
						return chezhuChepaiNumber;
					}
					/**
					* 设置： 车牌号
					*/
					public void setChezhuChepaiNumber(String chezhuChepaiNumber) {
						this.chezhuChepaiNumber = chezhuChepaiNumber;
					}
					/**
					* 获取： 照片
					*/
					public String getChezhuPhoto() {
						return chezhuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setChezhuPhoto(String chezhuPhoto) {
						this.chezhuPhoto = chezhuPhoto;
					}








}
