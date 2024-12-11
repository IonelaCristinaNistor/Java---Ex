package ex2;

class Vers {
    private String vers;
    public Vers(String v)
    {
        vers = v;
    }

    public String getVers()
    {
        return vers;
    }

    public void random()
    {
        double x = Math.random();
        if(x < 0.1)
        {
            vers = vers.toUpperCase();
        }
    }

    public boolean cautare(String grupare)
    {
        return vers.endsWith(grupare);
    }

    public int numar_de_cuvinte()
    {
        String[] split = vers.split(" ");
        return split.length;
    }

    public int numar_de_vocale()
    {
        int numar = 0;
        String vocale = "aeiouAEIOU";
        for(int i = 0; i < vers.length(); i++)
            if(vocale.indexOf(vers.charAt(i)) >= 0)
                numar++;
        return numar;
    }
}

