import java.util.Random;

public class Requins extends Thread {

    public static final int NBRECYCLE=10;  // nombre de cycle Max
    private int actuCycle;  // nombre de cycle actuel du requins
    private Zone ze;
    public static final int P=5 ; //nombre de poissons Max transportés
    private int actuPoissons; // nombre de poissons sur le requin



    public void setZoneRequuin(Zone zone){
        this.ze=zone;
    }
    public Zone getZoneRequin(){
        return ze;
    }

    public void manger(){
        if(ze.getSardine()<2){
            System.out.println("le requin "+Thread.currentThread().getName()+" mange 0 sardines  ---- il reste "+ze.getSardine()+" dans la zone"+ "("+ ze.getLigne()+","+ze.getColonne()+")" );
        }else {
            ze.setSardine(ze.getSardine() - 2);
            System.out.println("le requin "+Thread.currentThread().getName()+" mange 2 sardines  ---- il reste "+ze.getSardine()+" dans la zone"+ "("+ ze.getLigne()+","+ze.getColonne()+")" );
        }

    }


    synchronized void transporter(Poissons poissons) {
        if (actuPoissons <= P) {
            actuPoissons++;

            while(ze==poissons.getZonePoissons()) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    /**
     *Permet de trouver la prochaine zone atteinte par le requin
     */

    public Zone findZone(){


        Random rd = new Random();
        int value = rd.nextInt(4);
        int newColonnes=0;
        int newLigne=0;
        switch (value){

            case 0: // a droite
                newColonnes = ze.getColonne()+1;
                // Si on est sur la derniere colonne et qu'on veut aller a droite on se retrouve sur la premiere colonnes
                if(newColonnes>Ocean.n-1)
                {
                    newColonnes=0;
                }
                newLigne=ze.getLigne();
                break;


            case 1 ://a gauche
                newColonnes= ze.getColonne()-1;

                if(newColonnes<0){
                    newColonnes=Ocean.n-1;
                }

                newLigne=ze.getLigne();
                break;

            case 2 : // en bas
                newLigne=ze.getLigne()+1;

                if(newLigne>Ocean.n-1)
                {
                    newLigne=0;  // Si on est sur la derniere ligne et qu'on veut aller en bas on se retrouve sur la premiere lignes

                }
                newColonnes=ze.getColonne();
                break;

            case 3 : //en haut
                newLigne=ze.getLigne()-1;

                if(newLigne<0){
                    newLigne=Ocean.n-1;
                }

                newColonnes=ze.getColonne();    break; //en haut


            default: System.out.println("erreur de calcul");
        }
        return Ocean.returnZone(newLigne,newColonnes);
    }


    public void run(){
        while (actuCycle<=NBRECYCLE) {// On prendre un nombre de Cycle egal a 10


            ze.sortir();
            findZone().entrer(this);
            this.manger();
        }
    }

    public int getNbreCycle() {
        return actuCycle;
    }

    public void setNbreCycle(int actuCycle) {
        this.actuCycle= actuCycle;

    }
}
