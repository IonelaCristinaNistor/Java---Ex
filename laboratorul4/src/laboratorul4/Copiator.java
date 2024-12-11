package laboratorul4;

class Copiator extends Echipament{
    private int pg;
    private String p_ton;
    private Format format;

    public Copiator(String denumire, int nr_inv, float pret, String zona_mag, Situatie situatie, int pg, String p_ton, Format format)
    {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.pg = pg;
        this.p_ton = p_ton;
        this.format = format;
    }

    public Format getFormat()
    {
        return format;
    }
    public void setFormat()
    {
        this.format = format;
    }

    public String toString()
    {
        return super.toString() + " Copiator: " + "Numar de pagini: " + pg +
                "Numarul de pagini/tonner: " + p_ton + "Format: " + format;
    }
}
