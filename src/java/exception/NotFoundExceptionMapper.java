package exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Rihards
 */
// error mapper for handling non existing services api/dgtrgrvddfssdtrg
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    ServletContext context;

    @Override
    public Response toResponse(NotFoundException e) {

        boolean isDebug = context.getInitParameter("debug").toLowerCase().equals("true");
        ErrorMessage em = new ErrorMessage(e,404, isDebug);
        em.setMessage("The page/service you requested does not exist");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(gson.toJson(em))
                    .type(MediaType.APPLICATION_JSON).build();
    }

}
