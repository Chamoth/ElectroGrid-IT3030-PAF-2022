package com.electrogrid.power_consumption.resource;

import com.electrogrid.power_consumption.model.PowerConsumption;
import com.electrogrid.power_consumption.repository.PowerConsumptionRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/powerCon")
public class PowerConsumptionResource {
    PowerConsumptionRepository repo = new PowerConsumptionRepository();

    // read data from data base - Read Operation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List <PowerConsumption> getPowerConsumptions() {
        System.out.println("Get Power Consumption Details");
        return repo.getPowerConsumptions();
    }

    // read data from data base - Search Operation
    @GET
    @Path("power_con/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PowerConsumption getPowerConsumption(@PathParam("id") int id) {

        return repo.getPowerConsumption(id);

    }

    // adding data to data base - Create Operation
    @POST
    @Path("power_con")
    @Produces(MediaType.APPLICATION_JSON)
    public PowerConsumption createPowerConsumption(PowerConsumption pc1){

        System.out.println(pc1);
        repo.createPowerConsumption(pc1);
        return pc1;

    }

    // update data details from data base - Update Operation
    @PUT
    @Path("power_con")
    @Produces(MediaType.APPLICATION_JSON)
    public PowerConsumption updatePowerConsumption(PowerConsumption pc1){

        System.out.println(pc1);
        if (repo.getPowerConsumption(pc1.getId()).getId()==0) {
            repo.createPowerConsumption(pc1);
        }
        else{
            repo.updatePowerConsumption(pc1);
        }
        return pc1;
    }

    //delete data entry from data base - Delete Operation
    @DELETE
    @Path("power_con/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PowerConsumption deletePowerConsumption(@PathParam("id") int id){

        PowerConsumption pc = repo.getPowerConsumption(id);
        if (pc.getId()!=0){
            repo.deletePowerConsumption(id);
        }
        return pc;
    }


}
