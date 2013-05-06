package br.ucb.saam.beans;

public class ItemFila {

	private UsuarioBean usuario;
	private AreaBean area;
	
	
	public ItemFila(){
		setArea(new AreaBean());
		setUsuario(new UsuarioBean());
	}
	
	public UsuarioBean getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}
	public AreaBean getArea() {
		return area;
	}
	public void setArea(AreaBean area) {
		this.area = area;
	}
	
}
