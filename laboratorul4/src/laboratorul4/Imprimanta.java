package laboratorul4;

class Imprimanta extends Echipament{
    private int ppm;
    private String rezolutie;
    private int p_car;
    private Mod_tiparire mod_tiparire;

    public Imprimanta(String denumire,  int nr_inv, float pret, String zona_mag,Situatie situatie, Mod_tiparire mod_tiparire, int ppm, String rezolutie, int p_car)
    {
        super(denumire, nr_inv, pret,zona_mag, situatie);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.mod_tiparire = mod_tiparire;
    }

    public Mod_tiparire getMod_tiparire()
    {
        return mod_tiparire;
    }
    public void setMod_tiparire(Mod_tiparire mod_tiparire)
    {
        this.mod_tiparire = mod_tiparire;
    }

    public String toString()
    {
        return super.toString() + " Imprimante: " + "Numar de pagini scrise pe minut: " + ppm +
                "Rezolutie: " + rezolutie + "Numarul de pagini pe cartus: " + p_car + "Mod de tiparire: " + mod_tiparire;
    }
}
