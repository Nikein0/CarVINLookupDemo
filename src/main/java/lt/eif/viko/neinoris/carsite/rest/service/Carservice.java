package lt.eif.viko.neinoris.carsite.rest.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.FileReader;

/*
OkHttpClient client = new OkHttpClient();

Request request = new Request.Builder()
	.url("https://car-api2.p.rapidapi.com/api/vin/KNDJ23AU4N7154467")
	.get()
	.addHeader("X-RapidAPI-Key", "68b1084373msh469c95ae87aa181p10b8cejsnec600e69b732")
	.addHeader("X-RapidAPI-Host", "car-api2.p.rapidapi.com")
	.build();

Response response = client.newCall(request).execute();
* */
@Service
@Slf4j
public class Carservice {

    //private static final String url = "https://car-api2.p.rapidapi.com/api/vin/KNDJ23AU4N7154467";
    private static final String rapidKey = "68b1084373msh469c95ae87aa181p10b8cejsnec600e69b732";
    private static final String rapidHost = "car-api2.p.rapidapi.com";
    private String VIN;

    @Autowired
    private RestTemplate restTemplate;
    public Object getCarData(){
        try{
            try(BufferedReader br = new BufferedReader(new FileReader("VINinput.txt"))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                VIN = sb.toString();
            }
            String url = "https://car-api2.p.rapidapi.com/api/vin/" + VIN;
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", rapidKey);
            headers.set("X-RapidAPI-Host", rapidHost);

            //Endpoint call

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            log.info("{}", response.getBody());

            return response.getBody();
        }catch(Exception e){
            log.error("Error from RapidAPI", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling endpoint", e);
        }
    }
    public Object getCarDataSimple(){
        try{
            String url = "https://car-api2.p.rapidapi.com/api/engines?verbose=yes&year=2020&direction=asc&sort=id&make=toyota&model=camry";
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", rapidKey);
            headers.set("X-RapidAPI-Host", rapidHost);

            //Endpoint call

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            log.info("{}", response.getBody());

            return response.getBody();
        }catch(Exception e){
            log.error("Error from RapidAPI", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling endpoint", e);
        }
    }
    public Object getConsumption(){
        try{
            String url = "https://car-api2.p.rapidapi.com/api/mileages?verbose=yes&year=2020&direction=asc&sort=id&make=toyota&model=camry";
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", rapidKey);
            headers.set("X-RapidAPI-Host", rapidHost);

            //Endpoint call

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

            log.info("{}", response.getBody());

            return response.getBody();
        }catch(Exception e){
            log.error("Error from RapidAPI", e);
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Exception while calling endpoint", e);
        }
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
}
