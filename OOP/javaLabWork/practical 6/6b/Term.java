public class Term {
	int coefficient,exponent;
	Term(){
		coefficient=0;
		exponent=-1;
		//Exponents of every term is set to -1 so that we can also add 0 to the exponent as we are checking for condition that adding exponent should not be already present in the polynomial so setting 0 as exponent of every term , then we cannot assign zero to any term's exponent as it will check that if the given exponent value is already present or not in the polynomial
	}
	int getCoefficient(){
		return coefficient;
	}
	int getExponent(){
		return exponent;
	}
	void setCoefficient(int coefficient){
		this.coefficient = coefficient;
	}
	void setExponent(int exponent){
		this.exponent = exponent;
	}
}