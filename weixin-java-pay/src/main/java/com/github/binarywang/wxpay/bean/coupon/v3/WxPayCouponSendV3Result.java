package com.github.binarywang.wxpay.bean.coupon.v3;

import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;

import java.io.Serializable;

/**
 * 发放代金券响应结果类
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxPayCouponSendV3Result extends BaseWxPayResult implements Serializable {
  private static final long serialVersionID = 1L;

  /**
   * 字段名：代金券id
   * 类型：String
   * 是否必填： 是
   */
  @XStreamAlias("coupon_id")
  private String couponId;

  @Override
  protected void loadXml(Document d) {
    couponId = readXmlString(d, "coupon_id");
  }
}
