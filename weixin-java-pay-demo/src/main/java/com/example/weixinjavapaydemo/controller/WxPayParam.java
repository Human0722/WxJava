package com.example.weixinjavapaydemo.controller;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WxPayParam {

  private String orderSn;//订单号

  private String openId;//微信用户openId

  private BigDecimal totalFee;//金额

}
