package journal.Matiere.Service;

public class Matiere {
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
