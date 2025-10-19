public class Software extends Item {
    private String chave; // Guarda a chave de licença do software (informação sensível, não pública)

    // Construtor da classe Software
    public Software(String id, String nome, String chave) {
        super(id, nome); // Chama o construtor da classe pai Item para setar ID e nome
        this.chave = chave; // Armazena a chave de licença específica do software
    }

    // Método sobrescrito da classe Item
    @Override
    public String getDetalhes() {
        return "Licença de Software: " + chave; // Retorna uma string com a informação específica do software
    }
}

