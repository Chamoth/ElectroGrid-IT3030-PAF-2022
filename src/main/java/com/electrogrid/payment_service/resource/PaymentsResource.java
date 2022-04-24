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

    @GET
    @Path("getPayment/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Payments getPayment(@PathParam("id") int id) {

        return repo.getPayment(id);

    }

    @POST
    @Path("addPayment")
    @Produces(MediaType.APPLICATION_JSON)
    public Payments createPayment(Payments py){

        System.out.println(py);
        repo.createPayment(py);
        return py;

    }


    @PUT
    @Path("updatePayment")
    @Produces(MediaType.APPLICATION_JSON)
    public Payments updatePayment(Payments py){

        System.out.println(py);
        if (repo.getPayment(py.getId()).getId()==0) {
            repo.createPayment(py);
        }
        else{
            repo.updatePayment(py);
        }
        return py;
    }


    @DELETE
    @Path("deletePayment/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Payments deletePayment(@PathParam("id") int id){

        Payments p = repo.getPayment(id);
        if (p.getId()!=0){
            repo.deletePayment(id);
        }
        return p;
    }


}
