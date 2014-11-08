package ua.edu.lp.sadiploma.tool;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Proba {
	public static void main(String[] args) {
		Proba p = new Proba();
		p.start();
		// p.start2();
	}

	public PictureSize generatePicture(String parentCode) {
		String[] parentCodeArr = parentCode.split(",");
		int[] parentCodeArr2 = new int[parentCodeArr.length];
		int[] nodeNumbers = new int[parentCodeArr.length];
		for (int i=0; i<nodeNumbers.length; i++){
			nodeNumbers[i]=i+1;
		}
		for (int i=0; i<parentCodeArr.length; i++){
			parentCodeArr2[i]=Integer.parseInt(parentCodeArr[i])+1;
		}
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		for (int i=1; i<parentCodeArr.length; i++){
			gv.addln(parentCodeArr[i]+" -> "+nodeNumbers[i]);
			System.err.println("Line added: "+nodeNumbers[i]+" -> "+parentCodeArr[i]);
		}
		gv.addln(gv.end_graph());
		System.err.println(gv.getDotSource());
		String type = "gif";
		File out = new File("C:/Program Files/xampp/tomcat/wtpwebapps/Diploma/resources/out." + type); // Windows
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
		
		byte[] img = gv.getGraph(gv.getDotSource(), type);
		InputStream in = new ByteArrayInputStream(img);
		int height=0;
		int width=0;
		try {
			BufferedImage buf = ImageIO.read(in);
			height = buf.getHeight();
			width = buf.getWidth();
			System.err.println("IMG height: "+height);
			System.err.println("IMG width: "+width);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PictureSize pictureSize = new PictureSize();
		pictureSize.setHeight(height);
		pictureSize.setWidth(width);
		return pictureSize;
	}

	/**
	 * Construct a DOT graph in memory, convert it to image and store the image
	 * in the file system.
	 */
	private void start() {
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		gv.addln("1 -> 2;");
		gv.addln("2 -> 3;");
		gv.addln("3 -> 4;");
		gv.addln("4 -> 5;");
		gv.addln("5 -> 6;");
		gv.addln("6 -> 7;");
		gv.addln(gv.end_graph());
		System.out.println(gv.getDotSource());

		String type = "gif";
		// String type = "dot";
		// String type = "fig"; // open with xfig
		// String type = "pdf";
		// String type = "ps";
		// String type = "svg"; // open with inkscape
		// String type = "png";
		// String type = "plain";
		// File out = new File("/tmp/out." + type); // Linux
		File out = new File("D:/eclipse/projects/graphviz-java-api/out." + type); // Windows
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
	}

	/**
	 * Read the DOT source from a file, convert to image and store the image in
	 * the file system.
	 */
	private void start2() {
		String dir = "/home/jabba/eclipse2/laszlo.sajat/graphviz-java-api"; // Linux
		String input = dir + "/sample/simple.dot";
		// String input = "c:/eclipse.ws/graphviz-java-api/sample/simple.dot";
		// // Windows

		GraphViz gv = new GraphViz();
		gv.readSource(input);
		System.out.println(gv.getDotSource());

		String type = "gif";
		// String type = "dot";
		// String type = "fig"; // open with xfig
		// String type = "pdf";
		// String type = "ps";
		// String type = "svg"; // open with inkscape
		// String type = "png";
		// String type = "plain";
		File out = new File("/tmp/simple." + type); // Linux
		// File out = new File("c:/eclipse.ws/graphviz-java-api/tmp/simple." +
		// type); // Windows
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type), out);
	}
}
