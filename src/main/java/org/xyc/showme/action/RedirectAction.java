package org.xyc.showme.action;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * created by wks on date: 2019/10/17
 */
@Controller
@RequestMapping(value = "/dir")
public class RedirectAction {

    private static final Logger logger = LoggerFactory.getLogger(RedirectAction.class);

    @RequestMapping(value = "/first/{hello}")
    public String normal(@PathVariable("hello") String hello, Map<String, Object> map) {
        logger.info("welcome - {}", hello);
        map.put("abc", hello);
        return "first/first";
    }

    @RequestMapping(value = "/second/{hello}")
    public String dir(@PathVariable("hello") String hello, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("abc", hello);
        return "redirect:/dir/third";
    }

    @RequestMapping(value = "/fifth/{hello}")
    public String dir2(@PathVariable("hello") String hello, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("abc", hello);
        redirectAttributes.addAttribute("other", "nice");
        return "redirect:/dir/third";
    }

    @RequestMapping(value = "/sixth/{hello}")
    public RedirectView dir3(@PathVariable("hello") String hello, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("abc", hello);
        redirectAttributes.addAttribute("other", "nice");
        return new RedirectView("/dir/third", true, false, true);
    }

    @RequestMapping(value = "/seventh/{hello}")
    public RedirectView dir4(@PathVariable("hello") String hello, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("abc", hello);
        redirectAttributes.addAttribute("other", "nice");
        return new RedirectView("/dir/third", true, false, false);
    }

    @RequestMapping(value = "/eighth/{hello}")
    public RedirectView dir5(@PathVariable("hello") String hello, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("abc", hello);
        redirectAttributes.addFlashAttribute("other", "nice");
        return new RedirectView("/dir/third", true, false, false);
    }

    @RequestMapping(value = "/third")
    public String goHere(Map<String, Object> map, @RequestParam(value = "other", required = false) String other) {
        if (other != null) {
            map.put("other", other);
        }
        return "first/first";
    }
}
