package ua.edu.lp.sadiploma.tool;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Proba {

	private String TMP_PATH;

	public Proba(String realPath) {
		System.err.println("proba path "+realPath);
		this.TMP_PATH = realPath;
	}
	
//	public static void main(String[] args) {
//		Proba proba = new Proba("C:\\apache-tomcat-7.0.54\\wtpwebapps\\Diploma\\");
//		proba.getPicFromMarks("0,1,2,3,4", "11,22,33,44,55");
//	}
	
	public PictureSize getPicFromMarks(String parentCode, String marks){
		String[] parentCodeArray = parentCode.split("[\\D]+");
		int[] intParentCode = new int[parentCode.length()];

		String[] marksStrArr = marks.split("[\\D]+");
		int[] marksArr = new int[marksStrArr.length];

		for (int i = 0; i < parentCodeArray.length; i++) {
			intParentCode[i] = Integer.parseInt(parentCodeArray[i]);
			marksArr[i] = Integer.parseInt(marksStrArr[i]);
		}

		GraphViz gv = new GraphViz(TMP_PATH);
		gv.addln(gv.start_graph());
		for (int i = 1; i < marksArr.length; i++) {
			gv.addln(marksArr[intParentCode[i]-1] + " -- " + marksArr[i]);
			System.err.println("Line added: " + marksArr[intParentCode[i]-1] + " -- " + marksArr[i]);
		}
		//gv.addln(marksArr[marksArr.length-2] + " -- " + marksArr[marksArr.length-1]);
		gv.addln(gv.end_graph());
		System.err.println(gv.getDotSource());
		String type = "gif";
		System.err.println("abs path " + new File(TMP_PATH).getAbsolutePath());
		System.err.println(new File(TMP_PATH).getAbsolutePath());
		// C:\\apache-tomcat-7.0.54\\wtpwebapps\\Diploma\\
		File out = new File(TMP_PATH+"resources\\outmarks." + type); // Windows
		System.err.println("FILE:  "+out.getAbsoluteFile());
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
		System.err.println("gv.getDotSource(): "+gv.getDotSource());
		byte[] img = gv.getGraph(gv.getDotSource(), type);
        System.err.println("img length: "+img.length);
		InputStream in = new ByteArrayInputStream(img);
		int height = 0;
		int width = 0;
		try {
			BufferedImage buf = ImageIO.read(in);
			height = buf.getHeight();
			width = buf.getWidth();
			System.err.println("IMG height: " + height);
			System.err.println("IMG width: " + width);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PictureSize pictureSize = new PictureSize();
		pictureSize.setHeight(height);
		pictureSize.setWidth(width);
		return pictureSize;

	}

	public PictureSize generatePicture(String parentCode) {
		String[] parentCodeArr = parentCode.split("[\\D]+");
		int[] parentCodeArr2 = new int[parentCodeArr.length];
		int[] nodeNumbers = new int[parentCodeArr.length];
		for (int i = 0; i < nodeNumbers.length; i++) {
			nodeNumbers[i] = i + 1;
		}
		for (int i = 0; i < parentCodeArr.length; i++) {
			parentCodeArr2[i] = Integer.parseInt(parentCodeArr[i]) + 1;
		}
		GraphViz gv = new GraphViz(TMP_PATH);
		gv.addln(gv.start_graph());
		for (int i = 1; i < parentCodeArr.length; i++) {
			// gv.addln(parentCodeArr[i]+" -> "+nodeNumbers[i]);
			gv.addln(parentCodeArr[i] + " -- " + nodeNumbers[i]);
			System.err.println("Line added: " + nodeNumbers[i] + " -- "
					+ parentCodeArr[i]);
		}
		gv.addln(gv.end_graph());
		System.err.println(gv.getDotSource());
		String type = "gif";
		System.err.println("abs path " + new File(TMP_PATH).getAbsolutePath());
		System.err.println(new File(TMP_PATH).getAbsolutePath());
		// C:\\apache-tomcat-7.0.54\\wtpwebapps\\Diploma\\
		File out = new File(TMP_PATH+"resources\\out." + type); // Windows
		System.err.println("FILE:  "+out.getAbsoluteFile());
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
		System.err.println("gv.getDotSource(): "+gv.getDotSource());
		byte[] img = gv.getGraph(gv.getDotSource(), type);
        System.err.println("img length: "+img.length);
		InputStream in = new ByteArrayInputStream(img);
		int height = 0;
		int width = 0;
		try {
			BufferedImage buf = ImageIO.read(in);
			height = buf.getHeight();
			width = buf.getWidth();
			System.err.println("IMG height: " + height);
			System.err.println("IMG width: " + width);
		} catch (IOException e) {
			e.printStackTrace();
		}
		PictureSize pictureSize = new PictureSize();
		pictureSize.setHeight(height);
		pictureSize.setWidth(width);
		return pictureSize;
	}
}
