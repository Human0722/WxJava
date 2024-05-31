package com.github.binarywang.wxpay.bean.coupon.v3;

import com.github.binarywang.wxpay.bean.result.BaseWxPayResult;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.Serializable;

/**
 * 查询代金券批次响应参数对象V3
 * https://pay.weixin.qq.com/docs/merchant/apis/cash-coupons/stock/query-stock.html
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@XStreamAlias("xml")
public class WxPayCouponStockQueryV3Result extends BaseWxPayResult implements Serializable {
  private static final long serialVersionUID = 1L;

  /**
   * 字段名： 批次号
   * 是否必填： 是
   * 类型： String
   */
  @XStreamAlias("stock_id")
  private String stockId;

  /**
   * 字段名：批次创建方商户号
   * 是否必填： 是
   * 类型：String
   */
  @XStreamAlias("stock_creator_mchid")
  private String stockCreatorMchid;

  /**
   * 字段名：批次名称
   * 是否必填： 是
   * 类型：String
   */
  @XStreamAlias("stock_name")
  private String stockName;

  /**
   * 字段名： 批次状态
   * 是否必填： 是
   * 类型：String: unactivated:未激活， audit:审核中， running:运行中，stoped:已停止， paused: 暂停发放
   */
  @XStreamAlias("status")
  private String status;

  /**
   * 字段名：创建时间
   * 是否必填： 是
   * 类型：String 格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @XStreamAlias("create_time")
  private String createTime;

  /**
   * 字段名：使用说明
   * 是否必填：是
   * 类型：String
   */
  @XStreamAlias("description")
  private String description;

  /**
   * 字段名：满减券批次使用规则
   * 是否必填：否
   * 说明：层级深，暂时不写
   */
  @XStreamAlias("stock_use_rule")
  private String stockUseRuleXML;

  /**
   * 字段名：可用开始时间
   * 是否必填： 是
   * 类型：String 格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @XStreamAlias("available_begin_time")
  private String availableBeginTime;


  /**
   * 字段名： 可用结束时间
   * 是否必填： 是
   * 类型：String 格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @XStreamAlias("available_end_time")
  private String availableEndTime;

  /**
   * 字段名：已发放数量
   * 是否必填：是
   * 类型：Integer
   */
  @XStreamAlias("distributed_coupons")
  private Integer distributedCoupons;

  /**
   * 字段名：是否
   * 是否必填：是
   * 类型：Boolean: true, false
   */
  @XStreamAlias("no_cash")
  private String noCash;

  /**
   * 字段名：激活批次的时间
   * 是否必填：否
   * 类型：String 格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @XStreamAlias("start_time")
  private String startTime;

  /**
   * 字段名： 终止批次的时间
   * 是否必填： 否
   * 类型：String 格式为yyyy-MM-DDTHH:mm:ss.sss+TIMEZONE 。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   */
  @XStreamAlias("stop_time")
  private String stopTime;

  /**
   * 字段名：减至批次特定信息
   * 是否必填： 否
   */
  @XStreamAlias("cut_to_message")
  private CutTypeMsg cutToMessage;

  /**
   * 字段名： 是否单品优惠
   * 是否必填：是
   * 类型：Boolean true,false
   */
  @XStreamAlias("single_item")
  private String singleitem;

  /**
   * 字段名：批次类型
   * 是否必填：是
   * 类型：String
   */
  @XStreamAlias("stock_type")
  private String stockType;

  /**
   * 字段名： 卡包ID
   * 是否必填： 否
   * 类型：String
   */
  @XStreamAlias("card_id")
  private String cardId;

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
  private static class StockUseRule {
    //TODO https://pay.weixin.qq.com/docs/merchant/apis/cash-coupons/stock/query-stock.html
    // too much
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

  @Override
  protected void loadXml(Document d) {
    stockId = readXmlString(d, "stock_id");
    stockCreatorMchid = readXmlString(d, "stock_creator_mchid");
    stockName = readXmlString(d, "stock_name");
    status = readXmlString(d, "status");
    createTime = readXmlString(d, "create_time");
    description = readXmlString(d, "description");
    stockUseRuleXML = readXmlString(d, "stock_use_rule");
    availableBeginTime = readXmlString(d, "available_begin_time");
    availableEndTime = readXmlString(d, "available_end_time");
    distributedCoupons = readXmlInteger(d, "distributed_coupons");
    noCash = readXmlString(d, "no_cash");
    startTime = readXmlString(d, "start_time");
    stopTime = readXmlString(d, "stop_time");
    cutToMessage = readXmlCutTypeMsg(d, "cut_to_message");
    singleitem = readXmlString(d, "singleitem");
    stockType = readXmlString(d, "stock_type");
    cardId = readXmlString(d, "card_id");

  }
}
