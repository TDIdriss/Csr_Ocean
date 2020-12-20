import java.util.Random;

public class Ocean {

    public static final int n=6;   // 6*6 Zones a créer
    //private Zone zone;
    public static Zone tabZone[][] = new Zone[n][n];
    private Poissons tabPoissons[]= new Poissons[100];

     public Ocean(){
        //this.n=n;



        /*
        * Creation des differentes Zones avec un nombre aleatoire de requin et de poissons
        * **/
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                Requins re = new Requins();

                tabZone[i][j] = new Zone(i , j );

            }
        }


    }

    public static Zone returnZone(int i, int j){
         return tabZone[i][j];
    }

  public void fonctionner(){
      for(int i=0; i<n; i++){
          for(int j=0; j<n; j++){
               if (tabZone[i][j].getRequin()!= null){
                  // System.out.println(tabZone[i][j].getRequin());
                   tabZone[i][j].getRequin().start();
               }
          }
}}

    public static void main(String[] args) {
        Ocean ocean =new Ocean();
        ocean.fonctionner();
    }

}


