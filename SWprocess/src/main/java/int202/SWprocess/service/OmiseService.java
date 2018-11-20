/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int202.SWprocess.service;

/**
 *
 * @author newso
 */

import java.io.IOException;

import co.omise.Client;
import co.omise.ClientException;
import co.omise.models.Charge;
import co.omise.models.OmiseException;


public class OmiseService {
    private Client client;

  public OmiseService(String omisePublicKey, String omisePrivateKey) throws ClientException {
    this.client = new Client(omisePublicKey, omisePrivateKey);
  }

  public void chargeCreditCard(String cardToken, double totalPrice) throws IOException, OmiseException {
    Charge charge = this.client.charges().create(
      new Charge.Create()
        .amount((long)(totalPrice * 100))
        .currency("thb")
        .card(cardToken)
    );
    System.out.printf("created charge: %s", charge.getId());
  }
}



  