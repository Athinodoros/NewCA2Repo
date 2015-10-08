package exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Rihards
 */
@Provider
public class AllExceptionMapper implements ExceptionMapper<Throwable> {

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    ServletContext context;

    @Override
    public Response toResponse(Throwable e) {
        boolean isDebug = context.getInitParameter("debug").equals("true");
        ErrorMessage err = new ErrorMessage(e, 500, isDebug);
        err.setMessage("Internal server Error, we are sorry, something went wrong");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(gson.toJson(err))
                .type(MediaType.APPLICATION_JSON).build();

    }

}
