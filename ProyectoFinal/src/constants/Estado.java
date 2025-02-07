package constants;

public enum Estado {
	REGISTRADO(0, "registrado"),
	MATRICULADO(1, "matriculado"),
	RETIRADO(2, "retirado");
	
	private final int codigo;
	private final String descripcion;

	Estado(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public int getCodigo() {
		return codigo;
	}
}
