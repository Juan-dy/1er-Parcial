package com.mycompany.primerparcial;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();   
        String op = request.getParameter("op");
        int id;
        int pos;
        Persona oE = new Persona();
      
        ArrayList<Persona> lista = (ArrayList<Persona>) ses.getAttribute("lP");
        
        switch (op){
            
            case "nuev":
                request.setAttribute("objetoE", oE);
                request.getRequestDispatcher("modificar.jsp").forward(request, response);
                break;
                
            case "mod":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPosicionObjeto(request, id);
                oE = lista.get(pos);
                
                request.setAttribute("objetoE", oE);
                request.getRequestDispatcher("modificar.jsp").forward(request, response);
                break;
                
            case "el":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPosicionObjeto(request, id);
                
                if(pos >= 0){
                    lista.remove(pos);
                }
                request.setAttribute("lP", lista);
                response.sendRedirect("index.jsp");
                break;
            default:
            
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Persona> lista = (ArrayList<Persona>) ses.getAttribute("lP");
        
        Persona oE = new Persona();
        
        oE.setId(id);
        oE.setNombre(request.getParameter("nombre"));
        oE.setP1(Integer.parseInt(request.getParameter("par1")));
        oE.setP2(Integer.parseInt(request.getParameter("par2")));
        oE.setEf(Integer.parseInt(request.getParameter("exaf")));
        
        if(id == 0){
            int idNuevo = obtenerIdObjeto(request);
            oE.setId(idNuevo);
            lista.add(oE);
        }else{
            int pos = buscarPosicionObjeto(request, id);
            lista.set(pos, oE);
        }
        
        request.setAttribute("lP", lista);
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
    
    public int obtenerIdObjeto(HttpServletRequest request){
        HttpSession ses = request.getSession();
        int idN = 0;
        ArrayList<Persona> lista = (ArrayList<Persona>) ses.getAttribute("lP");
        for(Persona e: lista){
            idN = e.getId();
        }
        return idN + 1;  
    }
    
    public int buscarPosicionObjeto(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        ArrayList<Persona> lista = (ArrayList<Persona>) ses.getAttribute("lP");
        int p = -1;
        
        if(lista != null){
            
            for(Persona e:lista){
                p++;
                if(e.getId() == id){
                    break;
                }
            }
        }
        return p;
        
    }
    
    
}