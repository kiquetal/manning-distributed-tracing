package manning.learning.tracingdemo;


import io.opentracing.Scope;
import io.opentracing.ScopeManager;
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
@RequestMapping("/v2")
public class ControllerV2
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
        Span checkoutSpan = tracer.buildSpan("checkout").start();
        try (Scope scope = tracer.scopeManager().activate(checkoutSpan)) {
            log.info("Checkout");
            inventoryService.createOrderV2();
            billingService.paymentV2();
            deliveryService.arrangeDeliveryV2();
            return "Checkout";
        }
        finally {
            checkoutSpan.finish();
        }

    }



}
