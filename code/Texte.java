public class Texte extends Forme {

    //les attributs:
    protected String texte;
    protected char[] tabLettre;

    //constructeur
    public Texte(int X, int Y, String texte) {
        super(X, Y);
        this.texte = texte;
        this.tabLettre = new char[texte.length()];

        //facilitera le dessin du texte
        for (int i = 0; i < tabLettre.length; i++) {
            tabLettre[i] = texte.charAt(i);
        }
    }

    //les méthodes:

    public String getTexte() {
        return this.texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public char[] getTabLettre() {
        return this.tabLettre;
    }

    public void setTabLettre(char[] tabLettre) {
        this.tabLettre = tabLettre;
    }

    @Override
    public char[][] ajouterForme(Surface surface, char caractere) {
        Surface surfaceModifiee = surface;
        char[] tabLettre = this.getTabLettre();
        int X = this.getX();
        int Y = this.getY();

        for (int i = 0; i < tabLettre.length; i++) {
            Caractere lettre = new Caractere(X, Y, tabLettre[i]);
            surfaceModifiee.setMatrice(lettre.ajouterForme(surfaceModifiee, caractere));
            Y = Y + 8;
        }
        return surfaceModifiee.getMatrice();
    }
}