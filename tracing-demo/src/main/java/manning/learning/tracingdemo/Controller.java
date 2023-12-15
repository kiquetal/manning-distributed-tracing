package manning.learning.tracingdemo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{

    Logger log = LoggerFactory.getLogger(Controller.class);
    @RequestMapping("/checkout")
    public String checkout()
    {
        log.info("Checkout");
        return "Checkout";
    }

}
