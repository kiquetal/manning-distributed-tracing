package manning.learning.tracingdemo;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class BillingService
{
    @Autowired
    Tracer tracer;
    Logger log = Logger.getLogger(BillingService.class.getName());
    public void payment(Span checkoutSpan)
    {
        Span paymentSpan = tracer.buildSpan("payment").asChildOf(checkoutSpan).start();
        log.info("Payment");
        try {
            Thread.sleep(1000 * Math.round(Math.random()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        paymentSpan.finish();
        log.info("Payment Done");
    }
}
