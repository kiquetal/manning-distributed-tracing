package manning.learning.deliverservice;

import org.springframework.http.HttpHeaders;

import java.util.Iterator;
import java.util.Map;

public class HttpHeaderCarrier implements io.opentracing.propagation.TextMap
{
    private HttpHeaders httpHeaders;
    public HttpHeaderCarrier(HttpHeaders httpHeaders)
    {
        this.httpHeaders = httpHeaders;
    }
    @Override
    public Iterator<Map.Entry<String, String>> iterator()
    {
        return  this.httpHeaders.toSingleValueMap().entrySet().iterator();
    }

    @Override
    public void put(String s, String s1)
    {
        this.httpHeaders.set(s, s1);
    }
}
