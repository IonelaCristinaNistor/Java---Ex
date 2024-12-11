package lab7;

public record Carte(String titlul,String autorul, int anul) {
    @Override
    public String titlul() {
        return titlul;
    }

    @Override
    public String autorul() {
        return autorul;
    }

    @Override
    public int anul() {
        return anul;
    }
}
