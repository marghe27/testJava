package it.corso.java.web.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AttributeRequestListener
 *
 */

@WebListener
public class AttributeRequestListener implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public AttributeRequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
         System.out.println("Oggetto rimosso dalla Request");
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 
    	//srae.getName(); // non funziona perchè ho usato un file diverso dal tutorial
    	//vedi video 174 e precedenti. 
    	System.out.println("Oggetto aggiunto alla Request");
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	System.out.println("Oggetto sostituito nella Request");
    }
	
}
