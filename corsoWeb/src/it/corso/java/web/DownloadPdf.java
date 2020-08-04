package it.corso.java.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;






/**
 * Servlet implementation class DownloadPdf
 */
@WebServlet("/downloadpdf")
public class DownloadPdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadPdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* creiamo un pdf al volo che invieremo al client. 
		 * in questo caso dobbiamo prendere l'OutputStream, 
		 * che prendiamo dalla response*/
		PdfWriter pdf = new PdfWriter(response.getOutputStream());
		
		/*Adesso dobbiamo inizializzare un oggetto di tipo PDF */
		PdfDocument doc = new PdfDocument(pdf);
		
		/*Adesso creiamo un oggetto di tipo Document
		 * che serve per inserire tutti gli elementi nel PDF */
		Document document = new Document(doc);
		document.add(new Paragraph("Sono un file PDF!"));
		document.add(new Paragraph("Sono un file PDF!"));
		document.add(new Paragraph("Sono un file PDF!"));
		document.add(new Paragraph("Sono un file PDF!"));
		document.close();
		
		/* Per aprire il file PDF dalla nostra pagina HTML generata,
		 * dobbiamo impostare il Content Type, con il SET */
		response.setContentType("application/pdf");
		/* Nella header diciamo che il file deve essere scaricabile */
		response.setHeader("Content-disposition", "attachment; filename=corsoWeb.pdf"); 
		
		
		
		
		//chiamata GET dal form di una jsp
		/*
		 * String nome = request.getParameter("nome"); String cognome =
		 * request.getParameter("cognome");
		 * 
		 * PrintWriter out = response.getWriter(); out.println("<!Doctype html>");
		 * out.println("<html>");
		 * out.println("<head><title>La mia Servlet</title></head>");
		 * out.println("<body>"); out.println("<h1>Ciao" +nome +" "+cognome+"</h1>");
		 * out.println("</body>");
		 * 
		 * out.println("</html>");
		 */
		
		
		/* request.getAttribute("Log"); richiama il Filter*/
		//request.getAttribute("Log");
		
		
		
		
		// aggiunge un cookie alla response 
		// da errore perchè non  viene fatto un import corretto 
		//response.addCookie(new Cookie("Corso Web 2 ", "Inserito cookie!"));
		
		
		/*Richiama tutte le informazioni che si trovano nella Header*/
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.getWriter().append(" Method: "+request.getMethod());
		//response.getWriter().append(" Context: "+request.getContextPath());
		//response.getWriter().append(" User - Agent: "+request.getHeader("user-agent"));
		
		/*
		 * Enumeration<String> en = request.getHeaderNames();
		 * 
		 * while(en.hasMoreElements()) { String elem = en.nextElement();
		 * response.getWriter().append(" - "+elem+" : "+ request.getHeader(elem)); }
		 */
		
		/* http://localhost:8080/corsoWeb/downloadpdf?pippo=4&prova=2  
		 * Query String : pippo=4&prova=2 
		 * */
		//response.getWriter().append(" Query String: "+request.getQueryString());
		//response.getWriter().append(" Get Parameter: "+request.getParameter("pippo"));
		
		/* se io ho più valori dello stesso parametro "pippo": 
		 * es: http://localhost:8080/corsoWeb/downloadpdf?pippo=4&prova=2&pippo=3&pippo=8*/
		/*
		 * String[] params = request.getParameterValues("pippo"); for(String s: params)
		 * { response.getWriter().append(" pippo = " + s +" - "); }
		 */
			/* Se voglio avvertire che esiste un errore*/
			//response.sendError(404, "Pagina non trovata!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/* Aggiunta come es. dal Tutor */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	

}
