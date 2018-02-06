package sugar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lei on 2018/2/5.
 */
@RestController
public class MayController {

    @RequestMapping("/admin/sugar/hello")
    public String mayBeLong(){
        return "helloWorld";
    }

}
