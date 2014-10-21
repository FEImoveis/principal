package businessObejct;

import sun.io.Converters;

public class UsuarioBO {

	private int telefone;
	
	public int getTelefone()
	{
		return telefone;
	}
	
	public void setTelfone(String telefone) 
	{
		try {
			this.telefone = Integer.parseInt(telefone);
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
}
