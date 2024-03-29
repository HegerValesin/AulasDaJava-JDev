package cursojava.classes;

import cursojava.interfaces.PermitirAcesso;

public class Secretario extends Pessoa implements PermitirAcesso {
	
	private String registro;
	private String nivelCargo;
	private String experiencia;
	
		
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getNivelCargo() {
		return nivelCargo;
	}
	public void setNivelCargo(String nivelCargo) {
		this.nivelCargo = nivelCargo;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	
	@Override
	public String toString() {
		return "Secretario [registro=" + registro + ", nivelCargo=" + nivelCargo + ", experiencia=" + experiencia
				+ ", nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", registroGeral="
				+ registroGeral + ", numeroCpf=" + numeroCpf + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + "]";
	}
	@Override
	public double salario() {
		// TODO Auto-generated method stub
		return 1800.85 * 0.9;
	}
	@Override
	public boolean autenticar(String login, String senha) {
		
		return login.equals("admin") && senha.equals("admin") ;
	}

	
	
}
