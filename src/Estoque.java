import java.util.ArrayList;
import java.util.List;

public class Estoque implements Gerenciador {
    // Lista que armazena todos os itens do estoque
    private List<Item> itens = new ArrayList<>();

    // ===== ADICIONAR ITEM =====
    @Override
    public void adicionar(Item item) throws ItemDuplicadoException {
        // Verifica se já existe algum item com o mesmo ID
        for (Item i : itens) {
            if (i.getId().equals(item.getId())) {
                throw new ItemDuplicadoException("Item com ID repetido!"); // Lança exceção se encontrar duplicado
            }
        }
        itens.add(item); // Adiciona o item à lista
        System.out.println("Adicionado: " + item); // Mensagem de confirmação no console (GUI não depende disso)
    }

    // ===== REMOVER ITEM =====
    @Override
    public void remover(String id) throws ItemNaoEncontradoException {
        Item achado = null;
        // Procura o item com o ID solicitado
        for (Item i : itens) {
            if (i.getId().equals(id)) achado = i;
        }
        if (achado == null) throw new ItemNaoEncontradoException("Item não encontrado!"); // Se não achou, lança exceção
        itens.remove(achado); // Remove o item
        System.out.println("Removido: " + achado); // Confirmação no console
    }

    // ===== BUSCAR ITEM =====
    @Override
    public Item buscar(String id) throws ItemNaoEncontradoException {
        // Percorre a lista procurando pelo ID
        for (Item i : itens) {
            if (i.getId().equals(id)) return i; // Retorna o item se encontrado
        }
        throw new ItemNaoEncontradoException("Item não encontrado! Tente Novamente."); // Se não encontrou, lança exceção
    }

    // ===== LISTAR ITENS =====
    @Override
    public List<Item> listar() {
        return itens; // Retorna a lista completa de itens
    }
}
