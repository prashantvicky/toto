import java.io.File;
import java.util.Base64;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class TToC {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			File file = new File("D:\\test.txt");
			String projectLocation="D:\\slm\\converted\\";
			String str=FileUtils.readFileToString(file);
			JSONParser jsonParser=new JSONParser();
			JSONArray jaa=(JSONArray)jsonParser.parse(str);
			Iterator it = jaa.iterator();
			while(it.hasNext()){
			JSONObject j = (JSONObject)it.next();
			File fi=new File(projectLocation+j.get("filepath").toString());
			FileUtils.touch(fi);
			byte[] decodedBytes = Base64.getDecoder().decode(j.get("filecontent").toString().getBytes());
			FileUtils.writeByteArrayToFile(fi, decodedBytes );
			System.out.println(j.toJSONString());
			}
	}

}
