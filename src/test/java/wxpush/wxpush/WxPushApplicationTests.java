package wxpush.wxpush;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wxpush.wxpush.utils.WeatherUtil;

@SpringBootTest
class WxPushApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(WeatherUtil.getBaiDuWeather());
    }

}
