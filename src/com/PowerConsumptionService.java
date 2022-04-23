package com;


import model.PowerConsumption;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;

import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;
import org.json.JSONObject;

import com.google.gson.*;


import org.jsoup.nodes.Document;

@Path("/Power")
public class PowerConsumptionService {

		PowerConsumption pObj = new PowerConsumption();

		@GET
		@Path("/")
		@Produces(MediaType.TEXT_HTML)
		public String readPowerConsumptions() {
			return pObj.readPowerConsumption();
		}

		@POST
		@Path("/")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertPowerConsumption(
				
				@FormParam("usedUnits") int usedUnits, 
				@FormParam("unitCost") Float unitCost
				
				) {
			String output = pObj.insertPowerConsumption( usedUnits,unitCost);
			return output;
		}
		
		@PUT
		@Path("/")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updatePowerConsumption(String PowerConsumptionData) {
			// Convert the input string to a JSON object
			JsonObject docObject = new JsonParser().parse(PowerConsumptionData).getAsJsonObject();
			// Read the values from the JSON object
			String billId = docObject.get("billId").getAsString();
			int usedUnits = docObject.get("usedUnits").getAsInt();
			Float unitCost = docObject.get("unitCost").getAsFloat();

			String output = pObj.updatePowerConsumption(billId, usedUnits, unitCost);
			return output;
		}

		@DELETE
		@Path("/")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deletePowerConsumption(String PowerConsumptionData) {
			// Convert the input string to an XML document
			Document doc = Jsoup.parse(PowerConsumptionData, "", Parser.xmlParser());
			// Read the value from the element <userID>
			String PowerConsumptionID = doc.select("PowerConsumptionID").text();
			String output = nObj.deletePowerConsumption(PowerConsumptionID);
			return output;
		}
		
	}

