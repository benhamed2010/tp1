package ConnectionJavaMysql;


	public class Cannaux {


		//variables d'instances
			private String tranche;
			private String quart;
			private String chainetv;
			private int nombre;
			
			
			//constructeur par defaut
			public Cannaux(){
				//On initialise les variables d'instance
				tranche= "";
				quart= "";
				chainetv= "";
				nombre=0;
				
				
			}	
		//Constructeurs d'initialisition
		public Cannaux(String pTranche, String pQuart, String pChainetv , int pNombre){
			tranche= pTranche;
			quart= pQuart;
			chainetv= pChainetv;
			nombre=pNombre;
			

			}
		//Getter
			public String getTranche(){
				return tranche;
			}
			public String getQuart(){
				return quart;
				
			}
			public String getChainetv(){
				return chainetv;
			}
			public int getNombre(){
				return nombre;
				
			}

			//Setter
			public void setTranche(String pTranche){
				if (pTranche!="") {
					tranche=pTranche;
					
				}else{
					System.out.println("La valeur propos? est incorrect");
				}	
				}
					
			public void setQuart(String pQuart){
				if (pQuart!="") {
					quart=pQuart;
					
				}else{
					System.out.println("La valeur propos? est incorrect");
				}	
				}
			public void setChainetv(String pChainetv){
				if (pChainetv!="") {
					chainetv=pChainetv;
					
				}else{
					System.out.println("La valeur propos? est incorrect");
				}	
				}
			public void setNombre(int pNombre){
				if (pNombre>=0) {
					nombre=pNombre;
					
				}else{
					System.out.println("La valeur propos? est incorrect");
				}	
				
			}
			//methode qui compte le nombre des chaines france2
				private int count(){
					int x=0;
					
					
					if (chainetv=="FRANCE2")	{
				
						
					  x=x+1;				
					}return x;
					
				}
				//methode qui calcule le nombre des spectateur  qui regarde france
						private int cal_nombre(){
							int w=0;
							
							
							if (chainetv=="FRANCE2")	{
											
							 w=w+nombre;				
							}return w;
							
							
						}
			//methode qui calcule la moyenne de spectateur de la chaine france
			private double calcul(){
				double moy=0;
				int y=this.count();
				int z=this.cal_nombre();
				if (chainetv!="FRANCE2")
				{moy=0;}
				else
				{
					moy=(z /(y));
				
				}
				return moy;
				
			}
			
		}



}
