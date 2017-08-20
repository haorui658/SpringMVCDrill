package com.jd.risktest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gooo on 2017/8/20.
 */
@Controller
@RequestMapping("/labelHelper")
public class LabelController {


    @RequestMapping("/index")
    public String index() {
        return "label";
    }


    @ResponseBody
    @RequestMapping(value = "/replace", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String SendRequest(String param) {
        try {

            String result = "";
            Pattern pattern = Pattern.compile("\\\"(\\w+)\\\"");
            Matcher matcher = pattern.matcher(param);
            while (matcher.find()) {

                System.out.print(matcher.group());

            }
            return result;
        } catch (
                Exception e)

        {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
