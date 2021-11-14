package proyecto.iap;

import java.util.HashMap;
import java.util.Map;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONToMap extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage arg0, String arg1) throws TransformerException {
		try {
			String msg = arg0.getPayloadAsString();
			HashMap <String, Object> result = new ObjectMapper().readValue(msg, HashMap.class);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
