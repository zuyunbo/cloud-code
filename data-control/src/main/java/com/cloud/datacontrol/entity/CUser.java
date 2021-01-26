package com.cloud.datacontrol.entity;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;



/**
 *
 * @author 2u c1111
 * @since 1.0 2021-01-25
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class CUser  {
	private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 创建时间
     */
     private String createTime;
    /**
     * 创建人
     */
     private Long createdBy;
    /**
     * 驱动
     */
     private String driverClassName;
    /**
     * 名称
     */
     private String name;
    /**
     * 密码
     */
     private String password;
    /**
     * 修改时间
     */
     private String updateTime;
    /**
     * 修改人
     */
     private Long updatedBy;
    /**
     * 链接
     */
     private String url;
    /**
     * 账号
     */
     private String username;
}
