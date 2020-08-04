<%@ include file="home.jsp" %>
<!-- /* alla stessa maniera si può scrivere: (TagLib)*/ -->
<jsp:include page="body.jsp"></jsp:include>

<!-- /* questa direttiva (@) dice quale pagina deve 
aprirsi in casi di errore */ -->
<%@ page errorPage="error.jsp" %>

<div><h1>Questa jsp fa l'include</h1>

<!-- /* creo l'errore */ -->
<!-- /* si apre la pagina di error ma 
non si vede nell'URI */ -->
<% 
String test = null;
test.equals("");

%>

<jsp:useBean id="articoloSelezionato" class="it.corso.java.web.beans.Articolo" scope="request"></jsp:useBean>

<p>
	<%  
	articoloSelezionato.getNome();
	%>
</p>


</div>