import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.vietocr.ImageIOHelper;


public class ImageTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File imageFile = new File("eve1.jpg");
		Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
                try {//localImageReader.setInput(localImageInputStream);
                	ImageInputStream is = ImageIO.createImageInputStream(new File("check2332_gs.jpg"));
                	
                    Iterator<ImageReader> readers = ImageIO.getImageReaders(is);
                    System.out.println(readers);
                    BufferedImage img = null;
                    while (readers.hasNext())
                    {
                        ImageReader reader = readers.next();
                       // System.out.println(reader);
                        reader.setInput(is);
                        img = reader.read(0);
                        System.out.println(img);
                    }
        	String result = instance.doOCR(img);
        	
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }

	}

}
