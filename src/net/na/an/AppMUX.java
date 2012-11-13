package net.na.an;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.MUX;

public class AppMUX implements MUX{

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ISOMsg request(ISOMsg arg0, long arg1) throws ISOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void request(ISOMsg m, long timeout, ISORequestListener r, Object handBack)
	throws ISOException {
	}

}
