package businessObejct;

import sun.io.Converters;

public class UsuarioBO {

	private int codigo;
	private String nome;
	private String email;
	private String usuario;
	private String numero;
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public void setTelfone(String telefone) 
	{
		try {
			this.numero = telefone;
			int aux = Integer.parseInt(telefone);
		} catch (Exception e) {
			throw new UsuarioException("Esse telefone não contem só números");
		}
	}
	
	
	public class UsuarioException extends RuntimeException
	{
		public String message;
		
		public UsuarioException(String msg)
		{
			super(msg);
			this.message = msg;
		}
	}
	
	
	public void Gravar()
	{
		// SETA PROPRIEDADE OBJETO DO E GRAVA
	}
}
