package journal.Filiere.Service;

public class Filiere {
    Integer Id;
    String Label;



    public Integer getID()  {
        return Id;
    }

    public String getLabel(){
        return Label;
    }

    public void setId(Integer pId)
    {
        Id = pId;
    }

    public void setLabel(String pLabel)
    {
        Label = pLabel;
    }

}