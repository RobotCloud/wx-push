package wxpush.wxpush.utils;

import java.util.HashMap;

/**
 * 封装数据的工具类，将查询的数据封装到工具类中，以JSON的形式返回给前端。
 *
 * @Author 张宝旭
 * @Date 2022/11/16
 */
public class ResponseData extends HashMap<String, Object> {

    @Override
    public ResponseData put(String name, Object message) {
        super.put(name, message);
        return this;
    }

    /**
     * 成功。
     *
     * @param message 响应的消息
     * @return 响应体
     */
    public static ResponseData success(String message) {
        ResponseData responseData = new ResponseData();
        responseData.put("code", 200);
        responseData.put("message", message);
        return responseData;
    }

    /**
     * 失败。
     *
     * @param message 响应的消息
     * @return 响应体
     */
    public static ResponseData error(String message) {
        ResponseData responseData = new ResponseData();
        responseData.put("code", -1);
        responseData.put("message", message);
        return responseData;
    }

    /**
     * 未登录。
     *
     * @return 响应体
     */
    public static ResponseData notLogin() {
        ResponseData responseData = new ResponseData();
        responseData.put("code", 401);
        responseData.put("message", "用户未登录");
        return responseData;
    }

    /**
     * 未注册。
     *
     * @return 响应体
     */
    public static ResponseData notRegister() {
        ResponseData responseData = new ResponseData();
        responseData.put("code", 1);
        responseData.put("message", "用户未注册");
        return responseData;
    }

    /**
     * 新用户。
     *
     * @return 响应体
     */
    public static ResponseData newUser() {
        ResponseData responseData = new ResponseData();
        responseData.put("code", 0);
        responseData.put("message", "新用户");
        return responseData;
    }

    public static void main(String[] args) {
        ResponseData.success("成功").put("user", "user");
    }
}
