package evento.fatec.api.artigo;

import java.time.LocalDate;
import java.util.List;

import evento.fatec.api.area.Area;
import evento.fatec.api.autor.Autor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "artigo")
@Entity (name = "artigo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Artigo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="artigo_id")
	private Long id;
	private String titulo; 
	private String resumo; 
	private String keyWord1;
	private String keyWord2;
	private String keyWord3;
	
	@Temporal(TemporalType.DATE)
	private LocalDate dataSubmissao; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "area_id", referencedColumnName = "area_id", insertable=false, updatable=false )
	private Area area;
	private Long area_id;
	
	@ManyToMany
	@JoinTable()
	private List<Autor> autores;
	
	
	public Artigo (DadosCadastroArtigo dados) {
		this.titulo = dados.titulo();
		this.resumo = dados.resumo();
		this.keyWord1 = dados.keyWord1();
		this.keyWord2 = dados.keyWord2();
		this.keyWord3 = dados.keyWord3();
		this.dataSubmissao = LocalDate.now();
		this.area.setId(dados.areaId());
	}
	
	public void atualizarInformacoes(@Valid DadosAtualizacaoArtigo dados) {
		if (dados.titulo() != null )
			this.titulo = dados.titulo();
		if (dados.resumo() != null )
			this.resumo = dados.resumo();
		if (dados.keyWord1() != null)
			this.keyWord1 = dados.keyWord1();
		if (dados.keyWord2() != null)
			this.keyWord2 = dados.keyWord2();
		if (dados.keyWord3() != null)
			this.keyWord3 = dados.keyWord3();
	}

}
