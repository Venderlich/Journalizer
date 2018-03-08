package journal.TypeDeCour.Service;

import journal.DI.SQLiteConnectionProvider;
import journal.Filiere.Service.Filiere;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadTypeDeCour {
    SQLiteConnectionProvider conn = new SQLiteConnectionProvider();

    private TypeDeCour rsToTypeDeCour(ResultSet rs) throws SQLException {
        TypeDeCour tdc = new TypeDeCour();
        tdc.setId(rs.getInt("ID"));
        tdc.setLabel(rs.getString("LabelTDC"));
        tdc.setRapport(rs.getDouble("Rapport"));
        return tdc;
    }

    public ArrayList<TypeDeCour> listTypeDeCour() throws SQLException {
        ArrayList<TypeDeCour> listTypeDeCour = new ArrayList<>();
        String query = "select * from TypeDeCour";
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            result = preparedStatement.executeQuery();
            while ( result.next() ) {
                listTypeDeCour.add(rsToTypeDeCour(result));
            }

        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            assert result != null;
            preparedStatement.close();
            result.close();
        }
        return  listTypeDeCour;
    }

    public TypeDeCour typeDeCourById(Integer idSearch) throws SQLException {
        TypeDeCour TypeDeCourSearch = new TypeDeCour();
        String query = "select * from TypeDeCour where ID = ?";
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            preparedStatement = conn.get().prepareStatement(query);
            preparedStatement.setInt(1,idSearch);
            result = preparedStatement.executeQuery();
            TypeDeCourSearch.setId(result.getInt("ID"));
            TypeDeCourSearch.setLabel(result.getString("LabelTDC"));
            TypeDeCourSearch.setRapport(result.getDouble("Rapport"));

        } catch (SQLException e) {

        } finally {
            assert preparedStatement != null;
            assert result != null;
            preparedStatement.close();
            result.close();
        }
        return  TypeDeCourSearch;
    }
}
