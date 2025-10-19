import java.util.List;

public interface Gerenciador {
    // Método para adicionar um item; lança exceção se o item já existir
    void adicionar(Item item) throws ItemDuplicadoException;

    // Método para remover um item pelo ID; lança exceção se não encontrar
    void remover(String id) throws ItemNaoEncontradoException;

    // Método para buscar um item pelo ID; lança exceção se não encontrar
    Item buscar(String id) throws ItemNaoEncontradoException;

    // Método para listar todos os itens
    List<Item> listar();
}
