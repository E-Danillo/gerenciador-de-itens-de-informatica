public class Hardware extends Item {
    private String serial; // Guarda o número de série do hardware

    // Construtor da classe Hardware
    public Hardware(String id, String nome, String serial) {
        super(id, nome); // Chama o construtor da classe Item para setar ID e nome
        this.serial = serial; // Armazena o serial number específico do hardware
    }

    // Método sobrescrito da classe Item
    @Override
    public String getDetalhes() {
        return "Hardware SN: " + serial; // Retorna os detalhes específicos do hardware
    }
}
