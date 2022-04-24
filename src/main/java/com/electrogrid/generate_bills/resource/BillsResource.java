package com.electrogrid.generate_bills.resource;

import com.electrogrid.generate_bills.model.Bills;
import com.electrogrid.generate_bills.repository.BillsRepository;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

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
    @Valid
    @Path("bill")
    @Produces(MediaType.APPLICATION_JSON)
    public Bills createBills(Bills b1){

//        System.out.println(b1);
        if(createBills(b1)!= null){
            repo.createBill(b1);
        }
        return b1;

    }

    @PUT
    @Path("bill")
    @Produces(MediaType.APPLICATION_JSON)
    public Bills updateBill(@Valid Bills b1){

//        System.out.println(b1);
        if (repo.getBill(b1.getId()).getId()==0) {
            repo.createBill(b1);
        }
        if(!Pattern.matches("^$|([0-9]{10})|(\\+[0-9]{11,20})$", b1.getMobileNo())) {
            throw new IllegalArgumentException("Mobile Number is not in valid format");
        }

        if(!Pattern.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", b1.getEmail())) {
            throw new IllegalArgumentException("Email is not in valid format");
        }

        else{
            repo.updateBill(b1);
            return b1;
        }

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
