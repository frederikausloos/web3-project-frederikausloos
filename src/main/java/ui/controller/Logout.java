package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // VERWIJDERD SESSIE
        request.getSession().invalidate();
        return "/Servlet?command=Index";
    }
}
