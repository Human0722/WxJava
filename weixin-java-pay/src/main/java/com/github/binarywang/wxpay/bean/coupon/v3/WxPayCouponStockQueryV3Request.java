package com.github.binarywang.wxpay.bean.coupon.v3;

import com.google.gson.annotations.SerializedName;
import lombok.experimental.Accessors;
import lombok.*;

import java.io.Serializable;

/**
 * 查询代金券批次请求对象类V3
 *
 * https://pay.weixin.qq.com/docs/merchant/apis/cash-coupons/stock/query-stock.html
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class WxPayCouponStockQueryV3Request implements Serializable {

  private static final long serialVersionUID = 1;

  /**
   * <pre>
   * 参数名：批次号
   * 是否必填： 是
   * 类型： String
   * </pre>
   */
  @SerializedName("stock_id")
  private String stockId;

  /**
   * <pre>
   * 参数名： 创建批次的商户号
   * 是否必填： 是
   * 类型： String
   * </pre>
   */
  @SerializedName("stock_creator_mchid")
  private String stockCreatorMchid;

}
