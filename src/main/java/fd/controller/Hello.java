package fd.controller;

import com.alibaba.fastjson.JSONObject;
import fd.entity.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/hello")
public class Hello{
    @Path("get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudent() {
        List<User> lists = new ArrayList<User>();
        lists.add(new User("xcc","123456798"));
        lists.add(new User("mahuateng","24"));
        lists.add(new User("zhouhongyi","25"));
        JSONObject json = new JSONObject();
        return Response.status(Response.Status.OK).entity(json.toJSONString(lists)).build();
    }
}
