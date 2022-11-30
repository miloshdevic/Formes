import java.util.Scanner;
import java.util.ArrayList;

public class Tp1 {

    public static void main(String[] args) {
        Surface surface = new Surface(1,1);
        Boolean initialized = false;//indique si la surface est initialisée ou pas

        Scanner scanner = new Scanner(System.in);
        String instruction;
        String[] tabInstruction;//contient les mots de l'instruction

        do {
            instruction = scanner.nextLine();

            //mettre les instructions dans un tableau
            tabInstruction = instruction.split(" ");

            //bloc de "if" et "else if" permettant de savoir quoi faire selon
            //la commande
            if (instruction.equals("fin")) {
                break;
            }



            else if (tabInstruction[0].toLowerCase().equals("init")) {
                surface = new Surface(Integer.parseInt(tabInstruction[1]),
                        Integer.parseInt(tabInstruction[2]));
                if (!initialized)
                    initialized = true;
            }



            else if (tabInstruction[0].toLowerCase().equals("car")) {
                if (tabInstruction.length <= 1){
                    surface.setCaractere('#');
                } else {
                    surface.setCaractere(tabInstruction[1].charAt(0));
                }
            }



            else if (tabInstruction[0].toLowerCase().equals("renverser")) {
                surface.renverser();
            }



            else if (tabInstruction[0].toLowerCase().equals("brasser")) {
                surface.brasser();
            }



            else if (tabInstruction[0].toLowerCase().equals("dessiner")) {
                if (initialized)
                    surface.dessiner();
                else
                    System.out.println("ERREUR: Aucune surface définie.");
            }


            //instructions pour ajouter des formes
            else if (tabInstruction[0].toLowerCase().equals("ajouter")) {

                if (tabInstruction[1].toLowerCase().equals("rectangle")) {
                    Rectangle rectangle =
                            new Rectangle(Integer.parseInt(tabInstruction[2]),
                                    Integer.parseInt(tabInstruction[3]),
                                    Integer.parseInt(tabInstruction[4]),
                                    Integer.parseInt(tabInstruction[5]));
                    rectangle.ajouterForme(surface, surface.getCaractere());
                    surface.addFormes(rectangle);
                    surface.addCaracUtilisee(surface.getCaractere());
                }

                else if (tabInstruction[1].toLowerCase().equals("carre")) {
                    Carre carre = new Carre(Integer.parseInt(tabInstruction[2]),
                            Integer.parseInt(tabInstruction[3]),
                            Integer.parseInt(tabInstruction[4]),
                            Integer.parseInt(tabInstruction[4]));
                    carre.ajouterForme(surface, surface.getCaractere());
                    surface.addFormes(carre);
                    surface.addCaracUtilisee(surface.getCaractere());
                }

                else if (tabInstruction[1].toLowerCase().equals("cercle")) {
                    Cercle cercle = new Cercle(Integer.parseInt(tabInstruction[2]),
                            Integer.parseInt(tabInstruction[3]),
                            Integer.parseInt(tabInstruction[4]));
                    cercle.ajouterForme(surface, surface.getCaractere());
                    surface.addFormes(cercle);
                    surface.addCaracUtilisee(surface.getCaractere());
                }

                else if (tabInstruction[1].toLowerCase().equals("ligne")) {
                    Ligne ligne = new Ligne(Integer.parseInt(tabInstruction[2]),
                            Integer.parseInt(tabInstruction[3]),
                            Integer.parseInt(tabInstruction[4]),
                            Integer.parseInt(tabInstruction[5]));
                    ligne.ajouterForme(surface, surface.getCaractere());
                    surface.addFormes(ligne);
                    surface.addCaracUtilisee(surface.getCaractere());
                }

                else if (tabInstruction[1].toLowerCase().equals("texte")) {
                    Texte texte = new Texte(Integer.parseInt(tabInstruction[2]),
                            Integer.parseInt(tabInstruction[3]),
                            (tabInstruction[4]));
                    texte.ajouterForme(surface, surface.getCaractere());
                    surface.addFormes(texte);
                    surface.addCaracUtilisee(surface.getCaractere());
                }

                else if (tabInstruction[1].toLowerCase().equals("lettre")) {
                    Caractere caractere = new Caractere(
                            Integer.parseInt(tabInstruction[2]),
                            Integer.parseInt(tabInstruction[3]),
                            (tabInstruction[4]).charAt(0));
                    caractere.ajouterForme(surface, surface.getCaractere());
                    surface.addFormes(caractere);
                    surface.addCaracUtilisee(surface.getCaractere());
                }
            }
        } while (scanner.hasNext());
    }
}