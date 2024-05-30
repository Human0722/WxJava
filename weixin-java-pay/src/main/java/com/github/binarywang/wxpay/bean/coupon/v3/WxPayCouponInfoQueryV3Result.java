package com.github.binarywang.wxpay.bean.coupon.v3;

import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.Serializable;

public class WxPayCouponInfoQueryV3Result extends BaseWxPayResult implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 字段名：创建批次的商户号
   * 变量名： stock_creator_mchid
   * 说明：微信为创建方商户分配的商户号
   * 类型：String
   * 是否必填： 是
   */
  @XStreamAlias("stock_creator_mchid")
  private String stockCreatorMchid;


  /**
   * 字段名：批次号
   * 说明：微信为代金券分配的唯一id
   * 变量名： stock_id
   * 类型： String
   * 是否必填： 是
   */
  @XStreamAlias("stock_id")
  private String stockId;

  /**
   * 字段名：代金券Id
   * 类型：String
   * 是否必填： 是
   */
  @XStreamAlias("coupon_id")
  private String couponId;

  /**
   * 字段名：单品优惠特定信息
   * 变量名： cut_to_message
   * 类型：CutTypeMsg
   * 是否必填： 否
   */
  @XStreamAlias("cut_to_message")
  private CutTypeMsg cutToMessage;


  /**
   * 字段名： 代金券名称
   * 变量名： coupon_name
   * 类型：String
   * 是否必填： 是
   */
  @XStreamAlias("coupon_name")
  private String couponName;

  /**
   * 字段名：代金券状态
   * 变量名： status
   * 类型：String: SENDED, USED, EXPIRED
   * 是否必填：是
   */
  @XStreamAlias("status")
  private String status;

  /**
   * 字段名：使用说明
   * 是否必填： 是
   * 类型：String
   */
  @XStreamAlias("description")
  private String description;

  /**
   * 字段名： 领券时间
   * 说明：格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
   * 是否必填： 是
   * 类型：String
   */
  @XStreamAlias("create_time")
  private String createTime;

  /**
   * 字段名： 券类型
   * 是否必填： 是
   * 类型： String， NORMAL(满减），CUT_TO(减至）
   */
  @XStreamAlias("coupon_type")
  private String couponType;

  /**
   * 字段名： 是否无资金流
   * 类型： Boolean: true, false
   * 是否必填： 是
   */
  @XStreamAlias("no_cash")
  private String noCash;

  /**
   * 字段名：可用开始时间
   * 说明：格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE
   * 类型：String
   * 是否必填： 是
   */
  @XStreamAlias("available_begin_time")
  private String availableBeginTime;

  /**
   * 字段名：可用结束时间
   * 说明：格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE
   * 类型：String
   * 是否必填： 是
   */
  @XStreamAlias("available_end_time")
  private String availableEndTime;

  /**
   * 字段名：是否单品优惠
   * 类型： Boolean: false, true
   * 是否必填： 是
   */
  @XStreamAlias("single_item")
  private String singleItem;

  /**
   * 字段名：满减券信息
   * 说明：普通满减券面额，门槛信息
   */
  @XStreamAlias("normal_coupon_information")
  private FixedValueStockMsg normalCouponInformation;

  /**
   * 字段名：商户单据号
   * 是否必填：否
   */
  @XStreamAlias("out_request_no")
  private String outRequestNo;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class CutTypeMsg {
    /**
     * 可用优惠的商品最高单价,单位：分
     */
    @XStreamAlias("single_price_max")
    private Integer singlePriceMax;

    /**
     * 减至后的优惠单价,单位：分
     */
    @XStreamAlias("cut_to_price")
    private Integer cutToPrice;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  private static class FixedValueStockMsg {

    /**
     * 面额，单位分
     */
    @XStreamAlias("coupon_amount")
    private Integer couponAmount;

    /**
     * 门槛，单位分
     */
    @XStreamAlias("transaction_minimum")
    private Integer transactionAmount;
  }



  @Override
  protected void loadXml(Document d) {
    stockCreatorMchid = readXmlString(d, "stock_creator_mchid");
    stockId = readXmlString(d, "stock_id");
    couponId = readXmlString(d, "coupon_id");
    cutToMessage = readXmlCutTypeMsg(d, "cut_to_message");
    couponName = readXmlString(d, couponName);
    status = readXmlString(d, "status");
    description = readXmlString(d, "description");
    createTime = readXmlString(d, "create_time");
    couponType = readXmlString(d, "coupon_type");
    noCash = readXmlString(d, "no_cash");
    availableBeginTime = readXmlString(d, "available_begin_time");
    availableEndTime = readXmlString(d, "available_end_time");
    singleItem = readXmlString(d, "single_item");
    normalCouponInformation = readXmlFixedValueStockMsg(d, "normal_coupon_information");
    outRequestNo = readXmlString(d, "out_request_no");

  }

  private CutTypeMsg readXmlCutTypeMsg(Document d, String tagName) {
    NodeList elementsByTagName = d.getElementsByTagName(tagName);
    if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
      return null;
    }
    Node item = elementsByTagName.item(0);
    CutTypeMsg cutTypeMsg = new CutTypeMsg();
    cutTypeMsg.setCutToPrice(readXmlInteger(item, "cut_to_price"));
    cutTypeMsg.setSinglePriceMax(readXmlInteger(item, "single_price_max"));
    return cutTypeMsg;
  }

  private FixedValueStockMsg readXmlFixedValueStockMsg(Document d, String tagName) {
    NodeList elementsByTagName = d.getElementsByTagName(tagName);
    if (elementsByTagName == null || elementsByTagName.getLength() == 0) {
      return null;
    }
    Node item = elementsByTagName.item(0);
    FixedValueStockMsg fixedValueStockMsg = new FixedValueStockMsg();
    fixedValueStockMsg.setCouponAmount(readXmlInteger(item, "coupon_amount"));
    fixedValueStockMsg.setTransactionAmount(readXmlInteger(item, "transaction_amount"));
    return fixedValueStockMsg;

  }

}
