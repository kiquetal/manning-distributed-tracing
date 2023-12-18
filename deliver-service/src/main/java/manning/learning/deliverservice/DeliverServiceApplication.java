package manning.learning.deliverservice;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DeliverServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(DeliverServiceApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    @Bean
    public Tracer getTracer()
    {
        // Check dockerfile we need to set environment -varaible
        return  Configuration.fromEnv("eshop").getTracer();
    }
}
