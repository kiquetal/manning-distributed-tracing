package manning.learning.tracingdemo;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class InventoryService
{
    @Autowired
    Tracer tracer;
    Logger log = Logger.getLogger(InventoryService.class.getName());
    public void createOrder(Span checkoutSpan)
    {
        log.info("Creating Order");
        Span inventorySpan = tracer.buildSpan("inventory").asChildOf(checkoutSpan).start();
        try {
            Thread.sleep(1000 * Math.round(Math.random()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        inventorySpan.finish();
        log.info("Order Created");

    }
}
