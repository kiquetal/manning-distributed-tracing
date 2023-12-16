package manning.learning.tracingdemo;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public class LogisticService
{
    Logger log = Logger.getLogger(LogisticService.class.getName());

    @Autowired
    Tracer tracer;

    public void transport(Span deliverySpan)
    {
        Span  logisticSpan = tracer.buildSpan("logistic").asChildOf(deliverySpan).start();
        log.info("Transporting");
        try {
            Thread.sleep(1000 * Math.round(Math.random()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logisticSpan.finish();
        log.info("Transported");
    }

    public void transportV2()
    {
        Span  logisticSpan = tracer.buildSpan("logistic").start();
         log.info("Transporting");
        try {
            Thread.sleep(1000 * Math.round(Math.random()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        logisticSpan.finish();
        log.info("Transported");
    }
}
