package org.xyc.showme.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by wks on date: 2018/1/19
 */
@Controller
@RequestMapping(value = "/body")
public class BodyAction {

    private static final Logger logger = LoggerFactory.getLogger(BodyAction.class);

    @RequestMapping(value = "/accept")
    @ResponseBody
    public String one(@RequestBody String str) {
        logger.info("accept - {}", str);
        return "hello + " + str;
    }
}
