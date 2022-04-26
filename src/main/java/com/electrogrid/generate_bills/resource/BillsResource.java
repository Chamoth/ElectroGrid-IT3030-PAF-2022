package com.electrogrid.generate_bills.resource;

import com.electrogrid.generate_bills.model.Bills;
import com.electrogrid.generate_bills.repository.BillsRepository;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.regex.Pattern;

/***
 *
 * @author IT19976518
 * Ketipearachchi C. D.
 * it19976518@my.sliit.lk
 *
 */

@Path("/bills")
public class BillsResource {

    BillsRepository repo = new BillsRepository();


    /***
     *
     * This method is used to create bills
     *
     * @return
     */
    @POST
    @Path("bill")
    @Produces(MediaType.APPLICATION_JSON)
    public Object createBills(@Valid Bills b1){

//        System.out.println(b1);
        System.out.println("Creating the Bill");
        if(!Pattern.matches("^$|([0-9]{10})|(\\+[0-9]{11,20})$", b1.getMobileNo())) {
            throw new IllegalArgumentException("Mobile Number is not in valid format");
        }
        if(!Pattern.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", b1.getEmail())) {
            throw new IllegalArgumentException("Email is not in valid format");
        }
        else {

            String res = repo.createBill(b1);
            return Response.status(Response.Status.OK).entity(res).type(MediaType.APPLICATION_JSON).build();

        }

    }

    /***
     *
     * This method is used to get all bills
     *
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List <Bills> getBills() {
        System.out.println("Getting All Bills");
        return repo.getBills();
    }

    /***
     *
     * This method is used to search bills
     *
     */
    @GET
    @Path("bill/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bills getBill(@PathParam("id") int id) {
        System.out.println("Getting Specified Bill");
        return repo.getBill(id);

    }

    /***
     *
     * This method is used to update bills
     *
     * @return
     */
    @PUT
    @Path("bill")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBill(@Valid Bills b1){

//        System.out.println(b1);
        System.out.println("Updating Bill");
//        if (repo.getBill(b1.getId()).getId()==0) {
//            repo.createBill(b1);
//        }
        String res = "";
        if(repo.getBill(b1.getId()).getId()==0){
            res = repo.updateBill(b1);
        }

        if(!Pattern.matches("^$|([0-9]{10})|(\\+[0-9]{11,20})$", b1.getMobileNo())) {
            throw new IllegalArgumentException("Mobile Number is not in valid format");
        }
        if(!Pattern.matches("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", b1.getEmail())) {
            throw new IllegalArgumentException("Email is not in valid format");
        }
        else{
            res= repo.updateBill(b1);
        }

        return Response.status(Response.Status.OK).entity(res).type(MediaType.APPLICATION_JSON).build();

    }

    /***
     *
     * This method is used to delete bills
     *
     */
    @DELETE
    @Path("bill/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBill(@PathParam("id") int id){

        System.out.println("Deleting Specified Bill");
        Bills b = repo.getBill(id);
        String res ="";

        if (b.getId()!=0){
           res = repo.deleteBill(id);
        }

        return Response.status(Response.Status.OK).entity(res).type(MediaType.APPLICATION_JSON).build();

    }

}
