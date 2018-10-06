/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cors;

/**
 *
 * @author mohammahomarhariri
 */

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class CORSRequestFilter implements ContainerRequestFilter
{
    @Override
    public void filter(ContainerRequestContext requestCtx) throws IOException
    {
        if (requestCtx.getRequest().getMethod().equals("OPTIONS"))
        {
            System.out.println("REQUEST WITH METHOD OPTIONS DETECTED...");
            
            requestCtx.abortWith(Response.status(Response.Status.ACCEPTED).build());
        }
    }
}