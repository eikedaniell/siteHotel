/**
 * @author Luís G. C. Barbosa
 */

public class Avaliacao {

    private Cliente cliente;
    private Suite suite;
    private int nota; // de 1 a 5
    private String comentario;

    public Avaliacao(Cliente cliente, Suite suite, int nota, String comentario) {
        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("A nota deve ser entre 1 e 5.");
        }
        this.cliente = cliente;
        this.suite = suite;
        this.nota = nota;
        this.comentario = comentario;
    }

    public void exibirAvaliacao() {
        System.out.println("Avaliação da Suíte: " + suite.getNome());
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Nota: " + nota);
        System.out.println("Comentário: " + comentario);
    }

}
