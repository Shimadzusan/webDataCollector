package core;

import io.prometheus.client.Counter;
import io.prometheus.client.exporter.HTTPServer;

import java.io.IOException;

public class SimpleWDC {
    HTTPServer srv = new HTTPServer(3333);
    static final Counter requests = Counter.build()
            .name("metric_counter")
            .labelNames("metric_2","metric_3")
            .help("Total number of metric_2.")
            .register();

    public SimpleWDC() throws IOException {
    }

    public void methodX() {
        System.out.println("SimpleWDC++");
        requests.labels("metric_counter","232").inc();
    }
}
