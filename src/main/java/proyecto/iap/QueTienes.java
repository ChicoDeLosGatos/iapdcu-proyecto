package proyecto.iap;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class QueTienes extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage arg0, String arg1) throws TransformerException {
		try {
			String str = arg0.getPayloadAsString();
		//	str.replace("[", "").replace("]", "");
			System.out.println("AA");
			System.out.println(str);
			return str;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arg0;
	}

}
