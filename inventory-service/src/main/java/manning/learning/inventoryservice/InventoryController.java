package manning.learning.inventoryservice;

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
public class InventoryController
{
    @Autowired
    private Tracer tracer;
    Logger logger = Logger.getLogger(InventoryController.class.getName());

    @RequestMapping("/createOrder")
    public String creteOrder(@RequestHeader HttpHeaders httpHeaders )
    {

        logger.info("[HttpHeaders]"+ httpHeaders.toString());
        SpanContext parent = tracer.extract(io.opentracing.propagation.Format.Builtin.HTTP_HEADERS, new HttpHeaderCarrier(httpHeaders));
        Span span = tracer.buildSpan("createOrder").asChildOf(parent).start();
        String user = span.getBaggageItem("user");
        logger.info("User: " + user);
        logger.info("httpHeaders: " + httpHeaders.toString());

        logger.info("Order Created");
        try
        {
            Thread.sleep(8000 + (int)(Math.random() * 2000));
        }
        catch (Exception e)
        {
            logger.info("Exception: " + e.getMessage());
        }
        logger.info(" Order Created by " + user);
        span.finish();
        return String.format("%s's order has been created\n", user);

    }
}
