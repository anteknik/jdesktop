package net.na.an;

import java.io.IOException;

import org.jpos.iso.ISOChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.ASCIIChannel;
import org.jpos.iso.packager.ISO87APackager;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;

public class JposClient {

	public static void main(String[] args) throws IOException, ISOException {
		Logger logger = new Logger();
		logger.addListener(new SimpleLogListener(System.out));
		ISOChannel channel =new ASCIIChannel("localhost", 8000, new ISO87APackager());
		((LogSource) channel).setLogger(logger,"server");
		channel.connect();
		
		ISOMsg msg = new ISOMsg();
		msg.setMTI("0800");
		msg.set (3,"100000");
		msg.set(41,"000001");
		msg.set(70,"301");
		channel.send(msg);
		//System.out.println(msg.toString());
		ISOMsg received = channel.receive();
		channel.disconnect();

	}

}
