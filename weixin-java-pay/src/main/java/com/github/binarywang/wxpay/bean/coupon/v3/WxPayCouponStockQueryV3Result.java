package com.github.binarywang.wxpay.bean.coupon.v3;

import com.github.binarywang.wxpay.bean.marketing.FavorStocksGetResult;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.checkerframework.checker.units.qual.N;

import java.io.Serializable;
import java.util.List;

/**
 * 查询代金券批次响应参数对象V3
 * https://pay.weixin.qq.com/docs/merchant/apis/cash-coupons/stock/query-stock.html
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class WxPayCouponStockQueryV3Result implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 字段名： 批次号
   * 是否必填： 是
   * 类型： String
   */
  @SerializedName("stock_id")
  private String stockId;

  /**
   * 字段名：批次创建方商户号
   * 是否必填： 是
   * 类型：String
   */
  @SerializedName("stock_creator_mchid")
  private String stockCreatorMchid;

  /**
   * 字段名：批次名称
   * 是否必填： 是
   * 类型：String
   */
  @SerializedName("stock_name")
  private String stockName;

  /**
   * 字段名： 批次状态
   * 是否必填： 是
   * 类型：String: unactivated:未激活， audit:审核中， running:运行中，stoped:已停止， paused: 暂停发放
   */
  @SerializedName("status")
  private String status;

  /**
   * 字段名：创建时间
   * 是否必填： 是
   * 类型：String 格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @SerializedName("create_time")
  private String createTime;

  /**
   * 字段名：使用说明
   * 是否必填：是
   * 类型：String
   */
  @SerializedName("description")
  private String description;

  /**
   * 字段名：满减券批次使用规则
   * 是否必填：否
   * 说明：层级深，暂时不写
   */
  @SerializedName("stock_use_rule")
  private StockUseRule stockUseRule;

  /**
   * 字段名：可用开始时间
   * 是否必填： 是
   * 类型：String 格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @SerializedName("available_begin_time")
  private String availableBeginTime;


  /**
   * 字段名： 可用结束时间
   * 是否必填： 是
   * 类型：String 格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @SerializedName("available_end_time")
  private String availableEndTime;

  /**
   * 字段名：已发放数量
   * 是否必填：是
   * 类型：Integer
   */
  @SerializedName("distributed_coupons")
  private Integer distributedCoupons;

  /**
   * 字段名：是否
   * 是否必填：是
   * 类型：Boolean: true, false
   */
  @SerializedName("no_cash")
  private String noCash;

  /**
   * 字段名：激活批次的时间
   * 是否必填：否
   * 类型：String 格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @SerializedName("start_time")
  private String startTime;

  /**
   * 字段名： 终止批次的时间
   * 是否必填： 否
   * 类型：String 格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @SerializedName("stop_time")
  private String stopTime;

  /**
   * 字段名：减至批次特定信息
   * 是否必填： 否
   */
  @SerializedName("cut_to_message")
  private CutTypeMsg cutToMessage;

  /**
   * 字段名： 是否单品优惠
   * 是否必填：是
   * 类型：Boolean true,false
   */
  @SerializedName("single_item")
  private String singleitem;

  /**
   * 字段名：批次类型
   * 是否必填：是
   * 类型：String
   */
  @SerializedName("stock_type")
  private String stockType;

  /**
   * 字段名： 卡包ID
   * 是否必填： 否
   * 类型：String
   */
  @SerializedName("card_id")
  private String cardId;

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

  /**
   * 满减券批次使用规则
   * 普通发券批次特定信息
   */
  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class StockUseRule {
    /**
     * <pre>
     *   字段名：发放总上限
     *   是否必填： 是
     *   类型：Integer
     * </pre>
     */
    @SerializedName("max_coupons")
    private Integer maxCoupons;


    /**
     * <pre>
     *   字段名：单天发放上限
     *   是否必填： 是
     *   类型：Integer
     *   描述：单天消耗金额上限，单位：分
     *</pre>
     */
    @SerializedName("max_amount")
    private Integer maxAmount;

    /**
     * <pre>
     *   字段名：固定面额批次特定信息
     *   是否必填： 否
     *   类型：FixedValueStockMsg
     *   描述：固定面额批次特定信息
     * </pre>
     */
    @SerializedName("fixed_normal_coupon")
    private FixedValueStockMsg fixedNormalCoupon;

    /**
     * <pre>
     *   字段名：单个用户可领个数
     *   是否必填： 是
     *   类型：Integer
     *   描述：单个用户可领个数
     * </pre>
     */
    @SerializedName("max_coupons_per_user")
    private Integer maxCouponsPerUser;

    /**
     * <pre>
     *   字段名：券类型
     *   是否必填： 否
     *   类型：String: NORMAL, CUT_TO
     * </pre>
     */
    @SerializedName("coupon_type")
    private String couponType;

    /**
     * <pre>
     *   字段名：订单优惠标记
     *   是否必填： 否
     *   类型：List<String>
     *   描述：暂未开放
     * </pre>
     */
    @SerializedName("goods_tag")
    private List<String> goodsTag;

    /**
     * <pre>
     *   字段名：指定支付模式
     *   是否必填： 否
     *   类型：List<String>
     *   枚举值：
     *      MICROAPP: 小程序支付
     *      APPPAY: APP支付
     *      PPAY: 免密支付
     *      CARD: 付款码支付
     *      FACE: 人脸支付
     *      OTHER: 其他支付
     */
    @SerializedName("trade_type")
    private List<String> tradeType;

    /**
     * <pre>
     *   字段名：是否允许合并使用
     *   是否必填： 否
     *   类型：Boolean
     * </pre>
     */
    @SerializedName("combine_use")
    private Boolean combineUse;
  }

  /**
   * 固定面额批次特定信息
   */
  @Data
  @NoArgsConstructor
  private static class FixedValueStockMsg {
    /**
     * <pre>
     *   字段名：面额
     *   是否必填： 是
     *   类型：Integer
     * </pre>
     */
    @SerializedName("coupon_amount")
    private Integer couponAmount;

    /**
     * <pre>
     *   字段名：使用门槛
     *   是否必填： 是
     *   类型：Integer
     * </pre>
     */
    @SerializedName("transaction_minimum")
    private Integer transactionMinimum;
  }

}
