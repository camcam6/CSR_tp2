class Site extends Thread{

	/* Constantes associ�es au site */
	
	static final int stockInit = 9;
	static final int stockMax = 10;
	static final int borneSup = 7;
	static final int borneInf = 2;
	int stockVelos;
	
	
	int numeroSite;
	public Site(int numeroSite){
		this.numeroSite = numeroSite;
		this.stockVelos = stockInit;
	}
	
	public int getStockVelos() {
		return stockVelos;
	}

	public void setStockVelos(int stockVelos) {
		this.stockVelos = stockVelos;
	}
	
	public int getNumeroSite() {
		return numeroSite;
	}

	public void setNumeroSite(int numeroSite) {
		this.numeroSite = numeroSite;
	}

	public static int getStockinit() {
		return stockInit;
	}

	public static int getStockmax() {
		return stockMax;
	}

	public static int getBornesup() {
		return borneSup;
	}

	public static int getBorneinf() {
		return borneInf;
	}
	public synchronized void destockerSite(){
		System.out.println("test1");
		while(stockVelos <= borneSup){
    		try {
    			System.out.println("test2");
				wait();
			} catch (InterruptedException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
    	}
		System.out.println("test3");
    	stockVelos--;
    	
        //notifyAll();
    		
		
	}
	public synchronized void stockerSite(){
		while(stockVelos <= borneInf){
    		try {
				wait();
			} catch (InterruptedException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
    	}
		stockVelos++;
    	notifyAll();
		
	}
	public void run(){
		
	}
	
	

}

