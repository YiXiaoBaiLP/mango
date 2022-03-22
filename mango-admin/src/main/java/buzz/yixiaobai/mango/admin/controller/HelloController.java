package buzz.yixiaobai.mango.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 * @author yixiaobai
 * @create 2022/03/18 下午2:59
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello(){
        return "Hello Mango!";
    }
}
