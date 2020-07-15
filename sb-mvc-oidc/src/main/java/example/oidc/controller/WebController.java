package example.oidc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/member")
    public String member()
    {
        return "member";
    }

    @RequestMapping("/admin")
    public String admin()
    {
        return "admin";
    }
}
