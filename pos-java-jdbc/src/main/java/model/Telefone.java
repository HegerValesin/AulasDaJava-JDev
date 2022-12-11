package model;

public class Telefone {
	private long id;
	private String numero;
	private long usuario;
	private String tipo;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", usuario=" + usuario + "]";
	}
	
	
	
	
}
