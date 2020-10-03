package ui.controller;

import domain.db.DbException;
import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.util.ArrayList;

public class Add extends RequestHandler {

    // TODO: 3/10/2020 GAAT NAAR INDEX ALS UREN NIET INGEVULD ZIJN  
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        // Arraylist voor errors op te slagen 
        ArrayList<String> errors = new ArrayList<String>();

        // Maak nieuwe deelnemer 
        Person person = new Person();
        // Stuur door naar setters .. 
        setUserid(person, request, errors);
        setFirstName(person, request, errors);
        setLastName(person, request, errors);
        setEmail(person, request, errors);
        setPassword(person, request, errors);
        setArrival(person, request, errors);
        setLeave(person, request, errors);

        // INDIEN GEEN ERRORS STUUR DOOR NAAR OVERVIEW
        if (errors.size() == 0) {
            try {
                service.add(person);
                return "Servlet?command=PersonOverview";
            } catch (DbException e) {
                errors.add(e.getMessage());
            }
        }

        request.setAttribute("errors", errors);
        return "Servlet?command=Register";

    }


    // SET USER ID
    private void setUserid(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String userId = request.getParameter("userid");
        try {
            person.setUserid(userId);
            request.setAttribute("userIdPrevious", userId);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    // SET FIRST NAME
    private void setFirstName(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String firstName = request.getParameter("firstName");
        try {
            person.setFirstName(firstName);
            request.setAttribute("firstNamePrevious", firstName);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    // SET LAST NAME
    private void setLastName(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String lastName = request.getParameter("lastName");
        try {
            person.setLastName(lastName);
            request.setAttribute("lastNamePrevious", lastName);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    // SET EMAIL
    private void setEmail(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String email = request.getParameter("email");
        try {
            person.setEmail(email);
            request.setAttribute("emailPrevious", email);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    // SET PASSWORD
    private void setPassword(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String password = request.getParameter("password");
        try {
            person.setPassword(password);
            request.setAttribute("passwordPrevious", password);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    //SET ARRIVAL
    private void setArrival(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String arrivalString = request.getParameter("arrival");
        LocalTime arrival = stringToLocalTime(arrivalString);

        try {
            person.setArrival(arrival);
            request.setAttribute("arrivalPrevious", arrival);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    //SET LEAVE
    private void setLeave(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String leaveString = request.getParameter("leave");
        LocalTime leave = stringToLocalTime(leaveString);

        try {
            person.setLeave(leave);
            request.setAttribute("leavePrevious", leave);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }


    // STRING TO LOCALTIME VARIABLE
    public LocalTime stringToLocalTime(String s) {
        return LocalTime.of(Integer.parseInt(s.substring(0, 2)), Integer.parseInt(s.substring(3)));
    }


}
