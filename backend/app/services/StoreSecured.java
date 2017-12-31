package services;

import controllers.routes;
import play.Logger;
import play.api.mvc.*;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

public class StoreSecured extends Security.Authenticator {

    @Override
    public String getUsername(Http.Context ctx) {
        Logger.debug("Getting user getUsername() method");
        Logger.debug(ctx.session().get("user"));
        return ctx.session().get("user");
    }

    @Override
    public Result onUnauthorized(Http.Context ctx) {
        Logger.debug("User is unathorized to access to the protected ressource. We redirect him to login page");
        return redirect(controllers.routes.UserController.index());
    }

}