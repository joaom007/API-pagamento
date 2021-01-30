package com.ifsp.apipagamento.config;

import java.time.Instant;
import java.util.Arrays;

import com.ifsp.apipagamento.model.Card;
import com.ifsp.apipagamento.model.Customer;
import com.ifsp.apipagamento.model.Phone;
import com.ifsp.apipagamento.model.Purchase;
import com.ifsp.apipagamento.repository.CardRepository;
import com.ifsp.apipagamento.repository.CustomerRepository;
import com.ifsp.apipagamento.repository.PhoneRepository;
import com.ifsp.apipagamento.repository.PurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
 
    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public void run(String... args) throws Exception {

        Customer ct1 = new Customer(null, "José Benfica", "999.888.777-66", "99.888.777-6", "testando@hotmail.com", "password", "ashduasjdas", "25/03/1997");

        Customer ct2 = new Customer(null, "Luciana da Silva", "111.222.333-44", "11.222.333-4", "teste@teste.com", "457895", "aksdhnsajdh", "13/02/1985");

        customerRepository.saveAll(Arrays.asList(ct1, ct2));

        Phone ph1 = new Phone(null, "11999998888", ct1);
        Phone ph2 = new Phone(null, "55999998888", ct1);
        Phone ph3 = new Phone(null, "38999998888", ct2);

        phoneRepository.saveAll(Arrays.asList(ph1, ph2, ph3));

        Card cd1 = new Card(null, "1245894589784589", "Luciana da Silva", "01/2027", "458", ct2);
        Card cd2 = new Card(null, "1111222233334444", "José Benfica", "01/2025", "111", ct1);
        Card cd3 = new Card(null, "9999888877776666", "José Benfica", "05/2018", "999", ct1);

        cardRepository.saveAll(Arrays.asList(cd1, cd2, cd3));

        Purchase pu1 = new Purchase(null, "Amazon", Instant.parse("2021-01-20T19:53:07Z"), 1547.89, 12, "pago", cd1);
        Purchase pu2 = new Purchase(null, "Magazine Luiza", Instant.parse("2019-01-20T19:53:07Z"), 645.89, 5, "cancelado", cd2);
        Purchase pu3 = new Purchase(null, "Detran", Instant.parse("2020-12-20T19:53:07Z"), 863.20, 3, "estornado", cd1);

        purchaseRepository.saveAll(Arrays.asList(pu1, pu2, pu3));
             
    }
}
