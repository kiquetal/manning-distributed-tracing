package manning.learning.tracingdemo;


import io.opentracing.ScopeManager;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Logger ;
@Service
public class DeliveryService
{
    @Autowired
    LogisticService logisticService;
    @Autowired
    Tracer tracer;
    Logger log = Logger.getLogger(DeliveryService.class.getName());
    public void arrangeDelivery(Span checkoutSpan)
    {
        log.info("Arranging Delivery");
        Span deliverySpan = tracer.buildSpan("delivery").asChildOf(checkoutSpan).start();

        try {
            logisticService.transport(deliverySpan);
            Thread.sleep(1000 * Math.round(Math.random()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("Delivery Arranged");
        deliverySpan.finish();
    }

    public void arrangeDeliveryV2()
    {
        Span deliverySpan = tracer.buildSpan("delivery").start();
        tracer.scopeManager().activate(deliverySpan);
        log.info("Arranging Delivery");
        try {
            Thread.sleep(1000 * Math.round(Math.random()));
            logisticService.transportV2();

        } catch (Exception e) {
            e.printStackTrace();
        }
        deliverySpan.finish();
    }
}
