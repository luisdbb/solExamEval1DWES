package DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import DAO.ViajeDAO;
import modelo.Usuario;
import modelo.Viaje;

public class ViajeDAOImpl_JDBC implements ViajeDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public ViajeDAOImpl_JDBC(Connection con) {
		this.con = con;
	}

	public ArrayList<Viaje> buscarViajesDeUsuarioEntreFechas(Usuario u, LocalDateTime fechaini, LocalDateTime fechafin) {
		ArrayList<Viaje> ret = new ArrayList<Viaje>();
		try {
			//SELECT * FROM `viajes` WHERE `idusuario`=1 AND `fechahora` BETWEEN '2021-01-01 00:00:00' AND '2021-12-31 23:59:59'
			String sql = "SELECT * FROM `viajes` WHERE `idusuario`="+u.getId()+" AND AND `fechahora` BETWEEN '";
			sql += fechaini.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")) +"' AND '";
			sql += fechafin.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")) +"'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				Date fechaviaje = rs.getDate(2);
				ret.add(new Viaje(rs.getInt("id"), fechaviaje, rs.getInt(3), u));
			}
		} catch (SQLException e) {
			System.out.println("error al consultar por viajes de un usuario entre fechas: " + e.getMessage());
		}
		return ret;
	}
}
