import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO; 
public class ReadImage {
		int [] rgbs;
		int width;
		int height;
		public ReadImage(){			
			
			File inputFile = new File("file path");
			BufferedImage bufferedImage;
			
			try {
				bufferedImage = ImageIO.read(inputFile);
				this.width = bufferedImage.getWidth();
				this.height = bufferedImage.getHeight(null);
				rgbs = new int[this.width*this.height];
				System.out.println("Load Pixel Values");
			 	bufferedImage.getRGB(0, 0, this.width, this.height, rgbs, 0, this.width); //Get all pixels
				System.out.println("Remove alpha value (ARGB -> RGB)");
			 	rgbs = new TransArray().remove_alpha(rgbs);
			 	new TransArray().InitArray(rgbs, this.width, this.height);
			 	
			 	
			} catch (IOException e) {
				System.out.println("Cannot Found Image\n");
			}
		}
		
		public void printArr(int arr[]){
			for(int i=0;i<this.width;i++)
			{
				for(int j=0;j<width;j++)
				{
					System.out.print(arr[i*this.width+ j]+" ");
				}
				System.out.println("");
			}
			System.out.println("");
			}
}
