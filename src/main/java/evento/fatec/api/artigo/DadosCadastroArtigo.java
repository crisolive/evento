package evento.fatec.api.artigo;


import jakarta.validation.constraints.NotBlank;

public record DadosCadastroArtigo(
		
		@NotBlank
		String titulo, 
		@NotBlank
		String resumo,
		@NotBlank
		String keyWord1,
		@NotBlank
		String keyWord2,
		@NotBlank
		String keyWord3,
		Long areaId	) {

}
