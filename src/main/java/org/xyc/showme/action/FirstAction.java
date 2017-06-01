package org.xyc.showme.action;

import java.util.Map;
import java.util.Random;

import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CCC on 2016/3/7.
 */
@Controller
@RequestMapping(value = "/first")
public class FirstAction {

    private static final Logger logger = LoggerFactory.getLogger(FirstAction.class);

    @RequestMapping(value = "/one")
    public String one(@RequestParam(required = false) String msg, Map<String, Object> map) {
        System.out.println(msg);
        if (Strings.isNullOrEmpty(msg))
            msg = "hello you";
        map.put("abc", msg);
        logger.info("receive message {}", msg);
        return "first/first";
    }

    @RequestMapping(value = "/two")
    @ResponseBody
    public String two() {
        Random random = new Random();
        return "hello " + random.nextInt(100);
    }
}
