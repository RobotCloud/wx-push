package wxpush.wxpush.service.impl;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import wxpush.wxpush.dto.push.PushReqDto;
import wxpush.wxpush.service.PushService;
import wxpush.wxpush.utils.ResponseData;
import wxpush.wxpush.utils.WeatherUtil;

/**
 * @Author BaoXu Zhang
 * @Date 2022/11/16 0:03
 */
@Service
public class PushServiceImpl implements PushService {

    @Value("${push.appId}")
    private String appId;

    @Value("${push.secret}")
    private String secret;

    @Value("${push.openId}")
    private String openId;

    @Value("${push.templateId}")
    private String templateId;

    @Override
    public ResponseData wxPush(PushReqDto reqDto) {
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openId)
                .templateId(templateId)
                .build();
        //填写变量信息，比如天气之类的
//        JSONObject todayWeather = Tianqi.getNanjiTianqi();
        templateMessage.addData(new WxMpTemplateData("riqi", WeatherUtil.getBaiDuWeather().getString("date")
                + "  " + WeatherUtil.getBaiDuWeather().getString("week"),"#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("tianqi", WeatherUtil.getBaiDuWeather().getString("text_day")
                + "  " + WeatherUtil.getBaiDuWeather().getString("wd_day") + WeatherUtil.getBaiDuWeather().getString("wc_day"),"#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("low", WeatherUtil.getBaiDuWeather().getString("low"),"#C71585"));
        templateMessage.addData(new WxMpTemplateData("high",WeatherUtil.getBaiDuWeather().getString("high"),"#FF6347" ));
        templateMessage.addData(new WxMpTemplateData("caihongpi", "人生若只如初见，何事秋风悲画扇","#FF69B4"));
//        templateMessage.addData(new WxMpTemplateData("lianai",JiNianRi.getLianAi()+"","#FF1493"));
        templateMessage.addData(new WxMpTemplateData("shengri","0.25","#FFA500"));
        templateMessage.addData(new WxMpTemplateData("jinju", "日落跌入昭昭星野 人间忽晚 山河以秋","#C71585"));
//        templateMessage.addData(new WxMpTemplateData("jiehun",JiNianRi.getJieHun()+""));
//        templateMessage.addData(new WxMpTemplateData("linzhen",JiNianRi.getLinZhen()+"","#FF6347"));
        String beizhu = "把细碎的烦恼关掉，将月亮挂好";
        templateMessage.addData(new WxMpTemplateData("beizhu",beizhu,"#FF0000"));


        try {
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
        return ResponseData.success("推送成功").put("data", templateMessage.toJson());
    }
}
