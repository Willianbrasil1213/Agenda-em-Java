import java.util.ArrayList;
import java.util.List;

public class ArmazenarContatos {
    private List<Contatos> listaContatos;

    public ArmazenarContatos() {
        this.listaContatos = new ArrayList<>();
    }
    public void adicionarContato(Contatos contato) {
        listaContatos.add(contato);
    }    
    public void editarContato(String nome, Contatos novoContato) {
        for (int i = 0; i < listaContatos.size(); i++) {
            Contatos contato = listaContatos.get(i);
            if (contato.getNome().equals(nome)) {
                listaContatos.set(i, novoContato);
                return; 
            }
        }
        System.out.println("Contato não encontrado.");
    }

    
    public boolean contatoExiste(String nome) {
        for (Contatos contato : listaContatos) {
            if (contato.getNome().equals(nome)) {
                return true; 
            }
        }
        return false; 
    }

    public void excluirContato(String nome) {
        for (int i = 0; i < listaContatos.size(); i++) {
            Contatos contato = listaContatos.get(i);
            if (contato.getNome().equals(nome)) {
                listaContatos.remove(i);
                System.out.println("Contato excluído com sucesso.");
                return; 
            }
        }
        System.out.println("Contato não encontrado.");
    }

    public List<Contatos> consultarContatos() {
        return listaContatos;
    }
}
