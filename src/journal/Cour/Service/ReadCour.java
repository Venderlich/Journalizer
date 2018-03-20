package journal.Cour.Service;

import journal.DI.SQLiteConnectionProvider;
import journal.Filiere.Service.Filiere;
import journal.Filiere.Service.ReadFiliere;
import journal.Matiere.Service.Matiere;
import journal.Matiere.Service.ReadMatiere;
import journal.TypeDeCour.Service.ReadTypeDeCour;
import journal.TypeDeCour.Service.TypeDeCour;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadCour {

    private ReadFiliere readerFiliere = new ReadFiliere();
    private ReadTypeDeCour readerTypeDeCour = new ReadTypeDeCour();
    private ReadMatiere readerMatiere =new ReadMatiere();

    SQLiteConnectionProvider conn = new SQLiteConnectionProvider();

    private Cour rsToCour(ResultSet rs) throws SQLException {
        Cour cour = new Cour();
        cour.setId(rs.getInt("ID"));
        cour.setCommentaire(rs.getString("Commentaire"));
        cour.setDateSeance(rs.getString("dateSeance"));
        cour.setTemps(rs.getInt("Temps"));
        cour.setFiliere(readerFiliere.filiereById(rs.getInt("IDFiliere")));
        cour.setTypeDeCour(readerTypeDeCour.typeDeCourById(rs.getInt("IDTypeDeCour")));
        cour.setMatiere(readerMatiere.matiereById(rs.getInt("IDMatiere")));
        return cour;
    }

    public ArrayList<Cour> listCour() throws SQLException {
        ArrayList<Cour> listCour = new ArrayList<>();
        String query = "select * From Seance";
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            result = preparedStatement.executeQuery();
            while ( result.next() ) {
                listCour.add(rsToCour(result));
            }

        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            assert result != null;
            preparedStatement.close();
            result.close();
        }
        return  listCour;
    }
}
