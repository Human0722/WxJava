package com.github.binarywang.wxpay.bean.coupon.v3;

import com.github.binarywang.wxpay.bean.request.BaseWxPayRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import me.chanjar.weixin.common.annotation.Required;

import java.util.Map;

/**
 * 查询代金券信息请求对象类
 * Created by xueliang on 2024-5-24
 * link: https://pay.weixin.qq.com/docs/merchant/apis/cash-coupons/coupon/query-coupon.html
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
public class WxPayCouponInfoQueryV3Request extends BaseWxPayRequest {


  /**
   * 字段名：代金券ｉｄ
   * 是否必填：是
   * 类型：　String
   */
  @Required
  @XStreamAlias("coupon_id")
  private String couponId;


  /**
   * 字段名：用户openid
   * 是否必填： 是
   * 类型： String
   */
  @Required
  @XStreamAlias("openid")
  private String openId;
  @Override
  protected void checkConstraints() throws WxPayException {
    // do nothing
  }

  @Override
  protected void storeMap(Map<String, String> map) {
    map.put("coupon_id",couponId);
    map.put("openid", openId);
  }
}
