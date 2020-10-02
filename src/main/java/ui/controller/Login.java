package ui.controller;

import domain.db.DbException;
import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        //ZOEKEN NAAR PERSOON MET GEGEVEN USERID
        String userId = request.getParameter("userId");
        Person person = getService().get(userId);

        //INDIEN PERSON LEEG IS
        if (person == null){
            request.setAttribute("errorLogin", "User not found.");
        }
        //INDIEN PERSOON GEVONDEN EN JUIST PASWOORD LOGIN GESLAAGD
        else if (person.isCorrectPassword(request.getParameter("password"))) {
            HttpSession session = request.getSession();
            session.setAttribute("person", person);

            // INDIEN PASWOORD FOUT GOOI ERROR OP
        } else {
            request.setAttribute("errorLogin", "Password is not corect");
            request.setAttribute("userIdPrevious", userId);
        }

        return "/Servlet?command=Index";
    }
}
