/**
 * @cs544
 * @author GROUP 4 Anthony Emma, Edwin Dauber, Ankush Israney, Francis Obiagwu
 * @version 1
 * @6/3/2016
 * The Discovery Server Thread is a seperate thread which is created only once by the RTCE Server
 * to facilitate IP Address discovery of the server by clients.   This thread will listen for 
 * messaging over the established DISCOVERY_PORT and respond back
 * with the "secret handshake" of "HI" to clients  
 */

package rtce.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/** The Discovery Server Thread is a seperate thread which is created only once by the RTCE Server
 * to facilitate IP Address discovery of the server by clients.   This thread will listen for 
 * Multicast messaging over the established discovery port 4446 and respond back
 * with the "secret handshake" of "HI" to clients 
 */
public class RTCEDiscoveryServer implements Runnable
{

	/**
	 * Create discover server thread
	 * @throws IOException
	 */
	RTCEDiscoveryServer() throws IOException
	{	   }

	/**
	 * Run discovery server thread
	 */
	public void run()
	{

		try{
			//Create the socket and join the Multicast Group for Discovery
			DatagramSocket socket = new DatagramSocket(4446);
			socket.setReuseAddress(true);

			//Configure the incoming message
			byte[] incomingBuf = new byte[40];
			DatagramPacket incomingPacket;
			incomingPacket = new DatagramPacket(
					incomingBuf,
					incomingBuf.length);

			System.out.println("Discovery Thread Starting");           
			while (true)
			{  socket.receive(incomingPacket);

			if (incomingPacket.getLength() == 4)
			{
				//Create the Response Datagram - "HI"
				DatagramPacket responsePacket;
				byte[] responseBuf = new byte[2];
				responseBuf[0] = 'H';
				responseBuf[1] = 'I';
				responsePacket = new DatagramPacket(
						responseBuf,
						responseBuf.length,
						incomingPacket.getAddress(),
						4447);


				socket.send(responsePacket);
			}
			}

		} //try block
		catch (IOException e) {
			e.printStackTrace(); }


	} //run()

} //class RTCEDiscoveryServer

