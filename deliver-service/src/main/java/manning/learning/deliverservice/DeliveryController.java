package manning.learning.deliverservice;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class DeliveryController
{

    @RequestMapping("/arrangeDelivery")
    public String arrangeDelivery()
    {
        Logger log = Logger.getLogger(DeliveryController.class.getName());

        log.info("Arranging delivery");
        try
        {
         Thread.sleep(800 + (int)(Math.random() * 400));
        }
        catch (Exception e)
        {
            log.info("Exception: " + e.getMessage());
        }
        log.info("Delivery arranged");
        return "Delivery arranged";
    }
}
