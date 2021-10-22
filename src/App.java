import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        
        DadosDao dadosDao = new DadosDao();
            
        dadosDao.insert(78f, 1.8f);

        List<RegistroDados> todosDados = dadosDao.getAll();

        Object[] arrayDados = todosDados.toArray();

        for(int i = 0; i < arrayDados.length; i++){
            System.out.println(arrayDados[i].toString());
        }

        System.out.println("uma query só: ");

        RegistroDados registro = dadosDao.get(1);

        System.out.println(registro);
    }
}
