package manning.learning.eshop;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EshopApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(EshopApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    @Bean
    public Tracer getJaegerTracer()
    {
        return Configuration.fromEnv("eshop").getTracer();
    }
}
