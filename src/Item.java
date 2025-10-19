public abstract class Item {
    protected String id;   // ID do item, protegido pra ser acessível pelas subclasses
    protected String nome; // Nome do item

    // Construtor básico da classe Item
    public Item(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // (getters)
    public String getId() { return id; }
    public String getNome() { return nome; }

    // Método abstrato que obriga subclasses a implementar detalhes específicos
    public abstract String getDetalhes();

    // Sobrescreve o toString para mostrar o item completo de forma legível
    @Override
    public String toString() {
        return id + " - " + nome + " (" + getDetalhes() + ")";
    }
}
