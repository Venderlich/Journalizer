package journal.Cour.Service;

import journal.Filiere.Service.Filiere;
import journal.Matiere.Service.Matiere;
import journal.TypeDeCour.Service.TypeDeCour;

import java.util.Date;

public class Cour {
    Integer id;
    String commentaire;
    String dateSeance;
    Integer temps;
    Filiere filiere;
    TypeDeCour typeDeCour;
    Matiere matiere;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(String dateSeance) {
        this.dateSeance = dateSeance;
    }

    public Integer getTemps() {
        return temps;
    }

    public void setTemps(Integer temps) {
        this.temps = temps;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public TypeDeCour getTypeDeCour() {
        return typeDeCour;
    }

    public void setTypeDeCour(TypeDeCour typeDeCour) {
        this.typeDeCour = typeDeCour;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }
}
