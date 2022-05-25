package com.example.retailer.fournisseur;

import au.com.dius.pact.provider.junit.Consumer;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import com.example.retailer.core.Music;
import com.example.retailer.core.FournisseurService;
import com.example.retailer.FournisseurApplication;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRestPactRunner.class)
@SpringBootTest(classes = FournisseurApplication.class, webEnvironment = RANDOM_PORT, properties = "server.port=80")
@Provider("fournisseur")
@Consumer("client")
@PactBroker(host = "localhost", port = "9292")
@ActiveProfiles("test")
public class MusicPactTests {

    @TestTarget
    public Target target = new SpringBootHttpTarget();

    @State("Get music details")
    public void testBuyerOneContract(){
        FournisseurService mock = Mockito.mock(FournisseurService.class);
    }
}
