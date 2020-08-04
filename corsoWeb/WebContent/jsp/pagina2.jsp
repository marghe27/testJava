<h1>Questo è la pagina 2</h1>

<!-- /* per visualizzare questa pagina adesso  che abbiamo inserito l'azione jsp:useBean,
dobbiamo utilizzare il Dispatcher e l'URL sarà il seguente:
 localhost:8080/corsoWeb/web?pagina=2 */ -->
<jsp:useBean id="articolo" class="it.corso.java.web.beans.Articolo" scope="request"></jsp:useBean>


<h2>Nome articolo nel carrello: <%=articolo.getNome() %></h2>

<h3>Codice: <%=articolo.getCodice() %></h3>
<h3>Prezzo: <%=articolo.getPrezzo() %></h3>
<p> Sono dentro al body della pagina 2 </p>

<!-- /* Il nome è la variabile associata all'ID;
	la property è la variabile che vogliamo configurare */ -->
<jsp:setProperty property="prezzo" name="articolo" value="600"/>
<h2>Nome articolo nel carrello: <%=articolo.getNome() %></h2>

<h3>Codice: <%=articolo.getCodice() %></h3>
<h3>Prezzo: <%=articolo.getPrezzo() %></h3>

<hr>
<!-- Adesso usiamo jsp:getProperty 
l'HTML risulta più pulito -->
<h2>Nome articolo nel carrello: 
<jsp:getProperty property="nome" name="articolo" /></h2>

<h3>Codice: <jsp:getProperty property="codice" name="articolo" /></h3>
<h3>Prezzo: <jsp:getProperty property="prezzo" name="articolo" /></h3>

</html>