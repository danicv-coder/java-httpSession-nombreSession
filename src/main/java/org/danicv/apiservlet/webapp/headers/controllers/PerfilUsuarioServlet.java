package org.danicv.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/usuario-logueado"})
public class PerfilUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = "anónimo";
        if (req.getSession().getAttribute("nombre") != null) {
            nombre = (String) req.getSession().getAttribute("nombre");
        }
        try (PrintWriter out = resp.getWriter()) {

            out.println("<!Doctype html>");
            out.println("<html>");
            out.println("    <head>");
            out.println("        <meta charset=\"UTF-8\">");
            out.println("        <title>Usuario Logueado</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("        <h1>Perfil del usuario: " + nombre + "</h1>");
            out.println("         <ul>");
            out.println("           <li>Username: " + nombre + "</li>");
            out.println("         </ul>");
            out.println("<p><a href=\"" + req.getContextPath() + "/index.jsp\">volver a index</a></p>");
            out.println("    </body>");
            out.println("</html>");
        }
    }
}
