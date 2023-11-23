package evento.fatec.api.organizador;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoOrganizador(
	@NotNull
	Long id,
	String nome,
	String email, 
	String fone) {
}
