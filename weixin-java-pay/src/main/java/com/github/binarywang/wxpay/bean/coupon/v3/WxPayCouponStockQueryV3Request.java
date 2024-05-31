package com.github.binarywang.wxpay.bean.coupon.v3;

import com.github.binarywang.wxpay.bean.request.BaseWxPayRequest;
import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.*;
import org.w3c.dom.Document;

import java.util.Map;

/**
 * 查询代金券批次请求对象类V3
 *
 * https://pay.weixin.qq.com/docs/merchant/apis/cash-coupons/stock/query-stock.html
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
public class WxPayCouponStockQueryV3Request extends BaseWxPayRequest {

  /**
   * 参数名：批次号
   * 是否必填： 是
   * 类型： String
   */
  @XStreamAlias("stock_id")
  private String stockId;

  /**
   * 参数名： 创建批次的商户号
   * 是否必填： 是
   * 类型： String
   */
  @XStreamAlias("stock_creator_mchid")
  private String stockCreatorMchid;


  @Override
  protected void checkConstraints() throws WxPayException {
    // do nothing
  }

  @Override
  protected void storeMap(Map<String, String> map) {
    map.put("stock_id", stockId);
    map.put("stock_creator_mchid", stockCreatorMchid);
  }
}
