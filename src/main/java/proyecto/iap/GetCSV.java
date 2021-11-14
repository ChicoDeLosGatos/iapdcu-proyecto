package proyecto.iap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.mortbay.util.ajax.JSON;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.util.CaseInsensitiveHashMap;

import com.ibm.wsdl.util.StringUtils;

public class GetCSV extends AbstractMessageTransformer {

	@Override
	public Object transformMessage(MuleMessage arg0, String arg1) throws TransformerException {
		String msg = "";
		String result = "";
		
		try {
			String separador=";", linea, nombreActo="", dni, apellidos, nombre, eret, csv = "";
			float nota;
			System.out.println(arg0.getPayloadAsString());
			List<Map<String, Object>> list = (List<Map<String, Object>> ) arg0.getPayload();
			System.out.println("He recogido un objeto que tiene "+list.size()+" elementos");
			for (int i = 0; i < list.size(); i++) {
				System.out.println("Elemento numero "+(i+1)+ ": ");
				nombreActo = (String) list.get(i).get("NombreActoEvaluacion");
				System.out.println("NombreActo: "+nombreActo);
				dni = (String) list.get(i).get("Dni");
				System.out.println("Dni: "+dni);
				eret = (String) list.get(i).get("EntregaRetrasada");
				System.out.println("EntregaRetrasada: "+eret);
				nota = (float) list.get(i).get("Nota");
				System.out.println("Nota: "+nota);
				nombre = (String) list.get(i).get("Nombre");
				System.out.println("Nombre: "+nombre);
				apellidos = (String) list.get(i).get("Apellidos");
				System.out.println("Apellidos: "+apellidos);
				linea = dni+separador+nombre+separador+apellidos+separador+String.valueOf(nota)+separador+eret+"\n";
				csv += linea;
			}
			
			
			result = nombreActo+separador+"SCORE_GRADE_TYPE\n\"\"\n"+csv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

}
