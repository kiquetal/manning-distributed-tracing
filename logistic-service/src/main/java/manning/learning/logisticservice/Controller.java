package manning.learning.logisticservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class Controller
{

    @RequestMapping("/transport")
    public String transport()
    {
        Logger log = Logger.getLogger(Controller.class.getName());
        log.info("Transporting");
        try
        {
            Thread.sleep(800 + (int)(Math.random() * 400));

        }
        catch (Exception e)
        {
            log.info("Exception: " + e.getMessage());
        }
        log.info("Transported");

        return "Transported";
    }
}
