public class Forme {

    //les attributs:
    protected int X, Y;//coordonnées

    //constructeur
    public Forme(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    //les méthodes:

    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

    public void setX(int x) {
        this.X = x;
    }

    public void setY(int y) {
        this.Y = y;
    }

    /**
     * permet de créer une forme dans la surface de dessin
     * @param surface
     * @param caractere
     * @return la surface modifiée avec la forme en plus
     */
    public char[][] ajouterForme(Surface surface, char caractere) {
        char[][] surfaceModifiee = surface.getMatrice();
        return surfaceModifiee;
    }
}
