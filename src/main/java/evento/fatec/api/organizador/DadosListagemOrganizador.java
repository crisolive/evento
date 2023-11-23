package evento.fatec.api.organizador;

public record DadosListagemOrganizador(
	Long id,
	String nome, 
	String email, 
	String fone) {
	public DadosListagemOrganizador (Organizador organizador) {
	this(organizador.getId(),
		 organizador.getNome(), 
		 organizador.getEmail(),
		 organizador.getFone());	
	}
}
