package com.github.binarywang.wxpay.bean.coupon.v3;

import com.github.binarywang.wxpay.bean.request.BaseWxPayRequest;
import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import me.chanjar.weixin.common.annotation.Required;
import org.w3c.dom.Document;

import java.util.Map;

/**
 * 发放代金券请求对象类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
public class WxPayCouponSendV3Request extends BaseWxPayRequest {

  /**
   * 字段名：用户openid
   * 是否必填：是
   * 类型：String
   * 说明： 
   */
  private String openId;

  /**
   * 字段名：批次id
   * 是否必填： 是
   * 类型： String
   */
  @Required
  @XStreamAlias("stock_id")
  private String stockId;

  /**
   * 字段名： 公众账号ID
   * 是否必填： 是
   *
   */
  @XStreamAlias("out_request_no")
  private String outRequestNo;

  /**
   * 字段名：创建批次的商户号
   * 是否必填： 是
   * 类型：String
   */
  @XStreamAlias("stock_creator_mchid")
  private String stockCreatorMchid;

  /**
   * 字段名： 制定面额发券，面额.单位：分
   * 是否必填： 否
   * 类型： Integer
   */
  @XStreamAlias("coupon_value")
  private Integer couponValue;

  /**
   * 字段名： 制定面额发券，券门槛.单位：分
   * 是否必填： 否
   * 类型：Integer
   */
  @XStreamAlias("coupon_minimum")
  private Integer couponMinimum;


  @Override
  protected void checkConstraints() throws WxPayException {
    // do nothing
  }

  @Override
  protected void storeMap(Map<String, String> map) {
    map.put("stock_id", stockId);
    map.put("out_request_no", outRequestNo);
    map.put("stock_creator_mchid", stockCreatorMchid);
    map.put("coupon_value", couponValue.toString());
    map.put("coupon_minimum", couponMinimum.toString());
  }
}
