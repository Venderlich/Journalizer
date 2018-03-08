package journal.Matiere.Service;

import journal.DI.SQLiteConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadMatiere extends ArrayList {
    SQLiteConnectionProvider conn = new SQLiteConnectionProvider();


    private Matiere rsToMatiere(ResultSet rs) throws SQLException{
        Matiere mat = new Matiere();
        mat.setId(rs.getInt("ID"));
        mat.setLabel(rs.getString("LabelMatiere"));
        return mat;
    }

    public ArrayList<Matiere>  listMatiere() throws SQLException {
        ArrayList<Matiere> listMatiere = new ArrayList<>();
        String query = "select * from Matiere";
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            result = preparedStatement.executeQuery();
            while ( result.next() ) {
                listMatiere.add(rsToMatiere(result));
            }
        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            assert result != null;
            preparedStatement.close();
            result.close();
        }
        return  listMatiere;
    }

    public Matiere  matiereById(Integer idSearch) throws SQLException {
        Matiere MatiereSearch = new Matiere();
        String query = "select * from Matiere where ID = ?";
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            preparedStatement.setInt(1,idSearch);
            result = preparedStatement.executeQuery();
            MatiereSearch.setId(result.getInt("ID"));
            MatiereSearch.setLabel(result.getString("LabelMatiere"));

        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            assert result != null;
            preparedStatement.close();
            result.close();
        }
        return  MatiereSearch;
    }



}
