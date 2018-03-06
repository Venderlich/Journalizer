package journal.TypeDeCour.Service;

public class TypeDeCour {
    Integer Id;
    String LabelTDC;
    Double Rapport;



    public Integer getID()  {
        return Id;
    }

    public String getLabel(){
        return LabelTDC;
    }

    public Double getRapport(){
        return Rapport;
    }


    public void setId(Integer pId)
    {
        Id = pId;
    }

    public void setLabel(String pLabel)
    {
        LabelTDC = pLabel;
    }

    public void setRapport(Double pRapport){
        Rapport = pRapport;
    }


}
