package com.electrogrid.generate_bills.resource;

import com.electrogrid.generate_bills.model.Bills;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bills")
public class BillsResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Bills getBills() {
        System.out.println("Get Bill 00001");
        Bills b1 = new Bills();
        b1.setInvoiceNo("00001");
        b1.setAccountNo("Elec0001");
        b1.setUserName("Chamoth");
        b1.setBillAmount("Rs.1000");

        return b1;
    }
}
