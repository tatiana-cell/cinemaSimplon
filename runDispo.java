class ErrorRow extends Exception {}
class ErrorSeat extends Exception {}

class PLACE {
	int row,seat;
	boolean occupe;
	
	public PLACE(int row, int seat) throws ErrorRow, ErrorSeat
	{
		if(row<0||row>7) throw new ErrorRow();
		if(seat<0||seat>8)throw new ErrorSeat();
		this.row=row;
		this.seat=seat;
		this.occupe=false;
	}
	
	public void setOccupe()
	{
		this.occupe=true;
	}
	public void affichDispoPlace()
	{
		if(this.occupe) {System.out.print("[ X ]");}
		else {System.out.print("[ _ ]");}
	}

}



public class runDispo {

	public static void main(String[] args) {
			
		PLACE[][] tbl=new PLACE [8][9];
		
		try {
			remplirCinema(tbl);
		} catch (ErrorRow e) {
			System.out.println("ErrorRow: le numéro de row est compris entre 1 et 8");
			System.exit(-1);
		} catch (ErrorSeat e) {
			System.out.println("ErrorSeat: le numéro (nombre) de seat(s) est compris entre 1 et 9");
		    System.exit(-1);
		}
		//affichSalle(tbl);
		try {
			checkDispos(tbl,5,1);
		} catch (ErrorRow e) {
			System.out.println("ErrorRow: le numéro de row est compris entre 1 et 8");
			System.exit(-1);
		} catch (ErrorSeat e) {
			System.out.println("ErrorSeat: le nombre de seats est compris entre 1 et 9");
		    System.exit(-1);
		}

	}  //main
	
	static void checkDispos(PLACE[][]t,int row,int seats) throws ErrorRow, ErrorSeat
	{
		if(row<1||row>8)throw new ErrorRow();
		if(seats<1||seats>9)throw new ErrorSeat();
		row-=1;
		
		int dispo=0;
		for(int j=0;j<t[row].length;j++)
		{
			if(!t[row][j].occupe)
			{
				dispo++;
			}
		}
		System.out.println("dispo="+dispo);
		if(seats>dispo)
		{
			System.out.println("La disponibilité pour la rangée "+(row+1)+" est "+dispo+" places.\n"
					+ "Vous avez demandé "+seats+" places.\n On ne peut pas satisfaire votre demande.");
		}else
		{
			System.out.println("Les disponibilitités de la Salle pour votre "
					+ "demande \n de "+seats+" places dans la rangéé numéro "+(row+1)+":");
			System.out.println();
			affichNumPlaces();
			affichSalle(t);}
		
	}
	
	static void remplirCinema(PLACE[][]t) throws ErrorRow, ErrorSeat
	{
		for(int i=0;i<t.length;i++)
		{
			for(int j=0;j<t[i].length;j++)
			{
				t[i][j]=new PLACE (i,j);
				int x=1+(int)(Math.random()*10);
				if(x>5) 
				{
					t[i][j].setOccupe();
					
				}
			}	
		}
	}
	static void affichNumPlaces()
	{   
		int j=1;
		for(int i=0;i<10;i++)
		{
			System.out.print(" ");
		}
		for(int i=1;i<=45;i++)
		{
		   if((i-3)%5==0) {
			   System.out.print(j);
			   j++;
			   }
		   else System.out.print(" ");
		  
		}
		System.out.println();
	}
	static void affichSalle(PLACE[][]t)
	{
		for(int i=0;i<t.length;i++)
		{
			System.out.print("Rangée "+(i+1)+": ");
			for(int j=0;j<t[i].length;j++)
			{  
				
			   t[i][j].affichDispoPlace();
				
			}
			System.out.println();
		}
	}
}
	
	
