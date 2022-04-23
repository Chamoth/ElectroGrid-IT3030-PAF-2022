package com;


import model.PowerConsumption;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;

@Path("/Power")
public class PowerConsumptionService {

		PowerConsumption pObj = new PowerConsumption();

		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readPowerConsumptions() {
			return pObj.readPowerConsumptions();
		}

		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertPowerConsumption(
				
				@FormParam("usedUnits") String usedUnits, 
				@FormParam("unitCost") String unitCost
				
				) {
			String output = pObj.insertPowerConsumption( usedUnits,unitCost);
			return output;
		}
		
	}

