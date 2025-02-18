package arquivosTexto;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ProdutoNaoPerecivelTest {

    static ProdutoNaoPerecivel ProdutoNaoPerecivel;
        
    
    @BeforeAll
    static public void prepare(){
        ProdutoNaoPerecivel = new ProdutoNaoPerecivel("ProdutoNaoPerecivel teste", 100, 0.1);
    }
    
    @Test
    public void calculaPrecoCorretamente(){
        assertEquals(110.0, ProdutoNaoPerecivel.valorDeVenda(), 0.01);
    }

    @Test
    public void stringComDescricaoEValor(){
        String desc = ProdutoNaoPerecivel.toString();
        assertTrue(desc.contains("ProdutoNaoPerecivel teste") && desc.contains("R$ 110,00"));
    }

    @Test
    public void naoCriaProdutoNaoPerecivelComPrecoNegativo(){
        assertThrows(IllegalArgumentException.class, () -> new ProdutoNaoPerecivel("teste", -5, 0.5));
    }
    
    @Test
    public void naoCriaProdutoNaoPerecivelComMargemNegativa(){
        assertThrows(IllegalArgumentException.class, () -> new ProdutoNaoPerecivel("teste", 5, -1));
    }
}
