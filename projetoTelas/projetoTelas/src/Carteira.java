

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.time.LocalDate;
	import javax.swing.JOptionPane;

	public class Carteira {

		private String vacina;
		private int periodo;
		private int qtdDoses;
		private int primeiraDose;
		private int segundaDose;
		
		public Carteira(String vacina, int periodo, int qtdDoses, int primeiraDose, int segundaDose) {
			super();
			this.vacina = vacina;
			this.qtdDoses = qtdDoses;
			this.primeiraDose = primeiraDose;
			this.segundaDose=segundaDose;
		}

	
		
		public String getVacina() {
			return vacina;
		}




		public void setVacina(String vacina) {
			this.vacina = vacina;
		}




		public int getQtdDoses() {
			return qtdDoses;
		}




		public void setQtdDoses(int qtdDoses) {
			this.qtdDoses = qtdDoses;
		}




		public int getPrimeiraDose() {
			return primeiraDose;
		}




		public void setPrimeiraDose(int primeiraDose) {
			this.primeiraDose = primeiraDose;
		}




		public int getSegundaDose() {
			return segundaDose;
		}




		public void setSegundaDose(int segundaDose) {
			this.segundaDose = segundaDose;
		}




		public void inserir() {
			String sql = "INSERT INTO tb_carteira(nomevacina,qtdDoses,primeiradose,segundadose) VALUES (?, ?, ?,?, ?)";
			ConnectionFactory factory = new ConnectionFactory();
			try (Connection c = factory.obtemConexao()) {
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setString(1, vacina);
				ps.setInt(2, qtdDoses);
				ps.setDate(primeiraDose, null);
				ps.setDate(segundaDose, null);
				ps.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void atualizar() {
			String sql = "UPDATE tb_vacina SET vacina = ?, periodo = ?, qtdDoses = ? WHERE idvacina = ?";
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




