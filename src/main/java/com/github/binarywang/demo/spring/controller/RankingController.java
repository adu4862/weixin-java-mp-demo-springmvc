package com.github.binarywang.demo.spring.controller;

import com.github.binarywang.demo.spring.domain.ReturnModel;
import com.github.binarywang.demo.spring.utils.HttpRequestUtil;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class RankingController {
    @ResponseBody
    @GetMapping(produces = "text/plain;charset=utf-8")
    @RequestMapping(method = RequestMethod.GET)
    public void get(HttpServletResponse response) {
        //将参数返回给页面
        String s = HttpRequestUtil.sendGet("http://api.zhuishushenqi.com/ranking/gender");
        ReturnModel returnModel = new ReturnModel();
        returnModel.setResult(true);
        returnModel.setDatum(null);
        renderString(response, returnModel);
    }


    /**
     * 客户端返回JSON字符串
     *
     * @param response
     * @param object
     * @return
     */
    protected String renderString(HttpServletResponse response, Object object) {
        return renderString(response, new Gson().toJson(object), "application/json");
    }

    /**
     * 客户端返回字符串
     *
     * @param response
     * @param string
     * @return
     */
    protected String renderString(HttpServletResponse response, String string, String type) {
        try {
            response.reset();
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            //解决跨域问题
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.getWriter().print(string);
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
