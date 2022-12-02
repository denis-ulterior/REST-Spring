package br.com.dio;

import br.com.dio.entity.Produto;
import br.com.dio.exception.ProductPriceException;
import br.com.dio.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProdutoTest {
    @Autowired
    private ProdutoService produtoService;

    @Test
    public void verificaValorNegativoProduto() throws Exception {
        Produto produto = new Produto();
        produto.setNome("Teste");
        produto.setPreco(-10.00);
        assertThrows(ProductPriceException.class,()->produtoService.save(produto));

    }
}
