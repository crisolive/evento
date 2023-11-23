package evento.fatec.api.artigo;


import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoArtigo(
	@NotNull
	Long id,
	String titulo, 
	String resumo, 
	String keyWord1,
	String keyWord2,
	String keyWord3,
	Long areaId) {
}
