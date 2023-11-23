package evento.fatec.api.area;


import jakarta.persistence.Column;
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
import lombok.Setter;

@Table(name = "area")
@Entity (name = "area")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Area {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="area_id")
	private Long id;
	private String descricao;
	
	public Area(Long id) {
        this.id = id;
    }
	
	public Area (DadosCadastroArea dados) {
		this.descricao = dados.descricao();
	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoArea dados) {
		if (dados.descricao() != null )
			this.descricao = dados.descricao();
	}
}
