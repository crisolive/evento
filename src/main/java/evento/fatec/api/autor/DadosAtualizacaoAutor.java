package evento.fatec.api.autor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoAutor(
	@NotNull
	Long id,
	String nome,
	String email, 
	String fone,
	String instituicao) {
}
