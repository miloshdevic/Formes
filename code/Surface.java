import java.util.ArrayList;

public class Surface {

    //les attributs:
    private int largeur;
    private int hauteur;
    private char[][] matrice;

    private ArrayList<Forme> formes = new ArrayList<Forme>();
    private ArrayList<Character> caractereUtilisee = new ArrayList<Character>();

    private char stockCaractere = ' ';

    //constructeur
    public Surface(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.matrice = new char[hauteur][largeur];

        //remplir la surface d'espaces
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[i].length; j++) {
                matrice[i][j] = " ".charAt(0);
            }
        }
    }

    //les méthodes:

    public int getLargeur() {
        return this.largeur;
    }

    public int getHauteur() {
        return this.hauteur;
    }

    public char[][] getMatrice() {
        return this.matrice;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setMatrice(char[][] matrice) {
        this.matrice = matrice;
    }

    public void addFormes(Forme forme){
        formes.add(forme);
    }

    public void addCaracUtilisee(char carac){
        caractereUtilisee.add(carac);
    }

    public void setCaractere(char carac){
        stockCaractere = carac;
    }

    public char getCaractere(){
        return stockCaractere;
    }

    /**
     * affiche le dessin
     */
    public void dessiner() {
        String dessin = "";

        for (int i=0; i < this.matrice.length; i++) {
            for (int j=0; j < this.matrice[i].length; j++) {
                dessin += this.matrice[i][j] + " ";
            }
            dessin += "\n";
        }
        System.out.println(dessin);
    }


    /**
     * déplace le dessin selon les axes et les indices de déplacement
     */
    public void brasser() {
        int[] possibilite = {-1, 0, 1};
        Surface surfaceModifiee = new Surface(this.largeur, this.hauteur);

        for (Forme forme : formes) {
            int deplacementX = possibilite[(int) Math.floor(Math.random() * 3.0)];
            int deplacementY = possibilite[(int) Math.floor(Math.random() * 3.0)];

            forme.setX(forme.getX() + deplacementX);
            forme.setY(forme.getY() + deplacementY);

            char used = caractereUtilisee.get(formes.indexOf(forme));

            forme.ajouterForme(surfaceModifiee, used);
        }

        this.setMatrice(surfaceModifiee.getMatrice());
    }

    /**
     * renverse le dessin
     */
    public void renverser() {
        char[][] surfaceModifiee =
                new char[this.matrice.length][this.matrice[0].length];

        int pointeur = this.matrice.length-1;

        //faire les modifications
        for (int i = 0; i < this.matrice.length; i++) {
            for (int j = 0; j< this.matrice[i].length; j++) {
                surfaceModifiee[i][j] = this.matrice[pointeur][j];
            }
            pointeur--;
        }

        //changer la surface originale
        for (int i = 0; i < this.matrice.length; i++) {
            for (int j = 0; j< this.matrice[i].length; j++) {
                this.matrice[i][j] = surfaceModifiee[i][j];
            }
        }
    }
}