package manning.learning.billingservice;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class BillingController
{

    Logger log = Logger.getLogger(BillingController.class.getName());
    @RequestMapping("/payment")
    public String payment()
    {

     log.info("Init payment");
     try
     {
         Thread.sleep(800 + (int)(Math.random() * 200));
     }
        catch(Exception e)
        {
            log.info("Error in payment");
        }
        log.info("End payment");

    return "Payment Done";
    }

}
