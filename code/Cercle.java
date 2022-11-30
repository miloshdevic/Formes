public class Cercle extends Forme {

    //les attributs:
    protected int rayon;

    //constructeur
    public Cercle(int X, int Y, int rayon) {
        super(X, Y);
        this.rayon = rayon;
    }

    //les méthodes:

    public int getRayon() {
        return this.rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    @Override
    public char[][] ajouterForme(Surface surface, char caractere) {
        char[][] surfaceModifiee = surface.getMatrice();
        int rayon = this.getRayon();
        int centreX = this.getX();//coordonnée sur l'axe des x du centre du cercle
        int centreY = this.getY();//coordonnée sur l'axe des y du centre du cercle
        int x = 0;
        int y = rayon;//on se place en haut du cercle
        int m = 5 - 4*rayon;//initialisation


        //algorithme de Bresenham
        while (x <= y) { //tant qu'on est dans le second octant

            //gros bloc de "if" et "else if" pour couvrir les cas
            //avec les coordonnées négatives et lorsque cela sort
            //de la surface

            surfaceModifiee[x+centreX][y+centreY] = caractere;
            surfaceModifiee[y+centreX][x+centreY] = caractere;
            surfaceModifiee[-x+centreX][y+centreY] = caractere;
            surfaceModifiee[-y+centreX][x+centreY] = caractere;
            surfaceModifiee[x+centreX][-y+centreY] = caractere;
            surfaceModifiee[y+centreX][-x+centreY] = caractere;
            surfaceModifiee[-x+centreX][-y+centreY] = caractere;
            surfaceModifiee[-y+centreX][-x+centreY] = caractere;


            if (m > 0) {
                y = y - 1;
                m = m - 8*y;
            }

            x = x + 1;
            m = m + 8*x + 4;
        }
        return surfaceModifiee;
    }
}
