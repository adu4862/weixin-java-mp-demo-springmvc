package com.github.binarywang.demo.spring.handler;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.github.binarywang.demo.spring.builder.TextBuilder;
import com.github.binarywang.demo.spring.service.WeixinService;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * 
 * @author Binary Wang
 *
 */
@Component
public class SubscribeHandler extends AbstractHandler {

  @Override
  public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
      WxSessionManager sessionManager) throws WxErrorException {

    this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser());

    WeixinService weixinService = (WeixinService) wxMpService;

    // 获取微信用户基本信息
//    WxMpUser userWxInfo = weixinService.getUserService().userInfo(wxMessage.getFromUser(), null);
//
//    if (userWxInfo != null) {
//      // TODO 可以添加关注用户到本地
//    }

    WxMpXmlOutMessage responseResult = null;
    try {
      responseResult = handleSpecial(wxMessage);
    } catch (Exception e) {
      this.logger.error(e.getMessage(), e);
    }

    if (responseResult != null) {
      return responseResult;
    }

    try {
      return new TextBuilder().build("你好，欢迎关注长沙资讯号!\n" +
              "\n" +
              "① 爱放影院是一个提供影视剧在线观看的公众号！\n" +
              "\n" +
              "② 我们这里无广告，全免费，资源全，更新快！\n" +
              "\n" +
              "③ 刚上映的、最新的电影、电视剧、动漫 我们这里应有尽有！\n" +
              "\n" +
              "④ 在其他地方要VIP，要收费才能看的影视剧，我们这里统统不要钱！\n" +
              "\n" +
              "⑤ 自助搜索，直接回复影视剧名称或者演员名称即可！\n" +
              "\n" +
              "⑥ 手机/电脑浏览器访问网址 http://www.bajiedianying.com\n" +
              "\n" +
              "⑦ 点击公众号右上角，置顶公众号，追剧从此更方便！\n" +
              "\n" +
              "⑧ 没找到剧集、无法播放，可加入问题反馈QQ群！一切问题群里反馈。群号：710211105", wxMessage, weixinService);
    } catch (Exception e) {
      this.logger.error(e.getMessage(), e);
    }

    return null;
  }

  /**
   * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
   */
  protected WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage) throws Exception {
    //TODO
    return null;
  }

}
