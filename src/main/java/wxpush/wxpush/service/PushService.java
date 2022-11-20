package wxpush.wxpush.service;

import wxpush.wxpush.dto.push.PushReqDto;
import wxpush.wxpush.utils.ResponseData;

/**
 * @Author BaoXu Zhang
 * @Date 2022/11/16 0:03
 */
public interface PushService {

    /**
     * 微信推送。
     *
     * @Author BaoXu Zhang
     * @Date 2022/11/16 0:06
     * @param reqDto 请求参数
     * @return wxpush.wxpush.utils.ResponseData
     **/
    ResponseData wxPush(PushReqDto reqDto);
}
