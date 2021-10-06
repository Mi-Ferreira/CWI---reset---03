
public class Registradora {

    public static void main(String[] args) {
  //    primeiroBug();
//
//       segundoBug();
//
//       terceiroBug();
//
 //      quartoBug();
//
//       quintoBug();
//
      sextoBug();
    }

    public static double registrarItem(String item, int quantidade) {
        double precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
           if (QuantidadeMinimaItem.precisaReposicao(item)) {
               if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                   if (!DataProjeto.cozinhaEmFuncionamento()) {
                       System.out.println("Cozinha fechada!");
                   } else {
                       ReposicaoCozinha.reporItem(item);
                   }
               }
           }

            if ("leite".equals(item) || "cafe".equals(item)) {
                ReposicaoFornecedor.reporItem(item);
            }

                return precoItem;
    }

    private static void primeiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;
        double precoTotal = registrarItem(item, quantidade);
        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void segundoBug() {
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void terceiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        double precoTotal2 = registrarItem(item2, quantidade2);

        System.out.println(String.format("Valor total: %.2f", precoTotal2));
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        double precoTotal = registrarItem(item, quantidade);

        System.out.println(String.format("Valor total: %.2f", precoTotal));
    }

    public static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();
        // Cliente 1
        System.out.println("Cliente 1");
        String item = "sanduiche";
        int quantidade = 20;

        if (ItensPorQuantidade.sanduiche-quantidade>=0) {
            ItensPorQuantidade.sanduiche = ItensPorQuantidade.sanduiche - quantidade;
            double precoTotal = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);
            System.out.println(String.format("Valor total: %.2f", precoTotal));
        }
        else{
            double precoTotal = registrarItem(item, quantidade);
        }

        // Cliente 2
        System.out.println("Cliente 2");
        String item2 = "sanduiche";
        int quantidade2 = 5;

        if (ItensPorQuantidade.sanduiche-quantidade2>=0) {
            ItensPorQuantidade.sanduiche = ItensPorQuantidade.sanduiche - quantidade2;
            double precoTotal = RelacaoPesoPreco.retornaPrecoProduto(item2, quantidade2);
            System.out.println(String.format("Valor total: %.2f", precoTotal));
        }
        else{
            double precoTotal = registrarItem(item2, quantidade2);
            System.out.println("Não há quantidade suficiente de produtos para voce.\nTemos quantidade " + ItensPorQuantidade.sanduiche+
                               " em estoque");
        }

    }
}
