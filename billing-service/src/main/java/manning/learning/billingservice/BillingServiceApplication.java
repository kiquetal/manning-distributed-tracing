package manning.learning.billingservice;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BillingServiceApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    public Tracer getJaeger()
    {
        return Configuration.fromEnv("eshop").getTracer();
    }
}
