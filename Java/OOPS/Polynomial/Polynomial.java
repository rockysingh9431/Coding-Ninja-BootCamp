package Polynomial;

public class Polynomial {
	int polyCoeff[];

	Polynomial(){
		polyCoeff=new int[5];
	}
	Polynomial(int size){
        polyCoeff=new int[size];
    }

  private void incrementSize(int degree){
    int[] newPolyCoeff=new int[degree>5?polyCoeff.length+degree:polyCoeff.length+5];
    for(int i=0;i<polyCoeff.length;i++){
      newPolyCoeff[i]=polyCoeff[i];
    }
    polyCoeff=newPolyCoeff;
  }
	public void setCoefficient(int degree, int coeff){
	    if(degree>=polyCoeff.length){
            incrementSize(degree);
        }
		polyCoeff[degree]=coeff;
	}
	
	// Prints all the terms(only terms with non zero coefficients are to be printed) in increasing order of degree. 
	public void print(){
		for(int i=0;i<polyCoeff.length;i++){
        if(polyCoeff[i]!=0)
                System.out.print(polyCoeff[i]+"x"+i+" ");
            }
        System.out.println();
	}

	
	// Adds two polynomials and returns a new polynomial which has result
	public Polynomial add(Polynomial p){
        
        int length=Math.max(this.polyCoeff.length,p.polyCoeff.length);
        Polynomial result=new Polynomial(length+1);
        for(int i=0;i<result.polyCoeff.length;i++){
            if(i<p.polyCoeff.length && i<this.polyCoeff.length ){
                result.polyCoeff[i]=this.polyCoeff[i]+p.polyCoeff[i];
            }else if(i<this.polyCoeff.length){
                result.polyCoeff[i]=this.polyCoeff[i];
            }else if(i<p.polyCoeff.length){
                result.polyCoeff[i]=p.polyCoeff[i];
            }
        }
        return result;
	}
	
	// Subtracts two polynomials and returns a new polynomial which has result
	public Polynomial subtract(Polynomial p){
        int length=Math.max(this.polyCoeff.length,p.polyCoeff.length);
		Polynomial result=new Polynomial(length);
    
        for(int i=0;i<length;i++){
            if(i<p.polyCoeff.length && i<this.polyCoeff.length ){
                result.polyCoeff[i]=this.polyCoeff[i]-p.polyCoeff[i];
            }else if(i<this.polyCoeff.length){
                result.polyCoeff[i]=this.polyCoeff[i];
            }else if(i<p.polyCoeff.length){
                result.polyCoeff[i]=-p.polyCoeff[i];
            }
        }
        return result;
	}
	
	// Multiply two polynomials and returns a new polynomial which has result
	public Polynomial multiply(Polynomial p){
		Polynomial result=new Polynomial(this.polyCoeff.length+p.polyCoeff.length);
    
        for(int i=0;i<this.polyCoeff.length;i++){
            for(int j=0;j<p.polyCoeff.length;j++){ 
                if(this.polyCoeff[i]!=0 && p.polyCoeff[j]!=0){
					int newDegree=i+j;
					int coeff1=this.polyCoeff[i]!=0?this.polyCoeff[i]:1;
					int coeff2=p.polyCoeff[j]!=0?p.polyCoeff[j]:1;
					int newCoeff=coeff1*coeff2;
					result.polyCoeff[newDegree]+=newCoeff;
				}
            }
        }
        return result;
	}

}
