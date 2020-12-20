

public class Poissons extends Thread {

    private Zone zonePoissons;
    //private int nbreZone;
    public static final int NBRECYCLEPOISSONS=10 ; // Nombre de cycle des poissons
    private int actuCyclePoissons; // nombre de cycle actuel

    public Poissons(){

    }

    public void setZonePoissons(Zone zone){
        this.zonePoissons=zone;
    }

    public void attacheRequin(Zone zone){
        zone.getRequin().transporter(this);

    }

    public void detacherRequin(Zone zone){
        zone.getRequin().transporter(this);

    }


    public Zone getZonePoissons() {
        return zonePoissons;
    }

    public void run(){
        while(actuCyclePoissons<=NBRECYCLEPOISSONS){
            attacheRequin(zonePoissons);


            detacherRequin(zonePoissons);


        }
    }
}
