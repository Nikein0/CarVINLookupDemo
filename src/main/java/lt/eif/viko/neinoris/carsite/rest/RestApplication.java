package lt.eif.viko.neinoris.carsite.rest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.xdevapi.JsonString;
import lt.eif.viko.neinoris.carsite.rest.config.RequestLoad;
import lt.eif.viko.neinoris.carsite.rest.config.RestTemplConfig;
import lt.eif.viko.neinoris.carsite.rest.control.APIcontrol;
import lt.eif.viko.neinoris.carsite.rest.service.Carservice;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args){
		SpringApplication.run(RestApplication.class, args);
	}


}
