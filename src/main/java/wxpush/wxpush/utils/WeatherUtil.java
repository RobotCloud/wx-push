package wxpush.wxpush.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 百度天气。
 *
 * @Author BaoXu Zhang
 * @Date 2022/11/16 21:50
 */
public class WeatherUtil {

    private static final String WEATHER_AK = "Q2F3gLc6N361G9SGnAgkSUED7OOIPEQP";
    private static final String WEATHER_DISTRICT_ID = "110105";

    /**
     * 调用百度天气API，获取天气信息。
     *
     * @Author BaoXu Zhang
     * @Date 2022/11/16 21:53
     **/
    public static JSONObject getBaiDuWeather() {
        String result;
        JSONObject today = new JSONObject();
        try {
            result = HttpUtil.getUrl("https://api.map.baidu.com/weather/v1/?district_id=" + WEATHER_DISTRICT_ID + "&data_type=all&ak=" + WEATHER_AK);
            JSONObject jsonObject = JSONObject.parseObject(result);
            System.out.println(jsonObject);
            if ("success".equals(jsonObject.getString("message"))) {
                JSONArray arr = jsonObject.getJSONObject("result").getJSONArray("forecasts");
                today = arr.getJSONObject(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return today;
    }

    public static void main(String[] args) {
        System.out.println(getBaiDuWeather());
    }
}
