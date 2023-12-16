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
    Tracer tracer;
    Logger log = LoggerFactory.getLogger(Controller.class);
    @RequestMapping("/checkout")
    public String checkout()
    {
        Span checkoutSpan = tracer.buildSpan("checkout").start();
        log.info("Checkout");
        checkoutSpan.finish();
        return "Checkout";
    }

}
