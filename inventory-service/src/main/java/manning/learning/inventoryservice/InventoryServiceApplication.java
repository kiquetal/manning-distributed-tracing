package manning.learning.inventoryservice;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public Tracer getJaegerTracer()
    {
        return  Configuration.fromEnv("eshop").getTracer();

    }
}
