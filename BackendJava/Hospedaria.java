import java.util.ArrayList;
import java.util.List;
/**
 * @author Luís G. C. Barbosa
 */

public class Hospedaria {

    private List<Suite> suites;

    public Hospedaria() {
        this.suites = new ArrayList<>();

        suites.add(new Suite("Suíte Encanto da Aurora", 1, 1, false, false, 100.00));
        suites.add(new Suite("Suíte Brisa do Mar", 1, 1, false, true, 100.20));
        suites.add(new Suite("Suíte Serenata das ondas", 2, 1, true, true, 150.00));
        suites.add(new Suite("Suite Luar em Família", 3, 2, true, true, 200.00));
        suites.add(new Suite("Suite Laguna", 1, 1, true, true, 180));
        suites.add(new Suite("Suíte Versos ao Luar", 2, 2, true, true, 250));
    }

    public List<Suite> getSuites() {
        return suites;
    }

    public void listarSuitesDisponiveis() {
        for (Suite suite : suites) {
            if (suite.isDisponivel()) {
                System.out.println(suite.getDescricaoCompleta());
            }
        }
    }
}
