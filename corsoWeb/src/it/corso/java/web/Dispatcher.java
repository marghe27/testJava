package it.corso.java.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.corso.java.web.beans.Articolo;

/**
 * Servlet implementation class Dispatcher
 */
/* "/web" questo è il mio URL per la visualizzazione della Servlet */
@WebServlet("/web")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dispatcher() {
        super();
        // Auto-generated constructor
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
		request.getServletContext().getRequestDispatcher("/jsp/header.jsp").include(request, response);
		
		String pagina = request.getParameter("pagina");
		/* faccio un controllo sulla pagina */
		if(pagina != null && !pagina.trim().equals("")) {
			/* se voglio vedere la pagina uno, mostramela...*/
			/* la mia interrogazione è:
			 * http://localhost:8080/corsoWeb/web?pagina=1  oppure 
			 * http://localhost:8080/corsoWeb/web?pagina=2 ecc ecc 
			 * */
			if(pagina.equals("1")) {
				
				/* questa parte  è relativa alla Session, il getSession() 
				 * es. del carrello */
				List<String> carrello = (List<String>) request.getSession().getAttribute("carrello");
				if(carrello == null) {
					carrello = new ArrayList<String>();
					request.getSession().setAttribute("carrello",  carrello);
				}
				
				/* questa parte riguarda le azioni  - video 179 - 
				 * il file è il test-include.jsp */
				String articolo = request.getParameter("articolo");
				if(articolo != null && !articolo.trim().equals("")) {
					carrello.add(articolo);
					
				}
				
				
				
				
				request.getServletContext().getRequestDispatcher("/jsp/pagina1.jsp").include(request, response);
			} else if(pagina.equals("2")) {
				
				/* creo nuovo articolo */
				Articolo art = new Articolo();
				art.setCodice("123");
				art.setNome("Gioco da Tavolo");
				art.setPrezzo(36);
				
				/*adesso associo alla variabile "articolo" l'oggetto art */
				request.setAttribute("articolo", art);
				/* adesso nella pagina2.jsp inserisco l'azione <jsp:usebean....> */
				
				
				request.getServletContext().getRequestDispatcher("/jsp/pagina2.jsp").include(request, response);
			
			} else if(pagina.equals("3")) {
				request.getServletContext().getRequestDispatcher("/jsp/pagina3.jsp").include(request, response);
			} else {
				request.getServletContext().getRequestDispatcher("/jsp/body.jsp").include(request, response);
			}
			
		} else {
			request.getServletContext().getRequestDispatcher("/jsp/body.jsp").include(request, response);
		}
		
		
		request.getServletContext().getRequestDispatcher("/jsp/footer.jsp").include(request, response);
		
		/* se faccio la request col forward, allora scriverò: */
		//request.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);
		/* in questo caso vedrò la mia pagina senza l'interrogazione ?pagina=1 
		 * e a prescindere, infatti non cambia l'url assolutamente */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
