import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


public class Zone {

   private int sardine;
   private int nbreRequin;
   public static final  int nbrePoisson=10;
   private Requins re;
   private List<Poissons> listPoissons = new ArrayList<>();


    /*
    * Coordonnées de la zone
    * **/
    private int ligne ;
    private int colonne ;


  public Zone(int i,int j ){
        this.ligne =i;
        this.colonne=j;
      Random rd = new Random();
      nbreRequin=rd.nextInt(2);
       if(nbreRequin==1){
           this.re=new Requins();
           re.setZoneRequuin(this);
           for(int k=0; k<=Zone.nbrePoisson; k++){
               listPoissons.add(new Poissons());

           }
       }

      //  this.nbreRequin=rd.nextInt(1);
        this.sardine=rd.nextInt(10);
    }




    synchronized  void entrer( Requins re)  {

        while (nbreRequin==1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

            re.setNbreCycle(re.getNbreCycle()+1);  // on incremente son cycle
            nbreRequin=1;
            this.re=re;
            re.setZoneRequuin(this);
        notifyAll();
        System.out.println("le requin "+Thread.currentThread().getName()+" est entrer dans la zone "+ "("+ ligne+","+colonne+")" );
        }



    synchronized void sortir(){
      nbreRequin=0;
      this.re=null;
     // requin.setZoneRequuin(requin.findZone());
      notifyAll();

        System.out.println("le requin "+Thread.currentThread().getName()+" est sorti de la zone "+ "("+ ligne+","+colonne+")" );
    }

    public int getSardine() {
        return sardine;
    }

    public void setSardine(int sardine) {
        this.sardine = sardine;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setRequin(Requins requin){
      this.re=requin;
    }

    public Requins getRequin(){
     // System.out.println("papa");
        return  re;
    }
}

