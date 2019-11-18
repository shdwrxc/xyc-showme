package org.xyc.showme.action;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by wks on date: 2019/11/14
 */
@Controller
@RequestMapping(value = "/click")
public class ClickSelfAction {

    @RequestMapping(value = "/click1")
    public String click1() {
        return "click/click1";
    }

    @RequestMapping(value = "/click2")
    public String click2() {
        return "click/click2";
    }

    @RequestMapping(value = "/click3")
    @ResponseBody
    public String click3() {
        Map<String, String> map = Maps.newHashMap();
        map.put("song", "jiang");
        map.put("qing", "pu");
        return JSON.toJSONString(map);
    }
}
