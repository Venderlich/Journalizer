package journal.Filiere.Service;

import journal.DI.SQLiteConnectionProvider;
import journal.Filiere.Service.Filiere;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadFiliere {

    SQLiteConnectionProvider conn = new SQLiteConnectionProvider();

    public Filiere rsToFiliere(ResultSet rs) throws SQLException {
        Filiere fil = new Filiere();
        fil.setId(rs.getInt("ID"));
        fil.setLabel(rs.getString("LabelFiliere"));
        return fil;
    }

    public ArrayList<Filiere> listFiliere() throws SQLException {
        ArrayList<Filiere> listFiliere = new ArrayList<>();
        String query = "select * from Filiere";
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            result = preparedStatement.executeQuery();
            while ( result.next() ) {
                listFiliere.add(rsToFiliere(result));
            }

        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            assert result != null;
            preparedStatement.close();
            result.close();
        }
        return  listFiliere;
    }

    public Filiere filiereById(Integer idSearch) throws SQLException {
        Filiere FiliereSearch = new Filiere();
        String query = "select * from Filiere Where ID = ?";
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            preparedStatement.setInt(1,idSearch);
            result = preparedStatement.executeQuery();
            FiliereSearch.setId(result.getInt("ID"));
            FiliereSearch.setLabel(result.getString("LabelFiliere"));

        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            assert result != null;
            preparedStatement.close();
            result.close();
        }
        return  FiliereSearch;
    }


//    public ArrayList<Filiere> listFiliere() throws SQLException {
//        ArrayList<Filiere> listFiliere = new ArrayList<>();
//        String query = "select Filiere.ID as FiliereID , Filiere.LabelFiliere as labelFiliere, Matiere.LabelMatiere as LabelMatiere from Filiere, Matiere  where Filiere.IDMatiere = Matiere.ID";
//        PreparedStatement preparedStatement = null;
//        ResultSet result = null;
//
//        try {
//            preparedStatement = conn.get().prepareStatement(query);
//            result = preparedStatement.executeQuery();
//            while ( result.next() ) {
//                listFiliere.add(rsToFiliere(result));
//            }
//
//        } catch (SQLException e) {
//
//        } finally {
//            assert preparedStatement != null;
//            assert result != null;
//            preparedStatement.close();
//            result.close();
//        }
//        return  listFiliere;
//    }
}