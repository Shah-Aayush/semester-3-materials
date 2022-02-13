class MyDegree {
	double fahrenheit,celsius;
	MyDegree(String choice, double data){
		if(choice == "fahrenheit"){
			this.fahrenheit = data;
			this.celsius = (double)((double)5/(double)9)*(this.fahrenheit-32);
		}
		else if(choice == "celsius"){
			this.celsius = data;
			this.fahrenheit = ((double)((double)9/(double)5)*this.celsius) + 32;
		}
		else{
			System.out.println("Invalid Input :(");
			System.out.println("Initializing temperature with zero :)");
			this.fahrenheit = 0;
			this.celsius = 0;
		}
	}
	double getFahrenheit(){
		return this.fahrenheit;
	}
	double getCelsius(){
		return this.celsius;
	}
	void setFehrenheit(double fahrenheit){
		this.fahrenheit = fahrenheit;
		this.celsius = (5/9)*(this.fahrenheit-32);
	}
	void setCelsius(double celsius){
		this.celsius = celsius;
		this.fahrenheit = ((9/5)*this.celsius) + 32;
	}
}