package evento.fatec.api.organizador;

import jakarta.persistence.Column;
//import evento.fatec.api.endereco.Endereco;
//import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "organizador")
@Entity (name = "Organizador")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Organizador {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="organizador_id")
	private Long id;
	private String nome; 
	private String email; 
	private String fone;
	private Boolean ativo;
	
//	@Embedded
//	private Endereco endereco; 
	
	public Organizador (DadosCadastroOrganizador dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.fone = dados.fone();
		this.ativo = true;
		//this.endereco = new Endereco(dados.endereco());
	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoOrganizador dados) {
		if (dados.nome() != null )
			this.nome = dados.nome();
		if (dados.fone() != null)
			this.fone = dados.fone();
		if (dados.email() != null)
			this.email= dados.email();
	}

	public void excluir() {
		//this.ativo = false;
	}
}
