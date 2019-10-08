/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package ord.syscomputer.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import ord.syscomputer.dto.ProduitDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

*//**
 *
 * @author Farouk
 *//*
@RefreshScope
@Service("ParamServiceClient")
public class ParamServiceClient {

    private final Logger log = LoggerFactory.getLogger(ParamServiceClient.class);

    private final RestTemplate restTemplate;
    
    
    @Value("${paramService}")
    private String paramService;

    public ParamServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "serviceFindOneFallback")
    public ProduitDTO serviceFindOne(Long id) {
        log.info("Sending request");
        ResponseEntity<ProduitDTO> service = restTemplate.getForEntity("localhost"+"/api/services/"+ id, ProduitDTO.class);
        return service.getBody();
    }

    ProduitDTO serviceFindOneFallback(int id) {
        log.info("falling back");
        ProduitDTO serviceDTO = new ProduitDTO();
        serviceDTO.setIdDTO(0L);
        serviceDTO.setDesignation("error.notAvailable");
        return serviceDTO;
    }
}
*/