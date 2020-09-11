import java.lang.Math;
public class chisqaure {
	private double arr[][] = new double [8][8];
	private double ChiValue=0;
	private double []ExpectedValue= new double [(8*8)/2];
	
	
	public chisqaure(double [][] arr){
		this.arr = arr;
		System.out.println("Start ChiSquare");
		getExpectedValue();
		getChiValue();
		if(ChiTest(this.ChiValue,63))
			System.out.println("\t We Found Hiden Message");
		else 
			System.out.println("\t We couldn't Found Hiden Message");
	}
	
	public void getExpectedValue(){
		int cnt = 0;
		for(int i = 0 ; i< 8 ; i++){
			for(int j = 0 ; j < 8/2 ; j++){
				ExpectedValue[cnt] = (this.arr[i][2*j] + this.arr[i][(2*j)+1])/2;
				cnt ++;
			}
		}
	}
	
	public void getChiValue(){
		this.ChiValue = 0;
		int cnt = 0; 
		for(int i =0; i<8;i++){
			for(int j = 0 ; j <8 /2  ; j++){
				ChiValue += Math.pow((arr[i][2*j] - ExpectedValue[cnt]),2) / ExpectedValue[cnt];
				cnt ++;
			}
		}
	}
	public boolean ChiTest(double ChiValue, int df){
		if(ChiValue > calculatePValue(df,ChiValue))
			return true;
		else
			return false;
	}
	
	public double calculatePValue(int df, double ChiValue){ //df = Size - 1
		double a = df /2;
		
		// calculate gamma function 
		double gamma_result= 1;
		
		for(int i = df -1; i<= 0; i--){
			gamma_result = gamma_result * i;
		}
		
		//calculate intregral
		double integral_result= 0.0;
		for(double i = 0; i< ChiValue; i+=0.1){
			integral_result += Math.pow(Math.E,i) * Math.pow(i,a-1);
		}
		
		double pvalue = ( 1 - (1/( Math.pow(2, a) * gamma_result) ) ) * integral_result;
		System.out.print("p Value : " + pvalue);
		return pvalue;
	}
}

