public class Rectangle extends Forme {

    //les attributs:
    protected int hauteur, largeur;//dimensions du rectangle

    //constructeur
    public Rectangle(int X, int Y, int largeur, int hauteur) {
        super(X, Y);
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    //les méthodes:

    public int getHauteur() {
        return this.hauteur;
    }

    public int getLargeur() {
        return this.largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }


    @Override
    public char[][] ajouterForme(Surface surface, char caractere) {
        char[][] surfaceModifiee = surface.getMatrice();
        int largeur = this.getLargeur();
        int hauteur = this.getHauteur();
        int X = this.getX();
        int Y = this.getY();
        int compteurX = 0;//pour le cas où on aurait des coordonées neégatives
        int compteurY = 0;//pareil

        while (X < 0) {
            X++;
            compteurX++;
        }

        while (Y < 0) {
            Y++;
            compteurY++;
        }

        hauteur -= compteurX;
        largeur -= compteurY;

        for (int i = X; i < X + hauteur; i++) {
            for (int j = Y; j < Y + largeur; j++) {
                if(i < 0 || j < 0 || i >= surface.getHauteur() || j >= surface.getLargeur()){
                    break;
                }
                surfaceModifiee[i][j] = caractere;
            }
        }
        return surfaceModifiee;
    }
}