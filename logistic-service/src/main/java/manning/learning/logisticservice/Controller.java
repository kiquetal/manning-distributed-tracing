package manning.learning.logisticservice;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class Controller
{

    @Autowired
    private Tracer tracer;
    @RequestMapping("/transport")
    public String transport()
    {
        Logger log = Logger.getLogger(Controller.class.getName());
        log.info("Transporting");
        Span span = tracer.buildSpan("transport").start();
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
