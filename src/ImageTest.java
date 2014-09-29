import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
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
		File imageFile = new File("check2.jpg");
		ImageReader localImageReader = null;
	    ImageInputStream localImageInputStream = null;
        Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
        // Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping

        try {//localImageReader.setInput(localImageInputStream);
        	String str1 = imageFile.getName();
        	String str2 = str1.substring(str1.lastIndexOf('.') + 1);
        	Iterator localIterator = ImageIO.getImageReadersByFormatName(str2);
        	localImageReader = (ImageReader)localIterator.next();
            localImageInputStream = ImageIO.createImageInputStream(imageFile);
            localImageReader.setInput(localImageInputStream);
            System.out.println(localImageReader);
            int i = localImageReader.getNumImages(true);
            System.out.println(i);
            for (int j = 0; j < i; j++)
            {
            	System.out.println(localImageReader.getDefaultReadParam());
              IIOImage localIIOImage = localImageReader.readAll(j, localImageReader.getDefaultReadParam());
              System.out.println(localIIOImage);
            }
        	String result = instance.doOCR(imageFile);
        	
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }

	}

}
