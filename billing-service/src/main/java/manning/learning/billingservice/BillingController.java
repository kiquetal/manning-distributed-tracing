package manning.learning.billingservice;


import io.opentracing.Span;
import io.opentracing.SpanContext;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
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
    public String payment(@RequestHeader HttpHeaders httpHeaders)
    {
      log.info("All headers: " + httpHeaders);
     SpanContext parentSpanContext = tracer.extract(io.opentracing.propagation.Format.Builtin.HTTP_HEADERS, new HttpHeaderCarrier(httpHeaders));
     Span span = tracer.buildSpan("payment").asChildOf(parentSpanContext).start();
     String user = span.getBaggageItem("user");
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
    return String.format("%s's has been paid\n", user);
    }

}
