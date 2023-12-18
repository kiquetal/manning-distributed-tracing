package manning.learning.inventoryservice;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class InventoryController
{
    @Autowired
    private Tracer tracer;
    @RequestMapping("/createOrder")
    public String creteOrder()
    {

        Span span = tracer.buildSpan("createOrder").start();
        Logger logger = Logger.getLogger(InventoryController.class.getName());
        logger.info("Order Created");
        try
        {
            Thread.sleep(8000 + (int)(Math.random() * 2000));
        }
        catch (Exception e)
        {
            logger.info("Exception: " + e.getMessage());
        }
        logger.info("Order Created");
        span.finish();
        return "Order Created";

    }
}
