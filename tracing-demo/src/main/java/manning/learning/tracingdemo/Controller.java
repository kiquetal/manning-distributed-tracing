package manning.learning.tracingdemo;


import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.module.Configuration;

@RestController
public class Controller
{

    @Autowired
    InventoryService inventoryService;
    @Autowired
    BillingService billingService;
    @Autowired
    DeliveryService deliveryService;
    @Autowired
    Tracer tracer;
    Logger log = LoggerFactory.getLogger(Controller.class);
    @RequestMapping("/checkout")
    public String checkout()
    {
       // log.info(System.getProperty("JAEGER_ENDPOINT"));
        Span checkoutSpan = tracer.buildSpan("checkout").start();
        log.info("Checkout");
        inventoryService.createOrder(checkoutSpan);
        billingService.payment(checkoutSpan);
        deliveryService.arrangeDelivery(checkoutSpan);
        checkoutSpan.finish();
        return "Checkout";
    }

}
