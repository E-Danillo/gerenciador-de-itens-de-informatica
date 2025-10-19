import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        JFrame frame = new JFrame("Gerenciamento de Itens de Informática");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // centraliza a janela

        JPanel panel = new JPanel(new BorderLayout(10, 10)); // espaçamento entre componentes
        panel.setBackground(new Color(45, 45, 45)); // fundo escuro moderninho

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Consolas", Font.PLAIN, 14));
        area.setBackground(new Color(30, 30, 30));
        area.setForeground(new Color(200, 200, 200));
        area.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // padding interno
        panel.add(new JScrollPane(area), BorderLayout.CENTER);

        // Botões estilosos
        JButton addBtn = new JButton("Adicionar Item");
        JButton removeBtn = new JButton("Remover Item");
        JButton listarBtn = new JButton("Listar Itens");

        // Cor e fonte dos botões
        JButton[] botoesArray = {addBtn, removeBtn, listarBtn};
        for (JButton b : botoesArray) {
            b.setBackground(new Color(70, 130, 180)); // azul elegante
            b.setForeground(Color.WHITE);
            b.setFocusPainted(false);
            b.setFont(new Font("Arial", Font.BOLD, 14));
            b.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        }

        // Painel de botões com espaçamento
        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        botoes.setBackground(new Color(45, 45, 45)); // mesmo fundo do painel principal
        botoes.add(addBtn);
        botoes.add(removeBtn);
        botoes.add(listarBtn);

        panel.add(botoes, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);

        // Ações continuam iguais
        addBtn.addActionListener(e -> {
            String tipo = JOptionPane.showInputDialog("Digite o tipo (hardware/software):");
            if (tipo == null) return;
            String id = JOptionPane.showInputDialog("ID do item:");
            if (id == null) return;
            String nome = JOptionPane.showInputDialog("Nome do item:");
            if (nome == null) return;
            String extra = JOptionPane.showInputDialog(
                    tipo.equalsIgnoreCase("hardware") ? "Serial number:" : "Chave de licença:");
            if (extra == null) return;

            try {
                Item item;
                if (tipo.equalsIgnoreCase("hardware")) {
                    item = new Hardware(id, nome, extra);
                } else {
                    item = new Software(id, nome, extra);
                }
                estoque.adicionar(item);
                JOptionPane.showMessageDialog(frame, "Item adicionado!");
            } catch (ItemDuplicadoException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        removeBtn.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("Digite o ID do item para remover:");
            if (id == null) return;
            try {
                estoque.remover(id);
                JOptionPane.showMessageDialog(frame, "Item removido!");
            } catch (ItemNaoEncontradoException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        listarBtn.addActionListener(e -> {
            area.setText("");
            for (Item i : estoque.listar()) {
                area.append(i.toString() + "\n");
            }
        });
    }
}
