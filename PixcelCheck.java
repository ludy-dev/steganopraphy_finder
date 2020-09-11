import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
public class PixcelCheck {
	public static void main(String[] args) throws Exception {
 		File inputFile = new File("file path");
		BufferedImage bufferedImage = ImageIO.read(inputFile);
 		int w = bufferedImage.getWidth();
 		int h = bufferedImage.getHeight(null);
 		//Get Pixels
		 int [] rgbs = new int[w*h];
 		bufferedImage.getRGB(0, 0, w, h, rgbs, 0, w); //Get all pixels
 		int Alpha, Red, Green, Blue;
 		for(int i=0;i<w*h/2;i++){
 			Alpha = (rgbs[i] >> 24) & 255;
 			Red	  = (rgbs[i] >> 16) & 255;
 			Green = (rgbs[i] >> 8)  & 255;
 			Blue  = (rgbs[i] ) & 255;
 			if(Red > 100)
 				System.out.print("rgbs["+i+"]\t\t Alpha : " + Alpha + "\t\tRed : " +Red +"\tGreen : ");
 			else 
 				System.out.print("rgbs["+i+"]\t\t Alpha : " + Alpha + "\t\tRed : " +Red +"\t\tGreen : ");
 			
 			if(Green > 100)
 				System.out.print(Green +"\t\tBlue : " +Blue);
 			else
 				System.out.print(Green +"\t\tBlue : " + Blue);
 			
 			if(Blue > 100)
 				System.out.println("\t\trgbs = " + rgbs[i]);
 			else
 				System.out.println("\t\trgbs = " + rgbs[i]);
 			
 		}	 
		
 	}
}
