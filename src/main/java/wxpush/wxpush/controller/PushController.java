package wxpush.wxpush.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wxpush.wxpush.dto.push.PushReqDto;
import wxpush.wxpush.service.PushService;
import wxpush.wxpush.utils.ResponseData;

/**
 * @Author BaoXu Zhang
 * @Date 2022/11/16 0:00
 */
@RestController
@RequestMapping("/push")
public class PushController {

    @Autowired
    private PushService pushService;

    @PostMapping("/push")
    public ResponseData push(@RequestBody PushReqDto reqDto) {
        return pushService.wxPush(reqDto);
    }
}
