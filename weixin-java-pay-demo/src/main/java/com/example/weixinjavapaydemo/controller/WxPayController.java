package com.example.weixinjavapaydemo.controller;

import com.github.binarywang.wxpay.bean.coupon.WxPayCouponStockQueryRequest;
import com.github.binarywang.wxpay.bean.coupon.v3.*;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderV3Request;
import com.github.binarywang.wxpay.bean.result.enums.TradeTypeEnum;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.common.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(WxPayController.BASE_URL)
public class WxPayController {

  public static final String BASE_URL = "/wx";

  @Autowired
  private WxPayService wxService;

  @ApiOperation(value = "test")
  @PostMapping("/test")
  public String test() {
    return "aaa";
  }

  @ApiOperation(value = "测试发放代金券，不带参数")
  @PostMapping("/sendCouponV3")
  public WxPayCouponSendV3Result sendV3Coupon() throws WxPayException {
    WxPayCouponSendV3Request request = new WxPayCouponSendV3Request();
    request.setAppid("wx0f454cbf8c369d54");
    request.setOpenId("oV-u01Yy-UHHGKeKk7hYFNfUVTAw");
    request.setStockId("18962051");
    request.setOutRequestNo(String.format("%s%s%s", "1651231433","2024-06-04","002"));
    request.setStockCreatorMchid("1651231433");
    return this.wxService.sendCouponV3(request);
  }

  @ApiOperation(value = "测试V3向微信服务器下单")
  @RequestMapping(value = "/exchangePayV3",method = RequestMethod.POST)
  public Object wxPay(){
    WxPayParam wxPayParam = new WxPayParam();
    wxPayParam.setOpenId("oV-u01Yy-UHHGKeKk7hYFNfUVTAw");
    wxPayParam.setTotalFee(new BigDecimal("1"));
    String orderSn = "exchange" + System.currentTimeMillis() + "_" + "abcde";
    wxPayParam.setOrderSn(orderSn);

    WxPayUnifiedOrderV3Request.Payer payer = new WxPayUnifiedOrderV3Request.Payer();
    payer.setOpenid(wxPayParam.getOpenId());
    WxPayUnifiedOrderV3Request.Amount amount = new WxPayUnifiedOrderV3Request.Amount();
    amount.setTotal(new BigDecimal(0.11));
    amount.setCurrency("CNY");
    WxPayUnifiedOrderV3Request orderRequest = new WxPayUnifiedOrderV3Request();
    orderRequest.setPayer(payer);
    orderRequest.setAmount(amount);
    orderRequest.setNotifyUrl("http://localhost:8080/pay/notify/order");
    orderRequest.setOutTradeNo(wxPayParam.getOrderSn());
    orderRequest.setDescription("支付测试");
    try {
      return this.wxService.createOrderV3(TradeTypeEnum.JSAPI,orderRequest);
    } catch (WxPayException e) {
      e.printStackTrace();
    }
    return null;
  }

  @ApiOperation(value = "测试查看批次详情接口Failed")
  @RequestMapping(value = "/queryStockV3", method = RequestMethod.POST)
  public WxPayCouponStockQueryV3Result queryStocy() throws WxPayException {
    WxPayCouponStockQueryV3Request request = new WxPayCouponStockQueryV3Request();
    request.setStockId("18962051");
    request.setStockCreatorMchid("1651231433");
    return this.wxService.queryCouponStockV3(request);
  }

  @ApiOperation(value = "查看代金券详情")
  @RequestMapping(value = "/queryCouponInfoV3", method = RequestMethod.POST)
  public Object queryCouponV3() throws WxPayException {
    WxPayCouponInfoQueryV3Request request = new WxPayCouponInfoQueryV3Request();
    request.setCouponId("66151530230");
    request.setOpenId("oV-u01Yy-UHHGKeKk7hYFNfUVTAw");
    request.setAppid("wx0f454cbf8c369d54");
    request.setStockId("18962051");

    WxPayCouponInfoQueryV3Result wxPayCouponInfoQueryV3Result = this.wxService.queryCouponInfoV3(request);
    return wxPayCouponInfoQueryV3Result;
  }


}
