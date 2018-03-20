package journal.Cour.GUI.DataClass;

import javafx.beans.property.SimpleStringProperty;

public class CourObservable {
    private SimpleStringProperty id;
    private SimpleStringProperty date;
    private SimpleStringProperty temps;
    private SimpleStringProperty filiere;
    private SimpleStringProperty typeDeCour;
    private SimpleStringProperty matiere;
    private SimpleStringProperty commentaire;

    public CourObservable(String id, String date, String temps, String filiere, String typeDeCour, String matiere, String commentaire){
        this.id =new SimpleStringProperty(id);
        this.date= new SimpleStringProperty(date);
        this.temps= new SimpleStringProperty(temps);
        this.filiere= new SimpleStringProperty(filiere);
        this.typeDeCour= new SimpleStringProperty(typeDeCour);
        this.matiere= new SimpleStringProperty(matiere);
        this.commentaire= new SimpleStringProperty(commentaire);
    }

    public String getId(){
        return id.get();
    }

    public void setId(String id){
        this.id.set(id);
    }

    public String getDate(){
        return date.get();
    }

    public void setDate(String date){
        this.date.set(date);
    }

    public String getTemps(){
        return temps.get();
    }

    public void setTemps(String temps){
        this.temps.set(temps);
    }

    public String getFiliere(){
        return filiere.get();
    }:

    public void setFiliere(String filiere){
        this.filiere.set(filiere);
    }

    public String getTypeDeCour(){
        return typeDeCour.get();
    }

    public void setTypeDeCour(String typeDeCour){
        this.typeDeCour.set(typeDeCour);
    }

    public String getMatiere(){
        return matiere.get();
    }

    public void setMatiere(String matiere){
        this.matiere.set(matiere);
    }

    public String getCommentaire(){
        return commentaire.get();
    }

    public void setCommentaire(String commentaire){
        this.commentaire.set(commentaire);
    }
}
