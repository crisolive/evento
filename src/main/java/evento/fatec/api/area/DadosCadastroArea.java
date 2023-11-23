package evento.fatec.api.area;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroArea(
		
		@NotBlank
		String descricao) {

}
