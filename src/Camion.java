public class Camion extends Thread {
	
	private Site[] sites;
	private int nbVelosCamion;


	public Camion(Site[] sites) {
		this.sites = sites;
	}
	
	
	public void run(){
		
		for(Site site:sites){
			
			site.start();
			System.out.println("test");
			site.destockerSite();
			chargerCamion(site);
			System.out.println("chargerCamion:  "+nbVelosCamion);
			site.stockerSite();
			dechargerCamion(site);
			System.out.println("chargerCamion:  "+nbVelosCamion);
		}
		
	}
	
	public synchronized void chargerCamion(Site site){
		while(site.stockVelos <= site.borneSup){
    		try {
				wait();
			} catch (InterruptedException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
    	}
		nbVelosCamion++;
    	
        notifyAll();
		
	}
	public synchronized void dechargerCamion(Site site){
		while(site.stockVelos >= site.borneInf){
    		try {
				wait();
			} catch (InterruptedException e) {
				// TODO Bloc catch généré automatiquement
				e.printStackTrace();
			}
    	}
		nbVelosCamion--;
    	
        notifyAll();
		
	}
	
	
	
	
	
	
	

}
