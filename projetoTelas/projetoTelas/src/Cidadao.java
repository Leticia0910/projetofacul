

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Cidadao {
	private String sus;
	private String nome;
	private int telefone;
	private String email;
	private String cpf;
	private String dataDeNascimento;
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private carteiraVacina carteiraVacina;


	public Cidadao(String sus,String nome, int telefone, String email, String cpf, String dataDeNacimento) {
		super();
		this.sus=sus;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNacimento;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	public carteiraVacina getcarteiraVacina() {
		return carteiraVacina;
	}
	
	
	public void setCarteiraVacina(carteiraVacina carteiraVacina) {
		this.carteiraVacina = carteiraVacina;
	}
	
	

	public String getSus() {
		return sus;
	}

	public void setSus(String sus) {
		this.sus = sus;
	}
	
	
	 public String getDtNascimento(){ 
		 return dataDeNascimento; 
		 } 
		 /** 
		 * retorna a data formatada “dd/MM/yyyy” 
		 * @return String  
		 */ 
		

	

	public void inserir() {
		String sql = "INSERT INTO tb_cidadao(nsus, nome, fone, email, cpfrne, datanasc) VALUES (?, ?, ?, ?, ?,?)";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, sus);
			ps.setString(2, nome);
			ps.setInt(3, telefone);
			ps.setString(4, email);
			ps.setString(5, cpf);
			ps.setString(6,dataDeNascimento);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizar() {
		String sql = "UPDATE tb_cidadao SET nome = ?, fone = ?, email = ?, cpfrne = ?, datanasc = ? WHERE nsus = ?";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, telefone);
			ps.setString(3, email);
			ps.setString(4, cpf);
			ps.setString(5,dataDeNascimento); 
			ps.setString(6, sus);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void apagar() {
		String sql = "DELETE FROM tb_cidadao WHERE nsus = ?";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, sus);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultar() {
		
			//1: Definir o comando SQL
			String sql = "SELECT  nome ,fone,email,cpfrne,datanasc FROM db_projeto.tb_cidadao  WHERE nsus=?";
			//2: Abrir uma conexão
			ConnectionFactory factory = new ConnectionFactory();
			try (Connection c = factory.obtemConexao()){
			//3: Pré compila o comando
			PreparedStatement ps = c.prepareStatement(sql);
			//4: Preenche os dados faltante
			ps.setString(7, sus);
			//5: Executa o comando
			ps.execute();
			}
			catch (Exception e){
			e.printStackTrace();
			}
			}


				
				
	

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}



	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}



	public void listar() {
		String sql = "SELECT * FROM db_projeto.tb_cidadao;";
		ConnectionFactory factory = new ConnectionFactory();
		try (Connection c = factory.obtemConexao()) {

			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String cpf = rs.getString("cpfrne");
				String nome = rs.getString("nome");
				int telefone = rs.getInt("fone");
				String email = rs.getString("email");
				String dataDeNascimento = rs.getString("datanasc");
				String aux = String.format("cpfrne: %d, nome: %s, fone: %s, email: %s", cpf, nome, telefone, email,
						dataDeNascimento);
				JOptionPane.showMessageDialog(null, aux);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
