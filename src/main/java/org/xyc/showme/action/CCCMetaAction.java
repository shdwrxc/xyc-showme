package org.xyc.showme.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cccis.base.redis.RedisBaseDao;

/**
 * created by wks on date: 2019/7/19
 */
@Controller
@RequestMapping(value = "/meta")
public class CCCMetaAction {

    private static final Logger logger = LoggerFactory.getLogger(CCCMetaAction.class);

    @Autowired
    private RedisBaseDao redisBaseDao;

    @RequestMapping(value = "/data")
    public void one(HttpServletRequest request, HttpServletResponse response) throws Exception {
        byte[] bytes = redisBaseDao.getNativeBytes("world");
        System.out.println("bytes length " + bytes.length);

        response.setHeader("Content-Encoding", "gzip");
        response.setHeader("Content-Length", String.valueOf(bytes.length));
//        response.setHeader("Content-Type", "application/json");
        response.setHeader("Content-Type", "text/plain");

        OutputStream stream = response.getOutputStream();
        stream.write(bytes);
        stream.flush();
        stream.close();
    }
}
