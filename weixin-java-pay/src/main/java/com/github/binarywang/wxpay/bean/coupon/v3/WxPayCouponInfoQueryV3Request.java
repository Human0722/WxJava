package com.github.binarywang.wxpay.bean.coupon.v3;

import com.github.binarywang.wxpay.bean.request.BaseWxPayRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import me.chanjar.weixin.common.annotation.Required;

import java.io.Serializable;
import java.util.Map;

/**
 * 查询代金券信息请求对象类
 * Created by xueliang on 2024-5-24
 * link: https://pay.weixin.qq.com/docs/merchant/apis/cash-coupons/coupon/query-coupon.html
 */

@Data
@NoArgsConstructor
public class WxPayCouponInfoQueryV3Request implements Serializable {

  public final static long serialVersionId = 1L;


  /**
   * 字段名：代金券ｉｄ
   * 是否必填：是
   * 类型：　String
   */
  @Required
  private String couponId;


  /**
   * 字段名：用户openid
   * 是否必填： 是
   * 类型： String
   */
  @Required
  private String openId;

  @SerializedName("stock_id")
  private String stockId;

  @SerializedName("out_request_no")
  private String outRequestNo;

  /**
   * 字段名：公众账号ID
   * 是否必填： 是
   * 类型： String
   */
  @Required
  @SerializedName("appid")
  private String appid;

}
