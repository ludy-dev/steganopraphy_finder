
public class TransArray {
	private int [] arr;
	private int width,height;
	
	public void InitArray(int [] Array, int width,int height){
		this.arr= new int[width*height];
		this.arr = Array;
		this.width = width;
		this.height = height;
		System.out.println("Transform Array (1-Dimension Array to 2-Dimension Array");
		transArray();
	}
	
	public void transArray(){
		float[][] tmp =new float[8][8];
		double [][] temp = new double[8][8];
		int MaxWidth  = (int)(this.width /8);
		int MaxHeight = (int)(this.height /8); 

		for(int i =0 ; i< MaxHeight;i++)
		{
			for(int j =0 ; j< MaxWidth; j++)
			{
				for(int q = 0 ; q<8; q++) 
				{
					for(int r=0; r<8; r++)  
					{
						tmp[q][r] = this.arr[(i*8*this.width)+(8*j)+r+(q*this.width)];
					}
				}
				printArr(tmp);
				temp = new DCT(99).forwardDCT(tmp);
				printArr(temp);
				
				new chisqaure(temp);
				//processing with Array
				
			}//end for
		}
		
	}//end of class

	public void printArr(float arr[][]){
	for(int i=0;i<8;i++)
	{
		for(int j=0;j<8;j++)
		{
			System.out.print(arr[i][j]+" ");
		}
		System.out.println("");
	}
	System.out.println("");
	}	
	
	public void printArr(double arr[][]){
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
	}	
	
	public void printArr(int arr[]){
		for(int i=0;i<height;i++)
		{
			for(int j=0;j<width;j++)
			{
				System.out.print(arr[i*this.width+ j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		}
	
	public int [] remove_alpha(int arr[]){
		for(int i=0; i<arr.length;i++)
			arr[i] = arr[i] & 16777215;
		return arr;
	}
}
		
	