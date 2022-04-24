package com.electrogrid.user_service.resource;

import com.electrogrid.user_service.model.Users;
import com.electrogrid.user_service.repository.UsersRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("/users")
public class UsersResource {
    UsersRepository repo = new UsersRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List <Users> getUsers() {
        System.out.println("Get Users");
        return repo.getUsers();
    }

    @GET
    @Path("users/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getUser(@PathParam("userID") int userId) {

        return repo.getUser(userId);

    }

    @POST
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    public Users createUsers(Users u1){

        System.out.println(u1);
        repo.createUsers(u1);
        return u1;

    }

    @PUT
    @Path("users")
    @Produces(MediaType.APPLICATION_JSON)
    public Users updateUser(Users u1){

        System.out.println(u1);
        if (repo.getUser(u1.getUserID()).getUserID()==0) {
            repo.createUsers(u1);
        }
        else{
            repo.updateUser(u1);
        }
        return u1;
    }

    @DELETE
    @Path("users/{userID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users deleteUser(@PathParam("userID") int userId){

        Users u = repo.getUser(userId);
        if (u.getUserID()!=0){
            repo.deleteUser(userId);
        }
        return u;
    }

}
