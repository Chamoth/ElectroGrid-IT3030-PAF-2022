package com.electrogrid.payment_service.resource;

import com.electrogrid.payment_service.model.Payments;
import com.electrogrid.payment_service.repository.PaymentsRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/payments")
public class PaymentsResource {

  PaymentsRepository repo = new PaymentsRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List <Payments> getPayments() {
        System.out.println("Get Payments");
        return repo.getPayments();
    }

    @POST
    @Path("payment")
    @Produces(MediaType.APPLICATION_JSON)
    public Payments createPayment(Payments py){

        System.out.println(py);
        repo.createPayment(py);
        return py;

    }


}
