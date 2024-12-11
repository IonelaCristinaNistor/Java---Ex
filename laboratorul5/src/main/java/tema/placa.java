package tema;

import java.util.List;

public class placa extends Mobilier{
        private String descriere;
        private int lungime;
        private int latime;
        private Orientare orientare;
        private boolean[] canturi;
        private int nrBucati;

        public placa(String nume, List<placa> placi, String descriere, int lungime, int latime, Orientare orientare, boolean[] canturi, int nrBucati) {
            super(nume, placi);
            this.descriere = descriere;
            this.lungime = lungime;
            this.latime = latime;
            this.orientare = orientare;
            this.canturi = canturi;
            this.nrBucati = nrBucati;
        }

    public placa(String nume, List<placa> placi) {
        super(nume, placi);
    }

    public String getDescriere ()
        {return descriere;
        }

        public int getLungime()
        {
            return lungime;
        }
        public int getLatime()
        {
            return latime;
        }
        public Orientare getOrientare()
        {
            return orientare;
        }

        public boolean[] getCanturi() {
            return canturi;
        }

        public int getNrBucati() {
            return nrBucati;
        }
    }

