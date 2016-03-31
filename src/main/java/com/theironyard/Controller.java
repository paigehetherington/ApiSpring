package com.theironyard;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by vajrayogini on 3/31/16.
 */
public class Controller {
    static final String SAMPLE_URL = "http://gturnquist-quoters.cfapps.io/api/random";

    @RequestMapping (path = "/quote", method = RequestMethod.GET)
    public HashMap getQuote() {
        //http request form server
        RestTemplate query = new RestTemplate();
        HashMap result = query.getForObject(SAMPLE_URL, HashMap.class); //parse into HM
        String type = (String) result.get("type"); //to retrieve certain part, must cast type
        if (type.equals("success")) {
            HashMap value = (HashMap) result.get("value"); //key of what want to return
            return value;
        }
        return null;
    }
}
