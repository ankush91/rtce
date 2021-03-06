/**
 * @cs544
 * @author GROUP 4 Anthony Emma, Ankush Israney, Edwin Dauber, Francis Obiagwu
 * @version 1
 * @date 6/3/2016
 * This file is responsible for providing output of the document and other misc UI output
 *    output.  
 *    UI this whole file is for UI
 */

package rtce.client;

import java.io.IOException;
import rtce.RTCEDocument;

public class RTCEClientUIOutput implements Runnable
{
	//The document
	private RTCEDocument document;

	//Objects to handle requests to refresh the GUI
	private Object lock = new Object();
	private boolean refreshUI = false;

	/**
	 * Create ui output
	 * @throws IOException
	 */
	RTCEClientUIOutput() throws IOException
	{}

	/**
	 * Set the document
	 * @param doc
	 */
	public void setDocument(RTCEDocument doc)
	{  this.document = doc;   }

	//UI
	/**
	 * Run the output thread
	 */
	public void run()
	{

		redrawUI();

		while(true)
		{    		
			synchronized (lock) {
				if (refreshUI)
				{ redrawUI();
				refreshUI = false;}    			  
			}    		  
			try{Thread.sleep(500);} catch (Exception e){}
		}
	} //run

	/**
	 * Redraw the ui
	 * UI
	 */
	private void redrawUI()
	{
		synchronized (lock) {
			System.out.println("--------------------------------------------");
			document.printDocument();
			System.out.println("");
			System.out.println("Enter Command>>");
		}		   
	}

	//After creation this is the only routine expected to be called.
	/**
	 * Identify that the ui needs to be refreshed
	 */
	public void refreshUI()
	{
		synchronized (lock) {
			refreshUI = true;
		}	   
	}

} //RTCEClientUIOutput