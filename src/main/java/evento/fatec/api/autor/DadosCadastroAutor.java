package evento.fatec.api.autor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAutor(
		
		@NotBlank
		//Not Blank inclui Not NUll 
		String nome,
		@NotBlank @Email
		String email, 
		@NotBlank
		String fone,
		String instituicao) {
}
