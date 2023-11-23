package evento.fatec.api.autor;

import java.util.Set;

import evento.fatec.api.artigo.Artigo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "autor")
@Entity (name = "Autor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="autor_id")
	private Long id;
	private String nome; 
	private String email; 
	private String fone;
	private String instituicao;
	private Boolean ativo;
	
	public Autor (DadosCadastroAutor dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.fone = dados.fone();
		this.instituicao = dados.instituicao();
		this.ativo = true;
	}
	
	@ManyToMany
	private Set<Artigo> artigos;

	public void atualizarInformacoes(@Valid DadosAtualizacaoAutor dados) {
		if (dados.nome() != null )
			this.nome = dados.nome();
		if (dados.fone() != null)
			this.fone = dados.fone();
		if (dados.email() != null)
			this.email= dados.email();
		if (dados.instituicao() != null)
			this.instituicao = dados.instituicao();
	}

	public void excluir() {
		this.ativo = false;
		
	}
}
