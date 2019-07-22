package org.xyc.showme.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by wks on date: 2019/1/18
 */
@Controller
@RequestMapping(value = "/rest")
public class RestSample {

    @ResponseBody
    @RequestMapping(path = "/hello/one")
    public String one() {
        return "hello one";
    }

    @ResponseBody
    @RequestMapping(path = "/hello/{world}")
    public String two(@PathVariable("world") String world) {
        return "hello two " + world;
    }

    @ResponseBody
    @RequestMapping(path = "/hello/{mode}/one")
    public String three(@PathVariable("mode") String mode) {
        return "hello three";
    }

    @ResponseBody
    @RequestMapping(path = "/hello/three/one")
    public String four() {
        return "hello four";
    }
}
