public class Ligne extends Forme {

    //les attributs:
    protected int X2, Y2;

    //constructeur
    public Ligne(int X, int Y, int X2, int Y2) {
        super(X, Y);
        this.X2 = X2;
        this.Y2 = Y2;
    }


    //les méthodes:

    public int getX2() {
        return this.X2;
    }

    public int getY2() {
        return this.Y2;
    }

    public void setX2(int x2) {
        this.X2 = x2;
    }

    public void setY2(int y2) {
        this.Y2 = y2;
    }

    @Override
    public char[][] ajouterForme(Surface surface, char caractere) {
        char[][] surfaceModifiee = surface.getMatrice();
        int X1 = this.getX();
        int Y1 = this.getY();
        int X2 = this.getX2();
        int Y2 = this.getY2();

        while (X1 < 0) {
            X1++;
        }

        while (Y1 < 0) {
            Y1++;
        }

        //algorithme de tracee de segment de Bresenham pour tracer des cercles
        if (Math.abs(X2 - X1) > Math.abs(Y2 - Y1)) {
            for (int x = Math.min(X1, X2); x <= Math.max(X1, X2); x++) {
                float y = ((float)(Y2 - Y1) / (X2 - X1)) * (x - X1) + Y1;
                int newY = Math.round(y);
                surfaceModifiee[newY][x] = caractere;
            }

        } else if (Math.abs(X2 - X1) < Math.abs(Y2 - Y1)) {
            for (int y =Math.min(Y1, Y2); y <= Math.max(Y1, Y2); y++) {
                float x = ((float)(X2 - X1) / (Y2 - Y1)) * (y - Y1) + X1;
                int newX = Math.round(x);
                surfaceModifiee[y][newX] = caractere;
            }

        } else { //cas ou Δx = Δy
            if (X1 == Y1) {//ligne diagonale
                for (int x = X1; x <= X2; x++) {
                    for (int y = Y1; y <= Y2; y++) {
                        if(x < 0 || y < 0 || x >= surface.getHauteur() || y >= surface.getLargeur()){
                            break;
                        }
                        if (x == y)
                            surfaceModifiee[x][y] = caractere;
                    }
                }
            } else {//ligne diagonale de l'autre sens

                //pour savoir quand insérer le caractère
                int delta = Math.abs(X1 - Y1);

                for (int x = Math.min(X1, X2); x <= Math.max(X1, X2); x++) {
                    for (int y = Math.max(Y1, Y2); y >= Math.min(Y1, Y2); y--) {
                        if(x < 0 || y < 0 || x >= surface.getHauteur() || y >= surface.getLargeur()){
                            break;
                        }
                        if (x + y == delta)
                            surfaceModifiee[x][y] = caractere;
                    }
                }
            }
        }
        return surfaceModifiee;
    }
}