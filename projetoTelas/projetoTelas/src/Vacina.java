import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.JOptionPane;

public class Vacina {
	private int idvacina;
	private String vacina;
	private int periodo;
	private int qtdDoses;
	
	public Vacina(String vacina, int periodo, int qtdDoses, int idvacina) {
		super();
		this.idvacina=idvacina;
		this.vacina = vacina;
		this.periodo = periodo;
		this.qtdDoses = qtdDoses;
		
	}

	

	



	public int getIdvacina() {
		return idvacina;
	}



	public void setIdvacina(int idvacina) {
		this.idvacina = idvacina;
	}



	public String getVacina() {
		return vacina;
	}



	public void setVacina(String vacina) {
		this.vacina = vacina;
	}



	public int getPeriodo() {
		return periodo;
	}



	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}



	public int getQtdDoses() {
		return qtdDoses;
	}



	public void setQtdDoses(int qtdDoses) {
		this.qtdDoses = qtdDoses;
	}



	public void inserir() {
		String sql = "INSERT INTO tb_vacina(nomevacina, periodo,doses) VALUES (?, ?, ?)";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, vacina);
			ps.setInt(2, periodo);
			ps.setInt(3, qtdDoses);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar() {
		String sql = "UPDATE tb_vacina SET doses= ?, nomevacina = ?, periodo = ? WHERE idvacina = ?";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, qtdDoses);
			ps.setString(2, vacina);
			ps.setInt(3, periodo);
			ps.setInt(4,idvacina);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void apagar() {
		String sql = "DELETE FROM tb_vacina WHERE idvacina = ?";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, vacina);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listar() {
		String sql = "SELECT * FROM tb_vacina";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {

			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String vacina = rs.getString("nomevacina");
				int periodo = rs.getInt("periodo");
				int qtdDoses = rs.getInt("doses");
				String aux = String.format(" nomevaina: %s, periodo: %s, doses: %s",vacina,periodo, qtdDoses);
				JOptionPane.showMessageDialog(null, aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	
}


