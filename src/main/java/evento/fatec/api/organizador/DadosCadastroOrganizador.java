package evento.fatec.api.organizador;

//import evento.fatec.api.endereco.DadosEndereco;
//import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroOrganizador(
		
		@NotBlank
		//Not Blank inclui Not NUll 
		String nome,
		@NotBlank @Email
		String email, 
		@NotBlank
		String fone
		) {

}
