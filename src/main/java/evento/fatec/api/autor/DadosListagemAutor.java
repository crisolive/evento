package evento.fatec.api.autor;

public record DadosListagemAutor(
	Long id,
	String nome,
	String email,
	String fone,
	String instituicao) {
	public DadosListagemAutor(Autor autor) {
		this(autor.getId(),
				autor.getNome(),
				autor.getEmail(),
				autor.getFone(),
				autor.getInstituicao());
	}
}
