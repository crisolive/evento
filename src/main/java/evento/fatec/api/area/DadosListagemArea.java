package evento.fatec.api.area;

public record DadosListagemArea(
	Long id,
	String descricao) {
	public DadosListagemArea (Area area) {
	this(area.getId(),
			area.getDescricao()); 
	}
}
