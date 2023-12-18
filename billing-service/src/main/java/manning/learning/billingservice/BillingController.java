package manning.learning.billingservice;


import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class BillingController
{

    Logger log = Logger.getLogger(BillingController.class.getName());
    @Autowired
    private Tracer tracer;
    @RequestMapping("/payment")
    public String payment()
    {

     Span span = tracer.buildSpan("payment").start();
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
        span.finish();
    return "Payment Done";
    }

}
