public class Caractere extends Forme {

    //les attributs:
    protected char caractere;

    //constructeur
    public Caractere(int X, int Y, char caractere) {
        super(X, Y);
        this.caractere = caractere;
    }

    //les méthodes:

    public char getCaractere() {
        return caractere;
    }

    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }

    @Override
    public char[][] ajouterForme(Surface surface, char caractere) {
        char[][] surfaceModifiee = surface.getMatrice();
        byte[] tab = Police8x12.getImage(this.caractere);

        for (int i = X; i < X + 12; i++) { //toujours 12 lignes
            //trouvé sur internet pour convertir en string
            String bits = String.format("%8s", Integer.toBinaryString(tab[i - X])).replace(' ', '0');

            for (int j = Y; j < Y + 8; j++) { //toujours 8 colonnes
                if(i < 0 || j < 0 || i >= surface.getHauteur() || j >= surface.getLargeur()){
                    continue;
                }

                if (bits.charAt(j - Y) == '1')
                    surfaceModifiee[i][j] = caractere;
            }
        }
        return surfaceModifiee;
    }
}