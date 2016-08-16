import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class CToT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directory ="D:\\slm\\to convert\\comserv-parent\\";
		String projectName="comserv-parent\\\\";
Collection<File> fil =FileUtils.listFiles(new File(directory),TrueFileFilter.INSTANCE,TrueFileFilter.INSTANCE);
Iterator it = fil.iterator();
JSONArray ja = new JSONArray();

while(it.hasNext()){
	File file= (File)it.next();
	if(!file.isDirectory()){
	String secondHalf = file.getAbsolutePath().split(projectName)[1];
	if(secondHalf.endsWith(".java") || secondHalf.endsWith(".js")||secondHalf.endsWith(".properties")||secondHalf.endsWith(".xml")|| secondHalf.endsWith(".css")|| secondHalf.endsWith(".txt")|| secondHalf.endsWith(".html")
			|| secondHalf.endsWith(".js")|| secondHalf.endsWith(".js")|| secondHalf.endsWith(".js")|| secondHalf.endsWith(".js")|| secondHalf.endsWith(".js")|| secondHalf.endsWith(".js")){
		try {
			String string = FileUtils.readFileToString(file);
			byte[] encodedBytes = Base64.getEncoder().encode(string.getBytes());
			JSONObject jb = new JSONObject();
			jb.put("filepath", "snowball-parent\\"+secondHalf);
			//jb.put("filepath", file.getAbsoluteFile());
			jb.put("filecontent", new String(encodedBytes));
			//jb.put("dirname", "");
			ja.add(jb);
			//System.out.println(jb.toJSONString());
			//System.out.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//System.out.println(secondHalf);
		File file1 = new File("d:\\test.txt");
		try {
			FileUtils.writeStringToFile(file1, ja.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}else{
		
	}
}
	}

}
