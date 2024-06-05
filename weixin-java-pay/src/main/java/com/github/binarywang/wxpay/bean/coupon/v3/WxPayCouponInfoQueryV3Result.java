package com.github.binarywang.wxpay.bean.coupon.v3;

import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.Serializable;

/**
 * 查询代金券信息响应结果类V3
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class WxPayCouponInfoQueryV3Result implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * <pre>
   * 字段名：创建批次的商户号
   * 变量名： stock_creator_mchid
   * 说明：微信为创建方商户分配的商户号
   * 类型：String
   * 是否必填： 是
   * </pre>
   */
  @SerializedName("stock_creator_mchid")
  private String stockCreatorMchid;


  /**
   * <pre>
   * 字段名：批次号
   * 说明：微信为代金券分配的唯一id
   * 变量名： stock_id
   * 类型： String
   * 是否必填： 是
   * </pre>
   */
  @SerializedName("stock_id")
  private String stockId;

  /**
   * <pre>
   * 字段名：代金券Id
   * 类型：String
   * 是否必填： 是
   * </pre>
   */
  @SerializedName("coupon_id")
  private String couponId;

  /**
   * <pre>
   * 字段名：单品优惠特定信息
   * 变量名： cut_to_message
   * 类型：CutTypeMsg
   * 是否必填： 否
   * </pre>
   */
  @SerializedName("cut_to_message")
  private CutTypeMsg cutToMessage;


  /**
   * <pre>
   * 字段名： 代金券名称
   * 变量名： coupon_name
   * 类型：String
   * 是否必填： 是
   * </pre>
   */
  @SerializedName("coupon_name")
  private String couponName;

  /**
   * <pre>
   * 字段名：代金券状态
   * 变量名： status
   * 类型：String: SENDED, USED, EXPIRED
   * 是否必填：是
   * </pre>
   */
  @SerializedName("status")
  private String status;

  /**
   * <pre>
   * 字段名：使用说明
   * 是否必填： 是
   * 类型：String
   * </pre>
   */
  @SerializedName("description")
  private String description;

  /**
   * <pre>
   * 字段名： 领券时间
   * 说明：格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
   * 是否必填： 是
   * 类型：String
   * </pre>
   */
  @SerializedName("create_time")
  private String createTime;

  /**
   * <pre>
   * 字段名： 券类型
   * 是否必填： 是
   * 类型： String， NORMAL(满减），CUT_TO(减至）
   * </pre>
   */
  @SerializedName("coupon_type")
  private String couponType;

  /**
   * <pre>
   * 字段名： 是否无资金流
   * 类型： Boolean: true, false
   * 是否必填： 是
   * </pre>
   */
  @SerializedName("no_cash")
  private String noCash;

  /**
   * <pre>
   * 字段名：可用开始时间
   * 说明：格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE
   * 类型：String
   * 是否必填： 是
   * </pre>
   */
  @SerializedName("available_begin_time")
  private String availableBeginTime;

  /**
   * 字段名：可用结束时间
   * 说明：格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE
   * 类型：String
   * 是否必填： 是
   */
  @SerializedName("available_end_time")
  private String availableEndTime;

  /**
   * 字段名：是否单品优惠
   * 类型： Boolean: false, true
   * 是否必填： 是
   */
  @SerializedName("single_item")
  private String singleItem;

  /**
   * 字段名：满减券信息
   * 说明：普通满减券面额，门槛信息
   */
  @SerializedName("normal_coupon_information")
  private FixedValueStockMsg normalCouponInformation;

  /**
   * 字段名：商户单据号
   * 是否必填：否
   */
  @SerializedName("out_request_no")
  private String outRequestNo;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class CutTypeMsg {
    /**
     * 可用优惠的商品最高单价,单位：分
     */
    @SerializedName("single_price_max")
    private Integer singlePriceMax;

    /**
     * 减至后的优惠单价,单位：分
     */
    @SerializedName("cut_to_price")
    private Integer cutToPrice;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class FixedValueStockMsg {

    /**
     * 面额，单位分
     */
    @SerializedName("coupon_amount")
    private Integer couponAmount;

    /**
     * 门槛，单位分
     */
    @SerializedName("transaction_minimum")
    private Integer transactionAmount;
  }

}
