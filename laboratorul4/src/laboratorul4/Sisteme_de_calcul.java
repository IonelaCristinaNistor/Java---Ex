package laboratorul4;

class Sisteme_de_calcul extends Echipament
{
    private String tip_mon;
    private double vit_proc;
    private int c_hdd;
    private Sistem_operare sist;

    public Sisteme_de_calcul(String denumire, int nr_inv, float pret, String zona_mag, Situatie situatie, String tip_mon, double vit_proc, int c_hdd, Sistem_operare sist)
    {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.tip_mon = tip_mon;
        this.vit_proc=vit_proc;
        this.c_hdd = c_hdd;
        this.sist = sist;
    }

    public Sistem_operare getSist()
    {
        return sist;
    }
    public static void setSist(Sistem_operare sist)
    {
        this.sist = sist;
    }

    public String toString()
    {
        return super.toString() + " Tip monitor: " + tip_mon +
                "Viteza procesor: " + vit_proc +
                "Capacitate HDD: " + c_hdd +
                "Sistem de operare: " + sist;
    }
}
