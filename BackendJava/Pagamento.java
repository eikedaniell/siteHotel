import java.time.LocalDate;

/**
 * @author Luís G. C. Barbosa
 */

public class Pagamento {

    private double valor;
    private String formaDePagamento;
    private boolean pago;
    private LocalDate dataPagamento;

    public boolean isPago() {
        return pago;
    }

    public double getValor() {
        return valor;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public Pagamento(double valor, String formaDePagamento){
        this.valor = valor;
        this.formaDePagamento = formaDePagamento;
        this.pago = false;
        this.dataPagamento = null;
    }

    public void realizarPagamento(){
        if (!pago) {
            this.pago = true;
            this.dataPagamento = LocalDate.now();
            System.out.println("Pagamento efetuado com sucesso!");
        } else {
            System.out.println("O pagamento já foi efetuado");
        }
    }
}

