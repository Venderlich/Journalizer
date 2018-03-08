package journal.Cour.Service;

import journal.Filiere.Service.Filiere;
import journal.Matiere.Service.Matiere;
import journal.TypeDeCour.Service.TypeDeCour;

import java.util.Date;

public class Cour {
    Integer id;
    String label;
    String commentaire;
    String dateSeance;
    Integer temps;
    Filiere filiere;
    TypeDeCour typeDeCour;
    Matiere matiere;

}
