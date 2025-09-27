package cdp;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v139.network.Network;
import org.openqa.selenium.devtools.v139.network.model.Request;
import org.openqa.selenium.devtools.v139.network.model.Response;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetRequestAndResponse {

    public static void main(String[] args) {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        // Create DevTools session
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Enable Network with Optionals (NO nulls!)
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), java.util.Optional.empty()));

        // Listen to requests
        devTools.addListener(Network.requestWillBeSent(), request -> {
            Request req = request.getRequest();
            System.out.println("Request URL: " + req.getUrl());
        });

        // Listen to responses
        devTools.addListener(Network.responseReceived(), response -> {
            Response resp = response.getResponse();
            int status = resp.getStatus();
            System.out.println("Response: " + resp.getUrl() + " | Status: " + status);
            if (Integer.toString(status).startsWith("4")) {
                System.out.println("⚠️ Response is failing (4xx error).");
            }
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
    }
}
