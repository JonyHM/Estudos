package br.com.seboDidatico.loja.daos;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import br.com.seboDidatico.loja.builders.ProdutoBuilder;
import br.com.seboDidatico.loja.conf.DataSourceConfigurationTest;
import br.com.seboDidatico.loja.conf.JPAConfiguration;
import br.com.seboDidatico.loja.models.Produto;
import br.com.seboDidatico.loja.models.TipoPreco;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProdutoDAO.class, 
    JPAConfiguration.class, DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProdutoDAOTest {

    @Autowired
    private ProdutoDAO produtoDao;

    @Test
    @Transactional
    public void deveSomarTodosPrecosPorTipoLivro() {        

        List<Produto> livrosImpressos = ProdutoBuilder
                .newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN)
                .mais(3).buildAll();
        livrosImpressos.stream().forEach(produtoDao::gravar);

        List<Produto> livrosEbook = ProdutoBuilder
                .newProduto(TipoPreco.EBOOK, BigDecimal.TEN)
                .mais(3).buildAll();
        livrosEbook.stream().forEach(produtoDao::gravar);

        BigDecimal valor = produtoDao.somaPrecosPorTipo(TipoPreco.EBOOK);
        Assert.assertEquals(new BigDecimal(40).setScale(2), valor);

    }
}
