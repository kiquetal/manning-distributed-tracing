package manning.learning.logisticservice;

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
public class Controller
{

    @Autowired
    private Tracer tracer;
    @RequestMapping("/transport")


    public String transport(@RequestHeader HttpHeaders httpHeaders)
    {
        Logger log = Logger.getLogger(Controller.class.getName());
        log.info("Transporting");


        SpanContext parentSpanContext = tracer.extract(io.opentracing.propagation.Format.Builtin.HTTP_HEADERS, new HttpHeaderCarrier(httpHeaders));
        log.info("parentSpanContext: " + parentSpanContext);
        Span span = tracer.buildSpan("transport").asChildOf(parentSpanContext).start();
        try
        {
            Thread.sleep(800 + (int)(Math.random() * 400));

        }
        catch (Exception e)
        {
            log.info("Exception: " + e.getMessage());
        }
        log.info("Transported");
        span.finish();
        return "Transported";
    }
}
