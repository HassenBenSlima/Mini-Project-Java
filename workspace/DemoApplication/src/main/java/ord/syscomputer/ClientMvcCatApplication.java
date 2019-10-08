package ord.syscomputer;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;


@SpringBootApplication
public class ClientMvcCatApplication {

    private static final Logger log = LoggerFactory.getLogger(ClientMvcCatApplication.class);
    //    @Value("${default-lang}")
//    private static String defaultLang;

    public static void main(String[] args) throws UnknownHostException {
    	SpringApplication app = new SpringApplication(ClientMvcCatApplication.class);
//        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();

        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
//        defaultLang= env.getProperty("default-lang");
        log.info("\n----------------------------------------------------------\n\t"
                + "Application's name '{}' is running! Access URLs:\n\t"
                + "Local: \t\t{}://localhost:{}/{}\n\t"
                + "External: \t{}://{}:{}/{}\n\t"
                + "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port"),
                env.getProperty("server.contextPath"),
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getProperty("server.contextPath"),
                env.getActiveProfiles());
     
	
    }
}
