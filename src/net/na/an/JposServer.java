package net.na.an;

import java.io.IOException;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOServer;
import org.jpos.iso.ISOSource;
import org.jpos.iso.ServerChannel;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.channel.XMLChannel;
import org.jpos.iso.packager.ISO87APackager;
import org.jpos.iso.packager.XMLPackager;
import org.jpos.q2.Q2;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;

public class JposServer implements ISORequestListener {
	public JposServer() {
		super();
	}

	public boolean process (ISOSource source, ISOMsg m) {
		
	try

	{
		m.setResponseMTI();
		m.set(39, "00");
		source.send(m);
	}catch(
	ISOException e)
	{
		e.printStackTrace();
	}catch(
	IOException e)
	{
		e.printStackTrace();
	}
	return true;
	}
	public static void main(String[] args) {
		// Q2 q2 = new Q2(args);
		// q2.start();

		Logger logger = new Logger();
		logger.addListener(new SimpleLogListener(System.out));
		ServerChannel channel = null;
		try {
			channel = new ASCIIChannel(new ISO87APackager());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((LogSource) channel).setLogger(logger, "server");
		ISOServer server = new ISOServer(8000, channel, null);
		server.setLogger(logger, "server");
		server.addISORequestListener(new JposServer());
		new Thread(server).start();
	}

}
