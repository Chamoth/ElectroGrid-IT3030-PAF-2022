package com.electrogrid.generate_bills.resource;

import com.electrogrid.generate_bills.model.Bills;
import com.electrogrid.generate_bills.repository.BillsRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/bills")
public class BillsResource {

    BillsRepository repo = new BillsRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List <Bills> getBills() {
        System.out.println("Get Bills");
        return repo.getBills();
    }

    @GET
    @Path("bill/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bills getBill(@PathParam("id") int id) {

        return repo.getBill(id);

    }

    @POST
    @Path("bill")
    @Produces(MediaType.APPLICATION_JSON)
    public Bills createBills(Bills b1){

        System.out.println(b1);
        repo.createBill(b1);
        return b1;

    }

    @PUT
    @Path("bill")
    @Produces(MediaType.APPLICATION_JSON)
    public Bills updateBill(Bills b1){

        System.out.println(b1);
        if (repo.getBill(b1.getId()).getId()==0) {
            repo.createBill(b1);
        }
        else{
            repo.updateBill(b1);
        }
        return b1;
    }

    @DELETE
    @Path("bill/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bills deleteBill(@PathParam("id") int id){

        Bills b = repo.getBill(id);
        if (b.getId()!=0){
            repo.deleteBill(id);
        }
        return b;
    }

}
