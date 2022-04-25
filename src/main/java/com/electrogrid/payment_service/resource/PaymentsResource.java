package com.electrogrid.payment_service.resource;

import com.electrogrid.payment_service.model.Payments;
import com.electrogrid.payment_service.repository.PaymentsRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/payments")
public class PaymentsResource {

  PaymentsRepository repo = new PaymentsRepository();

    //Read Operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List <Payments> getPayments() {
        System.out.println("Get Payments");
        return repo.getPayments();
    }

    //Search Operation
    @GET
    @Path("getPayment/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Payments getPayment(@PathParam("id") int id) {

        return repo.getPayment(id);

    }

    //Insert Operation
    @POST
    @Path("addPayment")
    @Produces(MediaType.APPLICATION_JSON)
//    public Payments createPayment(Payments py){
//
//        System.out.println(py);
//        repo.createPayment(py);
//        return py;
//
//    }
    public Response createPayment(Payments py){
        System.out.println(py);
        String res = repo.createPayment(py);
        return Response.status(Response.Status.OK).entity(res).type(MediaType.APPLICATION_JSON).build();
    }


    //Update Operation
    @PUT
    @Path("updatePayment")
    @Produces(MediaType.APPLICATION_JSON)
//    public Payments updatePayment(Payments py){
//
//        System.out.println(py);
//        if (repo.getPayment(py.getId()).getId()==0) {
//            repo.createPayment(py);
//        }
//        else{
//            repo.updatePayment(py);
//        }
//        return py;
//    }
    public Response updatePayment(Payments py){
        System.out.println(py);
        String res ="";
        if (repo.getPayment(py.getId()).getId()==0){
            res = repo.updatePayment(py);
        }
        else {
            res = repo.updatePayment(py);
        }
        return Response.status(Response.Status.OK).entity(res).type(MediaType.APPLICATION_JSON).build();
    }


    //Delete Operation
    @DELETE
    @Path("deletePayment/{id}")
    @Produces(MediaType.APPLICATION_JSON)
//    public Payments deletePayment(@PathParam("id") int id){
//
//        Payments p = repo.getPayment(id);
//        if (p.getId()!=0){
//            repo.deletePayment(id);
//        }
//        return p;
//    }

    public Response deletePayment(@PathParam("id") int id){

        Payments py = repo.getPayment(id);
        String res ="";

        if (py.getId()!=0){
            res = repo.deletePayment(id);
        }

        return Response.status(Response.Status.OK).entity(res).type(MediaType.APPLICATION_JSON).build();
    }


}
