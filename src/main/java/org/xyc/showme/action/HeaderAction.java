package org.xyc.showme.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Enumeration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by wks on date: 2018/9/26
 */
@Controller
@RequestMapping(value = "/header")
public class HeaderAction {

    private static final Logger logger = LoggerFactory.getLogger(HeaderAction.class);

    @RequestMapping(value = "/agent")
    @ResponseBody
    public String agent(HttpServletRequest req, HttpServletResponse resp) {
        Enumeration e = req.getHeaderNames();
        StringBuilder sb = new StringBuilder();
        while (e.hasMoreElements()) {
            String name = (String)e.nextElement();
            logger.info("{} : {}", name, req.getHeader(name));
            sb.append(name).append(" : ").append(req.getHeader(name)).append("</br>");
        }
        return sb.toString();
    }
}
