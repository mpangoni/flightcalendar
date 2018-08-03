package br.pangoni.flightme.infrastructure.content;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class SabreContentProvider implements ContentProvider{
	
	private static final Logger logger = LoggerFactory.getLogger(SabreContentProvider.class);
	
	private static String TOKEN = "T1RLAQJSDxsvonxRyzOtQ1RKUCj+9LFpVBCQT1NBgezFkRXke4Tb77+oAADA8vQKAtG9z1R4uMFuEX4132rGwBMTNTYB2XoNNsD8BGKUl5JdgTIIoKuZVXal+E2dF0UidldG4C0tm+4+jW0TSnX2NMf21y01Mi2bkXCFl6e4/JuRQVwYemnO8sqWdJpPzhyhRWyHystFvzoAeC9C0HwMa59jpjU4QZIE2RF0BOZYLlsRpgTblwIwgY2dIH8GpThbCzOHdakfEXioqTMZzVPFVI2Gn07pB7PXCztTQCeX+5Fh4IePc1cF7Pl8SvI4";
	private static String REST_ENDPOINT = "https://api-crt.cert.havail.sabre.com";
    
    public String invoke(String method, String path, String parameters) {

        URL url = buildURLWithQueryString(path, parameters);
        HttpURLConnection connection = createConnection(method, url);

        try {
            connection.connect();

            if(connection.getResponseCode() ==  HttpURLConnection.HTTP_OK) {

               return readContent(connection.getInputStream());
               
            }else{

            	String message = String.format("Invalid SABRE response code [%d] with parameter [%s, %s, %s ]", 
            			connection.getResponseCode(), method, path, parameters);
            	
       			logger.error(message);

       			throw new RuntimeException(message);
            }

        }catch(IOException e) {
        	String message = String.format("Unknow Problems invoking SABRE with parameters [%s, %s, %s ]", 
        			method, path, parameters);
        	
   			logger.error(message, e);

        	throw new RuntimeException(message, e);
            
        }finally {
			if(connection != null) {
				connection.disconnect();
			}
		}
    }

    private URL buildURLWithQueryString(String path, String parameters) {
    	try {
            return new URL(String.format("%s/%s?%s", REST_ENDPOINT, path, parameters));    		
    	}catch(MalformedURLException e){
    		throw new RuntimeException(e);
    	}
    }

    private HttpURLConnection createConnection(String method, URL url) {

        try {
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod(method);
            connection.setRequestProperty("Accept","application/json, text/javascript, */*; q=0.01");
            connection.setRequestProperty("Authorization",String.format("Bearer %s", TOKEN));
            connection.setDoOutput(true);

            return connection;
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private String readContent(InputStream stream) {
    	
    	Scanner scanner = new Scanner(stream, "UTF-8").useDelimiter("\\A");
    	
    	String result = scanner.hasNext() ? scanner.next() : "";
    	
    	scanner.close();
    	
    	return result;
    }
}
