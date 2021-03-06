package io.jpress.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JPress, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseCouponUsedRecord<M extends BaseCouponUsedRecord<M>> extends JbootModel<M> implements IBean {

    private static final long serialVersionUID = 1L;

	public void setId(java.lang.Long id) {
		set("id", id);
	}

	public java.lang.Long getId() {
		return getLong("id");
	}

    /**
     * 使用优惠码的用户
     */
	public void setUsedUserId(java.lang.Long usedUserId) {
		set("used_user_id", usedUserId);
	}

    /**
     * 使用优惠码的用户
     */
	public java.lang.Long getUsedUserId() {
		return getLong("used_user_id");
	}

    /**
     * 使用优惠码的用户ID
     */
	public void setUsedUserNickname(java.lang.String usedUserNickname) {
		set("used_user_nickname", usedUserNickname);
	}

    /**
     * 使用优惠码的用户ID
     */
	public java.lang.String getUsedUserNickname() {
		return getStr("used_user_nickname");
	}

    /**
     * 订单ID
     */
	public void setUsedOrderId(java.lang.Long usedOrderId) {
		set("used_order_id", usedOrderId);
	}

    /**
     * 订单ID
     */
	public java.lang.Long getUsedOrderId() {
		return getLong("used_order_id");
	}

    /**
     * 支付的ID
     */
	public void setUserPaymentId(java.lang.Long userPaymentId) {
		set("user_payment_id", userPaymentId);
	}

    /**
     * 支付的ID
     */
	public java.lang.Long getUserPaymentId() {
		return getLong("user_payment_id");
	}

    /**
     * 优惠码ID
     */
	public void setCodeId(java.lang.Long codeId) {
		set("code_id", codeId);
	}

    /**
     * 优惠码ID
     */
	public java.lang.Long getCodeId() {
		return getLong("code_id");
	}

    /**
     * 优惠码名称
     */
	public void setCode(java.lang.String code) {
		set("code", code);
	}

    /**
     * 优惠码名称
     */
	public java.lang.String getCode() {
		return getStr("code");
	}

    /**
     * 优惠券归属的用户ID
     */
	public void setCodeUserId(java.lang.Long codeUserId) {
		set("code_user_id", codeUserId);
	}

    /**
     * 优惠券归属的用户ID
     */
	public java.lang.Long getCodeUserId() {
		return getLong("code_user_id");
	}

    /**
     * 优惠券归属的用户昵称
     */
	public void setCodeUserNickname(java.lang.String codeUserNickname) {
		set("code_user_nickname", codeUserNickname);
	}

    /**
     * 优惠券归属的用户昵称
     */
	public java.lang.String getCodeUserNickname() {
		return getStr("code_user_nickname");
	}

	public void setCouponId(java.lang.Long couponId) {
		set("coupon_id", couponId);
	}

	public java.lang.Long getCouponId() {
		return getLong("coupon_id");
	}

    /**
     * 使用时间
     */
	public void setCreated(java.util.Date created) {
		set("created", created);
	}

    /**
     * 使用时间
     */
	public java.util.Date getCreated() {
		return getDate("created");
	}

}

