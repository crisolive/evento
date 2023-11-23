package evento.fatec.api.area;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoArea(
	@NotNull
	Long id,
	String descricao) {
}
