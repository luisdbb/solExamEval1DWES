package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO.LineaDAO;
import modelo.Linea;

public class LineaDAOImpl_JDBC implements LineaDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public LineaDAOImpl_JDBC(Connection con) {
		this.con = con;
	}

	public ArrayList<Linea> buscarLineasPorNombre(String cadena) {
		ArrayList<Linea> ret = new ArrayList<Linea>();
		try {
			ps = con.prepareStatement("select * from lineas where nombre like %?%");
			ps.setString(1, cadena);
			rs = ps.executeQuery();
			if (rs.next())
				ret.add(new Linea(rs.getInt("id"), rs.getString(2)));
		} catch (SQLException e) {
			System.out.println("error al consultar por viajes de un usuario entre fechas: " + e.getMessage());
		}
		return ret;
	}
}
